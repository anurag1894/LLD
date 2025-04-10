package LoggingSystem;

public class LogProcessor {
    LogProcessor logProcessor;

    LogProcessor(LogProcessor logProcessor){
        this.logProcessor = logProcessor;
    }
    void log(LogType logType,String message){
        if(logType!=null){
            logProcessor.log(logType,message);
        }
    }
}
