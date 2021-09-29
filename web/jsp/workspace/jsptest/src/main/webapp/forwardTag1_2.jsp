<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");/* forward를 통하면 request가 아직 죽지 않았기 때문에 데이터를 받아올 수 있다. */
%>
<h1> Forward Tag Example </h1>
당신의 아이디는 <b><%=id %></b>이고</p>
패스워드는 <b><%=pwd %></b>입니다.
</body>
</html>