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
	String root = request.getContextPath();
	//이미지 목록을 배열에 저장
	String[] images = {"tu01.jpg", "tu02.jpg", "tu03.jpg", "tu04.jpg", "tu05.jpg", "tu06.jpg", "tu07.jpg", "tu08.jpg",
		    "tu09.jpg", "tu10.jpg" };
	out.print("<h1> 튜울립 축제 </h1><br>");
	
	for(int i = 0; i < images.length; i++){
		out.print("<a href='" + root + "/tulip/" + images[i] + "'>");
		out.print("<img src='" + root + "/tulip/" + images[i] + "' width='200px' height='160px' border='0'>");
		out.print("</a>");
	}
%>
</body>
</html>