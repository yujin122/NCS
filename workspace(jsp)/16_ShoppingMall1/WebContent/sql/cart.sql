create table cart(
	cart_num number(8) primary key,			-- 카드 번호
	cart_pnum number(8) not null,			-- 상품 일련 번호
	cart_pname varchar2(100) not null,		-- 상품 이름
	cart_pqty number(8) not null,			-- 상품 수량
	cart_price number(8) not null,			-- 상품 단가
	cart_pspec varchar2(20) not null,		-- 상품 스펙
	cart_pimage varchar2(500) 				-- 상품 이미지
);

create sequence cart_seq
start with 1
increment by 1
nocache;

