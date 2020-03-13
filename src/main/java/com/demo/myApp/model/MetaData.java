package com.demo.myApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {
	
	long total;
	int page;
	int per_page;
	
	public MetaData() {
		
	}

	public MetaData(long total, int page, int per_page) {
		super();
		this.total = total;
		this.page = page;
		this.per_page = per_page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	@Override
	public String toString() {
		return "MetaData [total=" + total + ", page=" + page + ", per_page=" + per_page + "]";
	}
	
	

}
