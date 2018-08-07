<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<br><br>
<h3>경매 등록</h3>
<br>
<form action="FrontServlet">
<input type="hidden" name="command" value="auction_insert">
<input type="hidden" name="num" value="${auctionVO.num }">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>번호</td>
		<td>${auctionVO.num }</td>
	</tr>
	<tr>
		<td>시작 금액(원)</td>
		<td><input type="text" name="startPrice" size="15"></td>
	</tr>
<!--<tr>
		<td>카운트 다운(시간)</td>
		<td><input type="text" name="auctionTime" size="15"></td>
	</tr> -->
	<tr>
		<td colspan="2">
			<input type="submit" value="등록">
			<input type="button" value="취소" onclick="">
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>