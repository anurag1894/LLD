package LF.strategy.formatter;

import LF.entity.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
