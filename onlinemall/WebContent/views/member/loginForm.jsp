<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Sign in</title>
</head>
<body>
	<h3>로그인</h3>
	<a
		href="${pageContext.request.contextPath }/MemController?cmd=joinForm">회원가입</a>
	<br />
	<form
		action="${pageContext.request.contextPath }/MemController?cmd=login" method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" name="id"><br /></td>
			</tr>
			<tr>
				<td>pwd:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
		</table>
		<br /> <input type="submit" value="로그인">
	</form>
</body>
</html>