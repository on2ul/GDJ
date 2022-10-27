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
		
		$('#frm_gesipan').submit(function(event){
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

	<div>
		<form method="POST" action="${contextPath}/gesipan/add.do" id="frm_gesipan">
		
		<table border="1">
			 <thead>
            <tr>
                <th><label for="editor">작성자</label></th>
                <th><input type="text" id="editor" name="editor"></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><label for="title">제목</label></td>
                <td><input type="text" id="title" name="title"></td>
             
            </tr>
            <tr height="200">
                <th><label for="content">내용</label></th>
                <th><input type="text" id="content" name="content" style="height:200px"></th>

            </tr>
            <tr>
              
            </tr>
        </tbody>
		
		
		
		</table>
		
			<div>
				<input type="submit" value="등록">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>