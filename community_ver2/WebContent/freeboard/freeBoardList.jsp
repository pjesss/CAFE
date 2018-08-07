<%@page import="com.onegroup.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/freeboard.js"></script>
<style type="text/css">
html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
}

.header {
	width: 98%;
	height: 3%;
	background: white;
	margin: 2px;
	text-align: left;
	float: left;
}

.footer {
	width: 98%;
	height: 3%;
	background: white;
	margin: 2px;
	text-align: left;
	float: left;
}

.section {
	width: 98%;
	height: 32%;
	float: left;
	background: white;
	margin: 2px;
	border-style: ridge;
	overflow-x: hidden;
	overflow-y: scroll;
}

.article1 {
	width: 50%;
	height: 13%;
	float: left;
	background: white;
	margin-bottom: 5px;
	text-align: left;
	border-bottom: 1px solid black;
}

.article2 {
	width: 20%;
	height: 13%;
	float: left;
	background: white;
	text-align: center;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
}

.article3 {
	width: 5%;
	height: 13%;
	float: left;
	background: white;
	text-align: center;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
}

.article4 {
	width: 50%;
	height: 13%;
	float: left;
	background: white;
	margin-bottom: 5px;
	text-align: left;
}

.article5 {
	width: 20%;
	height: 13%;
	float: left;
	background: white;
	text-align: center;
	margin-bottom: 5px;
}

.article6 {
	width: 5%;
	height: 13%;
	float: left;
	background: white;
	text-align: center;
	margin-bottom: 5px;
}

a {
	text-decoration: none;
	color: #000000;
}
</style>
</head>
<body>

	<header class="header">HOT</header>
	<section class="section">
		<article class="article3">번호</article>
		<article class="article1">제목</article>
		<article class="article2">글쓴이</article>
		<article class="article2">작성일</article>
		<article class="article3">조회수</article>
		<c:forEach var="list" items="${freeBoardSelectBest}">
			<article class="article6">${list.num}</article>
			<article class="article4">
				<a href="FrontServlet?command=free_board_view&num=${list.num }">${list.title}</a>
			</article>
			<article class="article5">${list.userid}</article>
			<article class="article5">
				<fmt:formatDate pattern="yy-MM-dd" value="${list.writedate}"></fmt:formatDate>
			</article>
			<article class="article6">${list.readcount}</article>
		</c:forEach>
	</section>

	<footer class="footer">NEW</footer>
	<section class="section">
		<article class="article3">번호</article>
		<article class="article1">제목</article>
		<article class="article2">글쓴이</article>
		<article class="article2">작성일</article>
		<article class="article3">조회수</article>
		<c:forEach var="list" items="${freeBoardSelectAll}">
			<article class="article6">${list.num}</article>
			<article class="article4">
				<a href="FrontServlet?command=free_board_view&num=${list.num }">${list.title}</a>
			</article>
			<article class="article5">${list.userid}</article>
			<article class="article5">
				<fmt:formatDate pattern="yy-MM-dd" value="${list.writedate}"></fmt:formatDate>
			</article>

			<article class="article6">${list.readcount}</article>
		</c:forEach>
	</section>

	<footer class="footer">
		<a href="FrontServlet?command=free_board_write_form" onclick="return writebutton('${loginUser}')">글쓰러 가기</a>
	</footer>

</body>
</html>