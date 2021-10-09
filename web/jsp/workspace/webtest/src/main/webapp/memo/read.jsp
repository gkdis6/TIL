<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="memo.MemoDTO" %>
<%@ page import="utility.*" %>
<jsp:useBean class="memo.MemoDAO" id="dao"/>
<%
	String col = Utility.checkNull(request.getParameter("col"));
	String word = Utility.checkNull(request.getParameter("word"));
	
	if(col.equals("total")){
		word = "";
	}
	
	int nowPage = 1;
	if(request.getParameter("nowPage") != null ){
 		nowPage = Integer.parseInt(request.getParameter("nowPage"));
 	}
	
	int memono = Integer.parseInt(request.getParameter("memono"));

	dao.upViewCnt(memono);
	
	MemoDTO dto = dao.read(memono);
	
	String content = dto.getContent().replaceAll("\r\n", "<br>");
%>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>메모</title>
  <meta charset="utf-8">
  <script>
  	function update(no){
  		let url = "updateForm.jsp";
  		url += "?memono="+no;
  		url += "&col=<%=col%>";
		url += "&word=<%=word%>";
		url += "&nowPage=<%=nowPage%>";
  		
  		location.href=url;
  	}
	function del(no){
		let url = "deleteForm.jsp";
		url += "?memono="+no;
		url += "&col=<%=col%>";
		url += "&word=<%=word%>";
		url += "&nowPage=<%=request.getParameter("nowPage") %>";
		
		location.href=url;
	}
	function list(){
		  let url = "list.jsp";
			url += "?col=<%=request.getParameter("col") %>";
			url += "&word=<%=request.getParameter("word") %>";
			url += "&nowPage=<%=request.getParameter("nowPage") %>";
					
			location.href=url;
	  }
  </script>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
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
	<button type="button" class = "btn" onclick="update(<%=memono%>)">수정</button>
	<button type="button" class = "btn" onclick="del(<%=memono%>)">삭제</button>
	<button type="button" class = "btn" onclick="list()">목록</button>
 </div>
</body> 
</html> 