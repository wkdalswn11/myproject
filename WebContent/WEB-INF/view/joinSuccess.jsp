<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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
@import url("강아지1.jpg");
*{margin: 0px; padding: o; box-sizing: border-box;}
body{
    
    display:;
    
    height: 100vh;  
    background: url("강아지1.jpg") no-repeat center;
    background-size: cover;
}
body::before{
    content: "";
    
    top: 0;right: 0; bottom: 0; left: 0;
    background-color: rgba(0,0,0,0.4);
}
</style>
</head>
<body>
<u:navbar></u:navbar>
<div class="container">
	<div class="alert alert-primary" role="alert">
	  가입을 축하드립니다.!
	</div>
<div class="jumbotron">
  <h1 class="display-4">가입을 환영합니다!!</h1>
  <p class="lead">우리사이트는 반려동물을 위한 정보 공유, 간식이나 사료정보 관련 의류를 볼 수 있는 사이트 입니다.</p>
  <hr class="my-4">
  <p>지금 바로 이용해 보세요!</p>
  <a class="btn btn-primary btn-lg" href="index.jsp" role="button">메인으로</a>
</div>
</div>
<u:new></u:new>
</body>
</html>