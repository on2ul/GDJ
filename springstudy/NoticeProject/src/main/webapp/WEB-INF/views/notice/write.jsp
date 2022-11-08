<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>

 	<div>
 		<form action="${contextPath}/ntc/add" method="post">
 			<div>
 				<label for="title">제목</label>
 				<input type="text" id="title" name ="title" required="required"> <%-- 서브밋하려면 name이 있어야 한다 name으로 하는 것. required 필수 정보 일때 넣는다 제목 안쓰면 서브밋안됨 --%>
 			</div>
 			<div>
 				<label for="content">내용</label><br>
 				<textarea id="content" name="content" rows="5" cols="30"></textarea>
 			</div>
 			<div>
 				<button>공지등록하기</button>
 				<input type="reset" value="입력초기화">
 				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'"> 
 			</div>
 		</form>
 	</div>
   
</body>
</html>