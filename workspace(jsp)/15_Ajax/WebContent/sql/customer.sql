create table customer(
	no number(5) unique,
	id varchar2(20) primary key,
	name varchar2(20) not null,
	age number(3),
	tel varchar2(20),
	addr varchar2(200)
);

-- 고객 번호 시퀀스 생성
create sequence customer_seq
start with 1
increament by 1
nocache;

-- 고객 정보 저장
insert into customer
	values(customer_seq.nextval, 'hong', '홍길동', 27, '010-1111-1234', '서울시 마포구');
insert into customer
	values(customer_seq.nextval, 'leess', '이순신', 31, '010-2222-2345', '전라남도 신안군');
insert into customer
	values(customer_seq.nextval, 'yooks', '유관순', 19, '010-3333-3456', '충청남도 천안군');