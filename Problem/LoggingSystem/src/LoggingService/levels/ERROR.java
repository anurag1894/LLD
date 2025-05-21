package LoggingService.levels;

import LoggingService.mgmt.LogProcessor;
import LoggingService.strategy.LogProcessorStrategy;

public class ERROR extends Logger {
    @Override
    public void log(String message, String level, LogProcessor strategy) {
        if(level.equals("ERROR")) {
            System.out.println("ERROR " + message);
            strategy.processLog(message);
        } else{
           System.out.println("False Log Level " + level);
        }
    }
}
