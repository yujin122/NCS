-- sql developer tool에서의 주석문

/*
오라클에서 DB의 테이블에 들어가는 주요 자료형(data type) - 교재 p.99

 1. number(n,n1) : - n : 전체 자릿수
                  - n1 : 소숫점 자릿수
                  - n - n1 : 정수 자릿수
    ex) number(7,2) : 전체 자릿수는 7, 소숫점 자릿수는 2, 정수 자릿수 5

 2. char(n) : 문자열이 n개가 저장되는 자료형 ==> 고정 자료형

 3. varchar(n) : 문자열이 n개가 저장되는 자료형 ==> 현재 사용하지 않는 자료형

 4. varchar2(n) : 문자열이 n개가 저장되는 자료형 ==> 가변 자료형
                  한글은 무조건 한 글자당 2byte씩 소모.
 
 5. data : 날짜가 저장되는 자료형 ==> 시스템의 현재 날짜 및 시간이 저장
*/

/*
 무결성(Integrity) : 데이터베이스에 저장된 데이터 값과 그것이 표현하는 현실 세계의
                    실제 값이 일치하는 정확성을 의미함.
                    
 무결성 제약조건 : 데이터베이스에 저장된 데이터의 정확성을 보장하기 위해서 정확하지
                않는 데이터가 데이터베이스 내에 저장되는 것을 방지하기 위한 조건.
                
 데이터베이스 상의 제약 조건 종류
 
 1. unique 제약 조건 : 중복이 되면 안되는 조건.
 
 2. not null 제약 조건 : 공백을 허용하지 않는 조건.
 
 3. check 제약 조건 : 특정한 값이 아닌 데이터가 들어오지 못하게 하는 조건.
 
 4. primary key 제약 조건 : unique + not null 제약 조건.
    
    기본키는 해당 테이블을 대표하는 컬럼으로서의 역할을 수행하며, 다른 테이블에서
    외래키들이 참조할 수 있는 키로서의 자격을 가진다. 이를 참조 무결성이라고 함.
*/

/*
 학생 테이블을 만들어 보자

 컬럼 : 학번, 이름, 학과, 학년, 나이, 연락처, 주소, 등록일(입학일) 등등 

 형식) create table 테이블이름(
        학번 자료형(크기) (제약조건),
        이름 자료형(크기) (제약조건),
        학과 자료형(크기) (제약조건),
        ...
 );

*/

create table student(
    id number(10) primary key,
    name varchar2(20) not null,
    major varchar2(20) not null,
    grade number(1),
    age number(3),
    phone varchar2(20) not null,
    regdate date
);

-- 테이블에 컬럼을 추가
-- 형식) alter table 테이블이름 add(컬럼명 데이터타입(크기) 제약조건);

-- student 테이블에서 누락된 주소 컬럼을 추가해보자.

alter table student add(addr varchar2(200));

-- 테이블의 컬럼을 수정(자료형 수정)
-- 형식) alter table 테이블이름 modify(컬럼명 데이터타입(크기));

alter table student modify(age varchar2(3));

-- 테이블의 컬럼을 삭제
-- 형식) alter table 테이블이름 drop column 컬럼명;

alter table student drop column age;

alter table student add(age number(3));

-- student 테이블에 데이터를 추가해 보자

/*
 형식1) insert into 테이블이름 values(학번, '이름', '학과', 
            학년, '번호', '등록일(sysdate)', '주소', 나이);           
 형식2) insert into 테이블이름(학번 컬럼명,이름 컬럼명,학과 컬럼명,번호 컬럼명)
                    values(학번, 이름, 학과, 번호);
            
*/

insert into student 
values(20201020, '홍길동', '컴퓨터공학', 3, '010-7154-8652', sysdate, '서울시 마포구', 25);

insert into student(id, name, major,phone) 
values(20201546, '유관순', '국문과', '010-2343-8470');

insert into student 
values(20205432, '이순신', '해양학과', 2, '010-6587-4251', sysdate, '인천시 부평구', 23);

insert into student(id, name, major,phone) 
values(20203521, '김연아', '사체과', '010-3645-9465');

insert into student 
values(20208456, '김유신', '경영학과', 4, '010-3147-4682', sysdate, '서울시 동대문구', 26);

insert into student(id, name, major,phone,addr) 
values(20208456, '김유신', '경영학과', '010-3147-4682', '서울시 동대문구');


select * from student;

desc student;

select * from emp;

select empno, ename, job, deptno from emp;

-- [문제] emp 테이블에서 이름, 입사일, 급여를 화면에 보여주세요
select ename, hiredate, sal from emp;

-- [문제] emp 테이블에서 사번, 이름, 담당업무, 보너스를 화면에 보여주세요
select empno, ename, job, comm from emp;

