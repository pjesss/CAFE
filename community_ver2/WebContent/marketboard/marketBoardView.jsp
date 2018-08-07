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

.section1 {
	width: 100%;
	height: 50%;
	float: left;
	background: white;
	margin: 2px;
	border-style: ridge;
}

.section2 {
	width: 100%;
	height: 30%;
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
		<article class="article1">판매 상태</article>
		<article class="article2">
			<c:choose>
				<c:when test="${vo.status==0 }">
					판매중
				</c:when>
				<c:when test="${vo.status==2 }">
					경매중
				</c:when>
				<c:otherwise>
					판매완료
				</c:otherwise>
			</c:choose>
		</article>
		<article class="article3">제목</article>
		<article class="article4">${vo.title }</article>
	</header>

	<header class="header">
		<article class="article1">글쓴이</article>
		<article class="article2">${vo.userid }</article>
		<article class="article3">날짜</article>
		<article class="article4">
			<fmt:formatDate value="${vo.writedate }" />
		</article>
	</header>
	<header class="header">
		<article class="article1">물품 이름</article>
		<article class="article2">${vo.goodsname }</article>
		<article class="article3">물품 가격</article>
		<article class="article4">${vo.goodsprice }</article>
	</header>
	<section class="section1">
		<c:forEach var="tmp" items="${arrImglocal }">
			<c:if test="${tmp != 'none' }">
				<img alt="사진 없음" src="${tmp }" width="200" height="200">
			</c:if>
		</c:forEach>
	</section>
	<section class="section2">${vo.content}</section>

	<c:if test="${vo.status==0}">
		<c:choose>
			<c:when test="${vo.userid==loginUser.userid }">
				<input type="button" value="수정"
					onclick="location.href='FrontServlet?command=market_board_update_form&num=${vo.num }&userid=${vo.userid}'">&nbsp;&nbsp;
				<input type="button" value="삭제"
					onclick="location.href='FrontServlet?command=market_board_delete&num=${vo.num }'">&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<input type="button" value="구입"
					onclick="open_buyWin('FrontServlet?command=market_board_buy_form&num=${vo.num}', 'buy', '${loginUser }')">&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:choose>
		<c:when test="${vo.status!=2 }">
			<input type="button" value="경매" name="auctionBtn"
				onclick="auctionWin('FrontServlet?command=auction_insert_form&num=${vo.num}')">&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
			<input type="button" value="경매취소" name="auctionBtn"
				onclick="auctionWin('FrontServlet?command=auction_delete&num=${vo.num}')">&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>
	<input type="button" value="목록"
		onclick="location.href='FrontServlet?command=market_board_list'">&nbsp;&nbsp;

</body>
</html>