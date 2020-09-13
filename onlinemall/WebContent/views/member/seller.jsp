<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Seller</title>
</head>
<body>
	<h3>내 상품 목록</h3>
	<form
		action="${pageContext.request.contextPath }/ProductController?cmd=list">
		<a
			href="${pageContext.request.contextPath }/MemController?cmd=editForm">내정보</a>
		<br /> <a
			href="${pageContext.request.contextPath }/MemController?cmd=logout">로그아웃</a>
		<br /> <a
			href="${pageContext.request.contextPath }/MemController?cmd=out">탈퇴</a>
		<br /> <a
			href="${pageContext.request.contextPath }/ProductController?cmd=registerForm">새
			상품 등록</a> <br />
	</form>
	<c:forEach var="p" items="${list }">
		<table border="1">
			<tr>
				<th>num</th>
				<td><a
					href="${pageContext.request.contextPath}/ProductController?cmd=detail&num=${p.num}">${p.num }</a></td>
			</tr>
			<tr>
				<th>name</th>
				<td>${p.name }</td>
			</tr>
			<tr>
				<th>price</th>
				<td>${p.price }원</td>
			</tr>
			<tr>
				<th>qty</th>
				<td>${p.qty }개</td>
			</tr>
			<tr>
				<th>img</th>
				<td><img src="${p.img_path }" width="300" height="200"></td>
			</tr>
			<tr>
				<th>info</th>
				<td>${p.info }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>