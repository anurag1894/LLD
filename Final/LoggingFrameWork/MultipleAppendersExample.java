package LoggingFrameWork;

import LF.Important.LogManager;
import LF.Important.Logger;
import LF.enums.LogLevel;
import LF.strategy.appender.ConsoleAppender;

// Custom appender to demonstrate the concept
class PrefixedConsoleAppender implements LF.strategy.appender.LogAppender {
    private final String prefix;
    private LF.strategy.formatter.LogFormatter formatter;

    public PrefixedConsoleAppender(String prefix) {
        this.prefix = prefix;
        this.formatter = new LF.strategy.formatter.SampleFormatter();
    }

    @Override
    public void append(LF.entity.LogMessage logMessage) {
        System.out.println(prefix + " " + formatter.format(logMessage));
    }

    @Override
    public void close() {}

    @Override
    public void setFormatter(LF.strategy.formatter.LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LF.strategy.formatter.LogFormatter getFormatter() {
        return formatter;
    }
}

public class MultipleAppendersExample {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance();
        
        System.out.println("=== Setting up Logger Hierarchy with Multiple Appenders ===");
        
        // Setup root logger
        Logger rootLogger = logManager.getRootLogger();
        rootLogger.setLevel(LogLevel.INFO);
        rootLogger.addAppender(new PrefixedConsoleAppender("[ROOT-CONSOLE]")); 
        
        // Setup intermediate parent logger
        Logger exampleLogger = logManager.getLogger("com.example");
        exampleLogger.addAppender(new PrefixedConsoleAppender("[APP-LOG]")); 
        
        // Setup specific logger
        Logger dbLogger = logManager.getLogger("com.example.db");
        dbLogger.addAppender(new PrefixedConsoleAppender("[DB-LOG]")); 
        
        System.out.println("\n=== Single Log Call - Multiple Outputs ===");
        
        // This single log call will write to 3 places!
        dbLogger.info("Database connection established");
        
        System.out.println("\n=== Explanation ===");
        System.out.println("The message 'Database connection established' appeared 3 times because:");
        System.out.println("1. [DB-LOG] - from dbLogger's own appender");
        System.out.println("2. [APP-LOG] - from com.example parent's appender"); 
        System.out.println("3. [ROOT-CONSOLE] - from root parent's appender");
        System.out.println("This is due to additivity - message propagates up the parent chain!");
        
        try {
            Thread.sleep(500);
            logManager.shutdown();
        } catch (Exception e) {
            System.out.println("Exception during shutdown");
        }
    }
}