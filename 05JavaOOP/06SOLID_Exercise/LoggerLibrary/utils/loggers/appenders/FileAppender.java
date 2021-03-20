package LoggerLibrary.utils.loggers.appenders;

import LoggerLibrary.utils.helpers.IFile;
import LoggerLibrary.utils.loggers.layouts.Layout;

public class FileAppender extends AppenderImpl {
    private IFile fileHelper;

    public FileAppender(Layout layout, IFile fileHelper) {
        super(layout);
        this.fileHelper = fileHelper;
    }

    @Override
    public void append(String time, String reportLevel, String message) {
        this.incrementMessagesCount();
        this.fileHelper.write(this.getLayout().format(time, reportLevel, message));
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "File size: " + this.fileHelper.getSize();
    }
}
