package LoggingService.mgmt;

import LoggingService.strategy.ConsoleLoggingStrategy;
import LoggingService.strategy.DBLoggingStrategy;
import LoggingService.strategy.LogProcessorStrategy;
import LoggingService.levels.*;


public class LogSystem {

    LogProcessor processor ;
    LogProcessorStrategy DBStrategy = new DBLoggingStrategy();
    LogProcessorStrategy consoleStrategy = new ConsoleLoggingStrategy();
    Logger INFO = new INFO();
    Logger WARN = new DEBUG();
    Logger ERROR = new ERROR();

    public LogSystem(){
        INFO.setNextLoggerLogger(WARN);
        WARN.setNextLoggerLogger(ERROR);
        processor = new LogProcessor(consoleStrategy);
    }

    public void log(String message, String level, String strategy){
        /* here we can use factory design using enum to set this up) */

        if(strategy.equals("console")){
            processor.setStrategy(consoleStrategy);
        } else if(strategy.equals("db")){
            processor.setStrategy(DBStrategy);
        } else {
            System.out.println("Unknown strategy: " + strategy);
        }
        INFO.log(message,level,processor);
    }
}
