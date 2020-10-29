delete from cafeorder;
commit;
drop table cafeorder;

create table cafeorder(
	orderno number(5) primary key,
	menunumber number(4) references menu(menuno),
	count number(4) not null,
	sumprice number(10) not null,
	orderdate date
);

alter table cafeorder drop column orderno;

update member set point = 5000 where mphone = '010-7196-7599';
select * from member;
commit;
create sequence order_seq
start with 1
increment by 1
nocache;

select name, price, count, sumprice, orderdate from menu m join cafeorder c on m.menuno = c.menunumber order by orderdate;



drop sequence order_seq;

select * from cafeorder order by orderno;
select orderno,name, price, count, sumprice from menu m join cafeorder c on m.menuno = c.menunumber where orderno >= 5 order by orderno;


create table cafesum(
	todaydate date not null,	
	money number(20) not null
);

insert into cafesum values(sysdate, 8500);
insert into cafesum values(sysdate, 11000);
insert into cafesum values(sysdate, 9500);
insert into cafesum values(sysdate, 24000);
insert into cafesum values(sysdate, 26000);
insert into cafesum values(sysdate, 18000);
insert into cafesum values('2020-10-27', 8500);
insert into cafesum values('2020-10-27', 24000);
insert into cafesum values('2020-10-27', 15000);
insert into cafesum values('2020-10-27', 8000);
insert into cafesum values('2020-10-27', 1500);
insert into cafesum values('2020-10-27', 8000);
insert into cafesum values('2020-10-11', 1500);
insert into cafesum values('2020-10-11', 8000);
insert into cafesum values('2020-10-11', 1500);
insert into cafesum values('2020-10-13', 8000);
insert into cafesum values('2020-10-13', 24000);
insert into cafesum values('2020-10-14', 20000);
insert into cafesum values('2020-10-14', 16000);
insert into cafesum values('2020-10-14', 7000);
insert into cafesum values('2020-10-14', 30000);

select * from cafesum order by todaydate;

select sum(money) from cafesum where to_char(todaydate,'YYYY-mm')='2020-10';

select sum(money) from cafesum where todaydate = '2020-10-29';

commit;
