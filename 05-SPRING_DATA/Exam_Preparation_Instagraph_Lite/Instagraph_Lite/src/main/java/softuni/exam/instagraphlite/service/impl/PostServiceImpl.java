package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserService userService;
    private final PictureService pictureService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;

    public PostServiceImpl(PostRepository postRepository, UserService userService, PictureService pictureService, ValidationUtil validationUtil, ModelMapper modelMapper, XMLParser xmlParser) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.pictureService = pictureService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        PostSeedRootDto postSeedRootDto = this.xmlParser
                .readFromFile(POSTS_FILE_PATH, PostSeedRootDto.class);

        postSeedRootDto.getPosts()
                .stream()
                .filter(postSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(postSeedDto)
                            && this.userService.isEntityExists(postSeedDto.getUser().getUsername())
                            && this.pictureService.isEntityExists(postSeedDto.getPicture().getPath());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Post, made by %s",
                                        postSeedDto.getUser().getUsername())
                                    : "Invalid Post")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = this.modelMapper.map(postSeedDto, Post.class);
                    post.setUser(this.userService.findByUsername(postSeedDto.getUser().getUsername()));
                    post.setPicture(this.pictureService.findByPath(postSeedDto.getPicture().getPath()));
                    return post;
                })
                .forEach(this.postRepository::save);

        return sb.toString().trim();
    }
}
