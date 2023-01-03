<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <a href="${contextPath}/emp/list">사원목록</a>
   
   <h1>사원등록</h1>
   
   		<div>
			<input type="text" name="empNo" placeholder="사원번호">
			<input type="text" name="empName" placeholder="사원명">
			<input type="text" name="dptName" placeholder="부서명">
			<input type="button" value="등록" id="btn1">
		</div>
		
	<hr>
	
	 <h1>사원조회</h1>
		<div>
			<input type="text" name="empNo" placeholder="사원번호">
			<input type="button" value="조회" id="btn2">
			<input type="button" value="전체" id="btn3">
		</div>
		
	<hr>
	 <h1>사원목록</h1>
	  <table border="1">
        <thead>
            <tr>
                <td>사원번호</td>
                <td>사원명</td>
                <td>출고수량</td>
                <td>연봉</td>
            </tr>
        </thead>
       </table> 
	
   
   		
   
</body>
</html>