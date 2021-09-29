<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Request Example</h1>
프로토콜 : <%= request.getProtocol() %><br>
서버이름 : <%= request.getServerName() %><br>
서버의 포트번호 : <%= request.getServerPort() %><br>
사용자의 컴퓨터 주소 : <%= request.getRemoteAddr() %><br>
사용자의 컴퓨터 이름 : <%= request.getRemoteHost() %><br>
사용 Method : <%= request.getMethod() %><br>
현재 사용하는 브라우저 : <%= request.getHeader("User-Agent") %><br>
브라우저가 지원하는 파일 타입 : <%= request.getHeader("Accept") %><br>
</body>
</html>