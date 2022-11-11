<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		
		$('#edit_area').hide(); // 편집영역 숨김
		
		$('#btn_edit').click(function(){
			$('#edit_area').show(); // 편집영역 보여주기		
			$('#detail_area').hide(); // 상세영역 숨기기
		});
	});
</script>
</head>
<body>
	
	<div id="detail_area">
		<h1>공지번호 ${notice.noticeNo}</h1>
		<h1>제목 ${notice.title}</h1>
		<h1>내용 ${notice.content}</h1>
		<h1>조회수 ${notice.hit}</h1>
		<h1>작성일 ${notice.createDate}</h1>
		<h1>수정일 ${notice.modifyDate}</h1>
		<div>
			<form id="frm_remove" action="${contextPath}/ntc/remove" method="post">
				<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
				<input type="button" value="편집" id="btn_edit">
				<input type="submit" value="삭제">
				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'"> 
			</form>
			<script>
				$('#frm_remove').submit(function(event){
					if(confirm('공지를 삭제할까요')== false) {
						event.preventDefault(); // 서브밋을 막음
						return; // 코드 진행을 막음
					}
				})
			</script>
		</div>
	</div>




 	<div id="edit_area">
 		<form action="${contextPath}/ntc/modify" method="post">
 			<div>
 				<label for="title">제목</label>
 				<input type="text" id="title" name ="title" value="${notice.title}"required="required"> <%-- 서브밋하려면 name이 있어야 한다 name으로 하는 것. required 필수 정보 일때 넣는다 제목 안쓰면 서브밋안됨 --%>
 			</div>
 			<div>
 				<label for="content">내용</label><br>
 				<textarea id="content" name="content" rows="5" cols="30">${notice.content}</textarea> <%-- textarea는 value 넣으면 안됨 태그 사이에 적어준다 --%>
 			</div>
 			<div>
 				<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
 				<button>공지수정하기</button>
 				<input type="reset" value="입력초기화">
 				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'"> 
 			</div>
 		</form>
 	</div>
 	
 	
   
</body>
</html>