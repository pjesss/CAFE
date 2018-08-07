<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색결과</title>
<link rel="stylesheet" type="text/css" href="css/note.css">
<style type="text/css">
table td, th{
	border: #c9c2c8 solid 1px; /*경계선 색상 스타일, 굵기*/
	padding: 8px;  /* 안쪽 여백 */	
	border-spacing: 5px 5px;
	width: 10%;
}
</style>
</head>
<body>
<body>
	<h3>자유 게시판</h3>
	<div id="wrap" align="center">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="list" items="${fvo}">
				<tr>
					<td>${list.num}</td>
					<td><a href="FrontServlet?command=free_board_view&num=${list.num }">${list.title}</a></td>
					<td>${list.userid}</td>
					<td>${list.writedate}</td>
					<td>${list.readcount}</td>

				</tr>
			</c:forEach>
		</table>
	</div>


	<h3>장터 게시판</h3>
	<div id="wrap" align="center">
		<table>
			<tr>
				<td>이미지</td>
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach var="list" items="${mvo}" varStatus="st" >
			<tr>
				<td><img width="50" height="50" alt="이미지 없음" src="${mvoImg[st.index]}"></td>
				<td>${list.num }</td>
				<td><a href="FrontServlet?command=market_board_view&num=${list.num }">${list.title }</a></td>
				<td>${list.userid }</td>
				<td>${list.writedate }</td>
				<td>${list.readcount }</td>
			<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>