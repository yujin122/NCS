/*
View 

 물리적인 테이블에 근거한 논리적인 가상의 테이블을 말함
 View는 실질적으로 데이터를 저장하고 있지 않음
 View를 만들면 데이터베이스에 질의 시 실제 테이블에 접근하여 데이터를 불러오게 됨
 간단하게 말하면 필요한 내용들만 추출해서 사용하는 것
 주로 데이터를 조회할 때 가장 많이 사용됨
 View는 테이블과 유사하며 테이블처럼 사용이 가능함
 View는 테이블에 저장하기 위한 물리적인 공간이 필요가 없음
 테이블과 마찬가지로 select, insert, update, delete 명령이 가능함
 
 View 사용 이유
 1) 보안 관리를 위해 사용함(중요)
    보안 등급에 맞추어 컬럼의 범위를 정해서 조회가 가능하도록 할 수 있음
 
 2) 사용자의 편의성을 위해 사용함
    ==> 검색 조건을 단순화하여 사용할 수 있도록 함
    
 형식) create view 뷰이름
      as
      서브쿼리
*/

create view emp_view
as
select * from emp;

-- 인사부 뷰
-- 컬럼에 sal, comm 제외

create view emp_insa
as
select empno, ename, job, mgr, hiredate, deptno 
from emp;

select *
from emp_insa;

-- 영업부 뷰
-- 컬럼에 sal 제외
-- 경쟁심을 유발시키기 위해서 comm컬럼은 조회할 수 있게 해야함
create view emp_sales
as
select empno, ename, job, mgr, hiredate, comm, deptno
from emp;

select *
from emp_sales;

-- 회계부 뷰
-- 모든 컬럼이 다 보여지게 만들 것

create view emp_account
as
select * from emp;

-- emp_view View에 데이터를 추가해 보자
insert into emp_view
values(9000, 'ANGEL', 'SALSEMAN', 7698, sysdate, 1500, 200, 30);

select * from emp_view;

-- 읽기 전용 View로 만들면 insert, update, delete 가 안 됨

-- 읽기 전용 View로 만드는 방법 : 쿼리문 맨 마지막에 with read only; 작성

create view emp_view1
as
select * from emp
with read only;

insert into emp_view1
values(9000, 'ANGEL', 'SALSEMAN', 7698, sysdate, 1500, 200, 30);

-- 부서별로 부서별 급여합계, 부서별 급여평균을 구한
-- View를 만들어서 화면에 보여주세요

-- View를 만들 때 그룹함수를 사용 시 반드시 별칭을 설정을 해 주어야 함
create view emp_sal
as 
select deptno, sum(sal) "급여합계", avg(sal) "급여평균"
from emp
group by deptno;

select * from emp_sal;

-- [문제1] emp 테이블을 이용하여 emp_dept20 이라는 View를 만들어 보세요
-- 단, 부서번호가 20번 부서에 속한 사원들의 사번, 이름, 담당업무, 관리자,
-- 부서번호만 보여주시기 바랍니다.

create view emp_dept20
as
select empno, ename, job, mgr, deptno
from emp
where deptno = 20;

select * from emp_dept20;

-- [문제2] emp 테이블에서 각 부서별 최대급여와 최소급여를 보여주는 View를 
-- sal_view 라는 이름으로 만들어 화면에 보여주세요

create view sal_view
as
select deptno, max(sal) "최대급여", min(sal) "최소급여"
from emp
group by deptno;

select * from sal_view;

-- View에 컬럼만 만들고 싶은 경우 ==> 조건을 말이 안되게 작성하면 됨
create view emp_view2
as
select * from emp
where deptno = 1;

select * from emp_view2;

