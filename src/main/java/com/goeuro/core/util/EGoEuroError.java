package com.goeuro.core.util;

import com.goeuro.core.interfaces.IGoeuroErrorEnum;

public enum EGoEuroError implements IGoeuroErrorEnum{

	PARSE_JSONARRAY_POSITION{
		public String getErrorCode() {
			return "GE0001";
		}
		public String getErrorDesc() {
			return "Error parsing JSON returned by rest service for the position.";
		}
	},
	INVALIDURL{
		public String getErrorCode() {
			return "GE0002";
		}
		public String getErrorDesc() {
			return "Invalid url.";
		}
	},
	CANNOTGETURLCONNECTION{
		public String getErrorCode() {
			return "GE0003";
		}
		public String getErrorDesc() {
			return "Can not get connection to url.";
		}
	},
	HTTPERROR{
		public String getErrorCode() {
			return "GE0004";
		}
		public String getErrorDesc() {
			return "HTTP error has ocurred. Code: %s";
		}
	},
	INVALIDHTTPMETHOD{
		public String getErrorCode() {
			return "GE0005";
		}
		public String getErrorDesc() {
			return "HTTP method is invalid.";
		}
	}
	,
	CANNOTGETHTTPRESPONSE{
		public String getErrorCode() {
			return "GE0006";
		}
		public String getErrorDesc() {
			return "Error ocurred getting response from url execution";
		}
	},
	CANNOTCREATECSVFILE{
		public String getErrorCode() {
			return "GE0007";
		}
		public String getErrorDesc() {
			return "Error creating CSV file.";
		}
	},
	CANNOTAPPENDTOFILE{
		public String getErrorCode() {
			return "GE0008";
		}
		public String getErrorDesc() {
			return "Error appending string to file.";
		}
	},
	CANNOTCLOSEFILE{
		public String getErrorCode() {
			return "GE0009";
		}
		public String getErrorDesc() {
			return "Error occurred while flushing and closing the file.";
		}
	}
	;
	
}
