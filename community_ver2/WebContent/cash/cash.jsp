<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
	<h2>캐쉬충전</h2>
	<form action="FrontServlet" method="get" name="frm">
    	 <input type="hidden" name="command" value="cash_charge">
    	현재 보유 금액 : ${usermoney}<BR>
		충전금액 <input type="text" name="usermoney" >
		<input type="submit" value="충전하기" onclick="return cashCheck()">
		<br>
	</form>
</body>
</html>