<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Image List</title>
<script type="text/javascript">
function write_comment(img_num){
	writer_tag = document.getElementById(img_num+"_cmt_writer");
	cmt_tag = document.getElementById(img_num+"_cmt");
// 	alert(writer_tag.value+"\n"+cmt_tag.value);
	param = "cmd=write_cmt&img_num="+img_num+"&writer="+writer_tag.value+"&content="+cmt_tag.value;
	location.href = "${pageContext.request.contextPath}/ImgBoardController?"+param;
}
</script>
</head>
<body>
	<h3>얼굴책</h3>
	<form
		action="${pageContext.request.contextPath }/ImgBoardController?cmd=write"
		method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>title</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>writer</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>img</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="upload"></td>
			</tr>
		</table>
		<br/>
	</form>
	<c:forEach var="ib" items="${list }">
		<table border="1">
			<tr>
				<th>num</th>
				<td>${ib.num }</td>
			</tr>
			<tr>
				<th>title</th>
				<td><input type="text" name="title" value="${ib.title }"
					readonly></td>
			</tr>
			<tr>
				<th>writer</th>
				<td><input type="text" name="writer" value="${ib.writer }"
					readonly></td>
			</tr>
			<tr>
				<th>img</th>
				<td><img src="${ib.img }" width="400" height="300"></td>
			</tr>
			<tr>
				<th>comment</th>
				<td>작성자:<input type="text" id="${ib.num }_cmt_writer"><br/>
					내용:<input type="text" id="${ib.num }_cmt">
					<input type="button" value="작성" onclick="write_comment(${ib.num})">
				</td>
			</tr>
			<c:if test="${not empty ib.comments }">
				<tr>
					<th>댓글목록</th>
					<td><c:forEach var="ic" items="${ib.comments }">
							<h4>작성자:${ic.writer }<br/>${ic.content }</h4>
						</c:forEach></td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
</body>
</html>