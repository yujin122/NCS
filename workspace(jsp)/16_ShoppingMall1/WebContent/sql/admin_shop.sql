create table admin_shop(
	admin_id varchar2(20) primary key,
	admin_pwd varchar2(20) not null,
	admin_name varchar2(20) not null,
	admin_email varchar2(100) not null,
	admin_regdate date
);

insert into admin_shop
	values('admin', 'admin', '관리자1', 'admin@naver.com', sysdate);