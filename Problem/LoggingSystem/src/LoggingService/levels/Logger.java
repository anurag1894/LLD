package LoggingService.levels;

import LoggingService.mgmt.LogProcessor;
import LoggingService.strategy.LogProcessorStrategy;

public abstract class Logger {

    Logger nextLogger;

    public void setNextLoggerLogger(Logger logger) {
        nextLogger = logger;
    }


    public void log(String message, String level, LogProcessor strategy) {}

}
