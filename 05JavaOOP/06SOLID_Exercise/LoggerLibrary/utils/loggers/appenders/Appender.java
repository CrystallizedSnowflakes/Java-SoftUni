package LoggerLibrary.utils.loggers.appenders;

import LoggerLibrary.utils.enums.ReportLevel;

public interface Appender {

    void append(String time, String reportLevel, String message); // append Layout

    void setReportLevel(ReportLevel reportLevel); // enums

    ReportLevel getReportLevel();
}
