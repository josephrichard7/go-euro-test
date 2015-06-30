package com.goeuro.impl.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.goeuro.core.CSVFileGenerator;
import com.goeuro.core.RestClient;
import com.goeuro.core.interfaces.ICSVFileGenerator;
import com.goeuro.core.interfaces.IRestClient;
import com.goeuro.core.util.EAPIEndpoint;
import com.goeuro.core.util.Util;
import com.goeuro.desg.services.AbstractPositionSrv;
import com.goeuro.desg.vos.PositionVO;
import com.goeuro.impl.helpers.PositionHelper;

/**
 * Implementation of Position service.
 * 
 * @author Jose Mendoza
 */
public class PositionSrvImpl extends AbstractPositionSrv{
	
	private static final Logger logger = Logger.getLogger(PositionSrvImpl.class);

	/**
	 * Query positions using an REST API.
	 * 
	 * @param String
	 * @return List<PositionVO>
	 */
	@Override
	protected List<PositionVO> doQueryPositions(String filter) {
		List<PositionVO> listPositionVO = null;
		IRestClient restClient			= null;
		String url 						= null;
		String positionJsonArray 		= null;
		
		// If filter is empty, stop execution
		if(Util.isEmpty(filter))
			return null;
	
		// Query the positions using the REST API
		url 				= EAPIEndpoint.POSITION_QUERY.get();
		// Call API
		restClient 			= RestClient.newClient(Util.replaceParams(url, filter));
		positionJsonArray 	= restClient.get();
		// Parse the JSON array of positions returned by REST API to a list of PositionVO
		listPositionVO 		= PositionHelper.positionJSONArrayToVOs(positionJsonArray);
		
		return listPositionVO;
	}
	
	/**
	 * Create a CSV file with a list of positions.
	 * 
	 * @param List<PositionVO>
	 * @param String
	 */
	@Override
	protected void doPositionsToCSVFile(List<PositionVO> positions, String filename) {
		ICSVFileGenerator csvFileGenerator = null;
		
		// If the list of position is empty, create the file empty.
		// Create CSV file instance.
		csvFileGenerator = CSVFileGenerator.newInstance(filename);
		if(positions != null && positions.size() > 0){
			// Print positionVO in the file in CSV format.
			for(PositionVO positionVO: positions){
				csvFileGenerator.appendln(positionVO);
			}
		}
		// Flush and close the file
		csvFileGenerator.close();
	}
}
