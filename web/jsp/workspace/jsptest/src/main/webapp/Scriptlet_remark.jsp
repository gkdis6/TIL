<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Script Example1</h1>
<%! String declaration = "Declaration"; %>
<%! public String decMethod(){
		return declaration;
	}
%>
<%
	String scriptlet = "Scriptlet";
	String comment = "Comment";
	
	out.println("<p> 내장 객체를 이용한 출력:" + declaration + "</p>");
%>
선언문의 출력:
<%= declaration %><p />
선언문의 출력2:
<%= decMethod() %><p />
스크립틀릿의 출력:
<%= scriptlet %><p />

<!--JSP주석부분-->
<!-- JSP 주석1 :  <%=comment%> -->
<p />
<%-- JSP 주석2 : <%=comment%> --%>
<%
/* 주석 
  (여러줄 주석)
   */
%>
<%
// 주석(한줄 주석)
%>
</body>
</html>