package LoggingService.levels;

import LoggingService.mgmt.LogProcessor;
import LoggingService.strategy.LogProcessorStrategy;

public class DEBUG extends Logger{
    @Override
    public void log(String message, String level, LogProcessor strategy) {
        if(level.equals("DEBUG")){
            System.out.println("DEBUG "+message);
            strategy.processLog(message);
        } else{
            this.nextLogger.log(message, level, strategy);
        }
    }

}
