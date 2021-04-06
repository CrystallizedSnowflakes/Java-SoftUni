package LoggerLibrary.utils.loggers;

import LoggerLibrary.utils.enums.ReportLevel;
import LoggerLibrary.utils.loggers.appenders.Appender;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MessageLogger implements Logger {
    private Set<Appender> appenders; // fast search

    public MessageLogger(Appender... appenders) { // 0 or more
        this.setAppenders(appenders);
    }

    private void setAppenders(Appender[] appenders) {
        this.appenders = new LinkedHashSet<>();
        if(appenders != null) {
            this.appenders.addAll(Arrays.asList(appenders));
        }
    }

    private void log(String time, ReportLevel reportLevel, String message) {
        for (Appender appender : appenders) {
            if(appender.getReportLevel().ordinal() <= reportLevel.ordinal()) {
                appender.append(time, reportLevel.toString(), message);
            }
        }
    }

    @Override
    public void logError(String time, String message) {
        this.log(time, ReportLevel.ERROR, message);
    }

    @Override
    public void logInfo(String time, String message) {
        this.log(time, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String time, String message) {
        this.log(time, ReportLevel.WARNING, message);
    }

    @Override
    public void logCritical(String time, String message) {
        this.log(time, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String time, String message) {
        this.log(time, ReportLevel.FATAL, message);
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }
//    Logger info
//    Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info");
        builder.append(System.lineSeparator());

        for (Appender appender : appenders) {
            builder.append(appender.toString())
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
