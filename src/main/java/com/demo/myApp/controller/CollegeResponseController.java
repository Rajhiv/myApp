package com.demo.myApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myApp.model.CollegeResponse;
import com.demo.myApp.model.SearchCriteria;
import com.demo.myApp.provider.CollegeResponseProvider;
import com.demo.myApp.service.CollegeProviderService;

@RestController
public class CollegeResponseController {

	@Autowired
	CollegeProviderService cps;
	
	@RequestMapping(method = RequestMethod.POST, value ="/searchColleges")
	public ResponseEntity<Object> getSearchResults(@RequestBody SearchCriteria sc){
		if(sc == null)
		{
			return new ResponseEntity<>("Null Input!!", HttpStatus.BAD_REQUEST);
		}
		else if(sc.getYear()>2017)
			return new ResponseEntity<>("Invalid year!! Please send a year < 2017", HttpStatus.BAD_REQUEST);
		try {
			CollegeResponse cr = cps.getSearchResults(sc);
			if(cr == null)
				return new ResponseEntity<>("Bad Input!!", HttpStatus.BAD_REQUEST);
			ResponseEntity<Object> re = new ResponseEntity<Object>(cr, HttpStatus.CREATED);	
			return re;
		}
		catch (Exception e) {
			return new ResponseEntity<>("Bad Input!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	//search by year
	//search by location
	//search by location and zip code
	//search by awards
}
