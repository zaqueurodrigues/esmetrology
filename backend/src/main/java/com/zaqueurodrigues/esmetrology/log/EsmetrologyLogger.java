package com.zaqueurodrigues.esmetrology.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EsmetrologyLogger {
	
	
	private static Map<Class, Logger>loggers = new HashMap<>();
	
	/**
	 * Register log events
	 * 
	 * @param logType Log Type
	 * @param loggerClass Class to which the log belongs
	 * @param msg Log message
	 * @param error Error that is related to the log, if applies
	 */
	@SuppressWarnings("rawtypes")
	public static void log(EsmetrologyLogType logType, Class loggerClass,  String msg, Throwable error) {
		Logger logger = getLogger( loggerClass );
		
		switch( logType ){
			case FATAL:
				logger.log( Level.FATAL, msg, error);
				//logger.fatal(msg, error);
				break;
			case ERROR:
				logger.log( Level.FATAL, msg, error);
				//logger.error(msg, error);
				break;
			case INFO:
				//logger.info(msg, error);
				logger.log( Level.INFO, msg, error);
				break;
			case DEBUG:
				//logger.debug(msg, error);
				logger.log( Level.DEBUG, msg, error);
				break;
			default:
				//logger.info(msg, error);
				logger.log( Level.INFO, msg, error);
		
		}

	}

	@SuppressWarnings("rawtypes")
	private static Logger getLogger(Class loggerClass) {
		
		if(!loggers.containsKey( loggerClass  )){
			
			Logger logger = LogManager.getLogger(loggerClass.getCanonicalName());
					
			loggers.put( loggerClass, logger );
			
		}

		return loggers.get( loggerClass );
	}
	
	public static Level getLogLevel(Class loggerClass) {
		Logger loggerInstance = getLogger(loggerClass);

		return loggerInstance.getLevel();
	}
	
	public static boolean isInDebugMode(Class loggerClass) {
		
		Logger loggerInstance = getLogger(loggerClass);
		
		return loggerInstance.getLevel().equals( Level.DEBUG );
	}

	@SuppressWarnings("rawtypes")
	public static void error(Class loggerClass, String msg, Throwable error) {
		
		log(EsmetrologyLogType.ERROR, loggerClass,  msg, error);
		
	}

	@SuppressWarnings("rawtypes")
	public static void debug(Class loggerClass, String msg, Throwable error) {
		log(EsmetrologyLogType.DEBUG, loggerClass,  msg, error);
		
	}
	
	public static void info(Class loggerClass, String msg, Throwable error) {
		log(EsmetrologyLogType.INFO, loggerClass,  msg, error);
		
	}

	public static void warn(Class loggerClass, String msg, Throwable error) {
		log(EsmetrologyLogType.WARNING, loggerClass,  msg, error);
		
	}


}
