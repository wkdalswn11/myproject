<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(function() {
	$("#delete-btn1").click(function() {
		var d = confirm("삭제 하시겠습니까?");
		if(d) {
			location.href="read.do?no=${reply.infoNum }";
		}
	})
})
</script>
<div>
	<c:forEach items="${replyList }" var ="reply">
		<div>
		<textarea rows="7" cols="15" readonly="readonly">${reply.body }</textarea>
			<%-- <input type="text" value="${reply.body }" readonly /> --%>
			<input type="text" value="작성자 : ${reply.memberId }" readonly="readonly"/><%-- <span>${reply.memberId }</span> --%>
			<form action="${root }/reply/delete.do">
			<input type="text" value="${reply.infoNum }" name="no" hidden/>
			<input type="text" value="${reply.id }" name="num" hidden />			
			<button id="delete-btn1" class="btn btn-danger">댓글삭제</button>
			</form>
		</div>
		
	</c:forEach>
</div>