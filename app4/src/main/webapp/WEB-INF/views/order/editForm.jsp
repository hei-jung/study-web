<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>edit order</title>
</head>
<body>
<h3>EDIT ORDER</h3>
<a href="/order/myorder/${sessionScope.id }">go back to order list</a>
<form action="/order/edit" method="post">
<table border="1">
<tr>
<th>num</th>
<td><input type="text" name="num" value="${o.num }" readonly></td>
</tr>
<tr>
<th>seller ID</th>
<td><input type="text" value="${o.pnum.seller.id }" readonly></td>
</tr>
<tr>
<th>product name</th>
<td><input type="text" value="${o.pnum.name }" readonly></td>
</tr>
<tr>
<th>price per one</th>
<td><input type="text" name="total_price" value="${o.pnum.price }" readonly></td>
</tr>
<tr>
<th>amount</th>
<td>
<select name="amount">
<option value="1" selected>1</option>
<c:forEach var="i" begin="2" end="${o.pnum.amount }">
<option value="${i }">${i }</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<th>type</th>
<td>
<input type="radio" name="type" value="${OrderType.PAY}" checked>PAY
<input type="radio" name="type" value="${OrderType.CART}">CART
</td>
</tr>
</table>
<input type="submit" value="save">
<input type="hidden" name="pnum" value="${o.pnum.num }">
<input type="hidden" name="con_id" value="${sessionScope.id }">
</form>
</body>
</html>
