package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.entity.Picture;

import java.io.IOException;

public interface PictureService {

    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    boolean isEntityExists(String path);
    Picture findByPath(String path);
}
