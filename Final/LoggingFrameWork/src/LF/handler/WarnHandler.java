package LF.handler;

import LF.entity.LogMessage;
import LF.enums.LogLevel;

/**
 * Handler for WARN level messages
 */
public class WarnHandler implements LogHandler {
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
        return message.getLevel() == LogLevel.WARN;
    }
    
    @Override
    public void processMessage(LogMessage message) {
        System.out.println("[WARN HANDLER] ⚠️  " + message.getLoggerName() + 
                          " **WARNING** " + message.getMessage() + " ⚠️");
    }
}