<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Register a product</title>
</head>
<body>
	<h3>새 상품 등록</h3>
	<form
		action="${pageContext.request.contextPath }/ProductController?cmd=register"
		method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>등록자</th>
				<td><input type="text" value="${sessionScope.id}" name="s_id"
					readonly></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<th>재고량</th>
				<td><input type="text" name="qty"></td>
			</tr>
			<tr>
				<th>상품 이미지</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<th>제품 설명</th>
				<td><textarea rows=5 cols=20 name="info"></textarea></td>
			</tr>
		</table>
		<br />
		<input type="submit" value="등록">
	</form>
</body>
</html>