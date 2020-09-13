<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function del(){
	location.href = "${pageContext.request.contextPath}/ProductController?cmd=del&num=${p.num}";
}
</script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/ProductController?cmd=edit&num=${p.num}"
		method="post">
		<table border="1">
			<tr>
				<th>num</th>
				<td><input type="text" value="${p.num }" readonly></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" value="${p.name }" readonly></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="text" name="price" value="${p.price}"></td>
			</tr>
			<tr>
				<th>qty</th>
				<td><input type="text" name="qty" value="${p.qty }"></td>
			</tr>
			<tr>
				<th>img</th>
				<td><img src="${p.img_path }" width="300" height="200"></td>
			</tr>
			<tr>
				<th>info</th>
				<td><textarea rows=5 cols=20 name="info">${p.info }</textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="del()">
	</form>
</body>
</html>