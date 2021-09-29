<%@page contentType="text/html;charset=UTF-8"%>
<%
 	String name = "안녕";
 	String bloodType = request.getParameter("bloodType"); /* 무조건 네임 값으로만 호출할 수 있음 */
 %>
 <h1>Forward Tag Example2</h1>
<jsp:forward page='<%=bloodType + ".jsp"%>'>
 	<jsp:param name="name" value="<%=name%>"/>
</jsp:forward>