
/* Drop Triggers */

DROP TRIGGER TRI_orderTable_order_number;
DROP TRIGGER TRI_orderTable_order_number0;
DROP TRIGGER TRI_productTable_num;



/* Drop Tables */

DROP TABLE board2 CASCADE CONSTRAINTS;
DROP TABLE orderCancelTable CASCADE CONSTRAINTS;
DROP TABLE orderTable CASCADE CONSTRAINTS;
DROP TABLE member_Table CASCADE CONSTRAINTS;
DROP TABLE productTable CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_orderTable_order_number;
DROP SEQUENCE SEQ_orderTable_order_number0;
DROP SEQUENCE SEQ_productTable_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_orderTable_order_number INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_orderTable_order_number0 INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_productTable_num INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE board2
(
	num number NOT NULL,
	reg_date varchar2(30) NOT NULL,
	content varchar2(300),
	subject varchar2(100),
	readcount number,
	member_id varchar2(50) NOT NULL,
	PRIMARY KEY (num)
);


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


CREATE TABLE orderCancelTable
(
	order_number number NOT NULL,
	order_cancel number DEFAULT 0,
	order_return number DEFAULT 0
);


CREATE TABLE orderTable
(
	order_number number NOT NULL,
	dilivery_number number NOT NULL,
	order_date varchar2(50) NOT NULL,
	order_amount number DEFAULT 1 NOT NULL,
	delivery_address varchar2(300),
	delivery_telNumber number,
	order_etc varchar2(300),
	money_check number DEFAULT -1 NOT NULL,
	num number NOT NULL,
	member_id varchar2(50) NOT NULL,
	PRIMARY KEY (order_number)
);


CREATE TABLE productTable
(
	num number NOT NULL,
	proname varchar2(100) NOT NULL,
	amount number DEFAULT 0 NOT NULL,
	price number DEFAULT 0 NOT NULL,
	img varchar2(50),
	content varchar2(2000),
	kategori1 varchar2(100),
	kategori2 varchar2(100),
	kategori3 varchar2(100),
	PRIMARY KEY (num)
);



/* Create Foreign Keys */

ALTER TABLE board2
	ADD FOREIGN KEY (member_id)
	REFERENCES member_Table (member_id)
;


ALTER TABLE orderTable
	ADD FOREIGN KEY (member_id)
	REFERENCES member_Table (member_id)
;


ALTER TABLE orderCancelTable
	ADD FOREIGN KEY (order_number)
	REFERENCES orderTable (order_number)
;


ALTER TABLE orderTable
	ADD FOREIGN KEY (num)
	REFERENCES productTable (num)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_orderTable_order_number BEFORE INSERT ON orderTable
FOR EACH ROW
BEGIN
	SELECT SEQ_orderTable_order_number.nextval
	INTO :new.order_number
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_orderTable_order_number0 BEFORE INSERT ON orderTable
FOR EACH ROW
BEGIN
	SELECT SEQ_orderTable_order_number0.nextval
	INTO :new.order_number0
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_productTable_num BEFORE INSERT ON productTable
FOR EACH ROW
BEGIN
	SELECT SEQ_productTable_num.nextval
	INTO :new.num
	FROM dual;
END;

/



select * from orderTable;

CREATE TABLE orderTable
(
	order_number number NOT NULL,
	dilivery_number number NOT NULL,
	order_date varchar2(50) NOT NULL,
	order_amount number DEFAULT 1 NOT NULL,
	delivery_address varchar2(300),
	delivery_telNumber number,
	order_etc varchar2(300),
	money_check number DEFAULT -1 NOT NULL,
	num number NOT NULL,
	member_id varchar2(50) NOT NULL,
	PRIMARY KEY (order_number)
);
insert into orderTable values (1,1,'2016-04-30',1,'서울시 은평구 녹번동',01084194141,'1',-1,1,'bittap');

select count(*) from (select rownum as rowm,a.* from (select m.*, o.order_date from
		member_Table m, orderTable o where 1=1 and m.member_id = o.member_id)a)b
		where b.rowm>=1 and b.rowm<=5 and order_date = '2016-04-30'
		
select * from member_table, orderTable o where 

select * from member_Table;

select count(*) from member_Table m, orderTable o where m.member_id = o.member_id

select count(*) from (select rownum as rowm,a.* from (select m.*, o.order_date from
		member_Table m, orderTable o where 1=1 and m.member_id = o.member_id)a)b
		
		select count(*) from member_Table m, orderTable o where m.member_id = o.member_id
		where 1=1
		
		select count(*) from member_table
		
		select member_email from member_table
		
		select * from member_table where member_signDate = to_char(sysdate,'YYYY-MM-DD');

		select to_char(sysdate-30,'YYYY-MM-DD') from dual;
select * from producttable
select * from orderTable
delete  from orderTable
count(*),
select o.order_amount,p.price from orderTable o, productTable p where o.num = p.num;
select  a.order_amount*a.price from
(select o.order_amount*p.price from orderTable o, productTable p where o.num = p.num)a

select to_char(sysdate,'YYYY'),to_char(sysdate,'MM')-1,to_char(sysdate,'DD') from dual
select to_char(sysdate,'MM')-1 from dual
select to_char(sysdate,'DD') from dual
select sum(to_char(sysdate,'YYYY')+'-'+(to_char(sysdate,'MM')-1)-to_char(sysdate,'DD')) from dual

select * from orderTable

select   from dual
select to_char(sysdate,'YYYY-MM-')||'01' from dual
to_char(add_months(to_char(sysdate)),'YYYY-MM-')||'01'
select sum(o.order_amount*p.price) from orderTable o, productTable p where o.num = p.num and o.order_date = to_char(sysdate,'YYYY-MM-DD');

select count(*) from orderTable where order_date = to_char(sysdate,'YYYY-MM-DD');

select sum(o.order_amount*p.price) from orderTable o, productTable p where o.num = p.num and o.order_date >= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'01' and o.order_date <= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'31'

select count(*) from orderTable  where order_date >= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'01' and order_date <= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'31'

select sum(o.order_amount*p.price) from orderTable o, productTable p where o.num = p.num and o.order_date = to_char(sysdate,'YYYY-MM-DD');

select sum(o.order_amount*p.price) from orderTable o, productTable p where o.num = p.num and to_char(o.order_date,'MM') = to_char(sysdate,'MM')-1;

select sum(o.order_amount*p.price) from orderTable o, productTable p where o.num = p.num and o.order_date >= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'01' and o.order_date <= to_char(add_months(to_char(sysdate),-1),'YYYY-MM-')||'31';


select m.member_name, p.proname, o.order_date, o.order_amount   from member_table m,orderTable o, productTable p where m.member_id = o.member_id and o.num = p.num

and o.order_date >= to_char((sysdate),'YYYY-MM-')||'01' and o.order_date <= to_char((sysdate),'YYYY-MM-')||'31'


select member_id, member_name, member_email, member_signDate from member_table where  member_signDate >= to_char((sysdate),'YYYY-MM-')||'01' and member_signDate <= to_char((sysdate),'YYYY-MM-')||'31'