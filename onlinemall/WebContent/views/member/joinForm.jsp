<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Sign up</title>
</head>
<body>
	<h3>회원가입</h3>
	<form
		action="${pageContext.request.contextPath }/MemController?cmd=join"
		method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>pwd:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>type:</td>
				<td><input type="radio" name="type" value="consumer">구매자
					<input type="radio" name="type" value="seller">판매자</td>
			</tr>
		</table>
		<br /> <input type="submit" value="가입">
	</form>
</body>
</html>
