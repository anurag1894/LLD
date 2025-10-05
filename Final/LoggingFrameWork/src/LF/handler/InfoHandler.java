package LF.handler;

import LF.entity.LogMessage;
import LF.enums.LogLevel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handler for INFO level messages
 */
public class InfoHandler implements LogHandler {
    private LogHandler nextHandler;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
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
        return message.getLevel() == LogLevel.INFO;
    }
    
    @Override
    public void processMessage(LogMessage message) {
        String timestamp = dateFormat.format(new Date());
        System.out.println("[INFO HANDLER] ℹ️  " + message.getLoggerName() + 
                          " [" + timestamp + "] " + message.getMessage());
    }
}