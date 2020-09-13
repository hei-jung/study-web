<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.order.OrderType"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>my order</title>
</head>
<body>
<h3>MY ORDERS</h3>
<a href="/member/logout">sign out</a><br/>
<a href="/product/list">shop</a><br/>
<select onchange="if(this.value) location.href=(this.value);">
<option selected>---show---</option>
<option value="/order/myorder/${sessionScope.id }/${OrderType.CART}">cart</option>
<option value="/order/myorder/${sessionScope.id }/${OrderType.PAY}">paid</option>
</select>
<a href="/order/myorder/${sessionScope.id }">show all</a>
<br/>
<table border="1">
<tr>
<th>num</th>
<th>name</th>
<th>amount</th>
<th>total price</th>
<th>type</th>
</tr>
<c:forEach var="o" items="${list }">
<tr id="${o.type }">
<td>${o.num }</td>
<td><a href="/order/${o.pnum.num }">${o.pnum.name }</a></td>
<td>${o.amount }</td>
<td>${o.total_price }</td>
<td>${o.type }</td>
<td>
<c:if test="${o.type==OrderType.CART}">
<a href="/order/edit/${o.num }">edit</a>
</c:if>
<a href="/order/delete/${o.num }">
<c:if test="${o.type==OrderType.PAY }">
remove
</c:if>
<c:if test="${o.type==OrderType.CART}">
cancel
</c:if>
</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>