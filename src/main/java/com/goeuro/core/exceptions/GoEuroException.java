package com.goeuro.core.exceptions;

import java.io.Serializable;

import com.goeuro.core.util.EGoEuroError;
import com.goeuro.core.util.Util;

public class GoEuroException extends GoEuroServiceException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EGoEuroError error 	= null;
	private String[] params 	= null;
  	
  	public GoEuroException(){
  	}

  	public GoEuroException(EGoEuroError error, Throwable cause){
		super(error.getErrorDesc(), cause);
		this.error 	= error;
	}
  	
  	public GoEuroException(EGoEuroError error, Throwable cause, String ... params){
		super(Util.replaceParams(error.getErrorDesc(), params), cause);
		this.error 	= error;
		this.params	= params;
	}
	
	public EGoEuroError getError() {
		return error;
	}

	public void setError(EGoEuroError error) {
		this.error = error;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
	
}