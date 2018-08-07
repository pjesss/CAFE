<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/member.js"></script>
</head>
<body>
<h2>회원 탈퇴 확인</h2>
	<form action="../FrontServlet" method="post" name="frm">
		<input type="hidden" name=command value="drop_user">
		아이디 <input type="text" name="userid"><br>
		비밀번호 <input type="password" name="pwd">
		 <input type="submit" value=회원탈퇴 onclick="dropOk()">
		<!-- <input type="submit" value="회원탈퇴"> -->
		 <input type="button" value="취소" onclick="location.href='FrontServlet?command=my_info'"> 
	</form>
</body>
</html>