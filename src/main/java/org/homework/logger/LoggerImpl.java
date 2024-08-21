package org.homework.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger as Slf4jLogger;

public class LoggerImpl implements Logger {
    private final Slf4jLogger logger;

    public LoggerImpl(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
