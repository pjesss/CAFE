<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./script/auction.js"></script>
</head>
<body>
	<form action="FrontServlet" method="post"> 
	<input type="hidden" name="command" value="auction_buy">
	<h3>입찰가격을 입력해 주세요</h3><input type="text" name="buy" >
	<input type="submit" value="입력">
	<!-- <a href="FrontServlet?command=auction_buy" target="mainView">입력</a> -->
	</form>
	
</body>
</html>