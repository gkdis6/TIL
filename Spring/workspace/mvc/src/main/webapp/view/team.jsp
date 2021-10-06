<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
List<Map> list = (List<Map>) request.getAttribute("team");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>팀 목록</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>보유기술</th>
					<th>성격</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i = 0; i < list.size(); i++) { %>
				<%Map map = list.get(i);%>
				<tr>
					<td><%=map.get("no")%></td>
					<td><%=map.get("name")%></td>
					<td><%=map.get("age")%></td>
					<td><%=map.get("skill")%></td>
					<td><%=map.get("person")%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>