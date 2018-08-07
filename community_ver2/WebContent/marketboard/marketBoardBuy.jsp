<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	session -> loginUser : 구매자
	request -> saleMember: 판매자
			-> marketBoard: 물품 게시판(정보)
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("saleMember", request.getAttribute("saleMember"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/marketboard.js"></script>
</head>
<body>
<div>
<h3>구매 정보 확인</h3>
<form action="FrontServlet?command=market_board_buy" method="post" name="frm">
	<input type="hidden" name="saleUserid" value="${saleMember.userid }">
	<input type="hidden" name="num" value="${marketBoard.num }">
	<table>
		<tr>
			<td>글 번호</td>
			<td colspan="3">${marketBoard.num }</td>
		</tr>
		<tr>
			<td>구매자</td>
			<td>${loginUser.userid }</td>
			<td>이름</td>
			<td>${loginUser.name }</td>
		</tr>
		<tr>
			<td>판매자</td>
			<td>${saleMember.userid }</td>
			<td>이름</td>
			<td>${saleMember.name }</td>
		</tr>
		<tr>
			<td>물품 이름</td>
			<td colspan="3">${marketBoard.goodsname }</td>
		</tr>
		<tr>
			<td>물품 가격</td>
			<td colspan="3">${marketBoard.goodsprice }</td>
		</tr>
		<tr align="center">
			<td colspan="4">
				<input type="submit" value="구입">
				<input type="button" value="취소" onclick="javascript:window.close()">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>