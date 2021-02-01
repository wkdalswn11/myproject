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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="https://www.witkorea.kr/web/plugin/vendor.min.css?20200811">
<link rel="stylesheet" type="text/css" href="https://www.witkorea.kr/web/css/reset.css?20200811">
<link rel="stylesheet" type="text/css" href="https://www.witkorea.kr/web/css/common.css?20201019">
<link rel="stylesheet" type="text/css" href="https://www.witkorea.kr/web/css/style.css?20201019_1">
<style>

@import url("강아지7.jpg");
*{margin: 0px; padding: o; box-sizing: border-box;}
	body {     
	display: ;
    justify-content: center;
    height: 100vh; 
    background: url("") no-repeat center;
    background-size: cover;
	}
 	.container {
 	margin-bottom: 20px;
 	justify-content: center;
 	align-items: center;  
 	height: 60vh;
 	}
 	.container-body {
 	
 	}
</style>
</head>
<body>
<u:navbar/>
<div class="container-wrapper lately-container" >
      <a href="${root }/list.do" class="btn btn-info">정보 게시판</a>
      <a href="${root }/slist.do" class="btn btn-info">간식 게시판</a>
      <a href="https://search.musinsa.com/category/021004" class="btn btn-info">협찬 광고</a>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="간식.jpg" class="d-block " height="600" width="1000" alt="...">
      
    </div>
    <div class="carousel-item">
      <img src="정보공유.jpg" class="d-block " height="600"  width="1000" alt="...">
    </div>
    <div class="carousel-item">
      <img src="의류광고.jpg" class="d-block "  height="600"  width="1000" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>

<div class="content-body mt-5">

<div class="container-wrapper lately-container">
            <div class="wide-bg">
                <div class="list-title">
                    <p>이야기 게시판에 올라온</p>
                    <h2>게시글</h2>
                </div>
                <div class="lately-content">
                    <div class="list-content pet-story">
                        <h3>육아정보게시판</h3>
                        <ul class="tab-menu">
                            <li class="active">관심up!</li>
                            <li class="active" style= "font: orange"><a href="${root }/list.do">더 보기</a></li>
                        </ul>
                        <div class="tab-content">
                            <ul class="tab-item active">
                                    <c:forEach items="${infoPage.content}" var="info" begin="0"  end="4">
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/read.do?no=${info.number}&pageNo=${infoPage.currentPage}" style="-webkit-box-orient: vertical;"> <c:out value="${info.title }"></c:out> </a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>${info.writer.name }</p>
                                    </div>
                                </li>
                                    </c:forEach> 
                                        <c:if test="${empty sessionScope.infoPage }">
                                             <li>
                                             <span>Hot</span>
                                    <p><a href="${root }/read.do?no=6&pageNo=1" style="-webkit-box-orient: vertical;">첫번째 게시글</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                                                <span>Hot</span>
                                    <p><a href="${root }/read.do?no=12&pageNo=1" style="-webkit-box-orient: vertical;">두번째 게시글</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                                                <span>Hot</span>
                                    <p><a href="${root }/read.do?no=13&pageNo=1" style="-webkit-box-orient: vertical;">[이벤트] 추첨을 통해 상품! 드립니다</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>장민주</p>
                                    </div>
                                </li>
                                                                <li>
                                                                <span>Hot</span>
                                    <p><a href="${root }/read.do?no=4&pageNo=1" style="-webkit-box-orient: vertical;">산책할때 유의할점!!</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style="background: "></div>
                                        <p>q</p>
                                    </div>
                                </li>
                                                                <li>
                                                                <span>Hot</span>
                                    <p><a href="${root }/read.do?no=22" style="-webkit-box-orient: vertical;">입마개의 필요성 (필독)</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>q</p>
                                    </div>
                                </li> 
                                             </c:if>                     
                                                            </ul>
                           
                                                            
                        </div>
                    </div>
                    <div class="list-content free-story">
                        <h3>댕냥간식게시판</h3>
                        <ul class="tab-menu">
                            <li class="active">추천up</li>
                            <li class="active"><a href="${root }/slist.do">더 보기</a></li>
                            
                        </ul>
                        <div class="tab-content">
                            <ul class="tab-item active">
                            <c:forEach var="snack" items="${snackPage.content }" begin="0" end="4">
                                     
                                                              
                                     <li>
                                     <span>Hot</span> 
                                    <p><a href="${root }/sread.do?no=${snack.number}&pageNo=${snackPage.currentPage}" style="-webkit-box-orient: vertical;"><c:out value="${snack.title }"/></a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>${snack.writer.name }</p>
                                    </div>
                                </li>
                            </c:forEach>
                                        <c:if test="${empty sessionScope.snackPage }">
                                        	<li>
                                  <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=7&pageNo=1" style="-webkit-box-orient: vertical;">이 간식은 어떠세요?</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>q</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=4&pageNo=1" style="-webkit-box-orient: vertical;">ZZ간식 후기</a></p>
                                    <div class="profile">
                                       <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=2&pageNo=1" style="-webkit-box-orient: vertical;">AX간식 후기</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=10&pageNo=1" style="-webkit-box-orient: vertical;">bb간식 후기</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>장민주</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=10&pageNo=1" style="-webkit-box-orient: vertical;">cc간식 ㄹㅇ후기!</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김애니비아</p>
                                    </div>
                                </li> 
                                        
                                        
                                        </c:if>
                                                                <%-- <li>
                                    <p><a href="${root }/read.do?no=1&pageNo=1" style="-webkit-box-orient: vertical;">첫번째 게시글</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <p><a href="${root }/read.do?no=2&pageNo=1" style="-webkit-box-orient: vertical;">두번째 게시글</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <p><a href="${root }/read.do?no=3&pageNo=1" style="-webkit-box-orient: vertical;">[이벤트] 추첨을 통해 상품! 드립니다</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>장민주</p>
                                    </div>
                                </li>
                                                                <li>
                                    <p><a href="${root }/read.do?no=10&pageNo=1" style="-webkit-box-orient: vertical;">산책할때 유의할점!!</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style="background: "></div>
                                        <p>q</p>
                                    </div>
                                </li>
                                                                <li>
                                    <p><a href="${root }/read.do?no=8" style="-webkit-box-orient: vertical;">입마개의 필요성 (필독)</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>q</p>
                                    </div>
                                </li> --%>
                                                            </ul>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
