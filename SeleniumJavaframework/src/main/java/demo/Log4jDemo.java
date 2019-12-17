package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	//To switch between properties file and xml config file for more advanced features you need to rename the relevant config file
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
			
	public static void main(String[] args) {
		
		System.out.println("Hello world....!    \n");
		
		logger.trace("This is trace message");
		logger.info("This is information message");
		logger.error("This is an error message");
		logger.warn("This is an warning message");
		logger.fatal("This is an fatal message");
		
		System.out.println("\n Completed");

	}

}
