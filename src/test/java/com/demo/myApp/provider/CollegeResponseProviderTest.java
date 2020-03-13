package com.demo.myApp.provider;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.demo.myApp.model.CollegeResponse;

@RunWith(MockitoJUnitRunner.class)
public class CollegeResponseProviderTest {

	@InjectMocks
	CollegeResponseProviderImpl crp;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	public void getSearchResultsInvalidInputTest() {
		String queryUrl = crp.baseUrl+"invalidInput";
		Mockito.when(restTemplate.getForObject(queryUrl, CollegeResponse.class)).thenThrow(new RuntimeException("Test Invalid Input"));
		try {
			crp.getSearchResults("invalidInput");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("something went wrong"));
		}
	}

}
