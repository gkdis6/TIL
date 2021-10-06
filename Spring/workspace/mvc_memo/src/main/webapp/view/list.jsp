<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.*, model.*, utility.*" %> 
 <%
 	//검색 관련
 	String col = Utility.checkNull(request.getParameter("col"));
 	String word = Utility.checkNull(request.getParameter("word"));
 	
 	if(col.equals("total")){
 		word = "";
 	}
 	
 	//paging 관련
 	int nowPage = 1;
 	if(request.getParameter("nowPage") != null ){
 		nowPage = Integer.parseInt(request.getParameter("nowPage"));
 	}
 	
 	int recordPerPage = 5;
 	
 	int sno = ((nowPage-1) * recordPerPage) + 1;
 	int eno = nowPage * recordPerPage;
 	
 	Map map = new HashMap();
 	map.put("col", col);
 	map.put("word", word);
 	map.put("sno",sno);
 	map.put("eno",eno);
 	List<MemoDTO> list = dao.list(map);
 	
 	int total = dao.total(col, word);
 	
 	String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
 	
 %>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  function update(memono){
	  let url = "updateForm.jsp";
	  url += "?memono="+memono;
	  url += "&col=<%=col%>";
	  url += "&word=<%=word%>";
	  url += "&nowPage=<%=nowPage%>";
	  
	  location.href = url
  }
  </script>
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<h1>목록</h1>
 <form action='list.jsp' class='form-inline' >
	<div class="form-group">
		<select class="form-control" name="col">
			<option value="wname"
			<% if(col.equals("wname")) out.print("selected");%>
			>성명</option>
			<option value="title"
			<% if(col.equals("title")) out.print("selected");%>
			>제목</option>
			<option value="content"
			<% if(col.equals("content")) out.print("selected");%>
			>내용</option>
			<option value="title_content"
			<% if(col.equals("title_content")) out.print("selected");%>
			>제목+내용</option>
			<option value="total"
			<% if(col.equals("total")) out.print("selected");%>
			>전체출력</option>
		</select>
		</div>
		<div class="form-group">
		<input type="search" class="form-control" placeholder='검색어를 입력하세요' name="word" value="<%=word%>">
	</div>
	<button class="btn">검색</button>
	<button type = "button" class="btn" onclick="location.href='createForm.jsp'">등록</button>
</form>
<table class = "table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<% if(list.size() == 0) { %>
		<tr> <td colspan="6">등록된 글이 없습니다.</td></tr>
		<%
		} else {
			for(int i = 0; i < list.size(); i++){ 
				MemoDTO dto = list.get(i);
		%>
				<tr>
					<td><%=dto.getMemono() %></td>
					<td><a href="javascript:update('<%=dto.getMemono()%>')"><%=dto.getTitle() %></a></td>
					<td><%=dto.getWdate() %>
					<%if(Utility.compareDay(dto.getWdate())){ %>
						<img src="../images/new.gif">	
					<%}%>
					</td>
				</tr>
		<%}
		} %>
	</tbody>
</table>
<%=paging %>
</div>
</body> 
</html> 