/*
컬럼 속성(제약 조건)
 
 테이블에 부적합한 자료가 입력되는 것을 방지하기 위해서 
 테이블을 생성할 때 각 컬럼에 대해서 정의하는 여러가지 규칙을 정한 것임.
 
 1) not null
 
    null 값이 입력되지 못하게 하는 제약 조건
    특정 열에 데이터의 중복 여부와는 상관 없이 null의 저장을 허용하지 않는 제약 조건임
 
 create table null_test(
    col1 varchar2(10) not null,
    col2 varchar2(10) not null,
    col3 varchar2(10)
 );
 
 2) unique
    
    열에 저장할 데이터의 중복을 허용하지 않고자 할 때 사용하는 조건
    null 값은 허용됨
    
    create table unique_test(
        col1 varchar2(10) unique not null,
        col2 varchar2(10) unique,
        col3 varchar2(10) not null,
        col4 varchar2(10) not null
    );
    
 3) primary key
    
    not null + unique 제약 조건
    테이블에 하나만 존재해야 함
    보통은 주민번호나 emp 테이블의 사원번호
    
 4) foreign key(외래키)
    
    다른 테이블의 필드(컬럼)를 참조해서 무결성을 검사하는 제약 조건

    참조키 : 부모테이블의 컬럼을 이야기 함
    외래키 : 자식테이블의 컬럼을 이야기 함
    자식테이블의 컬럼의 값(데이터)이 부모테이블에 없는 경우에는 무결성 규칙이 깨져 버림.
    
    create table foreign_test(
        empno number(4) primary key,
        ename varchar2(20) not null,
        job varchar2(50) not null,
        deptno number(2) references dept(deptno)
    );
    
 5) check
    
    열에 저장할 수 있는 값의 범위 또는 패턴을 정의할 때 사용
    주어진 값만 허용하는 조건
    
    create table check_test(
        gender varchar(10) constraint gender_ch check(gender in('남자', '여자')
    );
*/

 create table null_test(
    col1 varchar2(10) not null,
    col2 varchar2(10) not null,
    col3 varchar2(10)
 );

select * from null_test;

insert into null_test values('aa', 'aa1', 'aa2');

create table unique_test(
        col1 varchar2(10) unique not null,
        col2 varchar2(10) unique,
        col3 varchar2(10) not null,
        col4 varchar2(10) not null
    );

insert into unique_test values('aa', 'bb', 'cc', 'dd');
insert into unique_test values('aa1', 'bb1', 'cc1', 'dd1');
    
update unique_test set col1 = 'bb1' where col1 = 'aa1'; 

create table foreign_test(
    empno number(4) primary key,
    ename varchar2(20) not null,
    job varchar2(50) not null,
    deptno number(2) references dept(deptno)
);

insert into foreign_test values(1111, '홍길동', '영업', 30);
insert into foreign_test values(2222, '유관순', '회계', 10);
insert into foreign_test values(3333, '김유신', 'IT', 50);

select * from foreign_test;

   create table check_test(
        gender varchar(10) constraint gender_ch check(gender in('남자', '여자'))
    );

insert into check_test values('여자');
insert into check_test values('남자');
insert into check_test values('여'); -- error

/*
시퀀스(Sequence)

 연속적인 번호를 만들어 주는 기능
 형식) 
     create sequence 시퀀스이름
     start with n    (n : 시작 번호 설정 - 기본값 1)
     increament by n (n : 증가 번호 설정 - 기본값 1)
     maxvalue n      (n : 최대 번호 설정)
     minvalue n      (n : 최소 번호 설정)
     cache / nocache (시퀀스의 값이 빠르게 설정하기 위해 캐쉬 메모리 사용 여부)
     
    1) cache : 시퀀스를 빨리 제공하기 위해서 미리 캐쉬 메모리에 시퀀스를
               넣어 두고 준비하고 있다가 시퀀스 작업이 필요할 때 사용을 함.
               디폴트로는 20개의 시퀀스를 캐쉬 메모리에 보관하게 됨.
               하지만 만약 시스템이 비정상적으로 종료를 하게 되면 캐쉬 메모리에
               존재하던 시퀀스 번호는 사라지게 됨.
               
    2) nocache : chche 기능을 사용하지 않겠다는 의미

 마지막 시퀀스 번호를 알고 싶을 때 확인하는 방법
*/

select memo_seq.currval from dual;

