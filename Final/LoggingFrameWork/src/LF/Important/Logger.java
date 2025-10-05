package LF.Important;

import LF.entity.LogMessage;
import LF.enums.LogLevel;
import LF.strategy.appender.LogAppender;
import LF.handler.LogHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Logger {
    private final String name;
    private LogLevel level;
    private final Logger parent;
    private final List<LogAppender> appenders;
    private boolean additivity = true;
    private LogHandler handlerChain; // COR Handler Chain

    Logger(String name, Logger parent) {
        this.name = name;
        this.parent = parent;
        this.appenders = new CopyOnWriteArrayList<>();
    }

    public void addAppender(LogAppender appender) {
        this.appenders.add(appender);
    }
    public List<LogAppender> getAppenders() {
        return appenders;
    }

    public void setLevel(LogLevel minLevel) {
        this.level = minLevel;
    }

    public void setAdditivity(boolean additivity) {
        this.additivity = additivity;
    }
    
    /**
     * Set the handler chain for Chain of Responsibility pattern
     */
    public void setHandlerChain(LogHandler handlerChain) {
        this.handlerChain = handlerChain;
    }

    public LogLevel getEffectiveLevel() {
        for (Logger logger = this; logger != null; logger = logger.parent) {
            LogLevel currentLevel = logger.level;
            if (currentLevel != null) {
                return currentLevel;
            }
        }
        return LogLevel.DEBUG; // Default root level
    }

    public void log(LogLevel messageLevel, String message) {
        if (messageLevel.isGreaterOrEqual(getEffectiveLevel())) {
            LogMessage logMessage = new LogMessage(messageLevel, this.name, message);
            callAppenders(logMessage);
        }
    }

    private void callAppenders(LogMessage logMessage) {
        // 1. Process through COR handler chain first
        if (handlerChain != null) {
            handlerChain.handle(logMessage);
        }
        
        // 2. Process through original appenders
        if (!appenders.isEmpty()) {
            LogManager.getInstance().getProcessor().process(logMessage, this.appenders);
        }
        
        // 3. Continue to parent logger (additivity)
        if (additivity && parent != null) {
            parent.callAppenders(logMessage);
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
