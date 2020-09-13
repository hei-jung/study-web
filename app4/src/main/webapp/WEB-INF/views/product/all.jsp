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
	<h3>ALL PRODUCTS</h3>
	<a href="/member/logout">sign out</a>
	<br />
	<a href="/order/myorder/${sessionScope.id }">my order</a>
	<br />
	<form action="/product/list" method="get">
	<select name="searchby">
		<option selected>---search by---</option>
		<option value="product">product</option>
		<option value="seller">seller</option>
	</select>
	<input type="text" name="name">
	<input type="submit" value="search">
	<a href="/product/list">show all</a>
	</form>
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
				<td><a href="/order/${p.num }">${p.name }</a></td>
				<td>${p.price }</td>
				<td>${p.amount }</td>
				<td>${p.info }</td>
				<td>${p.seller.id }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>