/*
트랜잭션(Transaction)

 데이터 처리의 한 단위를 말함
 오라클에서 발생하는 여러 개의 SQL 명령문들을
 하나의 논리적인 작업 단위로 처리하는 것을 말함.
 All or Nothing 방식으로 처리함.
 명령어 여러 개의 집합이 정상적으로 처리가 되면
 종료하고, 여러개의 명령어 중에서 하나의 명령어이라도
 잘못이 되면 전체를 취소하는 것
 트랜잭션을 사용하는 이유 : 데이터의 일관성을 유지하면서 
    데이터의 안정성을 보장하기 위해 사용

 트랜잭션 사용 시 트랜잭션 제어를 위한 명령어
 1) commit : 모든 작업을 정상적으로 처리하겠다고 확정하는 명령어
             트랜잭션(insert, update, delete) 작업의 내용을 실제 DB에 반영
             이전에 있던 데이터에 update 현상이 발생을 함
             모든 사용자가 변경된 데이터의 결과를 볼 수 있음
 2) rollback : 작업 중에 문제가 발생했을 때 트랜잭션 처리 과정에서 
               발생한 변경사항을 취소하여 이전 상태로 되돌리는 명령어.
               트랙잭션(insert, update, delete) 작업 내용을 취소함
               이전에 commit한 곳까지만 복구가 됨
 
 3) savepoint : 트랜잭션을 작게 분할하는 것을 말함
                사용자가 트랜잭션 중간 단계에서 포인트를 지정하여 트랜잭션 내의
                특정 savepoint까지 rollback을 할 수 있게 하는 것
    형식1) savepoint label_name;
    형식2) rollback to label_name;
    
 1. dept 테이블을 복사하여 dept_02 테이블을 만들어 보자
     create table dept_02
     as
     select * from dept;
 2. dept_02 테이블에서 40번 부서를 삭제 후에 commit을 해보자
    delete from dept_02
    where deptno = 40;
    
    commit;
 3. dept_02 테이블에서 30번 부서를 삭제해 보자
    delete from dept_02
    where deptno = 30;
 4. 이 때 savepoint c1을 설정해 보도록 하자
    savepoint c1;
 5. 부서번호가 20번인 부서를 삭제해보자
    delete from dept_02
    where deptno = 20;
 6. savepoint c2을 설정해 보도록 하자
    savepoint c2;
 7. 마지막으로 부서번호가 10번인 부서를 삭제해보자
    delete from dept_02
    where deptno = 10;
 8. 부서번호가 10번을 삭제하기 바로 전으로 되돌리려고 함
    rollback을 이용하면 commit 지점으로 되돌아가게 됨
    rollback to c2;
*/

-- rollback ex)
-- 1. dept_01 테이블을 만들 때 dept 테이블을 복사하여 만들어 보자

create table dept_01
as
select * from dept;

-- 2. dept_01 테이블 내용을 삭제해 보자
delete from dept_01;

commit;

-- 3. 이 때 만일 부서번호가 20번 부서에 대해서만 삭제하고 싶었는데
-- 잘못하여 전체 데이터를 삭제한 경우, 데이터가 삭제가 되어 데이터를 찾을 수 없게 됨.
rollback;

-- 4. 20번 부서만 삭제하면 됨

 create table dept_02
 as
 select * from dept;

delete from dept_02
where deptno = 40;
    
commit;

delete from dept_02
where deptno = 30;
    
savepoint c1;
     
delete from dept_02
where deptno = 20;
    
savepoint c2;
    
delete from dept_02
where deptno = 10;    

rollback to c2;

select * from dept_02;

