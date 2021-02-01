<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name = "infoNum" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${not empty sessionScope.authUser }">
	<div>
		<form action="${root }/reply/add.do" method="post">
			<input type="number"  value="${infoNum }" name="num" hidden/>
			<textarea name="body" id="" cols="60" rows="10" placeholder="비매너, 비속어 사용시 삭제 될 수 있습니다." autocapitalize="none" style="resize: none"></textarea> 
			<input type="submit" class="btn_b01 btn"value="댓글등록"/>
		</form>
	</div>
</c:if>
