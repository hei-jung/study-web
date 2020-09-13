<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login result</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/member/edit">내정보확인</a>
	<br>
	<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
	<br>
	<a href="${pageContext.request.contextPath }/member/out">탈퇴</a>
	<br>
	<a href="${pageContext.request.contextPath }/board/list">게시판</a>
	<br>
</body>
</html>