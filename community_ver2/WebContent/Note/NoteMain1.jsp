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
	margin-bottom: 5px;
	text-align: center;
	border-style: ridge;
}

.nav {
	width: 90%;
	height: 10%;
	float: left;
	background: white;
}

.section {
	width: 90%;
	height: 60%;
	float: left;
	background: white;
	border-style: ridge;
	margin-right: 2px;
}

nav ul {
	padding-top: 10px;
}

nav ul li {
	display: inline;
	border-left: 1px solid #999;
	font: bold 20px Dotum;
	padding: 0 60px;
}

nav ul li:first-child {
	border-left: none;
}

a {
	text-decoration: none;
	color: #000000;
}

a:hover {
	color: #ff0000;
}

.article1 {
	width: 15%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 5px;
	margin-bottom: 5px;
	text-align: left;
}

.article2 {
	width: 60%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 5px;
	text-align: center;
	margin-bottom: 5px;
}

.article3 {
	width: 15%;
	height: 10%;
	float: left;
	background: white;
	margin-top: 5px;
	text-align: center;
	margin-bottom: 5px;
}

.article4 {
	width: 10%;
	height: 10%;
	float: right;
	background: white;
	margin-top: 5px;
	text-align: center;
	margin-bottom: 5px;
}
</style>
<script type="text/javascript">
	function ShowTab(val) {
		for (i = 0; i < 3; i++) {
			var tb = document.getElementById('tab_' + i);
			if (i != val)
				tb.style.display = "none";
			else
				tb.style.display = "block";
		}
	}
	
	
	function selectCheck(){
		var arrCheck = document.getElementsByName("notenum")
		for(i=0;i<arrCheck.length;i++){
			if(arrCheck[i].checked == true){
				return true;
			}
		}
		alert('선택한 항목이 없습니다');
		return false;
	}
	
</script>
</head>
<body>
	<header class="header">
		<nav class="nav">
			<ul>
				<li onclick="ShowTab('0')" style="cursor: pointer;">받은 쪽지</li>
				<li onclick="ShowTab('1')" style="cursor: pointer;">보낸 쪽지</li>
				<li onclick="ShowTab('2')" style="cursor: pointer;">쪽지 쓰기</li>
			</ul>
		</nav>
	</header>


	<section class="section" id="tab_0">
		<form action="FrontServlet">
		<input type="hidden" name="command" value="note_delete">
		
		<header class="header1">
			<article class="article1">보낸사람</article>
			<article class="article2">제목</article>
			<article class="article3">보낸 시간</article>
			<article class="article4">삭제</article>
		</header>
		<section>
			<c:forEach var="noteList" items="${noteList}">
				<article class="article1">${noteList.toid}</article>
				<article class="article2">
					<a href="FrontServlet?command=note_view&notenum=${noteList.notenum }">${noteList.title}</a>
				</article>
				<article class="article3">
					<fmt:formatDate value="${noteList.notedate}"
						pattern="yy-MM-dd hh:mm:ss" />
				</article>
				<article class="article4">
					<input type="checkbox" name="notenum" value="${noteList.notenum }">
				</article>
			</c:forEach>
		</section>
		<br><br><input type="submit" value="삭제" onclick="return selectCheck()">
		</form>
	</section>

	<section class="section" id="tab_1">
		<form action="FrontServlet">
		<input type="hidden" name="command" value="note_delete">
		<header class="header1">
			<article class="article1">받은 사람</article>
			<article class="article2">제목</article>
			<article class="article3">보낸 시간</article>
			<article class="article4">삭제</article>
		</header>

		<section>
			<c:forEach var="noteList" items="${sendNoteList}">

				<article class="article1">${noteList.userid}</article>
				<article class="article2">
					<a
						href="FrontServlet?command=note_view&notenum=${noteList.notenum }">${noteList.title}</a>
				</article>
				<article class="article3">
					<fmt:formatDate value="${noteList.notedate}"
						pattern="yy-MM-dd hh:mm:ss" />
				</article>
				<article class="article4">
					<input type="checkbox" name="notenum" value="${noteList.notenum }">
				</article>

			</c:forEach>
		</section>
		<br><br><input type="submit" value="삭제" onclick="return selectCheck()">
		</form>
	</section>


	<section class="section" id="tab_2">
		<div id="wrap" align="center">
			<form action="FrontServlet?command=note_write" method="post">
				<input type="hidden" name="command" value="note_write">
				<table>
					<tr>
						<th>받는 사람</th>
						<td><input type="text" name="userid" size="66"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="66"></td>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="50" name="content"></textarea></td>
					</tr>
				</table>
				<input type="submit" value="보내기"
					onclick='javascript:alert("쪽지가 전송되었습니다.")'>
			</form>
		</div>
	</section>


</body>
</html>