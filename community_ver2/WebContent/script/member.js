function loginCheck(){
   if(document.frm.userid.value==""){
      alert("아이디를 입력하세요.");
      document.frm.userid.focus();
      return false;
      
   }else if(document.frm.pw.value==""){
      alert("비밀번호를 입력하세요.");
      document.frm.pw.focus();
      return false;
   }
   if(document.frm.userid.value!=db)

   return true; //위 사항 이외에는 submit을 작동시킨다.
   
}

function searchIdCheck(){
   if(document.frm.name.value==""){
      alert("이름을 입력하세요.");
      document.frm.name.focus();
      return false;
   }else if(document.frm.phone.value==""){
      alert("휴대전화번호를 입력하세요.");
      document.frm.phone.focus();
      return false;
   }else if(isNaN(document.frm.phone.value)){
      alert("휴대전화번호를 숫자로 입력하세요.");
      document.frm.phone.focus();
      return false;
   }
   return true; 
}

function searchPwCheck(){
   if(document.frm.userid.value==""){
      alert("아이디를 입력하세요.");
      document.frm.name.focus();
      return false;
      
   }else if(document.frm.name.value==""){
      alert("이름을 입력하세요.");
      document.frm.name.focus();
      return false;
      
   }else if(document.frm.phone.value==""){
      alert("휴대전화번호를 입력하세요.");
      document.frm.phone.focus();
      return false;
   }else if(isNaN(document.frm.phone.value)){
      alert("휴대전화번호를 확인하세요.");
      document.frm.phone.focus();
      return false;
   }
   return true; 
}


function idCheck(){
   if(document.frm.userid.value==""){
      alert("아이디를 입력하세요.");
      document.frm.userid.focus();
      return ;
   }
   var url = "FrontServlet?command=idCheck&userid=" + document.frm.userid.value;
   
   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200";
   window.open(url,"_blank_2",setting);
}

function search(getUrl){
   var url = getUrl;
   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200";
   window.open(url,"_blank_1",setting);
}

function noteView(getUrl){
   var url = getUrl;
   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=700";
   window.open(url,"_blank_1",setting);
}

function joinView(getUrl){
	   var url = getUrl;
	   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=600";
	   window.open(url,"_blank_1",setting);
	}


function idOk(userid){
   opener.frm.userid.value = userid;
   opener.frm.reid.value = userid;
   
   self.close();
}

function joinCheck(){
   if(document.frm.name.value==""){
      alert("이름을 입력하세요.");
      frm.name.focus();
      return false;
   }
   if(document.frm.userid.value==""){
      alert("아이디를 입력하세요.");
      frm.id.focus();
      return false;
   }else if(document.frm.userid.value.length<4){
      alert("아이디는 4글자 이상 입력하세요.");
      frm.userid.focus();
      return false;
   }else if(document.frm.pw.value.length<6){
      alert("비밀번호는 6글자 이상 입력하세요.");
      frm.pw.focus();
      return false;
   }
   if(document.frm.pw.value==""){
      alert("비밀번호를 입력하세요.");
      frm.pw.focus();
      return false;
   }else if(document.frm.pw.value != document.frm.pw_check.value){
      alert("비밀번호가 맞지 않습니다.");
      frm.pw.focus();
      return false;
   }
   if(document.frm.age.value==""){
      alert("나이를 입력하세요.");
      frm.age.focus();
      return false;
   }else if(isNaN(document.frm.age.value)){
      alert("나이를 숫자로 입력하세요.");
      frm.age.focus();
      return false;
   }if(document.frm.phone.value==""){
      alert("휴대전화번호를 입력하세요.");
      frm.phone.focus();
      return false;
   }else if(isNaN(document.frm.phone.value)){
      alert("휴대전화번호를 숫자로 입력하세요.");
      frm.phone.focus();
      return false;
   }if(document.frm.address.value==""){
      alert("주소를 입력하세요.");
      frm.address.focus();
      return false;
   }
   if(document.frm.reid.value==""){
      alert("아이디 중복체크를 하세요.");
      frm.userid.focus();
      return false;
   }
   if(document.frm.userid.value!=document.frm.reid.value){
      alert("중복확인 아이디를 확인하세요.");
      frm.userid.focus();
      return false;
   }
   
   alert(document.frm.userid.value + "(" + document.frm.name.value + ")님\n회원가입이 완료되었습니다.");
   return true;
   self.close();
}

function dropCheck(userid){
   var url = "myinfo/dropCheck.jsp";
   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=300";
   window.open(url,"_blank_2",setting);
}

function dropOk(){
   opener.location.reload();
   //opener.document.frm.submit();
   if(document.frm.userid.value==""){
      alert("아이디를 입력하세요.");
      document.frm.userid.focus();
      return false;
   }else if(document.frm.pw.value==""){
      alert("비밀번호를 입력하세요.");
      document.frm.pw.focus();
      return false;
   }
   return true;
   //self.close();
}

function Wclose(){
   self.close();
}

function cashCheck(){
   if(document.frm.usermoney.value==""){
      alert('충전금액을 입력하세요.');
      return false;
   }
   if(document.frm.usermoney.value>10000000){
      alert('최대 충전금액을 초과했습니다.');
      return false;
   }
   if(isNaN(document.frm.usermoney.value)){
      alert('충전금액을 숫자로 입력하세요.');
      return false;
   }
   return true;
   
}