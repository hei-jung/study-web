<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Write Editor</title>
<script type="text/javascript">
function a(){
	if (f.title.value == '') {
		alert('제목 필수');
		return;
	}
	if (f.content.value == '') {
		alert('글 내용 필수');
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<h3>글작성</h3>
<form action="${pageContext.request.contextPath }/BoardController?cmd=write" method="post" name="f">
<table border=1>
<tr>
<th>제목</th><td><input type="text" name="title"></td>
</tr>
<tr>
<th>작성자</th><td><input type="text" value="${sessionScope.id }" name="writer" readonly></td>
</tr>
<tr>
<td colspan=2><textarea rows=7 cols=28 name="content"></textarea></td>
</tr>
</table><br/>
<input type="button" value="저장" onclick="a()">
</form>
</body>
</html>