<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function readURL(input){
	let file = input.files[0]//파일의 정보
	if(file != ""){
		let reader = new FileReader()
		reader.readAsDataURL(file)//파일의 정보를 토대로 파일 읽기
		reader.onload = function(e){//파일 로드한 값 표현
			//e : 이벤트 안에 result값이 파일의 정보를 가지고 있다
			$("#preview").attr("src", e.target.result)
		}
	}
}
</script>
</head>
<body>

<%@ include file="../default/header.jsp" %>
<div style="width: 300px; margin: auto; ">

<form action="modify" method="post"
						enctype="multipart/form-data">	
 <input type="hidden" name="writeNo" value=${dto.writeNo }>
 <input type="hidden" name="originFileName" 
 							value="${dto.imageFileName }">
 제목 <input type="text" size="30" name="title"
 							value="${dto.title }"><hr>
 내용<textarea rows="5" cols="30" name="content">${dto.content }</textarea>
<hr>
	<img src="download?imageFileName=${dto.imageFileName }"
			width="200px" height="100px" id="preview">
	<input type="file" name="imageFileName"
							onchange="readURL(this)">
	<hr>
	<input type="submit" value="수정하기">
	<input type="button" onclick="history.back()"
								value="이전으로..">
</form>

</div>


</body>
</html>





