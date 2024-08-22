package org.homework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerImpl {
    private final Logger logger;

    public LoggerImpl(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
