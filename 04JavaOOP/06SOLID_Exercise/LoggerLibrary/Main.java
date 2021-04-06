package LoggerLibrary;

import LoggerLibrary.utils.enums.ReportLevel;
import LoggerLibrary.utils.helpers.FileHelper;
import LoggerLibrary.utils.loggers.Logger;
import LoggerLibrary.utils.loggers.MessageLogger;
import LoggerLibrary.utils.loggers.appenders.Appender;
import LoggerLibrary.utils.loggers.appenders.ConsoleAppender;
import LoggerLibrary.utils.loggers.appenders.FileAppender;
import LoggerLibrary.utils.loggers.layouts.Layout;
import LoggerLibrary.utils.loggers.layouts.SimpleLayout;
import LoggerLibrary.utils.loggers.layouts.XmlLayout;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Logger logger = new MessageLogger();


        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];

            Layout layout = tokens[1].equals("SimpleLayout")
                    ? new SimpleLayout()
                    : new XmlLayout();

            Appender appender;
            if (appenderType.equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
                if (tokens.length == 3) {
                    appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
                }
            } else {
                appender = new FileAppender(layout, new FileHelper());
            }
            logger.addAppender(appender);
        }


        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];

            switch (reportLevel) {
                case INFO:
                    logger.logInfo(time, message);
                    break;
                case WARNING:
                    logger.logWarning(time, message);
                    break;
                case ERROR:
                    logger.logError(time, message);
                    break;
                case CRITICAL:
                    logger.logCritical(time, message);
                    break;
                case FATAL:
                    logger.logFatal(time, message);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(logger.toString());
    }
}
