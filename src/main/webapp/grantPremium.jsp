<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="premium" method="get">
		<label>Uzytkownik:<input type="text" id="username" name="username"/></label><br />
		<label>Nadaj uprawnienia premium<input type="radio" name="premium" value="set"><br></label>
		<label>Zdejmij uprawnienia premium<input type="radio" name="premium" value="remove"><br></label>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>