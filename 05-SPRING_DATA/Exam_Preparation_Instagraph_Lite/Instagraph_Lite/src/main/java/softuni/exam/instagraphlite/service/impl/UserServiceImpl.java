package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, PictureService pictureService, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        UserSeedDto[] userSeedDTOs = this.gson.fromJson(readFromFileContent(), UserSeedDto[].class);
        Arrays.stream(userSeedDTOs)
                .filter(userSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(userSeedDto)
                            && !isEntityExists(userSeedDto.getUsername())
                            && this.pictureService.isEntityExists(userSeedDto.getProfilePicture());
                    sb
                            .append(isValid
                            ? "Successfully imported User: " + userSeedDto.getUsername()
                                    : "Invalid user")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = this.modelMapper.map(userSeedDto, User.class);
                    user.setProfilePicture(this.pictureService.findByPath(userSeedDto.getProfilePicture()));
                    return user;
                })
                .forEach(this.userRepository::save);
        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExists(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .orElse(null);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        this.userRepository.findUsersAndTheirPostsOrderByPostsCountDescThenByUserId()
            .forEach(user -> {
            sb
                    .append(String.format("""
                                    User: %s
                                    Post count: %d
                                    """,
                            user.getUsername(),
                            user.getPosts().size()));
            user.getPosts()
                    .stream()
                    .sorted(Comparator.comparingDouble(f -> f.getPicture().getSize()))
                    .forEach(post -> sb
                            .append(String.format("""
                                            ==Post Details:
                                            ----Caption: %s
                                            ----Picture Size: %.2f
                                            """,
                                    post.getCaption(),
                                    post.getPicture().getSize())));
        });
        return sb.toString().trim();
    }
}
