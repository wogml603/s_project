<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"
		 value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">


<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* { margin: 0; }
.wrap { width: 1000px; margin: auto; }
.header { width: 1000px; }
.navdiv { width: 100%; background-color: black; }
nav { background-color: black; width: 1000px; }
nav ul {
	list-style: none;
	display: flex;
	justify-content: flex-end;
}
nav ul li { margin: 0 3px; padding: 10px 10px; }
nav ul li a { text-decoration: none; color: white; }
nav ul li a:hover {
	color: orange;
	padding-bottom: 3px; /* a태그 밑줄과 글씨 간격*/
	border-bottom: 1px solid orange;
	transition: all 0.25s;
}
.title { /*오른, 아래, 번짐*/
	text-shadow: 10px 10px 15px black;
	font-size: 70pt;
	text-align: center;
	margin-top: 0px;
	padding-bottom: 20px;
	color: gray;
	font-family: Gabriola;
}
.content {
	margin-top: 50px;
}
</style>

</head>
<body>
	<div class="wrap">
		<div class="header">
			<h1 class="title">WEB PROJECT</h1>
		</div>
	</div>
	<div class="navdiv">
		<div class="wrap">
			<nav>
				<ul>
					<li><a href="/root">HOME</a></li>
					
					<li>
		<a href="/root/member/memberInfo">MEMBER_SHIP</a>
					</li>
					<li>
		<a href="/root/board/noticeAllList">NOTICE</a>
					</li>		
					<li>
		<a href="/root/board/boardAllList">BOARD</a>
					</li>

					
					
					<li>
			<c:if test="${loginUser != null }">
		<a href="/root/member/logout">LOGOUT</a>
			</c:if>
			<c:if test="${loginUser == null }">
		<a href="/root/member/login">LOGIN</a>
			</c:if>	
					
					</li>
				</ul>
				
			</nav>
		</div>
	</div>
</body>
</html>






