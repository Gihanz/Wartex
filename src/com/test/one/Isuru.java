package com.test.one;

import java.util.ArrayList;

public class Isuru {
	
public static void main(String args[]){
	String year = "2014";
	String country="Sri Lanka";
	ArrayList<String []> ar=new ArrayList<String []>();
	ArrayList<String > resultList=new ArrayList<String>();
	try {
		DBReader db=new DBReader();
		TwitterAnalytic at =new TwitterAnalytic();
		ar=db.getTwitterFeedAll();
		for(String [] ab:ar){
			if(ab[2].toLowerCase().contains(country.toLowerCase()+" ")){
				PredicationResult predictedYear = at.DocumentCategorizer(ab[2]);
				if(predictedYear.equals(year)){
					resultList.add(ab[1]);
					System.out.println(ab[1]+" : "+ab[2]);
				}
			}
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
