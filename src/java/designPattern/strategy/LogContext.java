package designPattern.strategy;

/**
 * Comparator
 */
public class LogContext {

    public void log(String msg) {
        LogStrategy strategy = new DbLog();
        strategy.log(msg);
    }
}
