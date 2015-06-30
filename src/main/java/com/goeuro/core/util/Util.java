package com.goeuro.core.util;

import org.apache.log4j.Logger;

/**
 * Util is a class with utility methods for all the project.
 * 
 * @author Jose Mendoza
 */
public class Util {

	private static final Logger logger = Logger.getLogger(Util.class);
	public static final String CSV_FIELD_SEPARATOR = ";";

	/**
	 * Check if a string is empty.
	 * 
	 * @param value
	 * @return boolean
	 */
	public static boolean isEmpty(String value){
		if(value == null)
			return true;
		if(value.trim().equals(""))
			return true;
		
		return false;
	}

	/**
	 * Replace parameters in the string in the order received.
	 * 
	 * @param string
	 * @param parameters
	 * @return String
	 */
	public static String replaceParams(String string, String... parameters) {
		return String.format(string, (Object[]) parameters);
	}
}
