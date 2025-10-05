package LF.strategy.appender;

import LF.entity.LogMessage;
import LF.strategy.formatter.LogFormatter;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
}
