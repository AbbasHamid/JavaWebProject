
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<%

String name = (String)session.getAttribute("name");

if(name == null){
	response.sendRedirect("index.jsp");
}

%>

<div class= "container">
<div class = "float-right">
<a href="${pageContext.request.contextPath }/logout.jsp">logout </a>

</div>
 
<button class="btn btn-primary" onclick ="window.location.href = 'views/post-add.jsp'">Add Post </button>
<span style="color : red"> ${message}</span> 
<table border = "1" class = "table table-striped table-bordered">
<tr class= "thead-dark"> 

<th> Post   </th>
<th> Tag   </th>
<th> Actions   </th>
 </tr>
 
 <c:forEach items="${PostList}" var="Post">
 
 <tr> 

<td> ${Post.post}   </td>
<td> ${Post.tag}   </td>

<td> <a href= "${pageContext.request.contextPath }/PostController?action=EDIT&id=${Post.id}">Edit</a> |  
<a href= "${pageContext.request.contextPath }/PostController?action=DELETE&id=${Post.id}"><span style = "color:red">DELETE</span></a> 
</td>

 </tr>
 </c:forEach>
 
 





</table>





</div>


</body>
</html>