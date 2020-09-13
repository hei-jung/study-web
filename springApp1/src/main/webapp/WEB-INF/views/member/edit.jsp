<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>edit</title>
<script>
// funcion edit(){
// 	pwd = prompt("비밀번호확인");
// 	if(pwd=='${m.pwd}'){
// 		f.submit();
// 	}else{
// 		alert('패스워드 불일치\n정보수정 취소')
// 	}
// }
</script>
</head>
<body>
	<form name="f" action="${pageContext.request.contextPath }/member/edit"
		method="post">
		<table border="1">
			<tr>
				<td>id:</td>
				<td><input type="text" value="${m.id }" name="id" readonly></td>
			</tr>
			<tr>
				<td>pwd:</td>
				<td><input type="text" value="${m.pwd }" name="pwd"></td>
			</tr>
			<tr>
				<td>name:</td>
				<td><input type="text" value="${m.name }" readonly></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" value="${m.email }" name="email"></td>
			</tr>
		</table>
		<input type="submit" value="수정"><br>
	</form>
</body>
</html>