<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<meta charset="utf-8">
<script>
	function update() {
		let url = "update";
		url += "?bbsno=${dto.bbsno}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";

		location.href = url;
	}
	function del() {
		let url = "delete";
		url += "?bbsno=${dto.bbsno}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";
		url += "&oldfile=${dto.filename}";

		location.href = url;
	}
	function reply() {
		let url = "reply";
		url += "?bbsno=${dto.bbsno}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";

		location.href = url;
	}
	function list() {
		let url = "list";
		url += "?col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";

		location.href = url;
	}
	function delete_Ajax(){
		let url = "delete_Ajax";
		url += "?bbsno=${dto.bbsno}";
		url += "&oldfile=${dto.filename}";
		url += "&col=${param.col}";
		url += "&word=${param.word}";
		url += "&nowPage=${param.nowPage}";
		
		location.href = url;
	}
</script>
</head>
<body>
	<div class="container">
		<h2>조회</h2>
		<div class="panel panel-default">
			<div class="panel-heading">작성자</div>
			<div class="panel-body">${dto.wname}</div>

			<div class="panel-heading">제목</div>
			<div class="panel-body">${dto.title}</div>

			<div class="panel-heading">내용</div>
			<div class="panel-body" style="height: 200px">${dto.content}</div>

			<div class="panel-heading">조회수</div>
			<div class="panel-body">${dto.viewcnt}</div>

			<div class="panel-heading">등록일</div>
			<div class="panel-body">${dto.wdate}</div>

			<div class="panel-heading">파일</div>
			<div class="panel-body">${dto.filename}</div>

		</div>

		<button class="btn" onclick="location.href='./create'">등록</button>
		<button class="btn" onclick="update()">수정</button>
		<button class="btn" onclick="del()">삭제</button>
		<button class="btn" onclick="reply()">답변</button>
		<button class="btn" onclick="list()">목록</button>
		<button class="btn" onclick="delete_Ajax()">삭제(비동기)</button>
	</div>
</body>
</html>
