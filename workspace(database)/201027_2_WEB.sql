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

update memo set title = '메모 2', wirter = '홍' where title = '메모1'; 


insert into menu values(0,'아메리카노(hot)', 4500, 0);
insert into menu values(1,'아메리카노(ice)', 5000, 0);
insert into menu values(2,'카페라떼(hot)', 5000, 0);
insert into menu values(3,'카페라떼(ice)', 5500, 0);
insert into menu values(4,'카페모카(hot)', 5000, 0);
insert into menu values(5,'카페모카(ice)', 5500, 0);
insert into menu values(6,'바닐라라떼(hot)', 5500, 0);
insert into menu values(7,'바닐라라떼(ice)', 6000, 0);
insert into menu values(8,'콜드브루(ice)', 6000, 0);
insert into menu values(9,'민트티(hot)', 4500, 0);
insert into menu values(10,'민트티(ice)', 5000, 0);
insert into menu values(11,'얼그레이티(hot)', 4500, 0);
insert into menu values(12,'버블티(ice)', 5500, 0);
insert into menu values(13,'레몬에이드(ice)', 4500, 0);
insert into menu values(14,'탄산수(ice)', 3500, 0);
insert into menu values(15,'망고스무디(ice)', 5500, 0);
insert into menu values(16,'우유(ice)', 2500, 0);
insert into menu values(17,'치즈케이크', 4500, 0);
insert into menu values(18,'초코케이크', 4500, 0);
insert into menu values(19,'샌드위치', 4500, 0);
insert into menu values(20,'쿠키', 2500, 0);
insert into menu values(21,'도넛', 3500, 0);
insert into menu values(22,'머핀', 3500, 0);
insert into menu values(23,'아이스크림', 2500, 0);
insert into menu values(24,'샐러드', 5500, 0);















