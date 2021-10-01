<%@ page contentType="text/html; charset=UTF-8" %> 
 <%@ page import="bbs.BbsDTO" %>
 <jsp:useBean class="bbs.BbsDAO" id="dao"/>
 <%
 	int bbsno = Integer.parseInt(request.getParameter("bbsno"));
 	
 	BbsDTO dto = dao.read(bbsno);
 	
 	String nowPage = request.getParameter("nowPage");
 	String col = request.getParameter("col");
 	String word = request.getParameter("word");
 %>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <style>
  #red{
    color:red;
  }
  </style>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">삭제</h1>
<form class="form-horizontal" 
      action="deleteProc.jsp"
      method="post"
      >
 
  <input type="hidden" name="bbsno" value="<%= dto.getBbsno() %>">
  <input type="hidden" name="nowPage" value="<%= request.getParameter("nowPage") %>">
  <input type="hidden" name="col" value="<%= request.getParameter("col") %>">
  <input type="hidden" name="word" value="<%= request.getParameter("word") %>">
  <div class="form-group">
  	<label class = "control-label col-sm-2" for="passwd">비밀번호</label>
  	<div class="col-sm-6">
  		<input type="password" name="passwd" id="passwd" class="form-control">
  	</div>
  	</div>
   <p id="red" class="col-sm-offset-2 col-sm-6">삭제하면 복구할 수 없습니다</p>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">삭제</button>
    <button type="reset" class="btn">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 