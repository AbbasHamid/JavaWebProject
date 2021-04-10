<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


<title>Insert title here</title>
</head>
<body>




<div class= "container form-group">

<div class = "float-right">
<a href="${pageContext.request.contextPath }/logout.jsp">logout</a>

</div>




<form action="${pageContext.request.contextPath }/PostController" method = "post">
<div class = "form-group">
 <input class="form-control" type="text" name="post" value = "${post.post }" placeholder="Enter post">
</div>

<div class = "form-group">
 <input class="form-control" type="text" name="tag" value = "${post.tag }" placeholder="Enter tag">
</div>
 <input type="hidden" name="id" value = "${post.id }">
<button class="btn btn-primary" type= "submit" >Save Post </button>
</form>



</div>










</body>
</html>