/*
PL/SQL(Procedual Language/SQL)

 SQL 만으로는 구현이 어렵거나 구현 불가능한 작업을 수행하기 위해
 오라클에서 제공하는 프로그래밍 언어를 말함.
 일반 프로그래밍 언어적인 요소를 다 가지고 있으며, 데이터베이스 업무를
 처리하기 위한 최적화된 언어.
 변수, 조건 처리,반복 처리 등 다양한 기능을 사용할 수 있음.
 
 기본 구 조
 1) 선언부(Declare) : 모든 변수나 상수를 선언하는 부분.
 2) 실행부(Excutable - Begin) : 실제 로직이 실행되는 부분.
                               제어문(조건문), 반복문, 함수 정의 등의 
                               로직을 기술하는 부분
 3) 예외처리부(Exception) : 실행 도중 예외가 발생 시 해결하기 위한
                          명령들을 기술하는 부분.
 기본 구조 중에서 선언부와 예외 처리부는 생략이 가능하지만
 실행부는 반드시 존재(기술)해야 함.
 
 PL/SQL 사용 시 주의사항
 1. 기본 구조(Declare, Begin, Exception) 키워드 뒤에는
    세미콜론(;)을 붙이지 않는다.
 2. 블럭의 각 부분에서 실행해야 하는 문장 끝에는 세미콜로(;)을 붙인다.
 3. begin ~ end(실행부) 밑에 반드시 "/"를 붙여 주어야 한다.
*/

-- "Hello PL/SQL!!" 이라는 내용을 화면에 출력해 보자. 
-- 실행 결과를 화면에 출력하겠다고 설정하는 부분
set serveroutput on;

begin 
    dbms_output.put_line('Hello PL/SQL');
end;
/

/*
선언부(Declare) 영역에 변수를 선언하는 방법
 1) 스칼라 자료형 : 형식) 변수명 자료형(크기);
                   예) no number(4); name varchar2(20);
 2) 레퍼런스 자료형 : 형식) 변수명 테이블명.컬럼명%type;
                     예) no emp.empno%type;
*/

-- 1) 스칼라 자료형
declare
    v_empno number(4) := 7788;
    v_ename varchar2(20);
begin
    v_ename := 'SCOTT';
    dbms_output.put_line('v_empno >>> ' || v_empno);
    dbms_output.put_line('v_ename >>> ' || v_ename);
end;
/

-- 2) 레퍼런스 자료형
declare
    v_empno emp.empno%type := 7693;
    v_ename emp.ename%type;
begin
    v_ename := 'SCOTT';
    dbms_output.put_line('v_empno >>> ' || v_empno);
    dbms_output.put_line('v_ename >>> ' || v_ename);
end;
/

-- 선언부에 상수를 선언하는 방법
declare
    v_pi constant number(3,2) := 3.14;
    v_empno emp.empno%type := 7693;
    v_ename emp.ename%type;
begin
    v_ename := 'SCOTT';
    dbms_output.put_line('v_pi >>> ' || v_pi);
    dbms_output.put_line('v_empno >>> ' || v_empno);
    dbms_output.put_line('v_ename >>> ' || v_ename);
end;
/

/* 
조건 제어문
 특정 조건식을 통해 상황에 따라 실행할 내용을 달리하는 방식의 명령어를 말함
 
 if 조건문
 1) if~then : 특정 조건을 만족하는 경우에 작업 수행
              형식) if 조건식 then 
                      조건식이 참인 경우 실행 문장
                   end if
                   
 2) if~then~else : 특정 조건을 만족하는 경우와 반대의 경우에 각자 지정한 작업 수행
                   형식) if 조건식 then 
                            조건식이 참인 경우 실행 문장
                        else
                            조건식이 거짓인 경우 실행 문장
                        end if
                        
 3) if~then~elsif : 여러 조건에 따라 각각 지정한 작업을 수행
                    형식) if 조건식1 then 
                            조건식1이 참인 경우 실행 문장
                        elsif 조건식2 then
                            조건식2가 참인 경우 실행 문장
                         elsif 조건식3 then
                            조건식3이 참인 경우 실행 문장
                         else
                            조건식이 모두 거짓인 경우 실행 문장
                        end if
*/

-- 1) if~then 예제
declare
    v_number number(3) := 13;
begin 
    if mod(v_number,2) = 1 then
       dbms_output.put_line(v_number || '(은)는 홀수입니다.');
    end if;
end;
/

-- 2)
declare
    v_number number(3) := 12;
