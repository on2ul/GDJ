<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/gesipan/edit.do?gesipan_no=${gesipan.gesipan_no}';
		});
		
		$('#btn_remove').click(function(event){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/gesipan/remove.do?board_no=${gesipan.gesipan_no}';
			} else {
				alert('취소되었습니다.');
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/gesipan/list.do';
		});
		
	});
</script>
</head>
<body>

	<h1>게시글 상세 보기</h1>
	<div>
		게시글 번호 : ${gesipan.gesipan_no}
	</div>
	<div>
		게시글 제목 : ${gesipan.title}
	</div>
	<div>
		<pre>${gesipan.content}</pre>
	</div>
	<div>
		작성일자 : ${gesipan.create_date}
	</div>
	<div>
		<input type="button" value="편집" id="btn_edit">
		<input type="button" value="삭제" id="btn_remove">
		<input type="button" value="목록" id="btn_list">
	</div>

</body>
</html>