package LF.handler;

import LF.entity.LogMessage;
import LF.enums.LogLevel;

/**
 * Handler for ERROR level messages
 */
public class ErrorHandler implements LogHandler {
    private LogHandler nextHandler;
    
    @Override
    public void setNext(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    @Override
    public LogHandler getNext() {
        return nextHandler;
    }
    
    @Override
    public boolean canHandle(LogMessage message) {
        return message.getLevel() == LogLevel.ERROR;
    }
    
    @Override
    public void processMessage(LogMessage message) {
        System.err.println("[ERROR HANDLER] ❌ " + message.getLoggerName() + 
                          " ***ERROR*** " + message.getMessage() + " ❌");
    }
}