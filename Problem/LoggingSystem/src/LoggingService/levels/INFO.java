package LoggingService.levels;

import LoggingService.mgmt.LogProcessor;
import LoggingService.strategy.LogProcessorStrategy;

public class INFO extends Logger{

    @Override
    public void log(String message, String level, LogProcessor strategy){
        if(level.equals("INFO")){
            System.out.println("INFO: " + message);
            strategy.processLog(message);
        }else{
            this.nextLogger.log(message, level, strategy);
        }
    }
}
