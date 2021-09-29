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
	String serverinfo = application.getServerInfo();
	String mimetype = application.getMimeType("request1.html");
	String realpath = application.getRealPath("/");
	application.log("application 내부객체 로그 테스트");
%>
<h1>Application Example</h1>
서블릿 컨테이너의 이름과 버전 : <%=serverinfo %><p/>
request1.html의 mime type : <%=mimetype %><p/>
로컬 파일 시스템의 경로 : <%=realpath %>
</body>
</html>