package LF.strategy.formatter;


import LF.entity.LogMessage;

import java.time.format.DateTimeFormatter;

public class SampleFormatter implements LogFormatter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s [%s] %s - %s: %s\n",
                logMessage.getTimestamp().format(DATE_TIME_FORMATTER),
                logMessage.getThreadName(),
                logMessage.getLevel(),
                logMessage.getLoggerName(),
                logMessage.getMessage());
    }
}
