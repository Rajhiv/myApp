package com.demo.myApp.provider;

import com.demo.myApp.model.CollegeResponse;

public interface CollegeResponseProvider {

	public CollegeResponse getSearchResults(String input) throws Exception;
}
