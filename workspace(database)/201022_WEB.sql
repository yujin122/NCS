/*
 3) Self Join
 
    하나의 테이블 내에서 조인을 해야 자료를 얻을 수 있는데 
    말 그대로 자기 자신 테이블과 조인을 맺는 것을 말함.
    
    from 절 다음에 테이블 이름을 나란히 두 번 기술할 수 없음
    따라서 같은 테이블이 하나 더 존재하는 것처럼 사용할 수 있도록
    테이블에 별칭을 붙여서 사용해야 함.
    
    ex)
    emp 테이블에서 각 사원별 관리자의 이름을 화면에 출력해보자
    select e.ename || '의 매니저 이름은 ' || em.ename || '입니다.'
    from emp e join emp em
    on e.mgr = em.empno;
    
    select e.ename || '의 매니저 이름은 ' || em.ename || '입니다.'
    from emp e, emp em
    where e.mgr = em.empno;
    
 4) Outer Join
 
    2개 이상의 테이블이 조인될 때 어느 한 쪽 테이블에 해당하는 
    데이터가 존재하는데 다른쪽 테이블에는 데이터가 존재하지 않는 경우
    그 데이터가 출력되지 않는 문제점을 해결하기 위해 사용되는 조인 기법
    
    정보가 부족한 테이블의 컬럼 뒤에 '(+)'기호를 붙여서 사용을 함.
    
    ex)
    select e.ename || '의 매니저 이름은 ' || em.ename || '입니다.'
    from emp e, emp em
    where e.mgr = em.empno(+);
*/

-- self join

-- emp 테이블에서 매니저가 'KING'인 사원들의
-- 이름과 담당업무를 화면에 보여주세요
select e.ename, e.job
from emp e, emp em
where em.ename = 'KING' and e.mgr = em.empno;

select e.ename || '의 매니저 이름은 ' || em.ename || '입니다.'
from emp e, emp em
where e.mgr = em.empno(+);

-- outer join
select ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno
order by deptno;

/*
시퀀스(sequence)

 순번을 부여할 때 사용하는 문법

 형식) create sequence 시퀀스이름 
      start with 1
      increment by 1;
*/

create table memo(
    num number(5) primary key,
    title varchar2(100) not null,
    wirter varchar2(20) not null,
    content varchar2(1000) not null,
    regdate date
);

-- 메모 시퀀스 만들기
create sequence memo_seq
start with 1
increment by 1;

insert into memo 
values(memo_seq.nextval, '메모1', '홍길동', '길똥이글',sysdate);

insert into memo 
values(memo_seq.nextval, '메모2', '유관순', '유관순님 글',sysdate);
insert into memo 
values(memo_seq.nextval, '메모3', '김유신', '유신님 글',sysdate);
insert into memo 
values(memo_seq.nextval, '메모4', '김연아', '연아 언니 글',sysdate);
insert into memo 
values(memo_seq.nextval, '메모5', '이순신', '장군님 글',sysdate);

select * from memo;

