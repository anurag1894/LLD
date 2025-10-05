package LF.handler;

import LF.entity.LogMessage;
import LF.enums.LogLevel;

/**
 * Handler for DEBUG level messages
 */
public class DebugHandler implements LogHandler {
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
        return message.getLevel() == LogLevel.DEBUG;
    }
    
    @Override
    public void processMessage(LogMessage message) {
        System.out.println("[DEBUG HANDLER] 🐛 " + message.getLoggerName() + 
                          " [Thread: " + Thread.currentThread().getName() + "] " +
                          message.getMessage());
    }
}