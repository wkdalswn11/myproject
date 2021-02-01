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
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/default.css?ver=1510">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/style.css?v2">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/board.common.css?ver=1510">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/js/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/mobile.css?ver=1510">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/css/contents.css?ver=1510">
<link rel="stylesheet" href="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.css?ver=1510">
<!--[if lte IE 8]><script src="http://sample.paged.kr/purewhite/js/html5.js"></script><![endif]-->
<script>var g5_url = "http://sample.paged.kr/purewhite"; var g5_bbs_url = "http://sample.paged.kr/purewhite/bbs"; var g5_is_member = ""; var g5_is_admin = ""; var g5_is_mobile = ""; var g5_bo_table = "basic"; var g5_sca = ""; var g5_editor = "smarteditor2"; var g5_cookie_domain = "";</script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery-1.11.0.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/jquery.menu.min.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/common.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/js/WEBsiting.js?ver=221712222"></script>
<script src="http://sample.paged.kr/purewhite/js/wrest.js?ver=171222"></script>
<script src="http://sample.paged.kr/purewhite/js/placeholders.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/shuffleLetters/jquery.shuffleLetters.min.js"></script>
<script src="http://sample.paged.kr/purewhite/theme/pagedtheme/plugin/featherlight/featherlight.min.js"></script>
<script>
$(function() {
	$("#modify-btn").click(function() {
		var c = confirm("수정 하시겠습니까?");
		if (c)  { 
			location.href="smodify.do?no=${snackData.snack.number}";
	}
	});
	$("#delete-btn").click(function() {
		var d = confirm("정말로 삭제 하시겠습니까?");
		if (d) {
			location.href="sdelete.do?no=${snackData.snack.number}";
		}
	})
})
</script> 
</head>
<body>
<u:navbar></u:navbar>
<article id="bo_v" style="width:100%">
    <header>
        <h2 id="bo_v_title">
                        <span class="bo_v_tit">
                        <c:out value="${snackData.snack.title }"/>
            			</span>
                        
        </h2>
    </header>

    <section id="bo_v_info">
        <h2>페이지 정보</h2>
        <span class="sound_only">작성자</span> <strong><span class="sv_member">${snackData.snack.writer.name }</span></strong>
        
        <span class="sound_only">조회</span><strong><i class="fa fa-eye" aria-hidden="true"></i>${snackData.snack.readConunt}</strong>
        <strong class="if_date"><span class="sound_only">작성일</span><i class="fa fa-clock-o" aria-hidden="true"></i>${snackData.snack.regdate }</strong>
    </section>

    <section id="bo_v_atc">
        <h2 id="bo_v_atc_title">본문</h2>

		
        <div id="bo_v_img">
</div>
		<div id="bo_v_can"><u:pre value="${snackData.content}"></u:pre> </div>
	</section>

	</article>




<div id="bo_v_top">
        
        <ul class="bo_v_left">
                                                                    </ul>

        <ul class="bo_v_com">
           
                       <li><a href="${root }/slist.do" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i> 목록</a></li>
                       <li><a href="sread.do?no=${snackData.snack.number }&oper=like" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i>좋아요${snack.good }</a></li>
                       <li><a href="sread.do?no=${snackData.snack.number }&oper=hate" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i>싫어요${snack.hate }</a></li>
                       <c:if test="${authUser.id == snackData.snack.writer.id }">
                       <button id="modify-btn" class="btn_b01 btn">게시글 수정</button>
						<button id="delete-btn" class="btn_b01 btn">게시글 삭제</button>
                    	</c:if>
                    </ul>

                	

                    </div>

<script>
// 글자수 제한
var char_min = parseInt(0); // 최소
var char_max = parseInt(0); // 최대
</script>

<hr class="dashHr">
<button type="button" class="cmt_btn"><i class="fa fa-commenting-o" aria-hidden="true"></i> 댓글목록 <i class="fa fa-chevron-up" aria-hidden="true"></i><i class="fa fa-chevron-down" aria-hidden="true"></i> </button>
<section id="bo_vc">
    <h2>댓글목록</h2>
    	<u:replySnackForm snackNum ="${snackData.snack.number }"/>
        <u:listReplySnack/>
</section>
<!-- } 댓글 끝 -->

<!-- } 댓글 쓰기 끝 --><script src="http://sample.paged.kr/purewhite/js/md5.js"></script>

<u:new/>




	<%-- <body>
	<div class="container">
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<td class="justify-content-center">${snackData.snack.number }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">작성자</th>
					<td>${snackData.snack.writer.name }</td>

				</tr>
				<tr>
					<th scope="row">제목</th>
					<td><c:out value=" ${snackData.snack.title }" /></td>

				</tr>
				<tr>
					<th scope="row">내용</th>
					<td><u:pre value="${snackData.content}" /></td>
				</tr>

				<tr>
					<th scope="row">
						<form action="read.do?no=${infoData.info.number }&oper=like" method="get">
						<input type="number" name="no" value="${infoData.info.number }" hidden />
						<a class="btn btn-danger"
						href="sread.do?no=${snackData.snack.number }&oper=like">좋아요</a> <!-- <input type="submit" value="좋아요" name = "good"  /> -->
						</form> <br />${snackData.snack.good }
					</th>

				</tr>
				<tr>
					<th scope="row">
						<form action="read.do?no=${infoData.info.number }&oper=like" method="get"> 
    	<input type="number" name="no" value="${infoData.info.number }" hidden />
    	<input type="submit" value="싫어요" name = "hate"  />
    	</form>  <a class="btn btn-danger"
						href="sread.do?no=${snackData.snack.number }&oper=hate">싫어요</a> <br />${snackData.snack.hate }
					</th>

				</tr>

				<tr>
					<th colspan="2"><c:set var="pageNo"
							value="${empty param.pageNo ? '1' : param.pageNo }" /> <a
						href="slist.do?pageNo=${pageNo }">[목록]</a> 
						<c:if
							test="${authUser.id == snackData.snack.writer.id }">
							<button id="modify-btn" class="btn btn-secondary">게시글 수정</button>
							<button id="delete-btn" class="btn btn-secondary">게시글 삭제</button>

						</c:if></th>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container">
	<u:replySnackForm snackNum="${snackData.snack.number }" />
	<u:listReplySnack/>
	</div> --%>
</body>
</html>