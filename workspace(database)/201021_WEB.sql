-- 카테고리 테이블을 만들어 보자
create table category(
    cnum number(5) default '1' not null,
    category_code varchar2(8) not null,
    category_name varchar2(30) not null,
    delete_chk char(1) default 'N' not null,
    primary key(cnum)
);

drop table category purge;

insert into category values(1, '00010000', '전자제품', 'N');

insert into category values(2, '00010001', 'TV', 'N');
insert into category values(3, '00010002', '컴퓨터', 'N');
insert into category values(4, '00010003', 'MP3', 'N');
insert into category values(5, '00010004', '에어컨', 'N');
insert into category values(6, '00020000', '의류', 'N');
insert into category values(7, '00020001', '남방', 'N');
insert into category values(8, '00020003', '속옷', 'N');
insert into category values(9, '0002004', '바지', 'N');
insert into category values(10, '00030000', '도서', 'N');
insert into category values(11, '00030001', '컴퓨터도서', 'N');
insert into category values(12, '00030002', '소설', 'N');

select * from category;

-- 상품 상세 정보 테이블을 만들어 보자

create table products(
    pnum number(11) primary key,
    category_fk varchar2(8) not null,
    products_name varchar2(50) not null,
    ep_code_fk varchar2(5) not null,
    input_price number(10) default 0 not null,
    output_price number(10) default 0 not null,
    trans_cost number(5) default 0 not null,
    mileage number(6) default 0 not null,
    company varchar2(30),
    status char(1) default '1' not null
);

insert into products
    values(1, '00010001', 'S 벽걸이 TV', '00001', 5000000, 8000000, 0, 100000,'삼성','1');
insert into products
    values(2, '00010001', 'D TV', '00002', 300000, 400000, 0, 50000,'대우','1');
insert into products
    values(3, '00010004', 'S 에어컨', '00001', 1000000, 1100000, 5000, 100000,'삼성','2'); 
insert into products
    values(4, '00010000', 'C 밥솥', '00003', 200000, 220000, 5500, 0,'쿠쿠','1');
insert into products
    values(5, '00010004', 'L 에어컨', '00003', 1200000, 1300000, 0, 0,'LG','1');
insert into products
    values(6, '00020001', '남성난방', '00002', 100000, 150000, 2500, 0,'','1');
insert into products
    values(7, '00020001', '여성난방', '00002', 120000, 200000, 0, 0,'','3');
insert into products
    values(8, '00020002', '사각팬티', '00002', 10000, 20000, 0, 0,'보디가드','1');
insert into products
    values(9, '00020003', '멜빵바지', '00002', 15000, 18000, 0, 0,'','1');
insert into products
    values(10, '00030001', '무따기 시리즈', '00001', 25000, 30000, 2000, 0,'길벗','1');

select * from products;

-- [문제1] member10 테이블에서 회원의 이름과 나이 직업을 화면에 보여주세요
select memname, age, job from member10;
-- [문제2] products 테이블에서 제품명, 입고가, 출고가, 제조사를 화면에 보여주세요
select products_name, input_price, output_price, company from products;

-- literal 문자열
-- 컬럼명이나 별칭이 아닌 select 목록에 포함되는 문자, 표현식 숫자를 의미.
-- 날짜나 문자열인 경우 단일 인용부호('')를 사용해야 한다.

-- ex) "KING 사원의 연봉은 60000 입니다."

select ename || '사원의 연봉은' || sal*12 || '입니다.' "사원의 연봉" from emp;

/*
???????
where 조건절

모든 자료를 가져오는 것이 아니라 사용자가 원하는 자료만 조회할 경우 사용

where 절은 from 테이블명 뒤에 기술을 해야 한다

형식) select 컬럼명1, 컬럼명2,... from 테이블이름 where 조건식;

where 조건절 사용 시 자료를 검색할 때 사용되는 연산자

 1) =   : 조건이 같은가?
 2) <   : 조건이 작은가?
 3) <=  : 조건이 작거나 같은가?
 4) >   : 조건이 큰가?
 5) >=  : 조건이 크거나 같은가?
 6) !=  : 조건이 같지 않은가?
 7) <>  : 조건이 같지 않은가? != 같은 의미
 8) between A and B : A와 B 사이에 있는가?
    주의) 작은 값을 앞에 기술하고 큰 값을 뒤에 기술해야 함
 9) in(list) : list 값 중에 어느 하나와 일치하는가?
 10) not between A and B : A와 B 사이에 없는가?
 11) not in(list) : list 값과 일치하지 않는가?
*/

