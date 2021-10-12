<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>EL Object</title>
</head>
<body>

	<h2>
		<%
		// http://localhost:8000/mvc_test/el/elParam.jsp 
		// http://localhost:8000/mvc_test/el/elParam.jsp?code=ABCDE 

		String code = request.getParameter("code");
		%>
		code 파라미터(스크립틀릿 방식) :
		<%
		out.println(code);
		%>
		<br> code 파라미터(EL 방식) : ${param.code} <br />
	</h2>

</body>
</html>
