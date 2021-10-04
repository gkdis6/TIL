<%@ page contentType="text/html; charset=UTF-8" %> 
 <%
	request.setCharacterEncoding("utf-8");
 %>
 <jsp:useBean class="memo.MemoDAO" id="dao"/>
 <jsp:useBean class="memo.MemoDTO" id="dto"/>
 <jsp:setProperty name="dto" property="*" />
 <%
	boolean flag = dao.create(dto);
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
<div class="well well-lg">
<%
	if(flag){
		out.print("메모 생성 성공입니다.");
	}else{
		out.print("메모 생성 실패입니다.");
	}
%>
</div>
</div>
</body> 
</html> 