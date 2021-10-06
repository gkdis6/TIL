<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.MemoDTO" %>
<jsp:useBean class="model.MemoDAO" id="dao"/>
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
  <script>
	function del(){
		let url = "delete.do";
		url += "?memono=<%=dto.getMemono()%>";
		url += "&col=<%=request.getParameter("col") %>";
		url += "&word=<%=request.getParameter("word") %>";
		url += "&nowPage=<%=request.getParameter("nowPage") %>";
		
		location.href=url;
	}
	function list(){
		  let url = "list.do";
			url += "?col=<%=request.getParameter("col") %>";
			url += "&word=<%=request.getParameter("word") %>";
			url += "&nowPage=<%=request.getParameter("nowPage") %>";
					
			location.href=url;
	  }
  </script>
</head>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">메모 수정</h1>
<form class="form-horizontal" 
      action="updateProc.do"
      method="post"
      >
 <input type="hidden" name="memono" value='<%=dto.getMemono() %>'>
 <input type="hidden" name="nowPage" value="<%= request.getParameter("nowPage") %>">
  <input type="hidden" name="col" value="<%= request.getParameter("col") %>">
  <input type="hidden" name="word" value="<%= request.getParameter("word") %>">
  <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목</label>
    <div class="col-sm-6">
      <input type="text" name="title" id="title" class="form-control" value="<%=dto.getTitle() %>">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">내용</label>
    <div class="col-sm-6">
    <textarea rows="5" cols="5" id="content" name="content" class="form-control" ><%=dto.getContent() %></textarea>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="passwd">비밀번호</label>
    <div class="col-sm-6">
      <input type="password" name="passwd" id="passwd" class="form-control">
    </div>
  </div>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class ="btn">수정</button>
	<button type = "button" class ="btn" onclick="del()">삭제</button>
	<button type ="button" class = "btn" onclick="list()">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 