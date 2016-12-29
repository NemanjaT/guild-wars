package com.nemanjat94.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neman on 29-Dec-16.
 *
 * Logger utility - currently uses log4j
 */
public class Logger {
  private org.apache.log4j.Logger log4jLogger;

  private static Map<Class<?>, Logger> loggers = new HashMap<>();

  public enum Level{
    INFO, WARN, ERROR, TRACE, DEBUG
  }

  public static Logger getLogger(Class<?> tClass) {
    for (Map.Entry<Class<?>, Logger> logger : loggers.entrySet()) {
      if (tClass == logger.getKey() || tClass.equals(logger.getKey())) {
        return logger.getValue();
      }
    }
    Logger newLogger = new Logger(tClass);
    loggers.put(tClass, newLogger);
    return newLogger;
  }

  private Logger(Class<?> tClass) {
    log4jLogger = org.apache.log4j.Logger.getLogger(tClass);
  }

  public void info(Object... message) {
    for (Object obj : message) {
      log4jLogger.info(obj);
    }
  }

  public void info(Object message, Throwable throwable) {
    log4jLogger.info(message, throwable);
  }

  public void debug(Object... message) {
    for (Object obj : message) {
      log4jLogger.debug(obj);
    }
  }

  public void debug(Object message, Throwable throwable) {
    log4jLogger.debug(message, throwable);
  }

  public void warn(Object... message) {
    for (Object obj : message) {
      log4jLogger.warn(obj);
    }
  }

  public void warn(Object message, Throwable throwable) {
    log4jLogger.warn(message, throwable);
  }

  public void error(Object... message) {
    for (Object obj : message) {
      log4jLogger.error(obj);
    }
  }

  public void error(Object message, Throwable throwable) {
    log4jLogger.error(message, throwable);
  }

  public void trace(Object... message) {
    for (Object obj : message) {
      log4jLogger.trace(obj);
    }
  }

  public void trace(Object message, Throwable throwable) {
    log4jLogger.trace(message, throwable);
  }

  public void log(Level level, Object... message) {
    switch (level) {
      case INFO:
        info(message);
        break;
      case WARN:
        warn(message);
        break;
      case ERROR:
        error(message);
        break;
      case TRACE:
        trace(message);
        break;
      case DEBUG:
        debug(message);
        break;
    }
  }

  public void log(Level level, Object message, Throwable throwable) {
    switch (level) {
      case INFO:
        info(message, throwable);
        break;
      case WARN:
        warn(message, throwable);
        break;
      case ERROR:
        error(message, throwable);
        break;
      case TRACE:
        trace(message, throwable);
        break;
      case DEBUG:
        debug(message, throwable);
        break;
    }
  }

}
