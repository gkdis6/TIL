<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="elfunc" uri="/ELFunctions" %>
<%
java.util.Date today = new java.util.Date();
request.setAttribute("today", today);
%>
<html>
<head>
<title>EL 함수 호출</title>
</head>
<body>

	오늘은 <b>${elfunc:dateFormat(today) }</b> 입니다. 
	오늘은 <b><%=today%></b> 입니다.
	<br>
</body>
</html>
