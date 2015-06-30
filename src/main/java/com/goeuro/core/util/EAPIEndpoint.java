package com.goeuro.core.util;

import com.goeuro.core.interfaces.IGoEuroEnum;

public enum EAPIEndpoint implements IGoEuroEnum{

	POSITION_QUERY{
		public String get() {
			return "http://api.goeuro.com/api/v2/position/suggest/en/%s";
		}
	};
	
}