-- student 테이블의 특정 컬럼을 수정해 보자
-- 형식) update 테이블이름 set 컬럼이름 = 컬럼수정내용 where primary key로 되어 있는 컬럼명 = 컬럼데이터;

update student set grade = 2, regdate = sysdate, age = 21, addr = '서울시 중구' where id = 20201546;
update student set grade = 3, regdate = sysdate, age = 20, addr = '서울시 서대문구' where id = 20203521;

select * from student;

-- student 테이블의 특정 컬럼을 삭제해 보자
-- 형식) delete from 테이블이름 where 기본키로 설정된 컬럼명 = 컬럼 데이터;
delete from student where id = 20208456;
delete from student where id = 20208456;
-- DB에 완벽하게 적용시키고자 할 때는 commit 키워드 사용

-- emp 테이블에서 사번, 이름, 급여, 보너스, 급여+보너스 를 화면에 보여주세요
select empno, ename, sal, comm, sal+comm from emp;

-- null 값을 갖는 컬럼을 다른 컬럼과 연산을 하게 되면 모두 null 값으로 처리

-- nvl() 함수 : null 값을 특정한 값으로 변경하는 함수
--             모든 데이터 타입에 적용이 가능하다.
--             nvl() 함수를 사용할 때는 전환되는 값의 자료형을 일치시켜야 한다.
-- 형식) nvl(null 값이 들어 있는 컬럼명, 변경할 값)

select empno, ename, sal, nvl(comm,0), sal+nvl(comm,0) from emp;

-- nvl2() 함수 : 자바에서의 삼항연산자와 비슷한 함수.
-- 형식) nvl2(컬럼명, expr1, expr2)

-- 컬럼명의 값이 null이 아닌 경우에는 expr1 값을 반환하고,
-- 컬럼명의 값이 null인 경우에는 expr2 값을 반환하는 함수.

-- as : 컬럼 제목에 이름을 변경하는 키워드 ==> 별칭(별명)
--      컬럼명 바로 뒤에 사용

select empno, ename, sal, comm, sal+nvl2(comm, comm, 0) as total from emp;
select empno, ename, sal, comm, sal+nvl2(comm, comm, 0) total from emp;

-- [문제] emp 테이블에서 사번, 사원명, 급여, 급여의 10% 인상액을 화면에 보여주세요

select empno, ename, sal, sal*1.1 "10% 인상 급여" from emp;

-- emp 테이블에서 각 사원의 담당업무(job)를 화면에 보여주세요

select job from emp;

/*
 distinct 키워드 : 중복을 제거하는 키워드
                  주로 하나의 컬럼에서 중복된 값을 제거하고 보여줄 때 사용함
                  distinct 키워드는 항상 select 키워드 다음에 기술
                  distinct 키워드 뒤에 나오는 컬럼들은 모두 distinct 영향을 받는다.
*/

select distinct job from emp;

-- 문제 emp 테이블에서 담당업무와 부서번호의 중복을 제거한 후 화면에 보여주세요
select distinct job, deptno from emp;

-- member 라는 테이블을 만들어 보자

create table member10(
    num number(7) primary key,
    memid varchar(20) not null,
    memname varchar2(20) not null,
    pwd varchar2(20) not null,
    age number(3),
    mileage number(8) not null,
    job varchar2(30),
    addr varchar2(200),
    regdate date not null
);

-- member10 테이블에 고객 정보를 저장해 보자
insert into member10 
values(1,'id1', '홍길동', '1111', 25, 0, '학생', '부산시 동래구', '2013-08-08');

insert into member10 
values(2,'id2', '김길동', '2222', 30, 1500, '직장인', '서울시 강남구', '2013-09-05');

insert into member10 
values(3,'id3', '공성현', '3333', 33, 10000, '직장인', '부산시 중구', '2013-09-09');

insert into member10 
values(4,'id4', '김영희', '4444', 18, 3000, '학생', '경상남도 미산시', '2012-01-01');

insert into member10 
values(5,'id5', '박말자', '5555', 45, 5000, '주부', '경기도 남양주시', '2013-05-05');

insert into member10 
values(6,'id6', '김철수', '6666', 55, 0, '교수', '제주도 서귀포시', '2013-08-08');

insert into member10 
values(7,'id7', '홍길동', '7777', 14, 6000, '학생', '경상북도 경주시', '2012-12-25');

insert into member10 
values(8,'id8', '김상현', '8888', 31, 0, '무직', '서울시 마포구', '2013-04-18');

insert into member10 
values(9,'id9', '이지연', '9999', 25, 0, '학생', '강원도 강릉시', '2013-02-06');

insert into member10 
values(10,'id10', '홍길동', '0000', 52, 10000, '주부', '서울시 강북구', '2013-09-15');

select * from member10;

commit;