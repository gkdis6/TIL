<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	boolean flag = (boolean)request.getAttribute("flag");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 생성</title>
</head>
<body>
<div class="container">
<div class="well well-lg">
	<%
		if(flag){
			out.print("글 등록 성공입니다.");
		}else{
			out.print("글 등록 실패입니다.");
		}
	%>
</div>
    <button class="btn"
    onclick="location.href='create.do'"
    >다시 등록</button>
    <button type="button" class="btn"
    onclick="location.href='list.do'"
    >목록</button>
 </div>
</body> 
</html> 