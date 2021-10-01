<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, bbs.*, utility.*" %> 
<jsp:useBean class="bbs.BbsDAO" id="dao"/>
 <%
 	String col = Utility.checkNull(request.getParameter("col"));
 	String word = Utility.checkNull(request.getParameter("word"));
 	
 	if(col.equals("total")){
 		word = "";
 	}
 	
 	Map map = new HashMap();
 	map.put("col", col);
 	map.put("word", word);
 	List<BbsDTO> list = dao.list(map);
 %>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  function read(bbsno){
	  let url = "read.jsp";
	  url += "?bbsno="+bbsno;
	  
	  location.href = url
  }
  </script>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<h1>게시판 목록</h1>
<form action='list.jsp' class='form-inline' >
	<div class="form-group">
		<select class="form-control" name="col">
			<option value="wname"
			<% if(col.equals("wname")) out.print("selected");%>
			>성명</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="title_content">제목+내용</option>
			<option value="total">전체출력</option>
		</select>
		<input type="search" class="form-control" placeholder='검색어를 입력하세요' name = "word" value = "<%=word%>">
	</div>
	<button>검색</button>
</form>
<table class = "table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>grpno</th>
			<th>indent</th>
			<th>ansnum</th>
		</tr>
	</thead>
	<tbody>
		<% if(list.size() == 0) { %>
		<tr> <td colspan="6">등록된 글이 없습니다.</td></tr>
		<%
		} else {
			for(int i = 0; i < list.size(); i++){ 
				BbsDTO dto = list.get(i);
		%>
				<tr>
					<td><%=dto.getBbsno() %></td>
					<td><a href="javascript:read('<%=dto.getBbsno()%>')"><%=dto.getTitle() %></a></td>
					<td><%=dto.getWname() %></td>
					<td><%=dto.getGrpno() %></td>
					<td><%=dto.getIndent() %></td>
					<td><%=dto.getAnsnum() %></td>
				</tr>
		<%}
		} %>
	</tbody>
</table>
<button class="btn" onclick="location.href='createForm.jsp'">등록</button>
</div>
</body> 
</html> 