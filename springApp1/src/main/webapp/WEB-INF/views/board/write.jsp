<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write</title>
</head>
<body>
<h3>새 글쓰기</h3>
<form action="${pageContext.request.contextPath }/board/write" method="post">
<table>
<tr>
<td>title</td><td><input type="text" name="title"></td>
</tr>
<tr>
<td>writer</td><td><input type="text" value="${sessionScope.id }" name="writer" readonly></td>
</tr>
<tr>
<td colspan=2><textarea rows=7 cols=28 name="content" style="resize: none;">내용을 입력하세요</textarea></td>
</tr>
</table>
<input type="submit" value="저장"><br>
</form>
</body>
</html>