-- emp 테이블에서 담당업무가 manager 인 사원의 모든 내용을 화면에 보여주세요
select * from emp where job = 'MANAGER';

select * from emp where job = 'SALESMAN';

select * from emp;
select * from products;
select * from member10;

-- [문제1] emp 테이블에서 담당업무가 'CLERK'인 
-- 사원의 사번 이름 담당업무 급여를 화면에 보여주세요

select empno, ename, job, sal 
from emp 
where job = 'CLERK';

-- [문제2] emp 테이블에서 1982년 1월 1일 이후에 입사한 
-- 사원의 사번 이름 담당업무 급여 입사일자를 화면에 보여주세요

select empno, ename, job, sal, hiredate 
from emp 
where hiredate > '82/01/01';

-- [문제3] emp 테이블에서 급여가 1300 ~ 1500 사이인 사원의
-- 이름 담당업무 급여 부서번호를 화면에 보여주세요

select ename, job, sal, deptno 
from emp 
where sal between 1300 and 1500;

-- [문제4] emp 테이블에서 사번이 7902, 7788, 7566인 사원의
-- 사번 이름 담당업무를 화면에 보여주세요

select empno, ename, job 
from emp 
where empno in(7902, 7788, 7566);

-- [문제5] emp 테이블에서 보너스가 300이거나 500이거나 1400인 
-- 사원의 모든 정보를 화면에 보여주세요

select * 
from emp 
where comm = 300 or comm = 500 or comm = 1400;

-- [문제6] member10 테이블에서 이름이 홍길동이면서 직업이 학생인
-- 회원의 모든 정보를 화면에 보여주세요

select * 
from member10 
where memname = '홍길동' and job = '학생';

-- [문제7] products 테이블에서 제조사가 '삼성' 또는 '현대' 이면서
-- 입고가가 100만원 이하인 상품의 상품명과 출고가를 화면에 보여주세요

select products_name, output_price 
from products 
where company in('삼성','현대') and input_price <= 1000000;

-- [문제8] emp 테이블에서 급여가 1100 이상이고, 담당업무가 'MANAGER'인
-- 사원의 사번 이름 담당업무 급여를 화면에 보여주세요.

select empno, ename, job, sal 
from emp 
where sal >= 1100 and job = 'MANAGER'; 

-- like 연산자 : 검색하는 연산자

-- where name like '%S%' ==> ename 컬럼에 S자를 포함하는 사원의 이름을 검색
-- where name like '%S' ==> ename 컬럼의 첫 글자가 S자로 시작하는 사원의 이름을 검색
-- where name like 'S%' ==> ename 컬럼의 마지막 글자가 S자로 끝나는 사원의 이름을 검색
-- where name like '_S%' ==> ename 컬럼의 두번째 글자가 S자가 들어가는 사원의 이름을 검색

select ename
from emp
where ename like '__O%';

select * from emp;
select * from products;
select * from member10;

-- [문제1] emp 테이블에서 이름이 'S'자로 끝나는 
-- 사원의 이름 담당업무를 화면에 보여주세요

select ename, job 
from emp
where ename like '%S';

-- [문제2] emp 테이블에서 이름에 세번째에 'R'이 들어가는
-- 사원의 이름과 담당업무 급여를 화면에 보여주세요

select ename, job, sal
from emp
where ename like '__R%';

-- [문제3] emp 테이블에서 이름의 두번째에 'O'가 들어가는
-- 사원의 모든 정보를 화면에 보여주세요

select *
from emp
where ename like '__O%';

-- [문제4] emp 테이블에서 입사년도가 82년도인 사원의
-- 사번 이름 입사일자를 화면에 보여주세요

select empno, ename, hiredate
from emp
where hiredate like '82%';

-- [문제5] member10 테이블에서 성이 김씨인 회원의
-- 모든 정보를 화면에 보여주세요

select *
from member10
where memname like '김%';

-- [문제6] member10 테이블에서 주소에 '서울시'가 포함된
-- 회원의 이름과 주소 직업을 화면에 보여주세요

select memname, addr, job
from member10
where addr like '%서울시%';

/*
order by 
 자료를 정렬하여 나타낼 때 필요한 구문.
 order by 절을 사용할 때는 select 구문의 맨 마지막에 위치
 
 asc : 오름차순 정렬
 desc : 내림차순 정렬
 
 기본적으로 order by 절 사용 시에는 default가 오름차순
 -> 이 경우에는 asc 생략 가능
 
 null 값은 오름차순에서는 제일 나중에 나오고, 내림차순에서는 제일 먼저 나옴.
*/

