package com.demo.myApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollegeResponse {

	private MetaData metadata;
	private List<Results> results;
	
	public CollegeResponse() {
		
	}

	public CollegeResponse(MetaData metadata, List<Results> results) {
		super();
		this.metadata = metadata;
		this.results = results;
	}

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "CollegeResponse [metadata=" + metadata + ", results=" + results + "]";
	}
	
	
}
