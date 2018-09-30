<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>







<font color="red"><h2>Library Management System</h2></font>
<form method="get" action="LoginServlet">

	<nav>
	<ul>
		<li><a href="/">Home</a></li>
		<li><a href="about.jsp">About</a></li>
		<li><a href="contact.jsp">Contact</a></li>
		<li><a href="REGISTER.jsp">Register</a></li>
		<li><a href="Logout.jsp">Logout</a></li>
	</ul>
	</nav>


	<jsp:include page="login.jsp"></jsp:include>
	<footer> . . . . .</footer>
	</body>
</html>