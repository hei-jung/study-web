<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Board</title>
</head>
<body>
<h3>글목록</h3>
<a href="${pageContext.request.contextPath }/BoardController?cmd=writeForm">글작성</a><br/>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>내용</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.num }</td>
				<td>${b.writer }</td>
				<td><a href="${pageContext.request.contextPath }/BoardController?cmd=detail&num=${b.num }">${b.title }</a></td>
				<td>${b.w_date }</td>
				<td>${b.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>