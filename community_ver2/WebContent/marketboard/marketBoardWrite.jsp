<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/marketboard.js"></script>

<style type="text/css">
html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
}

.header {
	width: 100%;
	height: 5%;
	background: white;
	margin: 2px;
	text-align: left;
	float: left;
	border-style: ridge;
}

.section {
	width: 100%;
	height: 70%;
	float: left;
	background: white;
	margin: 2px;
	border-style: ridge;
}

.article1 {
	width: 10%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 3px;
	margin-bottom: 3px;
	text-align: left;
}

.article2 {
	width: 40%;
	height: 10%;
	float: left;
	background: white;
	text-align: left;
	margin-bottom: 3px;
}

.article3 {
	width: 10%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 3px;
	text-align: left;
	margin-bottom: 3px;
}

.articl4 {
	width: 30%;
	height: 10%;
	float: left;
	margin-top: 3px;
	background: white;
	text-align: left;
	margin-bottom: 3px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="/script/freeboard.js"></script>
</head>
<body>
<form action="FrontServlet?command=market_board_write" method="post" enctype="multipart/form-data" name="frm">
	<h1>물품 등록하기</h1>
	<input type="hidden" name="userid" value="${loginUser.userid }">
	<header class="header">
		<article class="article1">제목</article>
		<article class="article2"><input type="text" name="title" size="40"></article>
	</header>

	<header class="header">
		<article class="article1">물품 이름</article>
		<article class="article2"><input type="text" name="goodsname" size="40"></article>
		<article class="article3">물품 가격</article>
		<article class="article4"><input type="text" name="goodsprice"></article>
	</header>
	<header class="header">
		<article class="article1">대표 사진</article>
		<article class="article2"><input type="file" name="img1"></article>
	</header>
	<header class="header">
		<article class="article1">추가 사진1</article>
		<article class="article2"><input type="file" name="img2"></article>
		<article class="article3">추가 사진2</article>
		<article class="article4"><input type="file" name="img3"></article>
	</header>
	<section class="section"><textarea rows="9" cols="95" name="content"></textarea></section>

	<input type="submit" value="확인" onclick="return writeCheck()">
	<input type="button" value="목록" onclick="location.href='FrontServlet?command=market_board_list'">
	<input type="button" value="체크" onclick="return writeCheck()">
</form>
</body>
</html>