<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url("강아지5.jpg");

* {
	margin: 0px;
	padding: o;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	display: ;
	justify-content: center;
	align-items: center;
	height: 90vh;
	background: url("강아지5.jpg") no-repeat center;
	background-size: cover;
}

body::before {
	content: "";
	position: ;
	z-index: 0;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background-color: rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
<u:navbar></u:navbar>
	<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<h1>게시글 쓰기</h1>
			<form action="${root }/write.do" method="post">
			<!-- div.form-group>label[for=input1-title]+input.form-control#input1-title[name=title] -->
				<div class="form-group">
			
				<label for="input1-title">제목</label>
				<input value="${param.title }" type="text" class="form-control" id="input1-title" name="title" />
				<c:if test="${errors.title }">
				<small class="form-text text-muted">
				제목을 입력하세요.
				</small>
				</c:if>
				</div>
				<!-- .form-group>label[for=textarea1-content]+textarea.form-control#textarea1-content -->
				<div class="form-group">
				<label for="textarea-content">내용</label>
				<textarea style="resize: none" name="content" id="textarea1-content" cols="30" rows="10" placeholder="비매너, 비속어, 정치적 발언, 타인 비하 사용시 경고없이 삭제 될 수 있습니다." class="form-control">${param.content }</textarea>
				</div>
				<button  class="btn btn-primary">등록</button>
			</form>
		</div>
	</div>
</div>
<u:new></u:new>
</body>
</html>