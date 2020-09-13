<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Join</title>
</head>
<body>
	<h3>join form</h3>
	<form
		action="${pageContext.request.contextPath }/MemController?cmd=join"
		method="post">
		id:<input type="text" name="id"><br/>
		pwd:<input type="text" name="pwd"><br/>
		name:<input type="text" name="name"><br/>
		email:<input type="text" name="email"><br/>
		<input type="submit" value="join"><br/>
	</form>
</body>
</html>
