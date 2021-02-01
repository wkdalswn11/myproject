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
</head>
<style>
<style>
@import url("고양이1.jpg");
*{margin: 0px; padding: o; box-sizing: border-box;}
body{
    font-family:'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;  
    background: url("고양이1.jpg") no-repeat center;
    background-size: cover;
}
body::before{
    content: "";
    position: absolute;z-index: 0;
    top: 0;right: 0; bottom: 0; left: 0;
    background-color: rgba(0,0,0,0.7);
}
 .login-form{position: relative; z-index: 2;}
 .login-form h1{
    font-size: 32px; color: #fff;
    text-align:center;
    margin-bottom: 60px;
}
.int-area{
    width: 400px; position: relative;
     margin-top: 20px;
}
.int-area input{
    width: 500px;
    padding: 20px 10px 10px;
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #999;
    font-size: 18px; color: #fff; 
    outline: none;
}
.int-area label{
    position: absolute; left: 10px; top: 3px;
    font-size: 18px;color: #999;
    transition: top .5s ease;
}
.int-area label.warning{
    color:red !important; 
    animation: warning .3s ease;
    animation-iteration-count: 3;
}
@keyframes warning{
    0%{transform: translateX(-8px);}
    25%{transform: translateX(8px);} 
    50%{transform: translateX(-8px);}
    75%{transform: translateX(8px);}
}
.int-area input:focus + label,
.int-area input:valid + label{
    top: -2px;
    font-size: 13px; color:#166cea;
}
 .btn-area{margin-top: 30px;}
 .btn-area button{
     width: 100% ; height: 50px;
     background-color: #166cea;
     color: #fff;
     border: none;
     border-radius: 25px;
     cursor: pointer;
 }    
.caption{
    margin-top: 20px;
    text-align: center;
}
.caption a{
    font-size: 15px; color: #999;
    text-decoration: none;
}

	#cm { position:absolute; 
		  	
			}
	.hc { width:200px; left:0; right:100%; margin-left:auto; margin-right:auto; }
	 .vc { height:40px; top: 3%; bottom:97%; margin-top:auto; margin-bottom:auto; } /* 세로 중앙 정렬 */
	.ac {text-align: center;}



</style>
<link rel="stylesheet" href="style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>

<body>
    <section class="login-form">   
	

        <form action="${root }/index.jsp" method="post">
            <div class="int-area">
                <label for="id">아이디</label>
                <input type="text" name="id" id="id" value="${users.id }" autocomplete="off" required readonly="readonly">
                
            </div>
            <div class="int-area">
                <label for="pw">비밀번호 </label>
                <input type="text" name="password" id="password" value="${users.password }"autocomplete="off" required readonly="readonly">               
            </div> 
            <div class="btn-area">
            
                <button id ="btn" type="submit">메인으로</button>
                
            </div>
            
         </form>

</section>





<%-- <div class="container">


	아이디 : ${users.id } <br />
	비밀번호 : ${users.password }

</div> --%>
</body>
</html>