package LoggerLibrary.utils.loggers.layouts;

public interface Layout {
    // 3/26/2015 2:38:01 PM - CRITICAL - No connection string found in App.config
    // 3/26/2015 2:39:19 PM - FATAL - mscorlib.dll does not respond
    String format(String time, String reportLevel, String message);
}
