package LoggerLibrary.utils.loggers.appenders;

import LoggerLibrary.utils.enums.ReportLevel;
import LoggerLibrary.utils.loggers.layouts.Layout;

public abstract class AppenderImpl implements Appender {
    // ConsoleAppender SimpleLayout CRITICAL
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendedMessages; // count of messages

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO; // !!!
        this.appendedMessages = 0; // starts from 0
    }

    protected Layout getLayout() { // not included in interface, only here as it is PROTECTED
        return this.layout;
    }

    protected void incrementMessagesCount() {
        this.appendedMessages++; // increase messages with 1
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public abstract void append(String time, String reportLevel, String message);

    //Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
    @Override
    public String toString() {
        return String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName() // ConsoleAppender
                , this.layout.getClass().getSimpleName() // SimpleLayout
                , this.reportLevel.toString() // CRITICAL
                , this.appendedMessages // 2
        );
    }
}
