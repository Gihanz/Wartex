package com.test.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;


public class TwitterAnalytic {
	static NameFinderME nameFinder;
	static int tweetCount = 0;
	static int positiveCount = 0;
	static int negativeCount = 0;
	private static TwitterAnalytic ta;
	static PrintWriter writer, writer2, writer3;


	public PredicationResult DocumentCategorizer(String text) throws IOException {
		DocumentCategorizerME classificationME = null;
		File test = new File("C:/Users/GIHANZ/Desktop/New folder/en-doccat.bin");
		String classificationModelFilePath = test.getAbsolutePath();

		try {
			classificationME = new DocumentCategorizerME(new DoccatModel(
					new FileInputStream(classificationModelFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String documentContent = text;
		double[] classDistribution = classificationME
				.categorize(documentContent);

		String predictedCategory = classificationME
				.getBestCategory(classDistribution);
		double highest = 0;
		for(int i=0;i<classDistribution.length;i++){
			//System.out.println(classDistribution[i]);
			if(classDistribution[i]>highest){
				highest = classDistribution[i];
			}
		}
		System.out.println("Ranking : "+highest);
		/*System.out.println("Text " + text + " , Best Category : "
				+ predictedCategory);*/
		PredicationResult pr = new PredicationResult();
		pr.year = predictedCategory;
		pr.relevancy = highest;
		pr.text = text;
	
		return pr;
	}

	public String sentenceDetect(String content) {
		SentenceDetector _sentenceDetector = null;
		InputStream modelIn = null;
		String sentiment = "";
		try {
			// Loading sentence detection model
			File test = new File("/home/gihanz/Desktop/Devops/NLP/en-sent.bin");
			String SentenceModelFilePath = test.getAbsolutePath();
			modelIn = new FileInputStream(SentenceModelFilePath);
			final SentenceModel sentenceModel = new SentenceModel(modelIn);
			modelIn.close();

			_sentenceDetector = new SentenceDetectorME(sentenceModel);
			String sentences[] = _sentenceDetector.sentDetect(content);
			for (String sentence : sentences) {
				// System.out.println(sentence);
				sentiment = DocumentCategorizer(sentence).year;
			}
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (final IOException e) {
				} // oh well!
			}
		}
		return sentiment;
	}



	public void NERCategorizer(String text,
			DocumentCategorizerME classificationME) throws IOException {

		String documentContent = text;
		double[] classDistribution = classificationME
				.categorize(documentContent);

		String predictedCategory = classificationME
				.getBestCategory(classDistribution);
		System.out.println("Text : " + text + " , Best Category : "
				+ predictedCategory);

	}
	
	public static void main(String args[]){
		String text = "This thing happend in 2014 but it is not important bn and there was a cricket match in 2015";
		TwitterAnalytic ta= new TwitterAnalytic();
		try {
			System.out.println(ta.DocumentCategorizer(text));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
