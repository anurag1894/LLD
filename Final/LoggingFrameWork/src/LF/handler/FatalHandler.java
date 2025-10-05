package LF.handler;

import LF.entity.LogMessage;
import LF.enums.LogLevel;

/**
 * Handler for FATAL level messages
 */
public class FatalHandler implements LogHandler {
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
        return message.getLevel() == LogLevel.FATAL;
    }
    
    @Override
    public void processMessage(LogMessage message) {
        System.err.println("[FATAL HANDLER] 💀 " + message.getLoggerName() + 
                          " ****FATAL**** " + message.getMessage() + " 💀");
        // Could add additional fatal handling like system alerts, shutdown procedures, etc.
    }
}