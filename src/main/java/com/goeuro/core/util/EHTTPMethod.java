package com.goeuro.core.util;

import com.goeuro.core.interfaces.IGoEuroEnum;

public enum EHTTPMethod implements IGoEuroEnum{

	GET{
		public String get() {
			return "GET";
		}
	},
	POST{
		public String get() {
			return "POST";
		}
	},
	DELETE{
		public String get() {
			return "DELETE";
		}
	},
	UPDATE{
		public String get() {
			return "UPDATE";
		}
	};	
}
