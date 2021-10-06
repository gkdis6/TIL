<%@ page contentType="text/html; charset=UTF-8" %> 
 <%@ page import="memo.MemoDTO" %>
 <jsp:useBean class="memo.MemoDAO" id="dao"/>
 <%
 	int memono = Integer.parseInt(request.getParameter("memono"));
 	
 	MemoDTO dto = dao.read(memono);
 	
 	String nowPage = request.getParameter("nowPage");
 	String col = request.getParameter("col");
 	String word = request.getParameter("word");
 %>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">메모 삭제</h1>
<form class="form-horizontal" 
      action="deleteProc.jsp"
      method="post"
      >
 <div class="form-group">
 <input type="hidden" name="memono" value="<%= dto.getMemono() %>">
  <input type="hidden" name="nowPage" value="<%= request.getParameter("nowPage") %>">
  <input type="hidden" name="col" value="<%= request.getParameter("col") %>">
  <input type="hidden" name="word" value="<%= request.getParameter("word") %>">
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