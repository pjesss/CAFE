<!--  
			<td>1: ${list.auctionTime }&nbsp;</td>
			<td>2: ${list.boardNum }&nbsp;</td>
			<td>3: ${list.endPrice }&nbsp;</td>
			<td>4:${list.readcount }&nbsp;</td>
			<td>5:${list.startPrice }&nbsp;</td>
			<td>6:${list.status }&nbsp;</td>
			<td>7:${list.writedate }&nbsp;</td>
			<td>8:${list.content }&nbsp;</td>
			<td>9:${list.title }&nbsp;</td>
			<td>10:${list.userid }&nbsp;</td>
			<td>11:${list.goodsname }&nbsp;</td>
			<td>12:${list.goodsprice }&nbsp;</td>
			<td>13:${list.imgpath1 }&nbsp;</td>
			<td>14:${list.imgpath2 }&nbsp;</td>
			<td>15:${list.imgpath3 }&nbsp;</td> -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/marketboard.js"></script>
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

.article0{
	width: 100%;
	height: 25%;
	float: left;
	background: white;
	margin-bottom: 5px;
	text-align: left;
}

.article {
	height: 15%;
	border-bottom: 1px solid black;
	float: left;
	background: white;
	text-align: center;
}

.article1 {
	width: 10%;
	height: 24%;
	float: left;
	background: white;
	border-bottom: 1px solid gray;
	text-align: center;
}

.article2 {
	width: 10%;
	height: 24%;
	float: left;
	background: white;
	border-bottom: 1px solid gray;
	text-align: center;
}

.article3 {
	width: 50%;
	height: 24%;
	float: left;
	background: white;
	border-bottom: 1px solid gray;
}

a {
	text-decoration: none;
	color: #000000;
}
</style>
</head>
<body>
<%-- <table>
<c:forEach var="list" items="${auctionList }">
<tr>
			<td>1: ${list.auctionTime }&nbsp;</td>
			<td>2: ${list.boardNum }&nbsp;</td>
			<td>3: ${list.endPrice }&nbsp;</td>
			<td>4:${list.readcount }&nbsp;</td>
			<td>5:${list.startPrice }&nbsp;</td>
			<td>6:${list.status }&nbsp;</td>
			<td>7:${list.writedate }&nbsp;</td>
			<td>8:${list.content }&nbsp;</td>
			<td>9:${list.title }&nbsp;</td>
			<td>10:${list.userid }&nbsp;</td>
			<td>11:${list.goodsname }&nbsp;</td>
			<td>12:${list.goodsprice }&nbsp;</td>
			<td>13:${list.imgpath1 }&nbsp;</td>
			<td>14:${list.imgpath2 }&nbsp;</td>
			<td>15:${list.imgpath3 }&nbsp;</td>
</tr>
</c:forEach>
</table> --%>

	<footer class="footer">NEW</footer>
	<section class="section">
		<article class="article" style="width: 10%;">사진</article>
		<article class="article" style="width: 10%;">번호</article>
		<article class="article" style="width: 50%;">제목</article>
		<article class="article" style="width: 10%;">글쓴이</article>
		<article class="article" style="width: 10%;">작성일</article>
		<article class="article" style="width: 10%;">조회수</article>
		<c:forEach var="list" items="${auctionList }" varStatus="st" >
			<article class="article1"><img width="30" height="30" alt="이미지 없음" src="${marketBoardAllImg[st.index] }"></article>
			<article class="article2">${list.boardNum }</article>
			<article class="article3"><a href="FrontServlet?command=auction_view&num=${list.boardNum }">${list.title }</a></article>
			<article class="article2">${list.userid }</article>
			<article class="article2"><fmt:formatDate pattern="yy-MM-dd" value="${list.writedate}"></fmt:formatDate></article>
			<article class="article2">${list.readcount }</article>
		</c:forEach>
	</section>
	<footer class="footer">
		<a href="FrontServlet?command=market_board_write_form" onclick="return addListCheck('${loginUser }')">글쓰러 가기</a>
	</footer>

</body>
</html>