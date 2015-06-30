package com.goeuro.desg.vos;

public class GeopositionVO {

	private String latitude;
	private String longitude;
	
	public GeopositionVO() {
	}
	
	public GeopositionVO(
		String latitude,
		String longitude
	) {
		this.latitude  = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}