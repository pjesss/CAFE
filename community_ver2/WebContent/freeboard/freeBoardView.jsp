<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	border-right-style: ridge;
}

.article2 {
	width: 40%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 3px;
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
	border-right-style: ridge;
}

.articl4 {
	width: 30%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 3px;
	text-align: left;
	margin-bottom: 3px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/board.css"> 
<script type="text/javascript" src="/script/freeboard.js"></script>
</head>
<body>
	
		<h1>상세글 보기</h1>
		<header class="header">
		<article class="article1">제목</article>
		<article class="article2">${oneboard.title }</article>
		<article class="article3">조회수</article>
		<article class="article4">${oneboard.readcount}</article>
	</header>

	<header class="header">
		<article class="article1">글쓴이</article>
		<article class="article2">${oneboard.userid }</article>
		<article class="article3">날짜</article>
		<article class="article4"><fmt:formatDate value="${oneboard.writedate }"/></article>
	</header>
	<section class="section">${oneboard.content}</section>
		
	<c:if test="${loginUser!=null}">
		<input type="button" name="update" value="수정" onclick="location.href='FrontServlet?command=free_board_update_form&num=${oneboard.num}'">
		<input type="button" name="update" value="삭제"
		 onclick="location.href='FrontServlet?command=free_board_delete&num=${oneboard.num}'">
	</c:if>
		<input type="button" name="update" value="목록" onclick="location.href='FrontServlet?command=free_board_list'">
	
</body>
</html>