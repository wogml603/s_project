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
			console.log(data.zonecode)
			console.log(data.userSelectedType)
			console.log(data.roadAddress)
			console.log(data.jibunAddress)
			
			let addr="";
			if(data.userSelectedType == 'R')
				addr = data.roadAddress
			else
				addr = data.jibunAddress
			$("#addr1").val(data.zonecode)
			$("#addr2").val( addr )
        }
    }).open();
}
function reg(){
	if($("#id").val() == "" ){
		alert("아이디는 필수 항목 입니다")
		$("#id").focus()
	}else if($("#pw").val() == "" ){
		alert("비밀번호는 필수 항목 입니다")
		$("#pw").focus()
	}else{
		fo.submit()
	}
}
function chkId(){
	let inputId = $("#id").val()
	//console.log( inputId )
	$.ajax({
		url : 'idChk/'+inputId, type:'get',
		success : function(data){
			console.log('data : '+data)
			if(data == 0){
	$("#label").html("<b>"+inputId+" 사용 가능합니다</b>")			
			}else if(data == -1){
	$("#label").html("<b style='color:red;'>길이가 짧습니다</b>")
			}else{
	$("#label").html("<b style='color:blue;'>중복된 아이디 입니다</b>")			
			}
		}
	})
}
</script>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	<div class="wrap">
		<div style="width:600px; margin: auto;">
			<br>
			<h3 align="center">- r e g i s t e r -</h3>
			<br>
			<form id="fo" action="register" method="post">
			<table class="table">
				<tr>
					<th>아이디</th>
					<td>
<input type="text" id="id" name="id" oninput="chkId()">
<label id="label">아이디 중복 체크</label>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" id="pw" name="pw">
					</td>
				</tr>
				<tr>
					<th>주 소</th>
					<td>
						<input type="text" id="addr1" placeholder="우편번호" readonly name="addr">
						<input type="button" class="btn btn-info" value="우편번호 찾기" onclick="daumPost()">
						<br>
						<input type="text" name="addr" id="addr2" placeholder="주 소" readonly>
						<input type="text" name="addr" placeholder="상세주소">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input class="btn btn-outline-primary" type="button" onclick="reg()" value="register">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>
















