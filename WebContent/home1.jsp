<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage = "error.jsp" %>
<%

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("<b>Hello, " + name + "</b>");
			} else {
				response.sendRedirect("Signup.jsp");
			}
		}
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  
   
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   
 <meta name="description" content="">
    <meta name="author" content="">

   
 <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
   
 <link href="bootstrap.min.css" rel="stylesheet">

    
<!-- Custom styles for this template -->
   
 <link href="shop-item.css" rel="stylesheet">


<title>Insert title here</title>
</head>
<body>
 <!-- Navigation -->
  
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    
  <div class="container">
     
   <a class="navbar-brand" href="#">Welcome</a>
   
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
    
      <span class="navbar-toggler-icon"></span>
      
  </button>
     
   <div class="collapse navbar-collapse" id="navbarResponsive">
       
   <ul class="navbar-nav ml-auto">
         
   <li class="nav-item active">
            
  <a class="nav-link" href="#">Home
              
  <span class="sr-only">(current)</span>
           
   </a>
          
  </li>
          
  <li class="nav-item">
          
    <a class="nav-link" href="#">About</a>
       
     </li>
         
   <li class="nav-item">
         
     <a class="nav-link" href="#">Services</a>
          
  </li>
          
  <li class="nav-item">
          
    <a class="nav-link" href="#">Contact</a>
       
     </li>
          </ul>
      
  </div>
   
   </div>
    </nav>

  
  <!-- Page Content -->
  
  <div class="container">

   
   <div class="row">

      
  <div class="col-lg-3">
        
  <h1 class="my-4">Online Courses</h1>
      
    <div class="list-group">
 
          
  <a href="Java.jsp" class="list-group-item  ">Java</a>
     
       <a href="C++.jsp" class="list-group-item ">C++</a>
        
    <a href="Phyton.jsp" class="list-group-item ">Phyton</a>
        
  </div>
        </div>
    
    <!-- /.col-lg-3 -->

     
  
</html>


</body>
</html>