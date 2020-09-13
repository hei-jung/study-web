<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>editor</title>
<script type="text/javascript">
	function edit(num, pwd){
		pwd2 = prompt("글 비밀번호");
		if(pwd==pwd2){
			ta = document.getElementById("content");
			str = ta.value;
			alert(str);
			location.href="/web0722/guestbook/Controller?cmd=edit&content="+str+"&num="+num;
		}
		else{
			alert("글 비밀번호가 틀렸습니다. 수정취소");
		}
	}
	
	function del(num, pwd){
		pwd2 = prompt("글 비밀번호");
		if(pwd==pwd2){
			location.href="/web0722/guestbook/Controller?cmd=del&num="+num;
		}
		else{
			alert("글 비밀번호가 틀렸습니다. 삭제취소")
		}
	}
</script>
</head>
<body>
	<h3>${a.num }번글</h3>
	<table>
		<tr>
			<td>writer:</td>
			<td><input type="text" name="writer" value="${a.writer }"
				readonly></td>
		</tr>
		<tr>
			<td>date:</td>
			<td><input type="text" name="w_date" value="${a.w_date }"
				readonly></td>
		</tr>
		<tr>
			<td>content:</td>
			<td><textarea id="content">${a.content }</textarea></td>
		</tr>
	</table>
	<input type="button" value="수정" onclick="edit(${a.num}, '${a.pwd }')">
	<input type="button" value="삭제" onclick="del(${a.num}, '${a.pwd }')">
</body>
</html>