<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<style>
@import url("강아지1.jpg");
@import url("강아지2.jpg");
@import url("강아지3.jpg");
@import url("강아지4.jpg");

</style>
<body>
<div class="content-body">
<div class="container-wrapper lately-container">
            <div class="wide-bg">
                <div class="list-title">
                    <p>이야기 게시판에 올라온</p>
                    <h2>게시글</h2>
                </div>
                <div class="lately-content">
                    <div class="list-content pet-story">
                        <h3>댕냥간식게시판</h3>
                        <ul class="tab-menu">
                            <li class="active">추천up!</li>
                            
                        </ul>
                        <div class="tab-content">
                            <ul class="tab-item active">
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=2&pageNo=1" style="-webkit-box-orient: vertical;">이 간식은 어떠세요?</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>q</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=10&pageNo=1" style="-webkit-box-orient: vertical;">ZZ간식 후기</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=7&pageNo=1" style="-webkit-box-orient: vertical;">AX간식 후기</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김세은</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="${root }/sread.do?no=11&pageNo=1" style="-webkit-box-orient: vertical;">bb간식 후기</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>장민주</p>
                                    </div>
                                </li>
                                                                <li>
                                    <span>Hot</span>
                                    <p><a href="/story/view/194" style="-webkit-box-orient: vertical;">cc간식 ㄹㅇ후기!</a></p>
                                    <div class="profile">
                                        <div class="profile-mini" onclick="pagePopup.openGotoPopup()" style=""></div>
                                        <p>김애니비아</p>
                                    </div>
                                </li>
                                                            </ul>
                           
                                                            
                        </div>
                    </div>
                    <div class="list-content free-story">
                        <h3>육아정보게시판</h3>
                        <ul class="tab-menu">
                            <li class="active">관심up!</li>
                            
                        </ul>
                        <div class="tab-content">
                            <ul class="tab-item active">
                                                                <li>
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
                                </li>
                                                            </ul>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
</html>