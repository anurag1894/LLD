package LoggingService.mgmt;

import LoggingService.strategy.LogProcessorStrategy;

public class LogProcessor {
    LogProcessorStrategy strategy;

    public LogProcessor(LogProcessorStrategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(LogProcessorStrategy strategy) {
        this.strategy = strategy;
    }

    public void processLog(String message) {
        strategy.processLog(message);
    }
}
