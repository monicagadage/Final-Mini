<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ page errorpage=""error.jsp" %>
    
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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	
		<c:if test="${requestScope.message !=null}">
	NOTE : ${message}
		</c:if>

	<c:if test="${requestScope.display !=null and
 	not empty requestScope.display}">
 
		<table style="width:100%;"" id="myTable">
      <th>name</th>
      <th>Amount</th>
       <c:forEach items="${requestScope.display}" var="current">
        <tr>
          <td><c:out value="${current.cost}"/></td>
          <td><c:out value=name/></td>
             
          
        </tr>
      </c:forEach>
      </c:if>
    </table>
    
    
        
        
</body>
</html>