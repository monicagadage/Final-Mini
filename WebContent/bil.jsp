<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ page errorPage = "error.jsp" %>
     <%

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("<b>Hello, " + name + "</b>");
			} else {
				response.sendRedirect("Signup.html");
			}
		}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	
		<table border="1"   >
		<c:forEach items="${requestScope.display}" var="current">
        <tr>
      	<th>name</th>
      	<th>Amount</th>
      	
        </tr>
         <tr>
         <td> <%=(String) session.getAttribute("user")%></td>
          <td>${current.cost}</td> 
            
 
        </tr>
      </c:forEach>
     
    </table>

</body>
</html>