/*
dual 테이블

 오라클에서 자체적으로 제공해 주는 테이블
 
 간단하게 함수를 이용해서 계산, 결과값을 확인할 때 사용하는 테이블.
 
 오직 한 행, 한 컬럼 만을 담고 있는 테이블
 
 사용 용도 : 특정 테이블을 생성할 필요 없이 함수 또는 계산을 하고 싶은 경우에 사용
 
 오라클에서 제공해 주는 함수들
 
 1. 날짜와 관련된 함수들
    1) 현재 시스템의 날짜를 구해 오는 함수 : sysdate
       select sysdate from dual;
    2) 현재 날짜에서 개월 수를 더해 주는 함수 : add_months(현재날짜, 숫자(개월수))
       select add_months(sysdate,5) from dual;
    3) 다가올 날짜(요일)를 구해 주는 함수 : next_day()
       select next_day(sysdate, '목요일') from dual;
    4) 해당 달의 마지막 날을 알려주는 함수 : last_day()
       select last_day(sysdate) from dual;
    5) 형식에 맞게 문자열로 날짜를 출력하는 함수 : to_char(날짜, '날짜형식')
       select to_char(sysdate, 'yyyy"년" mm"월" dd"일"') from dual;
       
 2. 문자와 관련된 함수들
    1) 문자열을 연결하는 함수 : concat('문자열1', '문자열2');
       문자열을 연결하는 연산자 : ||
       select concat('안녕', '하세요') from dual;
    2) 소문자를 대문자로 바꾸어 주는 함수 : upper()
       대문자를 소문자로 바꾸어 주는 함수 : lower()
    3) 문자열을 x부터 y의 길이만큼 추출해 내는 함수 : substr('문자열', x, y)
       x 값이 음수인 경우에는 오른쪽부터 시작된다.
       select substr('ABCDEFG',3,2) from dual;
    4) 자릿수를 늘려주는 함수
    
       왼쪽 자릿수를 눌려주는 함수 : lpad('문자열', 전체자릿수, '늘어난 자릿수에 들어갈 문자열');
       오른쪽 자릿수를 늘려주는 함수 : rpad('문자열', 전체자릿수, '늘어난 자릿수에 들어갈 문자열');
       
       주의) 한글은 2바이트씩 계산이 되어 처리
       select lpad('ABCDEFG', 15, '*') from dual;
       select rpad('ABCDEFG', 15, '*') from dual;
    5) 문자를 지워주는 함수
       왼쪽 문자를 지워주는 함수 : ltrim()
       오른쪽 문자를 지워주는 함수 : rtrim()
       select ltrim('ABCDEFG', 'A') from dual;
       select rtrim('ABCDEFG', 'G') from dual;
    6) 문자열을 교체해 주는 함수 : replace('원본 문자열', '교체된 문자열', '교체문자열')
       select replace('Java Program', 'Java', 'JSP') from dual;

 3. 숫자와 관련된 함수들
    1) 절대값을 구하는 함수 : abs()
    2) 양수(1), 음수(-1), 0을 반환해 주는 함수 : sign()
    3) 반올림을 해 주는 함수 : round()
    4) 소숫점 이하 자릿수를 잘라내는 함수 : trunc()
    5) 무조건 올림을 해 주는 함수 : ceil()
    6) 제곱을 구하는 함수 : power()
    7) 나머지를 구하는 함수 : mod()
    8) 제곱근을 구하는 함수 : sqrt()
*/

-- 2-2

-- [문제1] emp 테이블에서 결과가 아래와 같이 나오도록 화면에 보여주세요
-- 결과 : "SCOTT의 담당업무는 ANALYST 입니다."
-- 단, concat() 함수를 이용하세요.

select concat(concat(ename, '의 담당업무는 '), concat(job, '입니다.')) from emp where ename = 'SCOTT';

-- [문제2] 결과 : "SCOTT의 연봉은 36000 입니다."
-- 단, concat() 함수를 이용하세요.

select concat(concat(ename, '의 연봉은 '), concat(sal, '입니다.')) from emp where ename = 'SCOTT';

-- [문제3] member10 테이블에서 결과가 아래와 같이 나오도록 화면에 보여주세요
-- 결과 : "홍길동 회원의 직업은 학생입니다."
-- 단, concat() 함수를 이용하세요.

select concat(concat(memname, ' 회원의 직업은 '), concat(job, '입니다.')) from member10 where memname = '홍길동' and job = '학생';

-- [문제4] emp 테이블에서 사번 이름 담당업무를 화면에 보여주세요
-- 단, 담당업무는 소문자로 변경하여 화면에 보여주세요

select empno, ename, lower(job) from emp;

-- 2-3

-- [문제1] 여러분의 주민등록번호 중에서 생년월일을 추출하여 화면에 보여주세요

-- 2-6

-- [문제1] emp 테이블에서 담당업무에 'A'라는 글자를 
-- '$'로 바꾸어 화면에 출력해 보세요

select replace(job, 'A', '$') from emp;

-- [문제2] member10 테이블에서 직업이 '학생'인 정보를
-- '대학생'으로 바꾸어 화면에 출력해 보세요

select replace(job, '학생', '대학생') from member10;

-- [문제3] member10 테이블에서 주소에 '서울시'를
-- '서울특별시'로 바꾸어 화면에 출력해 보세요

select replace(addr, '서울시', '서울특별시') from member10;

