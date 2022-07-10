<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../default/header.jsp" %>
<div class="wrap" align="right" >
	<form action="user_check" method="post">
		<input type="text" name="id" 
						placeholder="input id"><br>
		<input type="text" name="pw" 
					placeholder="input password"><br>
		<input type="submit" value="로그인">
		<a href="register_form">회원가입</a>
		<br>
		<input type="checkbox" name="autoLogin">
		자동로그인
	</form>
</div>
</body>
</html>

















