<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList, guestbook.Article"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>home</title>
</head>
<body>
	<h3>방명록</h3>
	<table>
		<tr>
			<td><a href="${pageContext.request.contextPath }/guestbook/Controller?cmd=writeForm">글작성</a></td>
		</tr>
	</table>
	<br />
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th width="150px">내용</th>
		</tr>
		<%
			ArrayList<Article> list = (ArrayList<Article>) request.getAttribute("list");
			for (Article a : list) {
		%>
		<tr>
			<td><a href="${pageContext.request.contextPath }/guestbook/Controller?cmd=editForm&num=<%=a.getNum()%>"><%=a.getNum()%></a></td>
			<td><%=a.getWriter()%></td>
			<td><%=a.getW_date()%></td>
			<td><%=a.getContent()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>