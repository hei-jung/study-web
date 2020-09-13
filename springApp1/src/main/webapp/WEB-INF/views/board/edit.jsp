<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>edit</title>
</head>
<body>
<c:if test="${sessionScope.id!=b.writer }">
<c:set var="read">readonly</c:set>
</c:if>
<form action="${pageContext.request.contextPath }/board/edit" method="post">
<table>
<tr>
<td>no.</td><td><input type="text" value="${b.num }" name="num"></td>
</tr>
<tr>
<td>title</td><td><input type="text" value="${b.title }" name="title"></td>
</tr>
<tr>
<td>writer</td><td><input type="text" value="${b.writer }" name="writer" readonly></td>
</tr>
<tr>
<td colspan=2><textarea rows=7 cols=28 name="content" style="resize: none;">${b.content }</textarea></td>
</tr>
</table>
<c:if test="${sessionScope.id==b.writer }">
<input type="submit" value="저장">
<input type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/board/del?num=${b.num }'">
</c:if>
</form>
</body>
</html>