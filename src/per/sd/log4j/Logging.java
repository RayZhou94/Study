package per.sd.log4j;

import org.apache.log4j.Logger;

public class Logging {
	private static final Logger logger = Logger.getLogger(Logging.class);
	
	public static void main(String[] args) {
		print("HelloWorld");
	}
	public static void print(String str){
		logger.info("begin..." + str);
		System.out.println("Logging...");
		logger.info("after..." + str);
	}
}
