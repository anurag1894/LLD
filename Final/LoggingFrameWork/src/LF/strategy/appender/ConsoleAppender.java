package LF.strategy.appender;

import LF.entity.LogMessage;
import LF.strategy.formatter.LogFormatter;
import LF.strategy.formatter.SampleFormatter;

public class ConsoleAppender implements LogAppender{
    private LogFormatter formatter;

    public ConsoleAppender() {
        this.formatter = new SampleFormatter();
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }

    @Override
    public void close() {}

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }
}
