
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>



<div class = "container">

<form action="loginController"  method = "POST">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="text" class="form-control" placeholder="Enter name" id="email" name = "name">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name = "password">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button> <%
  
  String name = (String)session.getAttribute("name");
  if(name != null){
	  response.sendRedirect("EmployeeController?action=LIST");
  }
  
String status = request.getParameter("status");

if(status!=null){
	if(status.equals("false")){
		out.print("Wrong password or name");
		
	}
}


%>
</form>

</div>


</body>

</html>