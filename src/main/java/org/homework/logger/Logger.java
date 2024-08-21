package org.homework.logger;

public interface Logger {
    void info(String message);
    void debug(String message);
    void error(String message, Throwable throwable);
}
