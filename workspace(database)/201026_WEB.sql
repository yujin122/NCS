create table member20(
	name varchar2(20) primary key,
	age number(3) not null,
	wieght number(3) not null,
	height number(3) not null,
	gender varchar(10) not null
);

create table member(
	name varchar2(20) not null,
	birth number(8) not null,
	gender varchar(10) not null,
	phone number(11) primary key,
	mail varchar2(50)
);

alter table member modify(phone varchar2(20));

delete from member;

select * from member;
