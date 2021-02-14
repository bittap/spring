
/* Drop Tables */

DROP TABLE memberTable CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE member_Table
(
	member_id varchar2(50) NOT NULL,
	member_birthday varchar2(30),
	member_password varchar2(50),
	member_sex varchar2(10),
	member_address varchar2(300),
	member_homeNumber varchar2(50),
	member_telNumber varchar2(50),
	member_leaveChk number,
	member_email varchar2(100),
	member_signDate varchar2(50),
	member_administratorChk number,
	member_passwordQuestion varchar2(100),
	member_passwordAnswer varchar2(100),
	member_name varchar2(30),
	member_purchaseAmount number,
	member_recentDate varchar2(50),
	PRIMARY KEY (member_id)
);

select * from member_table

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount) 
values('bittap','남자','kinjwo1@naver.com','2016-04-24','김태영','50000');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount) 
values('koko12','여자','zkwodi@daum.net',sysdate,'김태순','3000');



insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount) 
values('toto6','여자','zkwodi1@daum.net','2015-02-10','태김순','350000');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount) 
values('admin','남자','admin@daum.net','2015-02-10','관리자','350000');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount,member_birthDay) 
values('jumin','여자','zkwodi1@daum.net','2015-02-10','태김순','350000','930816');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount,member_birthDay) 
values('juross','남자','zkwodi133@daum.net','2015-02-10','태김순','350000','930816-1024133');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount,member_birthDay) 
values('jurozzz333','남자','zkwodi133@daum.net',sysdate,'이나영','35022','020816-3024133');

insert into member_Table(member_id,member_sex,member_email,member_signDate,member_name,member_purchaseAmount,member_birthDay) 
values('jon','남자','zkwodi133@daum.net',to_char(sysdate,'YYYY-MM-DD'),'이보영','35022','020816-3024133');


