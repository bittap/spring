
insert into productTable values (1,'후드티','1',25000,null,'이 옷은 후드티 입니다',null,null,null)

insert into productTable values (2,'후드티','1',25000,null,'이 옷은 후드티 입니다',null,null,null)

insert into productTable values (3,'청바지','1',50000,null,'이 옷은 후드티 입니다',null,null,null)

insert into productTable values (4,'청바지','1',50000,null,'이 옷은 후드티 입니다',null,null,null)

insert into orderTable values (1,1,'2016-04-30',1,'서울시 은평구 녹번동',01084194141,'1',-1,1,'bittap');

insert into orderTable values (2,1,to_char(sysdate,'YYYY-MM-DD'),1,'서울시 은평구 녹번동',01084194141,'1',-1,2,'bittap');

insert into orderTable values (3,1,to_char(sysdate,'YYYY-MM-DD'),1,'서울시 은평구 녹번동',01084194141,'1',-1,3,'bittap');

insert into orderTable values (4,1,to_char(sysdate,'YYYY-MM-DD'),1,'서울시 은평구 녹번동',01084194141,'1',-1,4,'bittap');

SELECT * FROM    ALL_CONSTRAINTS
WHERE    TABLE_NAME = 'orderTable';


출처: https://all-record.tistory.com/151 [세상의 모든 기록]