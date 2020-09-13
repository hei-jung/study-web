<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>order</title>
</head>
<body>
<h3>ORDER</h3>
<form action="/order" method="post">
<input type="hidden" name="pnum" value="${p.num }" readonly>
<table border="1">
<tr>
<th>seller ID</th>
<td><input type="text" value="${p.seller.id }" readonly></td>
</tr>
<tr>
<th>my ID</th>
<td><input type="text" name="con_id" value="${sessionScope.id }" readonly></td>
</tr>
<tr>
<th>product name</th>
<td><input type="text" value="${p.name }" readonly></td>
</tr>
<tr>
<th>price per one</th>
<td><input type="text" name="total_price" value="${p.price }" readonly></td>
</tr>
<tr>
<th>amount</th>
<td>
<select name="amount">
<option value="0" selected>0</option>
<c:forEach var="i" begin="1" end="${p.amount }">
<option value="${i }">${i }</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<th>img</th>
<td><img src="http://localhost:7878${p.img }" width="300" height="200"></td>
</tr>
<tr>
<th>info</th>
<td><textarea rows=5 cols=20 name="info" readonly>${p.info }</textarea></td>
</tr>
<tr>
<th>type</th>
<td>
<input type="radio" name="type" value="${OrderType.PAY}" checked>PAY
<input type="radio" name="type" value="${OrderType.CART}">CART
</td>
</tr>
</table>
<input type="submit" value="done!">
</form>
</body>
</html>