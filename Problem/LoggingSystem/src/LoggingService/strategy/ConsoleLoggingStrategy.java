package LoggingService.strategy;

public class ConsoleLoggingStrategy implements LogProcessorStrategy{

    @Override
    public void processLog(String log) {
        System.out.println("printing on Console " + log);
    }
}
