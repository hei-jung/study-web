<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>product list</title>
</head>
<body>
	<h3>MY PRODUCTS</h3>
	<a href="/member/logout">sign out</a>
	<br />
	<a href="/product">add a product</a>
	<br />
	<table border="1">
		<tr>
			<th>num</th>
			<th>name</th>
			<th>price</th>
			<th>amount</th>
			<th>info</th>
			<th>seller</th>
		</tr>
		<c:forEach var="p" items="${list }">
			<tr>
				<td>${p.num }</td>
				<td><a href="/product/details/${p.num }">${p.name }</a></td>
				<td>${p.price }</td>
				<td>${p.amount }</td>
				<td>${p.info }</td>
				<td>${p.seller.id }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>