<div class="container-wrapper oneCut-container">
            <div class="list-title">
                <p>우리댕냥이들 얼굴보고 가실게요</p>
                <h2>최근 한컷</h2>
            </div>
            <div class="oneCut-content">
                                                        <div class="oneCut-item">
                        <div class="img-area" onclick="location.href='#'">
                            <div class="imgItem  more-img  " style="background: url('강아지.jpg') center center no-repeat; background-size: cover;">
                            </div>
                        </div>
                    </div>
                                                                            <div class="oneCut-item">
                        <div class="img-area" onclick="location.href='#'">
                            <div class="imgItem  more-img  " style="background: url('강아지2.jpg') center center no-repeat; background-size: cover;">
                            </div>
                        </div>
                    </div>
                                                                            <div class="oneCut-item">
                        <div class="img-area" onclick="location.href='#'">
                            <div class="imgItem  more-img  " style="background: url('강아지3.jpg') center center no-repeat; background-size: cover;">
                            </div>
                        </div>
                    </div>
                                                                            <div class="oneCut-item">
                        <div class="img-area" onclick="location.href='#'">
                            <div class="imgItem  more-img  " style="background: url('고양이.jpg') center center no-repeat; background-size: cover;">
                            </div>
                        </div>
                    </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    </div>
        </div>
</div>
<u:new></u:new>
<%-- <div class="container">
	<div class="card-deck">

	<div class="card" >
	  <div class="card-img-overlay">
		<!-- <h4 class="card-title">간식 게시판</h4> -->
		<a target="_blank" href="${root }/slist.do" class="btn btn-primary stretched-link" id="">게시판 바로가기</a>
	 </div>
	<img src="간식.jpg" alt="간식 사진" class="card-body card-img-right" style="width:100%"/>
	</div>
	<div class="card" >
	  <div class="card-img-overlay">
		<!-- <h4 class="card-title "></h4> -->	
		<a target="_blank" href="${root }/list.do" class="btn btn-primary stretched-link"  id="">정보공유 바로가기</a>
	 </div>
	<img src="정보공유.jpg" alt="동물 사진" class="card-body " style="width:100%"/>
	</div>
	<div class="card" >
	  <div class="card-img-overlay">
		<!-- <h4 class="card-title">광고판</h4> -->		
		<a target="_blank" href="https://search.musinsa.com/category/021004" class="btn btn-primary stretched-link"  id="">광고협찬 환영</a>
	 </div>
	<img src="의류광고.jpg" alt="광고 사진" class="card-body " style="width:100%; "/>
	</div>
</div>
</div> --%>

</body>
</html>