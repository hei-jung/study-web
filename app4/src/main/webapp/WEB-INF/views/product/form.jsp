<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>add product</title>
</head>
<body>
<h3>ADD A PRODUCT</h3>
<form action="/product" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<tr>
<th>seller</th>
<td><input type="text" value="${sessionScope.id}" name="p.seller" readonly></td>
</tr>
<tr>
<th>product name</th>
<td><input type="text" name="p.name"></td>
</tr>
<tr>
<th>price</th>
<td><input type="text" name="p.price"></td>
</tr>
<tr>
<th>amount</th>
<td><input type="text" name="p.amount"></td>
</tr>
<tr>
<th>image</th>
<td><input type="file" name="f"></td>
</tr>
<tr>
<th>info</th>
<td><textarea rows=5 cols=20 name="p.info"></textarea></td>
</tr>
</table>
<input type="submit" value="done!">
</form>
</body>
</html>