<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.example.app2.model.join.MemberType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#btn1").click(function(){
	var id = $("#id").val();
    $.post("/member/idCheck",
    {
      id: id
    },
    function(data,status){
    	if(status=="success"){
    		var html = "이미 존재하는 아이디";
    		var res = $.parseJSON(data);
    		if(res.flag==true){
    			html = "사용 가능한 아이디";
    		}
    		$("#idCheck").html(html)
    	}
//       alert("Data: " + data + "\nStatus: " + status);
    });
  });
});
</script>
</head>
<body>
<h3>JOIN FORM</h3>
<form action="/member" method="post">
<table>
<tr>
<td>id:</td><td><input id="id" type="text" name="id"><input type="button" id="btn1" value="id check"><span id="idCheck"></span></td>
</tr>
<tr>
<td>pwd:</td><td><input type="text" name="pwd"></td>
</tr>
<tr>
<td>name:</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td>email:</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>member type:</td>
<td>
<input type="radio" name="type" value="${MemberType.CONSUMER}" checked>CONSUMER
<input type="radio" name="type" value="${MemberType.SELLER}">SELLER
</td>
</tr>
</table><br/>
<input type="submit" value="join">
</form>
</body>
</html>