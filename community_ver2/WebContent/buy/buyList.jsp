<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/buysalelist.js"></script>
</head>
<body>

<form action="FrontServlet" method="post" name="frm">
<input type="hidden" name="command" value="buy_list_delete">
<table>
	<tr>
		<td><input type="checkbox" name="allNum" onclick="allCheck()"></td>
		<td>글 번호</td>
		<td>구입물품</td>
		<td>가격</td>
		<td>판매자</td>
		<td>확정상태</td>
	</tr>
	<c:choose>
		<c:when test="${list != null }">
				<c:forEach var="list" items="${list }">
				<tr>
					<td><input type="checkbox" name="num" value="${list.num }"></td>
					<td>${list.boardNum }</td>
					<td>${list.goodsname }</td>
					<td>${list.goodsprice }</td>
					<td>${list.saleUserid }</td>
					<td>
						<c:choose>
							<c:when test="${list.status==0 }">
								<input type="button" name="status" value="구매확정" onclick="location.href='FrontServlet?command=buy_complete&num=${list.num}'">
								<input type="button" name="status" value="구매취소" onclick="location.href='FrontServlet?command=buy_cancel&num=${list.num}'">
							</c:when>
							<c:when test="${list.status==1 }">
								구매완료
							</c:when>
							<c:when test="${list.status==2 }">
								경매 구매 완료
							</c:when>
							<c:otherwise>
								구매취소
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="6"><input type="submit" value="선택 삭제" onclick="return selectCheck()">	
				<input type="button" value="돌아가기" onclick="location.href='FrontServlet?command=my_info'"></td>
			</tr>
		</c:when>
		<c:otherwise>
			<script>
				alert('구매 목록이 없습니다.');
			</script>
		</c:otherwise>
	</c:choose>
	
</table>
</form>
</body>
</html>