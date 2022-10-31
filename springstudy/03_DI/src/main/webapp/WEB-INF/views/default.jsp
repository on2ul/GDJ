<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 보드폴더 밑 디테일X 그냥 매핑 이름임  -->
	<a href="${contextPath}/board/detail">게시판</a>
	
	<hr>
	
	   <a href="${contextPath}/notice/detail">공지사항</a>
	
</body>
</html>