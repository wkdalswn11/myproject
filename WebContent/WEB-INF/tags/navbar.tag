<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u"  tagdir = "/WEB-INF/tags"%>

<div class="container-fluid mb-3"> <%-- container-fluid 사용시 양쪽끝을 채워줌 --%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${root }/index.jsp">중앙프로젝트</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${root }/index.jsp"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${root }/list.do">정보공유(Tip)</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${root }/slist.do">동물간식</a>
      </li>
    </ul>
    <u:notLogin>
    <ul class="navbar-nav">
    	<li class="nav-item">
    	<a href="${root }/newmember.do" class="nav-link">회원 가입</a>
    	</li>
    	<li class="nav-item">
    	<a href="${root }/login.do" class="nav-link">로그인</a>
    	</li>
    </ul>		
    </u:notLogin>
    
    <u:isLogin>
	    <ul class="navbar-nav">
	    	<li class="nav-item">
	    	<b>현재 로그인 : ${authUser.id }</b> <br /> 
	    	<b>사용자 이름 : ${authUser.name }</b>
	    	</li>
	    	<li class="nav-item">
	    	<a href="${root }/logout.do" class="nav-link">로그아웃</a>
	    	</li>
	    	<li class="nav-item">
	    	<a href="${root }/changePwd.do" class="nav-link">암호 변경</a>
	    	</li>
	    	<li class="nav-item">
	    	<a href="${root }/memberdelete.do" class="nav-link">회원 탈퇴</a>
	    	</li>
	    </ul>
    </u:isLogin>
    	
       
  </div>
</nav>
</div>