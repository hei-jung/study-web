<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- .jsp 용도: View Page에서 사용 -->
	<%
		//< % 표시:- Scriptlet(스크립트릿). 자바코드. request/response
		String id = request.getParameter("id"); // form parameter(양식에 입력한 값으로, 파라미터는 폼파라미터의 이름.)
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String msg = request.getParameter("msg");
		String type = request.getParameter("type");
	%>
	<h3>파라미터 출력</h3>
	id:<%=id%><br /><!-- < % = 자바 변수 출력 -->
	pwd:<%=pwd%><br />
	hobby:<% for(String i:hobby){out.print(i+"<br/>");} %><br />
	gender:<%=gender%><br />
	msg:<%=msg%><br />
	type:<%=type%><br />
</body>
</html>