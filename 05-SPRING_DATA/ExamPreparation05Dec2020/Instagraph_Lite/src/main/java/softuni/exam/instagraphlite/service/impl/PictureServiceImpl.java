package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(pictureSeedDto)
                            && !isEntityExists(pictureSeedDto.getPath());
                    sb
                            .append(isValid
                    ? String.format("Successfully imported Picture, with size %.2f",
                            pictureSeedDto.getSize())
                    : "Invalid picture")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(pictureSeedDto -> this.modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(this.pictureRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean isEntityExists(String path) {
        return this.pictureRepository.existsByPath(path);
    }

    @Override
    public Picture findByPath(String path) {

        return this.pictureRepository.findByPath(path).orElse(null);
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        List<Picture> pictures = this.pictureRepository.findAllBySizeGreaterThanOrderBySize(30000);

        pictures
                .forEach(picture -> sb
                        .append(String.format("%.2f %s",
                        picture.getSize(),
                        picture.getPath()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
