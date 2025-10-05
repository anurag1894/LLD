package LF.handler;

import LF.entity.LogMessage;

/**
 * Chain of Responsibility Handler Interface
 */
public interface LogHandler {
    /**
     * Set the next handler in the chain
     */
    void setNext(LogHandler nextHandler);
    
    /**
     * Handle the log message - implements COR logic
     */
    default void handle(LogMessage message) {
        if (canHandle(message)) {
            processMessage(message);
        }
        
        // Always pass to next handler (for additivity behavior)
        LogHandler next = getNext();
        if (next != null) {
            next.handle(message);
        }
    }
    
    /**
     * Check if this handler can process the message
     */
    boolean canHandle(LogMessage message);
    
    /**
     * Process the message (implemented by concrete handlers)
     */
    void processMessage(LogMessage message);
    
    /**
     * Get the next handler in chain
     */
    LogHandler getNext();
}