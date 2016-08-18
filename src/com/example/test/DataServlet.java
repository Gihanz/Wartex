package com.example.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.one.PredicationResult;
/**
 * Servlet implementation class test
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int yearOne = Integer.parseInt(request.getParameter("yearone"));
		int yearTwo = Integer.parseInt(request.getParameter("yeartwo"));
		String country = request.getParameter("country");

		DataAlgorithm dataAlgoObj = new DataAlgorithm();
		/*HashMap<Integer,ArrayList<String>> r = dataAlgoObj.getData(country, yearOne, yearTwo);
		
		for (String a : r)
			response.getWriter().println(a);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int yearOne = Integer.parseInt(request.getParameter("yearone"));
		int yearTwo = Integer.parseInt(request.getParameter("yeartwo"));
		String country = request.getParameter("country");

		DataAlgorithm dataAlgoObj = new DataAlgorithm();
		HashMap<Integer,ArrayList<PredicationResult>> r = dataAlgoObj.getData(country, yearOne, yearTwo);
		ArrayList<PredicationResult> temp2012 = r.get(2012);
		ArrayList<PredicationResult> temp2013 = r.get(2013);
		ArrayList<PredicationResult> temp2014 = r.get(2014);
		ArrayList<PredicationResult> temp2015 = r.get(2015);
		
		ArrayList<ArrayList<PredicationResult>> finalResult = new ArrayList<ArrayList<PredicationResult>>();
		if(temp2012!=null){
			finalResult.add(temp2012);
		}
		if(temp2013!=null){
			finalResult.add(temp2013);
		}
		if(temp2014!=null){
			finalResult.add(temp2014);
		}
		if(temp2015!=null){
			finalResult.add(temp2015);
		}
		String url="/index2.jsp"; //relative url for display jsp page
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    
	    request.setAttribute("finalResult", finalResult );	    
	    rd.forward(request, response);
	}

}
