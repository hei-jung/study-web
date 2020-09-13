<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write</title>
<style type="text/css">
.t {
	width: 100%;
	height: 100%;
}
</style>
<script>
	function check() {
		if (f.writer.value == '') {
			alert('작성자 필수');
			return;
		}
		if (f.pwd.value == '') {
			alert('비밀번호 필수');
			return;
		}
		if (f.content.value == '') {
			alert('글 내용 필수');
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<h3>글작성</h3>
	<form action="/web0722/guestbook/Controller?cmd=write" method="post" name="f">
		<table>
			<tr>
				<td>writer:</td>
				<td><input class="t" type="text" name="writer"></td>
			</tr>
			<tr>
				<td>pwd:</td>
				<td><input class="t" type="password" name="pwd"></td>
			</tr>
			<tr height="100px">
				<td>content:</td>
				<td><textarea class="t" rows=5 cols=20 name="content"></textarea></td>
			</tr>
		</table>
		<input type="button" value="저장" onclick="check()">
	</form>
</body>
</html>