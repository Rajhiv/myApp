package com.demo.myApp.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.myApp.model.CollegeResponse;
import com.demo.myApp.model.SearchCriteria;
import com.demo.myApp.provider.CollegeResponseProvider;

@RunWith(MockitoJUnitRunner.class)
public class CollegeProviderServiceTest {

	@InjectMocks
	CollegeProviderService cpc;
	
	@Mock
	CollegeResponseProvider cp;
	
	@Test
	public void getSearchResultsNullInputTest() {
		
		SearchCriteria sc = new SearchCriteria();
		String year = "latest";
		String testStr = "&fields=id,school.name,"+year+".student.size"
				+"&sort="+year+".student.size";
		try {
			Mockito.when(cp.getSearchResults(testStr)).thenThrow(new RuntimeException("Mock Test"));
			cpc.getSearchResults(sc);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("service call"));
		
		}
		
		
	}
	
	

}
