package com.goeuro.core.util;

import com.goeuro.core.interfaces.IGoEuroEnum;

public enum EHTTPRequestProperty implements IGoEuroEnum{

	ACCEPT{
		public String get() {
			return "Accept";
		}
	};	
}
