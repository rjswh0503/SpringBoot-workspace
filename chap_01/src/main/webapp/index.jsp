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
<title>���� ��ȸ</title>
</head>
<body>
	

	<h1>����� ��ȸ</h1>
	<!-- ��������� �Է¹��� ���� action�� ���� ���� -->
	<form action="selectUser" method="post">
		<label for="userId">����� ID :</label>
		<input type="text" id="userId" name="userId" required/><br>
		<button type="submit">��ȸ</button>
	</form>
	
	

</body>
</html>