-- member10 테이블에서 정렬 시 이름을 기준으로 오름차순으로 정렬하여 화면에 보여주세요
-- 단, 이름이 같은 경우 나이를 기준으로 내림차순 정렬하여 화면에 보여주세요

select *
from member10
order by memname asc, age desc;


-- [문제1] emp 테이블에서 부서번호로 오름차순 정렬을 하고, 부서번호가 같은 경우
-- 급여를 기준으로 내림차순 정렬을 하여 화면에 보여주세요

select *
from emp
order by deptno asc, sal desc;

-- [문제2] products 테이블에서 판매가격을 기준으로 내림차순으로 정렬하여
--  모든 정보를 화면에 보여주세요

select *
from products
order by output_price desc;

-- [문제3] products 테이블에서 배송비를 내림차순으로 정렬하시오
-- 단, 배송비가 같은 경우 마일리지를 기준으로 내림차순으로 정렬하여
-- 모든 정보를 화면에 보여주세요

select *
from products
order by trans_cost desc, mileage desc;

-- [문제4] emp 테이블에서 입사일자가 오래된 사원부터 최근에 입사한 사원을
-- 기준으로 정렬하되, 사원명 입사일자를 화면에 보여주세요

select ename, hiredate
from emp
order by hiredate;

-- [문제5] emp 테이블에서 급여를 기준으로 내림차순으로 정렬하여 
-- 모든 정보를 화면에 보여주세요

select *
from emp
order by sal desc;

-- [문제6] emp 테이블에서 급여가 1100 이상인 사원들의 모든 정보를
-- 보여주되, 입사일이 빠른 순으로 모든 정보를 화면에 보여주세요

select *
from emp
where sal >= 1100
order by hiredate;

-- [문제7] emp 테이블에서 부서번호를 기준으로 오름차순 정렬하여 나타내고,
-- 부서번호가 같은 경우 담당업무를 오름차순으로 정렬하세요. 만약 담당업무가 
-- 같다고 한다면, 급여가 많은데서 적은 순으로 정렬하여 모든 정보를 화면에 보여주세요

select *
from emp
order by deptno asc, job asc, sal desc;

/*
not : 부정

 일단은 쿼리문 작성 시 부정이 아닌 긍정의 쿼리문을 작성 후에
 부정의 의미인 not을 붙여주면 딘다.
*/

-- emp 테이블에서 담당업무가 'MANAGE', 'CLERK', 'ANALYST'가
-- 아닌 사원의 사번 이름 담당업무 급여를 화면에 보여주세요

select *
from emp
where job not in('MANAGER', 'CLERK', 'ANALYST');

-- [문제1] emp 테이블에서 이름 'S'자가 들어가지 않는
-- 사원의 이름을 화면에 보여주세요

select ename
from emp
where ename not like '%S%';

-- [문제2] emp 테이블에서 부서번호가 10번 부서가 아닌 사원의
-- 이름 담당업무 부서번호를 화면에 보여주세요

select ename, job, deptno
from emp
where deptno != 10;

-- [문제3] member10 테이블에서 주소가 '서울'이 아닌 회원의
-- 모든 정보를 화면에 보여주세요

select *
from member10
where addr not like '%서울%';

-- [문제4] products 테이블에서 출고가가 100만원 미만이 아닌
-- 제품의 상품명 출고가를 화면에 보여주세요

select products_name, output_price
from products
where output_price >= 1000000;

/*
그룹함수

 여러 행 또는 테이블 전체에 대하여 함수가 적용되어 
 하나의 결과 값을 가져오는 함수
 
 1) avg() : 평균값을 구하는 함수
 2) count() : 행의 갯수를 구하는 함수
              -> null 값은 무시함.
 3) max() : 최댓값을 구하는 함수
 4) min() : 최솟값을 구하는 함수
 5) sum() : 총합을 구하는 함수 
*/

-- emp 테이블에서 사번을 가지고 있는 모든 사원의 수를 화면에 보여주세요

select count(comm)
from emp;

select * 
from emp;

-- [문제1] emp 테이블에서 관리자(mgr)의 수를 
-- 화면에 보여주세요

select count(distinct mgr) "관리자 수"
from emp;

-- [문제2] emp 테이블에서 보너스를 가진 사원의
-- 수를 화면에 보여주세요

select count(comm)
from emp;

