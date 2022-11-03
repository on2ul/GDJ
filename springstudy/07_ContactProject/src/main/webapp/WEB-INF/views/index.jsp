<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var ="contextPath" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	<%-- 스크립트가 바디태그 위에 있으면 레디를 사용해야 한다 --%>
	$(document).ready(function(){
		
	});
	
</script>
</head>
<body>
	 <div>
	 	<table border="1">
	 		<thead>
	 			<tr>
	 				<td>번호</td>
	 				<td>이름</td>
	 				<td>전화</td>
	 				<td>주소</td>
	 				<td>메일</td>
	 			</tr>
	 			<tr>
	 				<td colspan="5">없음</td>
	 			</tr>
	 			<tr>
	 				<td colspan="5" >
	 				<a href="${contextPath}/con/detil">신규연락처등록하기</a>	
	 				</td>
	 			</tr>
	 		</thead>
	 	</table>
	 </div>
	
</body>
</html>