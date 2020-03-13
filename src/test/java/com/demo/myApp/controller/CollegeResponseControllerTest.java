package com.demo.myApp.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.myApp.model.CollegeResponse;
import com.demo.myApp.model.SearchCriteria;
import com.demo.myApp.service.CollegeProviderService;

@RunWith(MockitoJUnitRunner.class)
public class CollegeResponseControllerTest {

	@InjectMocks
	CollegeResponseController crc;
	
	@Mock
	CollegeProviderService cps;
	
	
	@Test
	public void getSearchResultsTest() {
		
		SearchCriteria sc = null;
		
		ResponseEntity<Object> re = crc.getSearchResults(sc);
		assertEquals(HttpStatus.BAD_REQUEST, re.getStatusCode());
		
		sc = new SearchCriteria(0, 0, null, 2018);
		re = crc.getSearchResults(sc);
		assertEquals(HttpStatus.BAD_REQUEST, re.getStatusCode());
		
		try {
			
			//year >2017
			sc.setYear(2018);
			Mockito.when(cps.getSearchResults(sc)).thenReturn(null);
			
			re = crc.getSearchResults(sc);
			assertEquals(HttpStatus.BAD_REQUEST, re.getStatusCode());
			
			//valid input - 201 status
			
			Mockito.when(cps.getSearchResults(sc)).thenReturn(new CollegeResponse());
			sc.setYear(2015);
			re = crc.getSearchResults(sc);
			assertEquals(HttpStatus.CREATED, re.getStatusCode());
			
			//invalid input - 400
			sc.setZip(123);
			Mockito.when(cps.getSearchResults(sc)).thenReturn(null);
			re = crc.getSearchResults(sc);
			assertEquals(HttpStatus.BAD_REQUEST, re.getStatusCode());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
