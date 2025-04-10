package LoggingSystem;

public class InfoLogProcessor extends LogProcessor{
    InfoLogProcessor(LogProcessor logProcessor){
        super(logProcessor);
    }

    @Override
    void log(LogType logType, String message) {
        if(LogType.INFO.equals(logType)){
            System.out.println("This is info log with message : " + message);
        }  else {
            System.out.println("This is not info log with message : " + message);
            super.log(logType, message);
        }
    }
}
