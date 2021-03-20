package LoggerLibrary.utils.helpers;

import java.io.File;

public interface IFile {
    void write(String text);
    void setPath(String path);
    void setFile(File file);
    long getSize();
}
