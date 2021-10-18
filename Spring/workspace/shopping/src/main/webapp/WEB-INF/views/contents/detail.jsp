<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" uri="/ELFunctions" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <title>상세정보</title>
  <meta charset="utf-8">
  
</head>
<body>
<div class="container">

<h2 class="col-sm-offset-2 col-sm-10">${dto.pname}의 상세정보</h2>
 <table class="table table-bordered">
 <tr>
 	<td colspan="2" style="text-align: center">
 		<img src="${root}/pstorage/${dto.filename}" 
 		width="250px" height="250px" class="img-rounded" >
 	</td>
 </tr>
 <tr>
 	<th>상품 번호</th>
 	<td>${dto.contentsno}</td>
 </tr>
 <tr>
 	<th>카테고리 번호</th>
 	<td>${dto.cateno}</td>
 </tr>
 <tr>
 	<th>상품 이름</th>
 	<td>${dto.pname}</td>
 </tr>
 <tr>
 	<th>상품 가격</th>
 	<td>${dto.price}</td>
 </tr>
 <tr>
 	<th>상세 정보</th>
 	<td>${dto.detail}</td>
 </tr>
 
 </table>
 <div style="text-align: center">
 <button class="btn btn-default" onclick="order()">주문하기</button>
 <%-- <c:if test="${not empty sessionScope.id and sessionScope.grade != 'A'}">
 <button class="btn btn-default" onclick="updateFile()">사진수정</button>
 <button class="btn btn-default" onclick="updatePw()">패스워드변경</button>
 <button class="btn btn-default" 
 onclick="location.href='./download?filename=${dto.fname}'">다운로드</button>  
 </c:if> --%>
 <!-- <button class="btn btn-default" onclick="deleteM()">회원탈퇴</button> -->
 <%-- <c:if test="${not empty sessionScope.id and sessionScope.grade == 'A'}"> --%>
 <button class="btn btn-default" onclick="location.href='${root}/contents/mainlist/1'">상품목록</button>
 <%-- </c:if> --%>
 </div>
 
 <br>
 
</div>
</body>
</html>