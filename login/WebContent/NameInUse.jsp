<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>

  <h1>The name <%=request.getAttribute("name")%> is already in use</h1>
  
  Please enter another name and password.<br>
  
  <form action="CreateAccountServlet" method="post">
  User Name: <input type="text" name="name"><br>
  Password: <input type="text" name="password">
  <input type="submit" value="Create Account">
  </form>
  
</body>
</html>