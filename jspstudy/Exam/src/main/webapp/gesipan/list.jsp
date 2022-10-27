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
	
	$('#btn_write').click(function(event){
		location.href = '${contextPath}/gesipan/write.do';
	});
	
	$('#remove_link').click(function(event){
		if(!confirm('삭제할까요')) {
			alert('취소되었습니다.');
			event.preventDefault(); 
			return;
		}
		
	})
});

</script>
</head>
<body>
		
	총 게시글:${gesipan.gesipan_no}개
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
				<tr>
				<td colspan="4">게시물이 없습니다</td> 
				
				<tr>
				<td colspan="4">
					<div>
						<input type="button" value="새글작성" id="btn_write">
					</div>
				</td>
				</tr>
				
			</thead>
			<tbody>
				<c:forEach items="${gesipans}" var="gesipan">
					<tr>
						<td>${gesipan.gesipan_no}</td>
						<td><a href="${contextPath}/gesipan/detail.do?gesipan_no=${gesipan.gesipan_no}">${gesipan.title}</a></td>
						<td>${geispan.create_date}</td>
						<td>
							<a id="remove_link" href="${contextPath}/gesipan/remove.do?gesipan_no=${gesipan.gesipan_no}"><i class="fa-solid fa-x"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>