<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/default.css?ver=1459">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/style.css?ver=171222">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/board.common.css?ver=1459">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/js/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/mobile.css?ver=1459">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/contents.css?ver=1459">
<link rel="stylesheet"
	href="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.css?ver=1459">
<!--[if lte IE 8]><script src="http://sample.paged.kr/purewhite/js/html5.js"></script><![endif]-->

<script
	src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery-1.11.0.min.js"></script>
<script
	src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery.menu.min.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/common.js?ver=171222"></script>
<script
	src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/WEBsiting.js?ver=221712222"></script>
<script src="http://sample.paged.kr/purewhite/js/wrest.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/placeholders.min.js"></script>
<script
	src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/shuffleLetters/jquery.shuffleLetters.min.js"></script>
<script
	src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.js"></script>
<script>
	$(function() {
		var $sv_use = $(".sv_use");
		var count = $sv_use.length;

		$sv_use.each(function() {
			$(this).css("z-index", count);
			$(this).css("position", "relative");
			count = count - 1;
		});
	});
</script>
<style>
@import url("강아지4.jpg");
*{margin: 0px; padding: o; box-sizing: border-box;}
body{
    font-family:'Noto Sans KR', sans-serif;
    display: ;
    justify-content: center;
    align-items: center;
    height: 100vh;  
    background: url("강아지4.jpg") no-repeat center;
    background-size: cover;
    background-color: rgba(0,0,0,0.7);
}
body::before{
    content: "";
    position: ;z-index: 0;
    top: 0;right: 0; bottom: 0; left: 0;
    background-color: rgba(0,0,0,0.7);
}
</style>
</head>

<body>

	<u:navbar />
	
	<!-- } 게시판 카테고리 끝 -->
	<div class="conatainer">
	
		<form name="fboardlist" id="fboardlist"
			action="./board_list_update.php"
			onsubmit="return fboardlist_submit(this);" method="post">
			<input type="hidden" name="bo_table" value="basic"> <input
				type="hidden" name="sfl" value=""> <input type="hidden"
				name="stx" value=""> <input type="hidden" name="spt"
				value=""> <input type="hidden" name="sca" value="">
			<input type="hidden" name="sst" value="wr_num, wr_reply"> <input
				type="hidden" name="sod" value=""> <input type="hidden"
				name="page" value="1"> <input type="hidden" name="sw"
				value="">

			<h2 class="sound_only">기본게시판 목록</h2>
			<div class="likeTbl">
				<ul>
					<li class="likeTblTr likeTblTh">
						<div class="mvInlineN">번호</div>
						<div>제목</div>
						<div class="mvInlineN">작성자</div>
						<div class="mvInlineN td_num">
							<a
								href="#">조회
								<i class="fa fa-sort" aria-hidden="true"></i>
							</a>
						</div>
						<div class="mvInlineN td_datetime">
							<a
								href="#">날짜
								<i class="fa fa-sort" aria-hidden="true"></i>
							</a>
						</div>
					</li>






					<c:forEach var="info" items="${infoPage.content }">
						<li class=" likeTblTr likeTblTd">
							<div class="mvInlineN td_name sv_use">${info.number }</div>

							<div class="td_subject" style="padding-left: 0px">
								<div class="bo_tit">

									<a
										href="${root }/read.do?no=${info.number }&pageNo=${infoPage.currentPage}">
										<c:out value="${info.title }" />
									</a>
								</div>

							</div> <span class="onlyMvV" style="padding-left: 0px"></span>
							<div class="mvInlinev td_name sv_use">
								<span class="sv_member">${info.writer.name }</span>
							</div>
							<div class="mvInlinev td_name sv_use">
								<i class="fa fa-eye"></i>${info.read }</div>
							<div class="mvInlinev td_name sv_use">
								<i class="fa fa-clock-o"></i>${info.regdate}</div>

						</li>
					</c:forEach>
				</ul>
			</div>
		</form>

		

		<%-- <div class="list-container">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="num-col"><i class="fab fa-slack-hash"></i></th>
								<th class="title-col">제목</th>
								<th class="read-col"><i class="fas fa-eye"></i></th>
								<th class="writer-col"><i class="fas fa-user-edit"></i></th>
								<!-- <th class="love-col"><i class="fas fa-thumbs-up"></i></th>
								<th class="hate-col"><i class="fas fa-hand-middle-finger"></i></th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="info" items="${infoPage.content }">
								<tr>
									<td class="text-right">${info.number }</td>
									<td><a
										href="${root }/read.do?no=${info.number }&pageNo=${infoPage.currentPage}">
											<c:out value="${info.title }" />
									</a></td>
									<td class="text-right">${info.read }</td>
									<td>${info.writer.name }</td>
									<td>${infoSub.good }</td>
									<td>${infoSub.hate }</td>
								</tr>
							</c:forEach>
						</tbody>

					</table> --%>

		<form action="list.do" method="get" class="center">
			<select name="field" id="">
				<option value="title">제목</option>
				<option value="writer_id">작성자</option>
			</select> <input type="text" name="search" /> <input class="btn btn-info"type="submit" value="검색" />
			<u:isLogin>
				<a href="${root }/write.do" class="btn btn-primary">글 쓰기</a>
			</u:isLogin>
		</form>



		<div class="mt-5 pagenation-container d-flex justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${infoPage.startPage > 5}">
						<li class="page-item"><a class="page-link"
							href="${root }/list.do?pageNo=${info.startPage - 5 }">Previous</a></li>
					</c:if>

					<c:forEach begin="${infoPage.startPage }"
						end="${infoPage.endPage }" var="pNo">
						<li class="page-item"><a class="page-link"
							href="${root }/list.do?pageNo=${pNo}">${pNo }</a></li>

					</c:forEach>
					<c:if test="${infoPage.endPage < infoPage.totalPage }">
						<li class="page-item"><a class="page-link"
							href="${root }/list.do?pageNo=${infoPage.startPage + 5 }">Next</a></li>
					</c:if>
				</ul>

			</nav>

		</div>
</div>

<u:new></u:new>
</body>
</html>