package com.goeuro.entry;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.goeuro.core.exceptions.GoEuroServiceException;
import com.goeuro.desg.interfaces.IPosition;
import com.goeuro.impl.services.PositionSrvImpl;

public class Entry {

	private static Logger logger 					= Logger.getLogger(Entry.class);
	private static final String PREFIX_FILENAME 	= "GoEuroPositionsCSV";
	private static final String EXT 				= ".csv";
	
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = null;
		Date now 					= new Date();
		String filename				= null;
		String createdDate	 		= null;				
		String filter 				= null;
		Entry entry 				= new Entry();
		
		try{
			if(args == null || args.length <= 0)
				return;
			
			logger.info("Start to create the file.");
	
			filter 		= args[0];
			dateFormat 	= new SimpleDateFormat("yyyyMMddhhmmss");
			createdDate	= dateFormat.format(now);
			filename 	= PREFIX_FILENAME + "_" + createdDate + EXT;
			
			entry.generatePositionsCSVFile(filter, filename);
			
			logger.info("Finished creating the file: " + filename);
		} catch(GoEuroServiceException goEuroServiceException){
			logger.error(goEuroServiceException);
		} catch(Exception exception){
			logger.error(exception);
		}
	}
	
	public void generatePositionsCSVFile(String filter, String filename){
		IPosition position = new PositionSrvImpl();
		position.positionsToCSVFile(position.queryPositions(filter), filename);
	};
}
