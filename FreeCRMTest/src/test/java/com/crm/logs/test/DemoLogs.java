package com.crm.logs.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;



public class DemoLogs {

	static Logger log = LogManager.getLogger(DemoLogs.class);
//	static Logger log = Logger.getLogger(DemoLogs.class);
	public static void main(String[] args) {

		
		log.info("browser launched");
		log.warn("Application launched");
		log.error("enter username");
		log.fatal("enter password");
		log.info("click login button");
		log.warn("Home page opened");
		log.error("click logout");
		log.fatal("login page opened.");
		
	}
}
