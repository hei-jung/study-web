<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Consumer</title>
</head>
<body>
	<h3>상품 목록</h3>
	<a
		href="${pageContext.request.contextPath }/MemController?cmd=editForm">내정보</a>
	<br />
	<a href="${pageContext.request.contextPath }/MemController?cmd=logout">로그아웃</a>
	<br />
	<a href="${pageContext.request.contextPath }/MemController?cmd=out">탈퇴</a>
	<br />
	<a href="${pageContext.request.contextPath }/OrderController?cmd=order">구매내역</a>
	<br />
	<a href="${pageContext.request.contextPath }/OrderController?cmd=cart">장바구니</a>
	<br />
</body>
</html>