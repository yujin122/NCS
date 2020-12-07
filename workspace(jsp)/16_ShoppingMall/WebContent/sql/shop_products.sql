create table shop_products(
	pnum number(8) primary key,				-- 상품 번호
	pname varchar2(50) not null,			-- 상품명
	pcategory_fk varchar2(20) not null,		-- 카테고리 코드
	pcompany varchar2(50),					-- 상품 제조사
	pimage varchar2(50),					-- 상품 이미지
	pqty number(8) default 0,				-- 상품 수량
	price number(8) default 0,				-- 상품 가격
	pspec varchar2(20),						-- 상품 스펙
	pcontents varchar2(2000),				-- 상품 설명
	point number(8) default 0,				-- 상품 포인트
	pinputdate date							-- 상품 입고일
);