begin 
    if mod(v_number,2) = 1 then
       dbms_output.put_line(v_number || '(은)는 홀수입니다.');
    else
        dbms_output.put_line(v_number || '(은)는 짝수입니다.');
    end if;
end;
/

-- 3)
declare
    v_score number(3) := 88;
begin 
    if v_score >=90 then
       dbms_output.put_line('A학점 입니다.');
    elsif v_score >=80 then
       dbms_output.put_line('B학점 입니다.');
    elsif v_score >=70 then
        dbms_output.put_line('C학점 입니다.');
    elsif v_score >=60 then
        dbms_output.put_line('D학점 입니다.');
    else
        dbms_output.put_line('F학점 입니다.');
    end if;
end;
/

/*
2. case 조건문
 형식)
     case 비교 기준
        when 값1 then
            수행할 명령어;
        when 값2 then
            수행할 명령어;
        when 값3 then
            수행할 명령어;
        else    
            값1 ~ 3이 아닌 다른 값이 아닌 경우 수행할 명령어;
        end case;
*/

declare
    v_score number(3) := 92;
begin 
    case trunc(v_score/10)
        when 9 then
            dbms_output.put_line('A학점 입니다.');
        when 8 then
            dbms_output.put_line('B학점 입니다.');
        when 7 then
            dbms_output.put_line('C학점 입니다.');
        when 6 then
            dbms_output.put_line('D학점 입니다.');
        else
            dbms_output.put_line('F학점 입니다.');
    end case;
end;
/

declare
    v_score number(3) := 92;
begin 
    case
        when v_score >= 90 then
            dbms_output.put_line('A학점 입니다.');
        when v_score >= 80 then
            dbms_output.put_line('B학점 입니다.');
        when v_score >= 70 then
            dbms_output.put_line('C학점 입니다.');
        when v_score >= 60 then
            dbms_output.put_line('D학점 입니다.');
        else
            dbms_output.put_line('F학점 입니다.');
    end case;
end;
/           
            
/*
반복 제어문
 특정 작업을 반복하여 수행하고자 할 때 사용하는 무자
 
 반복 제어문의 종류
 1) 기본 loop : 기본 반복문
 2) while loop : 특정 조건의 결과를 통해 반복 수행
 3) for loop : 반복 횟수를 정하여 반복 수행
 4) cursor for loop : 커서를 활용한 반복 수행
 
 반복문의 반복 수행을 종료시키는 명령어
 1) exit : 수행중인 반복 종료하는 명령어
 2) exit-when : 반복 종료를 위한 조건식을 지정하고 만족하면 반복 종료.
 3) continue : 수행 중인 반복의 현재 주기를 건너뜀
 4) continue-when : 특정 조건식을 지정하고 조건식을 만족하면 현재 반복 주기를 건너뜀
*/

-- 1)
declare
    v_number number(3) := 1;
begin
    loop
        dbms_output.put_line('v_number >>> ' || v_number);
        v_number := v_number+1;
       -- exit when v_number > 10;
        if v_number > 10 then
            exit;
        end if;
    end loop;
end;
/

-- 2)
declare 
    v_number number(3) := 1;
begin
    dbms_output.put_line('while loop 출력문');
    while v_number <= 10 loop
        dbms_output.put_line('v_number >>> ' || v_number);
        v_number := v_number+1;
    end loop;
end;
/

-- 3)
begin
    dbms_output.put_line('for loop 출력문');
    for v_number in 1..10 loop
        dbms_output.put_line('v_number >>> ' || v_number);
    end loop;
end;
/

-- test라는 테이블을 만들어 보자
create table test(
    no number(3),
    name varchar2(20),
    addr varchar2(100)
);

declare
    no test.no%type;
    name test.name%type;
    addr test.addr%type;
begin
    no := '&no';
    name := '&name';
    addr := '&addr';
    
    insert into test values(no, name, addr);
    
    dbms_output.put_line('번호 / 이름 / 주소');
    dbms_output.put_line('-------------------');
    dbms_output.put_line(no || '/' || name || '/' || addr);
end;
/






