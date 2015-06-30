package com.goeuro.core.interfaces;

import java.util.Map;

public interface IRestClient {

	String get();
	String post(Map<String, String> mapValues);
	String delete(Map<String, String> mapValues);
	String update(Map<String, String> mapValues);
}
