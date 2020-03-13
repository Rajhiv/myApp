package com.demo.myApp.provider;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.myApp.model.CollegeResponse;

@Component
public class CollegeResponseProviderImpl implements CollegeResponseProvider {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${college.baseurl}")
	String baseUrl;
	
	Logger log = org.slf4j.LoggerFactory.getLogger(CollegeResponseProviderImpl.class);

	@Override
	public CollegeResponse getSearchResults(String queryParams) throws Exception {
		try {
		String queryUrl = baseUrl + queryParams;
		CollegeResponse cr = restTemplate.getForObject(queryUrl, CollegeResponse.class);
		return cr;
		}
		catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Oops...something went wrong while retrieving data");
		}
		
	}
	
	
}
