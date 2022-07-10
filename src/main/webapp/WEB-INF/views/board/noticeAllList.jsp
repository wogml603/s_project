<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../default/header.jsp" %>
<div class="wrap">
	<br>
		<h3 align="center">- N O T I C E -</h3>
		<br>
		<table class="table table-bordered" style="width:700px; margin: 0 auto;">
		<tr style="background-color:#FFFFF6; ">
			<th><div>번호</div></th> 
			<th><div>제목</div></th> 
			<th><div>조회수</div></th>
			<th><div>게시일</div></th>
			<c:forEach var="dto" items="${noticeList }">
				<tr>
					<td>${dto.n_number}</td>
					<td><a href="noticeView?n_number=${dto.n_number}">${dto.n_title }</a></td>			
					<td>${dto.n_hit }</td>			
					<td>${dto.n_saveDate }</td>	
				</tr>		
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>