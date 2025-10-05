package LF;

import LF.Important.LogManager;
import LF.Important.Logger;
import LF.enums.LogLevel;
import LF.handler.*;
import LF.strategy.appender.ConsoleAppender;

/**
 * Example demonstrating Chain of Responsibility pattern in Logging Framework
 */
public class CORDemo {
    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility Pattern Demo ===\n");
        
        // 1. Setup basic logging
        LogManager logManager = LogManager.getInstance();
        Logger rootLogger = logManager.getRootLogger();
        rootLogger.setLevel(LogLevel.DEBUG);
        rootLogger.addAppender(new ConsoleAppender());
        
        // 2. Create COR handler chain: DEBUG -> INFO -> WARN -> ERROR -> FATAL
        DebugHandler debugHandler = new DebugHandler();
        InfoHandler infoHandler = new InfoHandler();
        WarnHandler warnHandler = new WarnHandler();
        ErrorHandler errorHandler = new ErrorHandler();
        FatalHandler fatalHandler = new FatalHandler();
        
        // Build the chain
        debugHandler.setNext(infoHandler);
        infoHandler.setNext(warnHandler);
        warnHandler.setNext(errorHandler);
        errorHandler.setNext(fatalHandler);
        
        // 3. Create loggers and attach handler chain
        Logger appLogger = logManager.getLogger("com.example.app");
        appLogger.setHandlerChain(debugHandler);
        
        Logger dbLogger = logManager.getLogger("com.example.db");
        dbLogger.setHandlerChain(debugHandler);
        
        // 4. Test all log levels
        System.out.println("🔍 Testing COR Handler Chain:\n");
        
        System.out.println("--- DEBUG Level ---");
        appLogger.debug("Application started successfully");
        
        System.out.println("\n--- INFO Level ---");
        appLogger.info("User logged in");
        
        System.out.println("\n--- WARN Level ---");
        dbLogger.warn("Connection pool running low");
        
        System.out.println("\n--- ERROR Level ---");
        dbLogger.error("Failed to connect to database");
        
        System.out.println("\n--- FATAL Level ---");
        appLogger.fatal("System memory exhausted");
        
        System.out.println("\n=== COR Pattern Explanation ===");
        System.out.println("✅ Each message flows through the entire handler chain");
        System.out.println("✅ Only the matching handler processes the message");
        System.out.println("✅ Original appenders still work (see console output below handlers)");
        System.out.println("✅ Parent loggers receive messages via additivity");
        
        try {
            Thread.sleep(500);
            logManager.shutdown();
        } catch (Exception e) {
            System.out.println("Exception during shutdown");
        }
    }
}