/*
서브 쿼리
 
 하나의 쿼리문 안에 포함되어 있는 또 하나의 쿼리문을 말함.
 쿼리문 안에 또 다른 쿼리문이 존재하는 쿼리문
 
 서브쿼리는 메인 쿼리가 서브쿼리를 포함하는 종속적인 관계임.
 
 여러 번 쿼리를 실행해서 얻을 수 있는 결과를 하나의 중첩된
 쿼리문장으로 간편하게 결과를 얻을 수 있다.

 주의사항
 1. 서브쿼리는 괄호로 묶어서 사용
 2. 서브쿼리 안에서 order by 절은 사용할 수 없다.
 3. 연산자 오른쪽에 사용해야 한다.
 
 사용방법 : 우선은 안쪽에 있는 쿼리문을 실행 후, 그 결과값을 가지고 바깥쪽 쿼리문을 실행
 
 ex) 
 emp 테이블에서 이름이 'SCOTT'인 사원의 급여보다 더 많은 급여를 받는 사원의
 사번 이름 담당업무 급여를 화면에 출력하세요
 
 select empno, ename, job, sal
 from emp
 where sal > (select sal from emp where ename = 'SCOTT')
*/
select * from emp;

select empno, ename, job, sal
from emp
where sal > (select sal from emp where ename = 'SCOTT');

-- [문제1] emp 테이블에서 평균급여보다 적게 받는 사원의 
-- 사번 이름 담당업무 급여 부서번호를 화면에 보여주세요

select empno, ename, job, sal, deptno
from emp
where sal < (select avg(sal) from emp);

-- [문제2] emp 테이블에서 사번이 7521인 사원과 담당업무가 같고 
-- 급여가 7934인 사원보다 많이 받는 사원의 사번 이름 담당업무 급여를
-- 화면에 보여주세요

select empno, ename, job, sal
from emp
where job = (select job from emp where empno = 7521)
and sal  > (select sal from emp where empno = 7934);

-- [문제3] emp 테이블에서 담당업무가 'MANAGER'인 사원의 최소급여보다
-- 적으면서, 담당업무가 'CLERK'은 아닌 사원의 사번 이름 담당업무 급여

select empno, ename, job, sal
from emp
where sal < (select min(sal) from emp where job = 'MANAGER')
and job != 'CLERK';

-- [문제4] 부서위치가 'DALLAS'인 사원의 사번 이름 부서번호 담당업무

select empno, ename, d.deptno, job
from emp e join dept d
on e.deptno = d.deptno
where loc = 'DALLAS';

select empno, ename, deptno, job
from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

-- [문제5] member10 테이블에 있는 고객의 정보 중 마일리지가 가장 높은
-- 고객의 모든 정보

select * from member10;
select *
from member10
where mileage = (select max(mileage) from member10);

-- [문제6] emp 테이블에서 'SMITH'인 사원보다 더 많은 급여를 받는
-- 사원의 이름과 급여

select ename, sal
from emp
where sal > (select sal from emp where ename = 'SMITH');

-- [문제7] emp 테이블에서 10번 부서 급여의 평균급여보다 적은 급여를 받는
-- 사원들의 이름 급여 부서번호

select ename, sal, deptno
from emp
where sal < (select avg(sal) from emp where deptno = 10);

-- [문제8] emp 테이블에서 'BLAKE'와 같은 부서에 있는 사원들의 
-- 이름 입사일자

select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename = 'BLAKE')
and ename<>'BLAKE';

-- [문제9] emp 테이블에서 평균급여보다 더 많이 받는 사원들의 사번,
-- 이름 급여

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);

-- [문제10] emp 테이블에서 이름에 'T'를 포함하고 있는 사원들과 같은 부서에
-- 근무하고 있는 사원의 사번과 이름

select empno, ename
from emp
where deptno in(select deptno from emp where ename like '%T%');

-- [문제11] 'SALES' 부서에서 근무하고 있는 사원들의 부서번호 이름 담당업무

select empno, ename, job
from emp e join dept d
on e.deptno = d.deptno
where dname = 'SALES';

-- [문제12] emp 테이블에서 'KING'에게 보고하는 모든 사원의 
-- 이름 급여 관리자

select ename, sal, mgr
from emp
where mgr in(select mgr from emp
where mgr = (select empno from emp where ename = 'KING'));

-- [문제13] emp 테이블에서 자신의 급여가 평균급여보다 많고, 이름에
-- 'S'자가 들어가는 사원과 동일한 부서에서 근무하는 모든 사원의 사번
-- 이름 급여

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp) 
and deptno in(select deptno from emp where ename like '%S%');

-- [문제14] emp 테이블에서 보너스를 받는 사원과 부서번호 급여가 같은
-- 사원의 이름 급여 부서번호를 화면에 보여주세요

