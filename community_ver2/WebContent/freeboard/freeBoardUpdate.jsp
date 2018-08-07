<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
}

.header {
	width: 90%;
	height: 10%;
	background: white;
	margin: 2px;
	text-align: center;
	float: left;
	
}

.section {
	width: 90%;
	height: 70%;
	float: left;
	background: white;
	margin: 2px;

.article1 {
	width: 90%;
	height: 10%;
	float: left;
	background: white;
	margin: 2px;
	border-bottom-style: ridge;

.article2 {
	width: 90%;
	height: 70%;
	float: left;
	background: white;
	margin: 2px;
	

.nav1 {
	width: 20%;
	height: 20%;
	float: left;
	background: white;
	margin: 2px;
	

.nav2 {
	width: 80%;
	height: 70%;
	float: left;
	background: white;
	margin: 2px;

.nav3 {
	width: 20%;
	height: 20%;
	float: left;
	background: white;
	margin: 2px;
	border-style: ridge;
}

.nav4 {
	width: 80%;
	height: 70%;
	float: left;
	background: white;
	margin: 2px;
}


.footer {
	width: 90%;
	height: 10%;
	float: left;
	background: white;
	margin: 2px;
	
}

</style>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>

	<form action="FrontServlet?command=free_board_update&num=${param.num}"
		method="post">


		<header class="header"> <h1>글 수정하기</h1> </header>
		<section class="section">
			<article class="article1">
				<nav class="nav1">제목</nav>
				<nav class="nav2">
					<input type="text" size="30" name="title" value="${oneboard.title}">
				</nav>
			</article>
			<article class="article2">
				<nav class="nav3">내용</nav>
				<nav class="nav4">
					<textarea rows="20" cols="100" name="content">${oneboard.content}</textarea>
				</nav>
			</article>
		</section>
		<footer class="footer">
		<input type="submit" value="수정하기">
		</footer>
	</form>
</body>
</html>