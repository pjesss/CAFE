<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Auction Free Exchange</title>
<style type="text/css">
html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
}



.header {
	width: 96%;
	height: 16%;
	background: white;
	margin-bottom: 5px;
	text-align: center;
}

.nav {
	width: 100%;
	height: 16%;
	float: inherit;
	background: white;
}

.section {
	width: 70%;
	height: 76%;
	float: left;
	background: white;
	border-style: ridge;
	margin-right: 2px;
}

.aside {
	width: 25%;
	height: 76%;
	float: left;
	background: white;
	border-style: ridge;
	margin-left: 2px;
}

.login {
	width: 100%;
	height: 40%;
	float: left;
	background: white;
	border-bottom-style: ridge;
}

.adv {
	width: 100%;
	height: 60%;
	float: left;
	background: white;
	border-bottom-style: ridge;
}

a{
	text-decoration: none;
	color: #000000;
	font-size : 22px;
	font-family: 인터파크고딕 M ;
}

a:hover{
	color: #ff0000;
}

nav ul{
	padding-top: 10px;
} 
nav ul li{
	display: inline; 
	border-left: 1px solid #999;
	font: bold 20px Dotum;
	padding: 0 60px; 
}

nav ul li:first-child {
	border-left: none;
}

b{
	color:blue;
}


</style>
<!-- /  경기천년제목M Medium/인터파크고딕 M   / DX회전목마 / 10X10-->
<script type="text/javascript">
function change(url){
	var x= document.getElementById("mainView");
	x.src="FrontServlet?command="+url;
}
function searchChange(url){
	var x = document.getElementById("mainView");
	var y = encodeURIComponent(document.getElementById("searchWord").value);
	x.src = "FrontServlet?command="+url+"&searchWord="+y;
}
</script>
</head>
<body>
	<header class="header">
		<h1>
			<a href="#" style="color: gray; font-size: 50px; font-family: 타이포_크레파스 B"><b>C</b>ommunity <b>A</b>uction <b>F</b>ree <b>E</b>xchange</a>
		</h1>
		<input type="text" name="searchWord" id="searchWord" size="40" ><input type="button" value="검색" onclick="searchChange('search_form')">
	</header>
	<section class="section">
		<nav class="nav">
			<ul>
				<li><a href="FrontServlet?command=free_board_list"  target="mainView">자유게시판</a></li>
				<li><a href="FrontServlet?command=market_board_list" target="mainView">장터게시판</a></li>
				<li><a href="FrontServlet?command=auction_list" target="mainView">경매</a></li>
				<li><a href="#">게임(준비중)</a></li>
			</ul>
		</nav>
		<iframe id="mainView" name="mainView" 
		src="FrontServlet?command=free_board_list"  width="99%" height="82%"></iframe>
	</section>
	<aside class="aside">
		<aside class="login"><iframe src="FrontServlet?command=login_form" width="100%" height="100%" scrolling="no"></iframe></aside>
		<aside class="adv"><img alt="광고문의" src="upload/Advertising.png"  width="100%" height="100%"></aside>
	</aside>
</body>
</html>