<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 이 밑의 3개는 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "container">
	<h2>시원한 풍경사진입니다.</h2>
	<p>이미지 파일을 보여줍니다.</p>
	<img src="${pageContext.request.contextPath}/images/cinqueterre.jpg" alt="cinqueterre" class="img-rounded" width="304" height="236">
	<h1>JSTL 결과 출력하기</h1>
  <c:set var="season" value="봄이 도착했습니다."></c:set>
  <h3>JSTL 출력:${season} </h3>  
  
  <br>
  당신의 아이디는 ${id} 입니다.<br>
  당신의 이름은 ${name} 입니다.
</div>
</body>
</html>