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

@import url("강아지7.jpg");
*{margin: 0px; padding: o; box-sizing: border-box;}
body {     
	display: ;
    justify-content: center;
    align-items: center;
    height: 100vh; 
    background: url("강아지7.jpg") no-repeat center;
    background-size: cover;
	}
	body::before{
    content: "";
    position: ;z-index: 0;
    top: 0;right: 0; bottom: 0; left: 0;
    background-color: rgba(0,0,0,0.8);
}

</style>
</head>
<body>

<u:navbar/>
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
						<div class="mvInlineN">추천수</div>
					</li>






					<c:forEach var="snack" items="${snackPage.content }">
						<li class=" likeTblTr likeTblTd">
							<div class="mvInlineN td_name sv_use">${snack.number }</div>

							<div class="td_subject" style="padding-left: 0px">
								<div class="bo_tit">

									<a
										href="${root }/sread.do?no=${snack.number }&pageNo=${snackPage.currentPage}">
										<c:out value="${snack.title }" />
									</a>
								</div>

							</div> <span class="onlyMvV" style="padding-left: 0px"></span>
							<div class="mvInlinev td_name sv_use">
								<span class="sv_member">${snack.writer.name }</span>
							</div>
							<div class="mvInlinev td_name sv_use">
								<i class="fa fa-eye"></i>${snack.readConunt }</div>
							<div class="mvInlinev td_name sv_use">
								<i class="fa fa-clock-o"></i>${snack.regdate}</div>
							<div class="mvInlinev td_name sv_use">
								<span class="sv_member">${snack.good - snack.hate}</span>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</form>





	<%-- <div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1>간식 게시판</h1>

				<div class="list-container">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="num-col"><i class="fab fa-slack-hash"></i></th>
								<th class="title-col">제목</th>
								<th class="read-col"><i class="fas fa-eye"></i></th>
								<th class="writer-col"><i class="fas fa-user-edit"></i></th>
								<th class="good-col">추천</th>
								 
							</tr>
						</thead>
						<tbody>
							<c:forEach var="snack" items="${snackPage.content }">
								<tr>
									<td class="text-right">${snack.number }</td>
									<td><a
										href="${root }/sread.do?no=${snack.number }&pageNo=${snackPage.currentPage}">
											<c:out value="${snack.title }" />
									</a></td>
									<td class="text-right">${snack.readConunt }</td>
									<td>${snack.writer.name }</td>
									<td>${snack.good - snack.hate }</td>
									 
								</tr>
							</c:forEach>
						</tbody>

					</table> --%>
					<form action="slist.do" method="get" class="center">
						<select name="field" id="">
						<option value="title">제목</option>
						<option value="writer_id">작성자</option>
						</select>
						<input type="text"  name="search" />
						<input type="submit" value="검색" class="btn btn-primary"/>
						<u:isLogin>
						<a href="${root }/swrite.do" class="btn btn-primary">글 쓰기</a>
						</u:isLogin>
					</form>

				</div>
				<div class="mt-5 pagenation-container d-flex justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${snackPage.startPage > 5}">
								<li class="page-item"><a class="page-link"
									href="${root }/slist.do?pageNo=${snack.startPage - 5 }">Previous</a></li>
							</c:if>

							<c:forEach begin="${snackPage.startPage }"
								end="${snackPage.endPage }" var="pNo">
								<li class="page-item"><a class="page-link"
									href="${root }/slist.do?pageNo=${pNo}">${pNo }</a></li>

							</c:forEach>
							<c:if test="${snackPage.endPage < snackPage.totalPages }">
								<li class="page-item"><a class="page-link"
									href="${root }/slist.do?pageNo=${snackPage.startPage + 5 }">Next</a></li>
							</c:if>
						</ul>

					</nav>
					
				</div>
		
	
<u:new></u:new>
</body>
</html>