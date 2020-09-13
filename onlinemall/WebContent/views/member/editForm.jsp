<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Info Editor</title>
<script type="text/javascript">
	function a() {
		if (f.pwd.value == '' || f.pwd.value == null) {
			f.pwd.value = "${m.pwd}";
		}
		f.submit();
	}
</script>
</head>
<body>
	<h3>${sessionScope.id }님의 정보</h3>
	<form
		action="${pageContext.request.contextPath }/MemController?cmd=edit"
		method="post" name="f">
		<table border="1">
			<tr>
				<td>id</td>
				<td><input type="text" value="${m.id }" name="id" readonly></td>
			</tr>
			<tr>
				<td>pwd</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" value="${m.name }" name="name" readonly></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" value="${m.email }" name="email"></td>
			</tr>
			<tr>
				<td>type</td>
				<td><input type="text" value="${m.type }" name="type" readonly></td>
			</tr>
			<tr>
			</tr>
		</table>
		<input type="button" value="수정" onclick="a()">
	</form>
</body>
</html>