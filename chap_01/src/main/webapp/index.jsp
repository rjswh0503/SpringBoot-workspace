<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.kh.model.dao.DAO"  %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.kh.model.vo.DTO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>유저 조회</title>
</head>
<body>
	

	<h1>사용자 조회</h1>
	<!-- 사용자한테 입력받은 폼을 action을 통해 전달 -->
	<form action="selectUser" method="post">
		<label for="userId">사용자 ID :</label>
		<input type="text" id="userId" name="userId" required/><br>
		<button type="submit">조회</button>
	</form>
	
	

</body>
</html>