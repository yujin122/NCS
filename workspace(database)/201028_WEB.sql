delete from cafeorder;
select name, price, count, sumprice, orderdate from menu m join cafeorder c on m.menuno = c.menunumber order by orderdate;

alter table menu drop column checknum; 

alter table cafeorder add(orderdate date);

commit;

select count(*) from cafeorder;
select * from member;

select name, point from member where mphone = '010-7196-7599';

drop table mgr;

create table mgr(

    mgname varchar2(30) not null,
    mgrnumber varchar2(20) not null,
    mggender varchar(10) not null,
    mgid varchar2(20) primary key,
    mgpw varchar2(20) not null,
    mgphone varchar2(20) not null,
    mgemail varchar2(80) not null,
    redate date not null
    );

insert into mgr
    values('고길동', '860618-1687255', '남', 'dong86', '1111', '010-6580-7156', 'dong86@naver.com',sysdate);
insert into mgr
    values('김영희', '930728-2037220', '여', 'yonghee07', '2222', '010-7458-7235', 'dong86@naver.com',sysdate);
insert into mgr
    values('김철수', '000628-3287718', '남', 'ironwater00', '3333', '010-3562-7877', 'dong86@naver.com',sysdate);
insert into mgr
    values('이준영', '971212-1687565', '남', 'junyoung16', '4444', '010-6580-7156', 'dong86@naver.com',sysdate);    
insert into mgr
    values('신지은', '010105-4018210', '여', 'jieun0101', '5555', '010-6580-7156', 'dong86@naver.com',sysdate);    
insert into mgr
    values('이지연', '951023-2667285', '여', 'yeon12', '6666', '010-6580-7156', 'dong86@naver.com',sysdate);    