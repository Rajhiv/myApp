package com.demo.myApp.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	@JsonProperty("school.name")
	String schoolName;
	long id;
//	@JsonProperty("2013.student.size")
//	long studentSize;
	
	Map<String, Object> informations = new LinkedHashMap<>();

	@JsonAnySetter
	void setInformation(String key, Object value) {
	    informations.put(key, value);
	}
	
	public Results() {
		
	}
	
	

public Results(String schoolName, long id, Map<String, Object> informations) {
		super();
		this.schoolName = schoolName;
		this.id = id;
		this.informations = informations;
	}

//	public Results(String schoolName, long id, long studentSize) {
//		super();
//		this.schoolName = schoolName;
//		this.id = id;
//		this.studentSize = studentSize;
//	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public Map<String, Object> getInformations() {
		return informations;
	}

	public void setInformations(Map<String, Object> informations) {
		this.informations = informations;
	}

	@Override
	public String toString() {
		return "Results [schoolName=" + schoolName + ", id=" + id + ", informations=" + informations + "]";
	}

//	public long getStudentSize() {
//		return studentSize;
//	}
//
//	public void setStudentSize(long studentSize) {
//		this.studentSize = studentSize;
//	}
//
//	@Override
//	public String toString() {
//		return "Results [schoolName=" + schoolName + ", id=" + id + ", studentSize=" + studentSize + "]";
//	}
	
	
	

}
