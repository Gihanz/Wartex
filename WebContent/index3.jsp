<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>Wartex</title>
<meta charset="iso-8859-1">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear">
    <div id="hgroup">
      <h1><a href="#">Wartex</a></h1>
      <h2>Find Cricket Tournaments</h2>
    </div>
    <nav>
      
    </nav>
  </header>
</div>
<!-- content -->
<div class="wrapper row2"> 
  <div id="container" class="clear" style="background-color: transparent;width:940px;">
    <%
    ArrayList<ArrayList<String>> finalResult = (ArrayList<ArrayList<String>>)request.getAttribute("finalResult");
    
    for(int i=0;i<finalResult.size();i++){
    	ArrayList<String> al=finalResult.get(i);
    	%>
    	<div name="subwindow" style="background-color:#809eff;width:450px;height:300px;padding:10px;float: left; ">
	    	<div style="background-color:transparent;width:450px;height:300px;padding:0px; overflow: scroll;">
	    	<%
	    	if(al.size() > 0){	    		
		    	for(int j=0;j<al.size();j++){            
				    %>
				    <p><a style="background-color: transparent;color:black;"><%=al.get(j)%></a><%=j++%><p>
				    <p><a style="background-color: transparent;color:white;" href="<%=al.get(j) %>"><%=al.get(j)%></a><p>
				    <%			            
				}
	    	}
			 %>
	    	</div>
	    </div>
	    <%
    }    
    %>   
         
  </div>
</div>
<!-- Footer -->
<div class="wrapper row3">
  <footer id="footer" class="clear">
    <p class="fl_left"></p>
    <p class="fl_right">
  </footer>
</div>
</body>
</html>
