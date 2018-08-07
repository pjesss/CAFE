create table member(
	name varchar2(10),
	userid varchar2(10) primary key,
	pw varchar2(15),
	age number(3),
	email varchar2(30),
	phone varchar2(11),
	address varchar2(50),
	usermoney number(8),
	userlevel number(1) default 0
);
			
insert into member values('가나다','aa','1','15','asd.com','1','가나다 라마아','50000','0');
select * from member;


create table note(
	notenum number(5) primary key,
	toid varchar2(10),
	userid varchar2(10),
	title varchar2(50),
	content varchar2(500),
	notedate date default sysdate
);

select * from note;

create sequence note_seq start with 1 increment by 1;

insert into note(notenum,toid,userid,title,content) values(note_seq.nextval,'abc','a','첫 쪽지','내용 없음');
insert into note(notenum,toid,userid,title,content) values(note_seq.nextval,'a','abd','답 쪽지','내용 없음1');







CREATE TABLE freeboard(
	num number(5) PRIMARY KEY,
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,
	writedate date default sysdate,
	userid varchar2(10)
);
create sequence freeboard_seq start with 1 increment by 1;

select * from freeboard;

insert into freeboard(num, title, content, userid) values(freeboard_seq.nextval, '첫번째글','내용없음','dog');
insert into freeboard(num, title, content, userid) values(freeboard_seq.nextval, '두번째글','내용없음','cat');
insert into freeboard(num, title, content, userid) values(freeboard_seq.nextval, '세번째글','내용없음','cow');
insert into freeboard(num, title, content, userid) values(freeboard_seq.nextval, '세번째글','내용없음','cow');

update freeboard set readcount=10 where num=1;
update freeboard set readcount=15 where num=2;
update freeboard set readcount=3 where num=3;
update freeboard set readcount=15 where num=4;

delete from FREEBOARD where readcount=0;




CREATE TABLE marketboard(
	num number(5) PRIMARY KEY,
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,
	writedate date default sysdate,
	userid varchar2(10),
	goodsname varchar2(20),
	goodsprice number(8),
	imgpath1 varchar2(200),
	imgpath2 varchar2(200),
	imgpath3 varchar2(200)
);
create sequence marketboard_seq start with 1 increment by 1;

delete from MARKETBOARD;

select * from MARKETBOARD;


drop table marketboard;



CREATE TABLE marketboard(
	num number(5) PRIMARY KEY,
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,
	writedate date default sysdate,
	userid varchar2(10),
	goodsname varchar2(20),
	goodsprice number(8),
	imgpath1 varchar2(200),
	imgpath2 varchar2(200),
	imgpath3 varchar2(200),
	status number(1) default 0
);
create sequence marketboard_seq start with 1 increment by 1;
drop table marketboard;


CREATE TABLE buylist(
	num number(5) primary key,
	boardNum number(5),
	userid varchar2(10),
	saleUserid varchar2(10),
	goodsname varchar2(20),		
	goodsprice number(8),
	transMoney number(8),
	status number(1) default 0
);
create sequence buylist_seq start with 1 increment by 1;



CREATE TABLE salelist(
	num number(5) primary key,
	boardNum number(5),
	userid varchar2(10),
	buyUserid varchar2(10),
	goodsname varchar2(20),		
	goodsprice number(8),
	status number(1) default 0
);
create sequence salelist_seq start with 1 increment by 1;











	--테이블 컬럼의 구조를 바꾸다 : email을 30개로 바꾸다
	alter table member modify(email varchar2(30));

	--테이블 컬럼의 이름을 바꾸다 userid를 id로 바꾼다
	alter table member rename column userid to id;
	--> 다시 원래대로 바꿔놓자
	alter table member rename column id to userid;

	--테이블 이름을 바꾼다.
	rename member to MemberShip;
	--> 다시 원래대로 바꿔놓자
	rename membership to member;
	
	--컬럼을 추가하자 (age라는 컬럼은 정수형 3칸 짜리로 만들 것임, 제약조건은 없음)
	alter table member add(AGE number(3) null);

	--컬럼을 삭제하자 (age컬럼 삭제)
	alter table member drop column age;
	
	
	delete from member;	
	
	select * from member;

	--가상 table dual
	select 12+18 from dual;
	
	drop table member;
	
CREATE TABLE auction(
	boardnum number(5) PRIMARY KEY,
	startprice number(8),
	endprice number(8) default 0, 
	auctiontime number(2),
	writedate date default sysdate,
	readcount number(4) default 0,
	status number(1) default 0,
	enrolltime number(15),
	winner varchar2(10),
	constraint PK_auctionlist foreign key(boardnum) references marketboard(num)
);

drop table marketboard;
select*from auction;
drop table auction;


	