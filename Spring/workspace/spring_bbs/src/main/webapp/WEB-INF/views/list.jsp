<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="util" uri="/ELFunctions" %>
 <c:set var='root' value="${pageContext.request.contextPath }"/>
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script>
  function read(bbsno){
	  let url = "read";
	  url += "?bbsno="+bbsno;
	  url += "&col=${col}";
	  url += "&word=${word}";
	  url += "&nowPage=${nowPage}";
	  
	  location.href = url
  }
  function fileDown(filename){
	  let url = "./fileDown";
	  url += "?filename="+filename;
	  
	  location.href = url;
  }
  </script>
</head>
<body> 
<div class="container">
<h1>게시판 목록</h1>
<form action='list' class='form-inline' >
	<div class="form-group">
		<select class="form-control" name="col">
			<option value="wname"
			<c:if test="col=='wname'">selected</c:if>
			>성명</option>
			<option value="title"
			<c:if test="col=='title'">selected</c:if>
			>제목</option>
			<option value="content"
			<c:if test="col=='content'">selected</c:if>
			>내용</option>
			<option value="title_content"
			<c:if test="col=='title_content'">selected</c:if>
			>제목+내용</option>
			<option value="total"
			<c:if test="col=='total'">selected</c:if>
			>전체출력</option>
		</select>
		</div>
		<div class="form-group">
		<input type="search" class="form-control" placeholder='검색어를 입력하세요' name="word" value="${word}">
	</div>
	<button class="btn">검색</button>
	<button type = "button" class="btn" onclick="location.href='create'">등록</button>
</form>
<table class = "table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>파일이름</th>
			<th>grpno</th>
			<th>indent</th>
			<th>ansnum</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty list }">
				<tr> <td colspan="7">등록된 글이 없습니다.</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.bbsno }</td>
					<td>
					<c:forEach begin="1" end="${dto.indent}">&nbsp;&nbsp;</c:forEach>
					<c:if test="${dto.indent > 0}"><img src='${root }/images/re.jpg'></c:if>
					<a href="javascript:read('${dto.bbsno}')">${dto.title}</a>
					<c:if test="util:newImg(dto.wdate)">
					<img src="${root}/images/new.gif">	
					</c:if>
					</td>
					<td>${dto.wname}</td>
					<td>
					<c:choose>
						<c:when test="${empty dto.filename }">파일 없음</c:when>
						<c:otherwise><a href="javascript:fileDown('${dto.filename }')">${dto.filename }</a></c:otherwise>
					</c:choose>
					</td>
					<td>${dto.grpno}</td>
					<td>${dto.indent}</td>
					<td>${dto.ansnum}</td>
				</tr>
				
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
${paging}
</div>
</body> 
</html> 