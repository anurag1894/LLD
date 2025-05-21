package LoggingService.strategy;

public class DBLoggingStrategy implements LogProcessorStrategy{
    @Override
    public void processLog(String log) {
        System.out.println("Adding to DB " + log);
    }
}
