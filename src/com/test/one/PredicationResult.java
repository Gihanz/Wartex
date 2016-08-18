package com.test.one;

public class PredicationResult {

	public PredicationResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String year;
	public double relevancy;
	public String text;
	public String link;
	public String content;
	public PredicationResult(String year, double relevancy, String text,
			String link, String content) {
		super();
		this.year = year;
		this.relevancy = relevancy;
		this.text = text;
		this.link = link;
		this.content = content;
	}
	
}