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




<form action="${pageContext.request.contextPath }/EmployeeController" method = "POST">
<div class = "form-group">
 <input class="form-control" type="text" name="name" value = "${employee.name }" placeholder="Enter name">
</div>

<div class = "form-group">
 <input class="form-control" type="date" name="date" value = "${employee.dob }" >
</div>
<div class = "form-group">
 <input class="form-control" type="text" name="Departement" value = "${employee.departement }" placeholder="Enter departement name">
</div>
 <input type="hidden" name="id" value = "${employee.id }">
<button class="btn btn-primary" type= "submit" >Save Employee </button>
</form>



</div>










</body>
</html>