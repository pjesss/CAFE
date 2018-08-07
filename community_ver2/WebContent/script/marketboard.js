function writeCheck() {
	if (document.frm.title.value.length == 0) {
		alert('제목을 입력해 주세요!');
		document.frm.title.focus();
		return false;
	}
	if (document.frm.goodsname.value.length == 0) {
		alert('물품 이름을 입력해 주세요!');
		document.frm.goodsname.focus();
		return false;
	}
	if (document.frm.goodsprice.value.length == 0 || isNaN(document.frm.goodsprice.value)) {
		alert('물품가격을 입력하지 않았거나\n숫자가 아닙니다.');
		document.frm.goodsprice.focus();
		return false;
	}
	if (document.frm.img1.value == ""){
		alert('대표사진을 입력해주세요!');
		document.frm.img1.focus();
		return false;
	}
	if (document.frm.content.value.length == 0) {
		alert('내용을 입력해 주세요!');
		document.frm.content.focus();
		return false;
	}
	return true;
}

function open_buyWin(url, name, loginUser){
	if(loginUser == ""){
		alert('로그인 후 이용가능합니다.');
	}else{
		window.open(url, name, "width=380, height=350");
	}
}

function addListCheck(loginUser){
	if(loginUser == ""){
		alert('로그인 후 이용가능합니다.');
		return false;
	}
	return true;
}

function auctionWin(url){
	window.open(url, "add auction", "width=300, height=300");
}















