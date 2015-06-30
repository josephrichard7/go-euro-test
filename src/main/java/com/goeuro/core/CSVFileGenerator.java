package com.goeuro.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;

import com.goeuro.core.exceptions.GoEuroException;
import com.goeuro.core.interfaces.ICSVFileGenerator;
import com.goeuro.core.interfaces.ICSVPrintable;
import com.goeuro.core.util.EGoEuroError;

/**
 * Class to generate a csv file.
 * 
 * @author Jose Mendoza
 */
public class CSVFileGenerator implements ICSVFileGenerator{
	private static final Logger logger = Logger.getLogger(CSVFileGenerator.class);
	private PrintWriter writer = null;
	
	private CSVFileGenerator(String filename) {
		init(filename);
	}
	
	/**
	 * Create a new instance for CSVFileGenerator. This create a file.
	 * 
	 * @param fileName
	 * @return CSVFileGenerator
	 */
	public static CSVFileGenerator newInstance(String fileName){
		// Return the instance after init the file
		return new CSVFileGenerator(fileName);
	}
	
	/**
	 * Init CSVFileGenerator. Creates the file.
	 * 
	 * @param filename
	 */
	private void init(String filename){
		// Create the file empty
		createFile(filename);
	}
	
	/**
	 * Creates the file.
	 * 
	 * @param filename
	 */
	private void createFile(String filename){
		try {
			this.writer = new PrintWriter(filename, StandardCharsets.UTF_8.name());
		} catch (IOException ioException) {
			throw new GoEuroException(EGoEuroError.CANNOTCREATECSVFILE, ioException); 
		}
	}
	
	/**
	 * Append a new record to file using a vo that implements ICSVPrintable interface. 
	 * 
	 * @param ICSVPrintable
	 */
	public void appendln(ICSVPrintable vo){
		try {
			// Get a VO's CSV representation and append it as a new record in the file. 
			getWriter().append(vo.toCSV());
			getWriter().append(System.lineSeparator());
		} catch (Exception exception) {
			throw new GoEuroException(EGoEuroError.CANNOTAPPENDTOFILE, exception); 
		}
	}

	/**
	 * Get Writer object.
	 * 
	 * @return Writer
	 */
	public PrintWriter getWriter() {
		return writer;
	}

	/**
	 * Flush and close writeriter.
	 */
	public void close(){
		try {
			getWriter().flush();
			getWriter().close();
		} catch (Exception exception) {
			throw new GoEuroException(EGoEuroError.CANNOTCLOSEFILE, exception);
		}			
	}
	
}
