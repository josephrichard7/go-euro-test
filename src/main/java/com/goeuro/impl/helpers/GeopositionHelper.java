package com.goeuro.impl.helpers;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.goeuro.desg.vos.GeopositionVO;

/**
 * Helper class for a geoposition.
 * 
 * @author Jose Mendoza
 */
public class GeopositionHelper {
	
	private static final Logger logger = Logger.getLogger(GeopositionHelper.class);

	/**
	 * Parse a JSON representation object of a geoposition to a GeopositionVO object.
	 * 
	 * @param jsonObject
	 * @return GeopositionVO
	 */
	public static GeopositionVO geopositionJSONObjecttoVO(JSONObject jsonObject){
		GeopositionVO geopositionVO	= null;
		
		if(jsonObject == null)
			return null;

		geopositionVO = new GeopositionVO();
		geopositionVO.setLatitude((String) jsonObject.get("latitude").toString());
		geopositionVO.setLongitude((String) jsonObject.get("longitude").toString());
		
		return geopositionVO;
	}
	
}
