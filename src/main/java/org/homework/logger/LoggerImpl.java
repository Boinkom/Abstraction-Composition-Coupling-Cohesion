package org.homework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerImpl implements org.homework.logger.Logger {
    private final Logger logger;

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
