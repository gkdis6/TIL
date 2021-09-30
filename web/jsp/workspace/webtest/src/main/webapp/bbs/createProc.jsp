<%@ page contentType="text/html; charset=UTF-8" %> 
 <%
 	request.setCharacterEncoding("utf-8");
 %>
 <jsp:useBean class="bbs.BbsDAO" id="dao"/>
 <jsp:useBean class="bbs.BbsDTO" id="dto"/>
 <jsp:setProperty name="dto" property="*" />
 <%-- 이름이 다를 경우 param=""사용 --%>
 <!-- <% String wname = request.getParameter("wname");
 		dto.setWname(wname);%> -->
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
			out.print("글 등록 성공입니다.");
		}else{
			out.print("글 등록 실패입니다.");
		}
	%>
</div>
</div>
</body> 
</html> 