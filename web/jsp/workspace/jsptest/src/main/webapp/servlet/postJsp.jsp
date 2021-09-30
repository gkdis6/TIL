<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Post Servlet 방식</h1>
<form method="post" action="../ch07/PostServlet">
	id: <input name="id"><br>
	pwd: <input name="pwd" type="password"><br>
	email: <input name="email"><br>
	<input type = "submit" value="가입">
</form>
</body>
</html>