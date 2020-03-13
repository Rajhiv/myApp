package com.demo.myApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myApp.model.CollegeResponse;
import com.demo.myApp.model.SearchCriteria;
import com.demo.myApp.provider.CollegeResponseProvider;

@Service
public class CollegeProviderService {

	@Autowired
	CollegeResponseProvider crProvider;
	
	Logger log = LoggerFactory.getLogger(CollegeProviderService.class);
	
	public CollegeResponse getSearchResults(SearchCriteria sc) throws Exception {
		try {
			String queryParams = generateQueryParams(sc);
			CollegeResponse cr = crProvider.getSearchResults(queryParams);
			return cr;
		}catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Oops...something went wrong at service call");
		}
		
	}

	private String generateQueryParams(SearchCriteria sc) {
		
		String queryParams = "";
		
		if(sc.getDistance()>0)
			queryParams += "&distance="+sc.getDistance()+"mi";
		if(sc.getZip()>0)
			queryParams +="&zip="+sc.getZip();
		if(sc.getAwards()!=null && sc.getAwards().length()>0)
			queryParams +="&school.degrees_awarded.predominant="+sc.getAwards();

		String year = (sc.getYear() == 0)?"latest":""+sc.getYear();
		queryParams +="&fields=id,school.name,"+year+".student.size"
						+"&sort="+year+".student.size";
		return queryParams;
	}
}
