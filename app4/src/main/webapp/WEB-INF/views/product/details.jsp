<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>details</title>
<script type="text/javascript">
function del(){
	f.action="/product/delete";
	f.submit();
}
</script>
<!-- <script> -->
<!-- $(document).ready(function(){ -->
<!-- 	$("#del").click(function(){ -->
<!-- 		location.href="/product/delete" -->
<!-- 	}); -->
<!-- }); -->
<!-- </script> -->
</head>
<body>
<h3>PRODUCT DETAILS</h3>
<a href="/product/listbyseller/${sessionScope.id }">cancel editing</a>
<form action="/product/edit" method="post" name="f">
<table border="1">
<tr>
<th>num</th>
<td><input type="text" name="num" value="${p.num }" readonly></td>
</tr>
<tr>
<th>seller</th>
<td><input type="text" name="seller" value="${p.seller.id }" readonly></td>
</tr>
<tr>
<th>product name</th>
<td><input type="text" name="name" value="${p.name }"></td>
</tr>
<tr>
<th>price</th>
<td><input type="text" name="price" value="${p.price}"></td>
</tr>
<tr>
<th>amount</th>
<td><input type="text" name="amount" value="${p.amount }"></td>
</tr>
<tr>
<th>img</th>
<td><img src="http://localhost:7878${p.img }" width="300" height="200"></td>
</tr>
<tr>
<th>info</th>
<td><textarea rows=5 cols=20 name="info">${p.info }</textarea></td>
</tr>
</table>
<input type="hidden" name="img" value="${p.img }">
<input type="submit" value="edit">
<input type="button" value="delete" onclick="del()">
</form>
</body>
</html>