select ename, sal, deptno
from emp
where deptno in(select deptno from emp 
where comm > 0) and
sal in(select sal from emp 
where comm > 0);

-- [문제15] products 테이블에서 상품의 판매가격이 판매가격의
-- 평균보다 큰 상품의 전체 내용

select *
from products
where output_price > (select avg(output_price) from products);

-- [문제16] products 테이블에 있는 판매가격에서 평균가격 이상의
-- 상품목록을 구하되, 평균을 구할 때 가격이 가장 큰 금액인 상품을 제외하고
-- 평균을 구하여 화면에 보여주세요

select products_name
from products
where output_price >= (select avg(output_price) from products 
where output_price <> (select max(output_price) from products));

-- [문제17] products 테이블에서 카테고리의 이름에 '에어컨'이라는
-- 단어가 포함된 카테고리에 속하는 상품목록을 화면에 보여주세요

select products_name
from products p join category c
on c.category_code = p.category_fk
where category_name like '%에어컨%';

select products_name
from products
where category_fk = (select category_code from category 
where category_name like '%에어컨%');

-- [문제18] member10 테이블에 있는 고객정보 중 마일리지가 가장 높은 금액을
-- 가지는 고객에게 보너스 마일리지 5000점을 더 주어 고객명 마일리지
-- 마일리지+5000점을 화면

select memname, mileage, mileage+5000 "추가 마일리지"
from member10
where mileage = (select max(mileage) from member10);

/*
group by 절

보통은 특정 컬럼을 기준으로 집계를 구하는데 많이 사용됌

보통은 그룹함수와 함께 사용하면 효과적으로 활용이 가능
*/

select deptno from emp order by deptno;

select deptno
from emp
group by deptno;

-- emp 테이블에서 부서별로 각 부서의 인원을 확인하고 싶은 경우
select deptno, count(*)
from emp
group by deptno
order by deptno desc;

-- emp 테이블에서 부서별로 급여의 합계를 화면에 출력
select deptno, sum(sal) "급여합계"
from emp
group by deptno
order by sum(sal);

-- [문제] emp 테이블에서 부서별로 그룹을 지어서 부서의 급여 합계와
-- 부서별 인원 수, 부서별 평균 급여, 부서별 최대 급여, 부서별 최소 급여를
-- 구하여 화면에 보여주세요
-- 단, 급여 합계를 기준으로 내림차순으로 정렬하여 화면에 보여주세요

select deptno, count(*) "인원수", avg(sal) "평균 급여", max(sal) "최대 급여", min(sal) "최소 급여"
from emp
group by deptno
order by sum(sal) desc;

/*
having 절

 group by 절 다음에 오는 조건절로 group by 절의 결과에 조건을 주어서
 제한을 할 때 사용을 한다.
 
 group by 절에는 where 절이 올 수 없다.
*/

-- products 테이블에서 카테고리 별로 상품의 갯수를 화면에 보여주세요

select category_fk, count(*)
from products
group by category_fk
having count(*) >= 2
order by category_fk;

-- [문제1] member10 테이블에서 직업의 종류와 해당 직업에 속한
-- 최소 마일리지를 보여주되, 마일리지가 0인 경우는 제외하고
-- 화면에 보여주세요

select job, min(mileage)
from member10
group by job
having min(mileage) <> 0;

-- [문제2] member10 테이블에서 직업의 종류와 직업에 속한 회원 수를
-- 보여주되, 회원 수가 2명 이상인 직업군의 정보를 화면에 보여주세요

select job, count(*)
from member10
group by job
having count(*) >= 2;

-- [문제3] emp 테이블에서 부서번호와 그 부서에 속한 인원을 화면에 보여주되,
-- 해당 부서에 속한 인원이 4명 이상인 부서만 화면에 보여주세요

select deptno, count(*)
from emp
group by deptno
having count(*) >= 4;

-- [문제4] emp 테이블에서 담당업무별 급여 총액을 화면에 보여주되
-- 급여 총액이 5000 이상인 담당업무만 화면에 보여주세요
-- 조건1) 담당업무가 'SALSEMAN'은 제외하고 급여 총액을 화면에 보여줄 것
-- 조건2) 급여총액은 내림차순으로 정렬하여 보여줄 것

select deptno, sum(sal)
from emp
where job <> 'SALESMAN'
group by deptno
having sum(sal) >= 5000
order by sum(sal) desc;

commit;