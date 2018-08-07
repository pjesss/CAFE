<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
	<div id="wrap" align="center">
		<table>
			<tr align="center">
				<td colspan="5">자유 게시판</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

				<c:forEach var="list" items="${myview}">
			<tr>
					<td>${list.num}</td>
					<td><a href="FrontServlet?command=free_board_view&num=${list.num }">${list.title}</a></td>
					<td>${list.userid}</td>
					<td>${list.writedate}</td>
					<td>${list.readcount}</td>
			</tr>
			</c:forEach> 
		</table>
		<input type="button" value="목록으로가기" onclick="location.href='FrontServlet?command=free_board_myview'">
	</div> 
	<div id="wrap" align="center">
		<table>
			<tr align="center">
				<td colspan="5">장터 게시판</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

				<c:forEach var="list" items="${myMarketList}">
			<tr>
					<td>${list.num}</td>
					<td><a href="FrontServlet?command=market_board_view&num=${list.num }">${list.title}</a></td>
					<td>${list.userid}</td>
					<td>${list.writedate}</td>
					<td>${list.readcount}</td>
			</tr>
			</c:forEach> 
		</table>
	</div> 

</body>
</html>