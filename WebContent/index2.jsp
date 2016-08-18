<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.test.one.PredicationResult;" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Wartex Search</title>

    <!-- Bootstrap -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/flat-ui.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><img src="assets/images/logo.png" alt=""></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        <form class="form-inline">
				  <div class="form-group search">
				    <input type="text" class="form-control search-box" id="exampleInputName2" placeholder="Search...">
				  </div>
				  <button type="submit" class="btn btn-default search">Search</button>
				</form>
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="clear-top"></div>
    <div class="scroll-x-container">
    <%
    ArrayList<ArrayList<PredicationResult>> finalResult = (ArrayList<ArrayList<PredicationResult>>)request.getAttribute("finalResult");
   
    for(int i=0;i<finalResult.size();i++){
    	ArrayList<PredicationResult> al=finalResult.get(i);
    	%>
      <div class="result-container" id="resultContainer">
        <div class="result-box">
          <h2><%=al.get(i).year%></h2>
          <%
	    	if(al.size() > 0){	    		
		    	for(int j=0;j<al.size();j++){            
				    %>
				    <p><a style="font-size:120%;background-color: transparent;color:black;"><%=al.get(j).content.substring(0,70)%></a>
				    <br><a style="background-color: transparent;color:blue;" href="<%=al.get(j).link %>"><%=al.get(j).link%></a>
				    <br><a style="background-color: transparent;color:green;">Relevancy: <%=al.get(j).relevancy %></a>
				    <br><a style="background-color: transparent;color:#cccccc;">------------------------------------------------------------------------------------</a><p>
				    <%			            
				}
	    	}
			 %>
        </div>
        
        
      </div> <%
    }    
    %>
    </div>
    
    <div class="clear"></div>
    <footer>&copy; Copyright Wartex Inc 2015</footer>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="assets/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/flat-ui.min.js"></script>
    <script src="assets/js/jquery.mousewheel.js"></script>

    <script type="text/JavaScript">
      $(document).ready( function(){
        $("#resultContainer").mousewheel(function(event, delta) {
          this.scrollLeft -= (delta * 30);
          event.preventDefault();
        });
      })
    </script>
  </body>
</html>