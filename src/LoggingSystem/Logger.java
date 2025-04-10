package LoggingSystem;

public class Logger {
    public static void main(String args[]) {
        LogProcessor logProcessor = new InfoLogProcessor(new ErrorLogProcessor( new DebugLogProcessor(null)));
        logProcessor.log(LogType.DEBUG,"This is debug Hi");

        logProcessor.log(LogType.INFO,"This is INFO Hi");
        logProcessor.log(LogType.ERROR,"This is Error Hi");
        logProcessor.log(null,"This is null Hi");
    }
}
