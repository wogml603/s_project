<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function daumPost(){
    new daum.Postcode({
        oncomplete: function(data) {
			let addr="";
			if(data.userSelectedType == 'R')
				addr = data.roadAddress
			else
				addr = data.jibunAddress
			$("#addr1").val(data.zonecode)
			$("#addr2").val( addr )
			$("#addr3").val("")
			$("#addr3").focus()
        }
    }).open();
}
function setPost(){
	//alert("호출")
	let str = '${data.addr}'
	let arr = str.split(",")
	$("#addr1").val(arr[0])
	$("#addr2").val(arr[1])
	$("#addr3").val(arr[2])
	
}
</script>

</head>
<body onload="setPost()">
<%@ include file="../default/header.jsp" %>
<div class="wrap">
<div style="width: 500px; margin: 0 auto;">
	<br>
	<h3 align="center">- m o d i f y -</h3>
	<br>
	<form action="modify" method="post">
<table class="table">
	<tr>
		<th>아이디</th> 
		<td>
			<input type="text" readonly 
							name="id" value="${data.id }">
		</td>
	</tr>
	<tr>
		<th>비밀번호</th> 
		<td>
			<input type="text" name="pw" value="${data.pw }">
		</td>
	</tr>
	<tr>
		<th>주소</th> 
		<td>
			<input type="text" id="addr1" readonly name="addr">
			<input type="button" class="btn btn-info" value="우편번호 찾기" onclick="daumPost()">
			<br>
			<input type="text" name="addr" id="addr2" readonly>
			<input type="text" name="addr" id="addr3">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" class="btn btn-warning" value="수정">
		</td>
	</tr>
</table>	
	</form>
</div>
</div>


</body>
</html>













