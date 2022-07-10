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
<div align="center">
	<br>
	<h3 align="center">- B O A R D -</h3>
	<br>
	<table class="table table-bordered" style="width:700px; margin: 0 auto;">
		<tr style="background-color:#FFFFF6; ">
			<th><div>번호</div></th>
			<th><div>id</div></th> 
			<th><div>제목</div></th>
			<th><div>날짜</div></th>
			<th><div>조회수</div></th> 
			<th><div>이미지이름</div></th>
		</tr>
		<c:if test="${boardList.size() == 0 }">
			<tr><th colspan="6">등록된 글이 없습니다</th></tr>
		</c:if>
		<c:forEach var="dto" items="${boardList }">
		<tr>
			<td>${dto.writeNo }</td> <td>${dto.id }</td>
			
			<td>
				<a href="contentView?writeNo=${dto.writeNo }">${dto.title }</a>
			</td> 
			
			<td>${dto.saveDate }</td>
			<td>${dto.hit }</td> <td>${dto.imageFileName }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">
				<div align="left">
				<c:forEach var="num" begin="1" 
										end="${repeat }">
					<a href="boardAllList?num=${num }">
						${num } &nbsp;
					</a>
				</c:forEach>
				</div>
			
				<a href="/root/board/writeForm">글작성</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>







