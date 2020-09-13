var x = 10 // 전역변수
function f1() {
	var x = 100 // 지역변수
	y = 200 // 전역변수
	alert("x:" + x + "/y:" + y)
	document.write("f1<br>")
}

function f2(a, b) {
	alert("x:" + x + "/y:" + y)
	return a + b
}