<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Article</title>
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
function b(){
	location.href = "${pageContext.request.contextPath }/BoardController?cmd=del&num=${b.num}";
}
</script>
</head>
<body>
	<c:if test="${sessionScope.id!=b.writer }">
		<c:set var="read">readonly</c:set>
	</c:if>
	<form
		action="${pageContext.request.contextPath }/BoardController?cmd=edit&num=${b.num}"
		method="post" name="f">
		<table>
			<tr>
				<td>글번호|</td>
				<td><input type="text" name="num" value="${b.num }" readonly></td>
			</tr>
			<tr>
				<td>글제목|</td>
				<td><input type="text" name="title" value="${b.title }"
					${read }></td>
			</tr>
			<tr>
				<td>작성자|</td>
				<td>${b.writer }</td>
			</tr>
			<tr>
				<td>작성일|</td>
				<td>${b.w_date }</td>
			</tr>
			<tr>
				<td colspan=2><textarea rows=7 cols=28 name="content" ${read }>${b.content}</textarea></td>
			</tr>
		</table>
	</form>
	<c:if test="${sessionScope.id==b.writer }">
		<input type="button" value="수정" onclick="a()">
		<input type="button" value="삭제" onclick="b()">
	</c:if>
</body>
</html>