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
		
		$('#frm_edit').submit(function(event){
		
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				event.preventDefault();
				return;
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/gesipan/list.do';
		});
		
	});
</script>
</head>
<body>

	<h1>게시글 편집 화면</h1>
	<div>
		<form method="POST" action="${contextPath}/gesipan/modify.do" id="frm_edit">
			<div>
				게시글 번호 : ${gesipan.gesipan_no}
				<input type="hidden" name="gesipan_no" value="${gesipan.gesipan_no}">
			</div>
			<div>
				게시글 제목 : <input type="text" name="title" id="title" value="${gesipan.title}">
			</div>
			<div>
				게시글 내용<br>
				<textarea name="content" id="content" rows="5" cols="30">${gesipan.content}</textarea>
			</div>
			<div>
				작성일자 : ${gesipan.create_date}
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>