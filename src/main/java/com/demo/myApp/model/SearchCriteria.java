package com.demo.myApp.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchCriteria {
	int zip;
	int distance;
	int[] awards;
	int year;
	
	public SearchCriteria() {
		
	}

	public SearchCriteria(int zip, int distance, int[] awards, int year) {
		super();
		this.zip = zip;
		this.distance = distance;
		this.awards = awards;
		this.year = year;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getAwards() {
		
		String awardStr = (awards!=null)?IntStream.of(awards)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(",")):"";
		return awardStr;
	}

	public void setAwards(int[] awards) {
		this.awards = awards;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
