<%@ page contentType="text/html; charset=UTF-8" %>
<%
	Cookie cookie = null;

	cookie = new Cookie("name","User1");
	cookie.setMaxAge(30);
	response.addCookie(cookie);
	
	cookie = new Cookie("kuk","90");
	cookie.setMaxAge(30);
	response.addCookie(cookie);
	
	cookie = new Cookie("eng","90");
	cookie.setMaxAge(30);
	response.addCookie(cookie);
%> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>쿠키 예제</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
	<div class="well well=lg">
	<br>
	<p> 성적을 쿠키로 저장했습니다.</p>
	<p><a href="./readCookie.jsp">쿠키로 저장된 성적 읽어오기</a>
	</div>
</div>
</body> 
</html> 