function writebutton(loginUser){
	if(loginUser!=""){
		return true;
	}else{
		alert('로그인 해주세요');
		return false;
	}
}
function write(){
	if(document.frm.title.value=""){
		alert('제목을 입력해 주세요');
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value=""){
		alert('내용을 입력해 주세요');
		document.frm.content.focus();
		return false;
	}
	
}