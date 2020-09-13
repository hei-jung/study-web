<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="${pageContext.request.contextPath }/member/join" method="post">
		<table>
			<tr>
				<td>id:</td><td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>pwd:</td><td><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td>name:</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email:</td><td><input type="text" name="email"></td>
			</tr>
		</table>
		<input type="submit" value="join"><br>
	</form>
</body>
</html>