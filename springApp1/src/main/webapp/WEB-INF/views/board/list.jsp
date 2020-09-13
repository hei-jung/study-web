<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/board/write">새 글쓰기</a><br/>
<table border="1">
<tr>
<th>번호</th>
<th>작성자</th>
<th>제목</th>
<th>작성날짜</th>
<th>내용</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<td><a href="${pageContext.request.contextPath }/board/edit?num=${b.num}">${b.num }</a></td>
<td>${b.writer }</td>
<td>${b.title }</td>
<td>${b.w_date }</td>
<td>${b.content }</td>
</tr>
</c:forEach>
</table>
</body>
</html>