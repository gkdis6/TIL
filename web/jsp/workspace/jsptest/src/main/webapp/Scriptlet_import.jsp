<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style='font-size:36px;color:#ffffff;background-color:#ff3399;'>
	<%
		Date date = new Date();
		out.print(date.toLocaleString());
	%>
	</div>
</body>
</html>