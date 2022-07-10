<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th div { text-align: center; }
</style>

</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="../default/header.jsp" %>
<div class="wrap">
	<br>
		<h3 align="center">- M E M B E R -</h3>
		<br>
		<table class="table table-bordered" style="width:700px; margin: 0 auto;">
		<tr style="background-color:#FFFFF6; ">
			<th><div>아이디</div></th> 
			<th><div>비밀번호</div></th> 
			<th><div>주소</div></th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>
				<a href="info?id=${dto.id }">${dto.id }</a>
			</td>
			<td>* * * * * *</td>
			<td>${dto.addr }</td>
		</tr>
		</c:forEach>
		
	</table>
</div>	



</body>
</html>













