<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.*" %>
 <%
 	request.setCharacterEncoding("utf-8");
 %>
 <jsp:useBean class="bbs.BbsDAO" id="dao"/>
 <jsp:useBean class="bbs.BbsDTO" id="dto"/>
 <jsp:setProperty name="dto" property="*" />
<%
	Map map = new HashMap();
	map.put("bbsno", dto.getBbsno());
	map.put("passwd", dto.getPasswd());
	
	int bbsno = dto.getBbsno();
	
	boolean pflag = dao.passCheck(map);
	
	boolean flag = false;
	
	if(pflag){
		flag = dao.delete(bbsno);
	}
%>	
<!DOCTYPE html> 
<html> 
<head>
  <title>게시글 삭제</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<div class="well well-lg">
	<%
		if(!pflag){
			out.print("잘못된 비밀번호입니다.");
		}else if(flag){
			out.print("글 삭제 성공입니다.");
		}else{
			out.print("글 삭제 실패입니다.");
		}
	%>
	
</div>
<% if(!pflag){ %>
	<button class="btn" onclick="history.back()">다시 시도</button>
	<% } %>
	<button class="btn" onclick="location.href='list.jsp'">목록</button>
</div>
</body> 
</html> 