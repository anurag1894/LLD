package LoggingSystem;

public class ErrorLogProcessor extends LogProcessor{
    ErrorLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    void log(LogType logType, String message) {
        if(LogType.ERROR.equals(logType)){
            System.out.println("This is error log type with message : " + message);
        } else {
            System.out.println("This is not error log with message : " + message);
            super.log(logType, message);
        }
    }
}
