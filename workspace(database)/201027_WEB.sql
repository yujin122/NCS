drop table member;

create table member(
    mname varchar2(20) not null,
    mbirth number(8) not null,
    mgender varchar(10) not null,
    mphone varchar2(20) primary key,
    memail varchar2(80),
    point number(6) default 0 not null
);

alter table member modify(memail varchar2(80));

create table stock(
    stoname varchar2(50) not null,
    stocount number(4) not null
);

drop table stock;

create table menu(
    menuno number(4) primary key,
    name varchar2(10) not null,
    price number(10) not null,
    check number(1) default 0 not null
);

create table menu(
	menuno number(4) primary key,
	name varchar2(10) not null,
	price number(10) not null,
	check number(4) default 0 not null
);

create table order(
	no number(4) references menu(menuno),
	count number(4) not null,
	sum number(10) not null
);

