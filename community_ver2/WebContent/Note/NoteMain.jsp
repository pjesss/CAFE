<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/note.css">
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
	width: 100%;
	height: 10%;
	float: left;
	background: white;
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

	function selectCheck() {
		var arrCheck = document.getElementsByName("notenum")
		for (i = 0; i < arrCheck.length; i++) {
			if (arrCheck[i].checked == true) {
				alert('삭제되었습니다.');
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


	<section class="section" id="tab_0" style="display: block;">
		<form action="FrontServlet">
			<input type="hidden" name="command" value="note_delete">

			<header class="header1">
				<table style="width: 91%">
					<tr>
						<td>보낸사람</td>
						<th>제목</th>
						<td>보낸 시간</td>
						<td>삭제</td>
					</tr>
				</table>
			</header>
			<section>
				<c:forEach var="noteList" items="${noteList}">
					<table style="width: 91%"> 
						<tr>
							<td>${noteList.toid}</td>
							<th><a
								href="FrontServlet?command=note_view&notenum=${noteList.notenum }">${noteList.title}</a>
							</th>
							<td><fmt:formatDate value="${noteList.notedate}"
									pattern="yy-MM-dd hh:mm:ss" /></td>
							<td><input type="checkbox" name="notenum"
								value="${noteList.notenum }"></td>
						</tr>
					</table>
				</c:forEach>
			</section>
			<table style="width: 91%">
				<tr>
					<td style="width: 10%" align="right"><input type="submit"
						value="삭제" onclick="return selectCheck()"></td>
				</tr>
			</table>
		</form>
	</section>

	<section class="section" id="tab_1" style="display: none;">
		<form action="FrontServlet">
			<input type="hidden" name="command" value="note_delete">
			<header class="header1">
				<table style="width: 91%">
					<tr>
						<td>받은사람</td>
						<th>제목</th>
						<td>보낸 시간</td>
						<td>삭제</td>
					</tr>
				</table>
			</header>

			<section>
				<table style="width: 91%">
					<c:forEach var="noteList" items="${sendNoteList}">
						<tr>
							<td>${noteList.userid}</td>
							<th><a
								href="FrontServlet?command=note_view&notenum=${noteList.notenum }">${noteList.title}</a>
							</th>
							<td><fmt:formatDate value="${noteList.notedate}"
									pattern="yy-MM-dd hh:mm:ss" /></td>
							<td><input type="checkbox" name="notenum"
								value="${noteList.notenum }"></td>
						</tr>
					</c:forEach>
				</table>
			</section>
			<table style="width: 91%">
				<tr>
					<td style="width: 10%" align="right"><input type="submit"
						value="삭제" onclick="return selectCheck()"></td>
				</tr>
			</table>
		</form>
	</section>


	<section class="section" id="tab_2" style="display: none;">
		<div id="wrap" align="left">
			<form action="FrontServlet?command=note_write" method="post">
				<input type="hidden" name="command" value="note_write">
				<table style="width: 84%">
					<tr>
						<td style="width: 10%">받는 사람</td>
						<th style="width: 50%"><input type="text" name="userid"
							size="80"></th>
					</tr>
					<tr>
						<td style="width: 10%">제목</td>
						<th style="width: 50%"><input type="text" name="title"
							size="80"></th>
					<tr>
						<td style="width: 10%">내용</td>
						<th style="width: 50%"><textarea rows="10" cols="60"
								name="content"></textarea></th>
					</tr>
				</table>
				<table style="width: 84%">
					<tr>
						<td style="width: 10%" align="right"><input type="submit"
							value="보내기" onclick='javascript:alert("쪽지가 전송되었습니다.")'></td>
					</tr>
				</table>

			</form>
		</div>
	</section>


</body>
</html>



