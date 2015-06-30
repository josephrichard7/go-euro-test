package com.goeuro.impl.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.goeuro.core.exceptions.GoEuroException;
import com.goeuro.core.util.EGoEuroError;
import com.goeuro.core.util.Util;
import com.goeuro.desg.vos.PositionVO;

/**
 * Helper class for a position.
 * 
 * @author Jose Mendoza
 */
public class PositionHelper {

	private static final Logger logger = Logger.getLogger(PositionHelper.class);
	
	/**
	 * Parse a JSON representation object of a position to a PositionVO object.
	 * 
	 * @param jsonObject
	 * @return PositionVO
	 */
	public static PositionVO positionJSONObjToVO(JSONObject jsonObject){
		PositionVO positionVO 			= null;
		JSONObject geopositionJSONObj	= null;
		
		if(jsonObject == null)
			return null;
			
		positionVO = new PositionVO();
		positionVO.setId((String) jsonObject.get("_id").toString());
		positionVO.setName((String) jsonObject.get("name"));
		positionVO.setType((String) jsonObject.get("type"));
		
		geopositionJSONObj = (JSONObject) jsonObject.get("geo_position");
		positionVO.setGeopositionVO(GeopositionHelper.geopositionJSONObjecttoVO(geopositionJSONObj));
		
		return positionVO;
	}
	
	/**
	 * Parse a JSON array representation of a position to a List of PositionVO.
	 * 
	 * @param positionJSONArray
	 * @return List<PositionVO>
	 */
	public static List<PositionVO> positionJSONArrayToVOs(String positionJSONArray){
		List<PositionVO> vos 	= null;
		JSONParser jsonParser 	= null;
		JSONArray jsonArray 	= null;

		if(Util.isEmpty(positionJSONArray))
			return null;
			
		try {			
			vos 		= new ArrayList<PositionVO>();
			jsonParser	= new JSONParser();
			jsonArray 	= (JSONArray) jsonParser.parse(positionJSONArray);
			if(jsonArray != null && jsonArray.size() > 0){
				for(Object obj: jsonArray){
					vos.add(positionJSONObjToVO((JSONObject)obj));
				}
			}
		} catch (ParseException parseException) {
			throw new GoEuroException(EGoEuroError.PARSE_JSONARRAY_POSITION, parseException);
		}
		
		return vos;
	}
	
	/**
	 * Helper method to get a csv representation of a position.
	 * 
	 * @param positionVO
	 * @return String
	 */
	public static String positionVOtoCSV(PositionVO positionVO){
		StringBuilder stringBuilder = null;
		
		if(positionVO == null)
			return null;
		
		stringBuilder = new StringBuilder();
		stringBuilder.append(positionVO.getId());
		stringBuilder.append(Util.CSV_FIELD_SEPARATOR);
		stringBuilder.append(positionVO.getName());
		stringBuilder.append(Util.CSV_FIELD_SEPARATOR);
		stringBuilder.append(positionVO.getType());
		stringBuilder.append(Util.CSV_FIELD_SEPARATOR);
		
		if(positionVO.getGeopositionVO() != null){
			stringBuilder.append(positionVO.getGeopositionVO().getLatitude());
			stringBuilder.append(Util.CSV_FIELD_SEPARATOR);
			stringBuilder.append(positionVO.getGeopositionVO().getLongitude());
		}else{
			stringBuilder.append(Util.CSV_FIELD_SEPARATOR);
		}
		
		return stringBuilder.toString();
	}
}
