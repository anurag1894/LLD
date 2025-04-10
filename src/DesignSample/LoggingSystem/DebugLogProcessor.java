package LoggingSystem;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    void log(LogType logType, String message) {
        if(LogType.DEBUG.equals(logType)){
            System.out.println("This is debug log type with message : " + message);
        } else {
            System.out.println("This is not debug log with message : " + message);
            super.log(logType, message);
        }
    }
}
