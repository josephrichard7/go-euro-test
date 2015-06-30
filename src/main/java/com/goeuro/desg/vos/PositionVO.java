package com.goeuro.desg.vos;

import com.goeuro.core.interfaces.ICSVPrintable;
import com.goeuro.impl.helpers.PositionHelper;

public class PositionVO implements ICSVPrintable{

	private String id;
	private String name;
	private String type;
	private GeopositionVO geopositionVO;
	
	// TODO Add fields missing. 
	
	public PositionVO() {
	}
	
	public PositionVO(
		String id,
		String name,
		String type,
		GeopositionVO geopositionVO
	) {
		this.id        		= id;
		this.name      		= name;
		this.type      		= type;
		this.geopositionVO 	= geopositionVO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GeopositionVO getGeopositionVO() {
		return geopositionVO;
	}

	public void setGeopositionVO(GeopositionVO geopositionVO) {
		this.geopositionVO = geopositionVO;
	}

	public String toCSV() {
		return PositionHelper.positionVOtoCSV(this);
	}
}
