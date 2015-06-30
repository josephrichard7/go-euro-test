package com.goeuro.core.util;

import com.goeuro.core.interfaces.IGoEuroEnum;

public enum EHTTPContentType implements IGoEuroEnum{

	JSON{
		public String get() {
			return "application/json";
		}
	},
	XML{
		public String get() {
			return "application/xml";
		}
	}
	;
}