-- [문제3] emp 테이블에서 모든 SALESMAN의
-- 급여 평균과 급여 최고액 급여최적액 급여합계액을 
-- 화면에 보여주세요

select avg(sal) "급여 평균", max(sal) "급여 최고액", min(sal) "급여 최저액", sum(sal) "급여 합계액"
from emp
where job = 'SALESMAN';

-- [문제4] emp 테이블에서 등록되어 있는 사원의 총 수,
-- 보너스가 null이 아닌 인원수 보너스의 평균 등록되어 있는
-- 부서의 수를 화면에 보여주세요

select count(*) "사원 총 수", count(comm) "보너스 받는 사원수", avg(comm) "보너스 평균"
from emp;

/*
join ~ on 키워드

 테이블과 테이블을 연결하여 특정한 데이터를 얻고자 할 때 사용함
 두 개 이상의 테이블에 정보가 나뉘어져 있음.
 중복해서 데이터가 저장되는 것을 막기 위함
 
 emp 테이블 부서의 상세정보까지 저장을 한다면 10번 부서에 소속된 
 사원이 3명이므로 부서명과 근무지가 3번 중복되어 저장이 됨
 이렇게 중복되어 저장된 데이터는 추후 삽입, 수정, 삭제 시 이상 현상이 
 발생할 수 있게된다.
 
 이러한 현상이 발생하지 않게 하려면 즉, 데이터가 중복이 되어 저장되지 
 않게 하려면 데이터베이스에서 두 개 이상의 테이블에 정보를 나누어서 저장
 
 하지만 이렇게 두개의 테이블로 나누게 되면 데이터는 중복이 발생하지 않지만 원하는
 정보를 얻으려면 여러 번 질의를 해야 하는 불편함이 발생함
 
 특정 사원이 소속된 부서명을 알아내기 위해 emp 테이블과 dept 테이블을 넘나드는
 작업이 생기므로 상당히 불편하게 됨. 그래서 SQL 에서는 두 개의 테이블을 결합해서
 원하는 결과를 얻어낼 수 있도록 하는 조인이라는 기능을 제공함
 
 조인의 종류
 
 1) Cross Join 
 
    두 개 이상의 테이블이 조인될 때 조건이 없이 테이블의 결합이 이루어지는 조인
    그렇기 때문에 테이블 전체 행의 컬럼이 조인이 된다.
    Cross Join은 사용을 안함
    
 2) Equi Join
    
    가장 많이 사용하는 조인 방법
    
    조인의 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 
    일치되는 행을 연결하여 결과를 생성하는 방법
    
    두 테이블을 조인하려면 일치되는 공통 컬럼을 사용해야 함.
    컬럼의 이름이 같으면 혼동이 오기 때문에 컬럼 이름 앞에 테이블의 이름을 기술해야 함
    
    ex) 
    emp 테이블에서 사원의 사번 이름 담당업무 부서번호 부서명 근무위치를
    화면에 보여주세요 ==> dept 테이블과 조인이 되어야 함
    
    select empno, ename, job, e.deptno, dname, loc
    from emp e join dept d
    on e.deptno = d.deptno;
    
    emp 테이블에서 사원명이 'SCOTT'인 사원의 부서명을 알고싶은 경우
    select ename, dname
    from emp e join dept d
    on e.deptno = d.deptno
    where ename = 'SCOTT';
 
 3) Self Join
 4) Outer Join
*/

-- Equi Join
-- [문제1] 부서명이 'RESEARCH'인 사원의
-- 사번 이름 급여 부서명 근무위치를 화면에 보여주세요

select empno, ename, sal, dname, loc
from emp e join dept d
on e.deptno = d.deptno
where dname = 'RESEARCH';

-- [문제2] emp 테이블에서 'NEWYORK'에 근무하는 사원의
-- 이름과 급여 부서번호를 화면에 보여주세요

select ename, sal, d.deptno
from emp e join dept d
on e.deptno = d.deptno
where loc = 'NEW YORK';

-- [문제3] emp 테이블에서 'ACCOUNTING' 부서 소속 사원의
-- 이름과 담당업무 입사일 부서번호 부서명을 화면에 보여주세요

select ename, job, hiredate, d.deptno, dname
from emp e join dept d
on e.deptno = d.deptno
where dname = 'ACCOUNTING';

-- [문제4] emp 테이블에서 담당업무가 'MANAGER'인 사원의 
-- 이름과 부서명을 화면에 보여주세요

select ename, dname
from emp e join dept d
on e.deptno = d.deptno
where job = 'MANAGER';

commit;
