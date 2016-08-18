package com.test.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SimpleARFFConverter {
	public static void main(String args[]) {
		SimpleARFFConverter smp = new SimpleARFFConverter();
		try {
			smp.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() throws Exception {

		String csvFile = "/home/gihanz/Desktop/Devops/NLP/wekatests/TestData/rt-polarity.neg";
		BufferedReader br = null;
		PrintWriter writer = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String []> ar=new ArrayList<String[]>();
		DBReader db = new DBReader();
		ar = db.getTwitterFeedAll();
		try {

			writer = new PrintWriter(
					"/home/gihanz/Desktop/Devops/NLP/wekatests/TestingPur/isurutraining.txt",
					"UTF-8");

			int i = 0;
			
			for(String [] ab :ar){
				writer.println(ab[3]+" "+ab[2]);
				// use comma as separator
				/*String[] country = line.split(cvsSplitBy);
				//if (country.length == 5) {*/
					/*
					 * System.out.println("["+i+"] Tweet [sentiment = " +
					 * country[1] + " , text =" + country[4] + "]");
					 */
					/*if(country[4].length()>=60){
					writer.println(removeQuotes(country[1]) + ","
							+ replaceQuotes(country[4]) + "");
					}*/
					
					
				///}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

	public String removeQuotes(String input) {
		String output = input;
		if (input.startsWith("\"") && input.endsWith("\""))
			output = input.substring(1, input.length() - 1);
		return output;
	}
	
	
/*	public String replaceQuotes(String input) {
		
		String split [] = input.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String textPart:split){
			if(!textPart.contains("http")){
				sb.append(textPart + " ");
			}
		}
		input = sb.toString();
		String output = input;
		if (input.startsWith("\"") && input.endsWith("\"")) {
			output = input.substring(1, input.length() - 1);
			output = Utils.quote(output);
		}
		return output ;
	}*/

	public static void readFile() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"/home/gihanz/Desktop/Devops/NLP/wekatests/en-doccat.train")));
		String line;
		PrintWriter writer = new PrintWriter(
				"/home/gihanz/Desktop/Devops/NLP/wekatests/doccat.arff", "UTF-8");
		while ((line = br.readLine()) != null) {
			String[] ar = line.split("\\s+");
			writer.println(ar[0] + "," + ar[1]);
		}
		writer.close();
		/*
		 * line = null; br=new BufferedReader(new FileReader(new
		 * File("/home/gihanz/Desktop/facebook_user.txt"))); while ((line =
		 * br.readLine()) != null) { String [] ar=line.split(","); //
		 * dbw.addFacebookUser(ar); } line = null; br=new BufferedReader(new
		 * FileReader(new File("/home/gihanz/Desktop/facebook_post.txt"))); while
		 * ((line = br.readLine()) != null) { String [] ar=line.split(","); //
		 * dbw.addFacebookPost(ar); }
		 */
	}

	/*public void runDB() throws Exception {
			
			PrintWriter writer = null;
			writer = new PrintWriter(
						"/home/gihanz/Desktop/Devops/NLP/wekatests/TestingPur/doccattestdatadb.arff",
						"UTF-8");
			DBReader db = new DBReader();
			ArrayList<String[]> ar = db.getTwitterFeedAll();
			for (String[] inn : ar) {
					writer.println(inn[9]+",\""+inn[1]+"\"");
			}
	
			System.out.println("Done");
		}*/
}
