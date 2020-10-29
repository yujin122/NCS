create table menu(
	menuno number(4) primary key,
    name varchar2(10) not null,
    price number(10) not null,
    mcheck number(4) default 0 not null
);

create table orderlist(
	no number(4) references menu(menuno),
	count number(4) not null,
	sum number(10) not null
);

drop table menu;
drop table orderlist;


create table member20(
	name varchar2(20) primary key,
	age number(3) not null,
	wieght number(3) not null,
	height number(3) not null,
	gender varchar(10) not null
);

create table menu(
	menuno number(4) primary key,
	name varchar2(20) not null,
	price number(10) not null,
	checknum number(4) default 0 not null
);

create table cafeorder(
	menunumber number(4) references menu(menuno),
	count number(4) not null,
	sumprice number(10) not null
);

create table testdd(
    ndd number(8)
);

drop table testdd;
insert into testdd values(9701222156217);

create table mgr(
    mgname varchar2(30) not null,
    mgrnumber varchar2(13) not null,
    mggender varchar(10) not null,
    mgid varchar2(20) primary key,
    mgpw varchar2(20) not null,
    mgphone varchar2(20) not null,
    mgemail varchar2(80) not null,
    redate date not null
);

update memo set title = '�޸� 2', wirter = 'ȫ' where title = '�޸�1'; 


insert into menu values(0,'�Ƹ޸�ī��(hot)', 4500, 0);
insert into menu values(1,'�Ƹ޸�ī��(ice)', 5000, 0);
insert into menu values(2,'ī���(hot)', 5000, 0);
insert into menu values(3,'ī���(ice)', 5500, 0);
insert into menu values(4,'ī���ī(hot)', 5000, 0);
insert into menu values(5,'ī���ī(ice)', 5500, 0);
insert into menu values(6,'�ٴҶ��(hot)', 5500, 0);
insert into menu values(7,'�ٴҶ��(ice)', 6000, 0);
insert into menu values(8,'�ݵ���(ice)', 6000, 0);
insert into menu values(9,'��ƮƼ(hot)', 4500, 0);
insert into menu values(10,'��ƮƼ(ice)', 5000, 0);
insert into menu values(11,'��׷���Ƽ(hot)', 4500, 0);
insert into menu values(12,'����Ƽ(ice)', 5500, 0);
insert into menu values(13,'�����̵�(ice)', 4500, 0);
insert into menu values(14,'ź���(ice)', 3500, 0);
insert into menu values(15,'��������(ice)', 5500, 0);
insert into menu values(16,'����(ice)', 2500, 0);
insert into menu values(17,'ġ������ũ', 4500, 0);
insert into menu values(18,'��������ũ', 4500, 0);
insert into menu values(19,'������ġ', 4500, 0);
insert into menu values(20,'��Ű', 2500, 0);
insert into menu values(21,'����', 3500, 0);
insert into menu values(22,'����', 3500, 0);
insert into menu values(23,'���̽�ũ��', 2500, 0);
insert into menu values(24,'������', 5500, 0);















