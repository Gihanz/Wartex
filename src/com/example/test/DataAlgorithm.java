package com.example.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.test.one.DBReader;
import com.test.one.PredicationResult;
import com.test.one.TwitterAnalytic;

public class DataAlgorithm {
	HashMap<Integer,ArrayList<PredicationResult>> getData(String country,int year1,int year2){
		
		String result = "";
		
		ArrayList<String []> ar=new ArrayList<String []>();
		ArrayList<String > resultList=new ArrayList<String>();
		HashMap<Integer,ArrayList<PredicationResult>> ar2=new HashMap<Integer,ArrayList<PredicationResult>>();
		try {
			DBReader db=new DBReader();
			TwitterAnalytic at =new TwitterAnalytic();
			ar=db.getTwitterFeedAll();
			ArrayList<PredicationResult> temp2012 = new ArrayList<PredicationResult>();
			ArrayList<PredicationResult> temp2013 = new ArrayList<PredicationResult>();
			ArrayList<PredicationResult> temp2014 = new ArrayList<PredicationResult>();
			ArrayList<PredicationResult> temp2015 = new ArrayList<PredicationResult>();
			if(country!=""){
			for(String [] ab:ar){
				if(ab[2].toLowerCase().contains(country.toLowerCase()+" ")){
					PredicationResult predictedYear = at.DocumentCategorizer(ab[2]);
					predictedYear.link = ab[1];
					predictedYear.content = ab[2];
					int predictYr = Integer.parseInt(predictedYear.year);
					
					if(year1 <= predictYr && predictYr <=year2){
						//resultList.add(ab[1]);
						if(predictYr==2012){temp2012.add(predictedYear);}
						if(predictYr==2013){temp2013.add(predictedYear);}
						if(predictYr==2014){temp2014.add(predictedYear);}
						if(predictYr==2015){temp2015.add(predictedYear);}
						//result =result + ab[1] +" : "+ ab[2];
						//System.out.println(ab[1]+" : "+ab[2]);
						}
					}
				}
			}
			if(temp2012.size()!=0){ar2.put(2012, sortArray(temp2012));}
			if(temp2013.size()!=0){ar2.put(2013, sortArray(temp2013));}
			if(temp2014.size()!=0){ar2.put(2014, sortArray(temp2014));}
			if(temp2015.size()!=0){ar2.put(2015, sortArray(temp2015));}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ar2;
	}
	public ArrayList<PredicationResult> sortArray(ArrayList<PredicationResult> list){
		Collections.sort(list, new Comparator<PredicationResult>() {
		    public int compare(PredicationResult o1, PredicationResult o2) {
		    	Double d1 = new Double(o1.relevancy);
		    	Double d2 = new Double(o2.relevancy);
		    	return d2.compareTo(d1);
		    }
		});
		return list;
	} 
}
