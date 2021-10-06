<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.MemoDTO" %>
<jsp:useBean class="model.MemoDAO" id="dao"/>
<%
	MemoDTO dto = (MemoDTO)request.getAttribute("dto");
	
	String content = dto.getContent().replaceAll("\r\n", "<br>");
%>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>메모</title>
  <meta charset="utf-8">
  <script>
  	function update(){
  		let url = "update.do";
  		url += "?bbsno=<%=dto.getMemono()%>";
  		url += "&col=<%=request.getParameter("col") %>";
		url += "&word=<%=request.getParameter("word") %>";
		url += "&nowPage=<%=request.getParameter("nowPage") %>";
  		
  		location.href=url;
  	}
	function del(){
		let url = "delete.do";
		url += "?bbsno=<%=dto.getMemono()%>";
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
<h2><%=dto.getTitle() %></h2>
<div class="panel panel-default">
	<div class="panel-heading">내용</div>
	<div class="panel-body" style="height:200px"><%=content %></div>
	
	<div class="panel-heading">조회수</div>
	<div class="panel-body"><%=dto.getViewcnt() %></div>
	
	<div class="panel-heading">등록일</div>
	<div class="panel-body"><%=dto.getWdate() %></div>
	
</div>
	<button class = "btn" onclick="update()">수정</button>
	<button class = "btn" onclick="del()">삭제</button>
	<button class = "btn" onclick="list()">목록</button>
 </div>
</body> 
</html> 