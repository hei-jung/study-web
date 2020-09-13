<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login</title>
</head>
<body>
<h3>LOGIN</h3>
<form action="/member/login" method="post">
<table>
<tr>
<td>id:</td><td><input type="text" name="id"></td>
</tr>
<tr>
<td>pwd:</td><td><input type="text" name="pwd"></td>
</tr>
</table>
<input type="submit" value="login">
</form>
<a href="/member">sign up!</a>
</body>
</html>