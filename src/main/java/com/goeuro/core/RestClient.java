package com.goeuro.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.log4j.Logger;

import com.goeuro.core.exceptions.GoEuroException;
import com.goeuro.core.interfaces.IRestClient;
import com.goeuro.core.util.EGoEuroError;
import com.goeuro.core.util.EHTTPContentType;
import com.goeuro.core.util.EHTTPMethod;
import com.goeuro.core.util.EHTTPRequestProperty;

/**
 * RestClient is the class used to consume rest resources.
 * 
 * @author Jose Mendoza
 */
public class RestClient implements IRestClient {
	private static final Logger logger = Logger.getLogger(RestClient.class);
	private String sourceUrl 		= null;
	private URL url 				= null;
	private HttpURLConnection conn 	= null;
	
	// Constants
	private final EHTTPContentType DEFAULT_CONTENT_TYPE	= EHTTPContentType.JSON;

	private RestClient(String url) {
		this.sourceUrl = url;
		// Init url connection
		init();
	}
	
	/**
	 * Execute DELETE HTTP method for the url.
	 * @return String
	 */
	public String delete(Map<String, String> mapValues) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Free url and http connection.
	 */
	private void disconnect(){
		// Free url object
		this.url = null;
		// Disconnect http connection
		getConn().disconnect();
	}
	
	/**
	 * Execute the set method for the url.
	 * @return String
	 */
	private String execute(){
		String result = null;
		
		// Get the execution result of the url 
		result = getResult();

		// Free url and http connection
		disconnect();
		
		return result;
	}
	
	/**
	 * Execute GET HTTP method for the url.
	 * @return String
	 */
	public String get() {
		String result 			= null;

		setHTTPMethod(EHTTPMethod.GET);
		result = execute();
			
		return result;
	}
	
	/**
	 * Get http connection
	 * @return HttpURLConnection
	 */
	public HttpURLConnection getConn() {
		return conn;
	}

	/**
	 * Get the result of the url execution.
	 * @return String
	 */
	private String getResult(){
		BufferedReader bufferedReader 	= null;
		StringBuilder result 			= new StringBuilder();
		String readLine					= null;

		try{
			if(getConn().getResponseCode() != HttpURLConnection.HTTP_OK){
				throw new GoEuroException(EGoEuroError.HTTPERROR, new RuntimeException(), ""+getConn().getResponseCode());
			}
	 
			bufferedReader = new BufferedReader(new InputStreamReader((getConn().getInputStream()),StandardCharsets.UTF_8));
	 
			while((readLine = bufferedReader.readLine()) != null){
				result.append(readLine);
			}
		} catch (IOException ioException) {
			throw new GoEuroException(EGoEuroError.CANNOTGETHTTPRESPONSE, ioException);
		}
		
		return result.toString();
	}
	
	/**
	 * Get url object.
	 * @return URL
	 */
	private URL getUrl() {
		return this.url;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}	
	
	/**
	 * Initialize url connection
	 * @param url
	 * @return RestClient
	 */
	public RestClient init(){
		initUrl();
		openConnection();
		setContentType(this.DEFAULT_CONTENT_TYPE);
		return this;
	}

	/**
	 * Init URL object.
	 * @param url
	 */
	private void initUrl(){
		try{
			this.url = new URL(getSourceUrl());
		} catch (MalformedURLException malformedURLException) {
			throw new GoEuroException(EGoEuroError.INVALIDURL, malformedURLException);
		}
	}
	
	/**
	 * Return a new RestClient instance 
	 * @param url
	 * @return RestClient
	 */
	public static RestClient newClient(String url){
		return new RestClient(url);
	}
	
	/**
	 * Execute POST HTTP method for the url.
	 * @param Map<String, String>
	 * @return String
	 */
	public String post(Map<String, String> mapValues) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Open url connection.
	 */
	private void openConnection(){
		try{
			this.conn = (HttpURLConnection) getUrl().openConnection();
		} catch (IOException ioException) {
			throw new GoEuroException(EGoEuroError.CANNOTGETURLCONNECTION, ioException);
		}
	}
	
	/**
	 * Set the content type property 'Accept' for request.
	 * @param contentType
	 */
	private void setContentType(EHTTPContentType contentType){
		getConn().setRequestProperty(EHTTPRequestProperty.ACCEPT.get(), contentType.get());
	}
	
	/**
	 * Set http method.
	 * @param httpMethod
	 */
	private void setHTTPMethod(EHTTPMethod httpMethod){
		try{
			getConn().setRequestMethod(httpMethod.get());
		} catch (ProtocolException protocolException) {
			throw new GoEuroException(EGoEuroError.INVALIDHTTPMETHOD, protocolException);
		}
	}
	
	/**
	 * Execute UPDATE HTTP method for the url.
	 * @param Map<String, String>
	 * @return String
	 */
	public String update(Map<String, String> mapValues) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
