/*
View 

 �������� ���̺� �ٰ��� ������ ������ ���̺��� ����
 View�� ���������� �����͸� �����ϰ� ���� ����
 View�� ����� �����ͺ��̽��� ���� �� ���� ���̺� �����Ͽ� �����͸� �ҷ����� ��
 �����ϰ� ���ϸ� �ʿ��� ����鸸 �����ؼ� ����ϴ� ��
 �ַ� �����͸� ��ȸ�� �� ���� ���� ����
 View�� ���̺�� �����ϸ� ���̺�ó�� ����� ������
 View�� ���̺� �����ϱ� ���� �������� ������ �ʿ䰡 ����
 ���̺�� ���������� select, insert, update, delete ����� ������
 
 View ��� ����
 1) ���� ������ ���� �����(�߿�)
    ���� ��޿� ���߾� �÷��� ������ ���ؼ� ��ȸ�� �����ϵ��� �� �� ����
 
 2) ������� ���Ǽ��� ���� �����
    ==> �˻� ������ �ܼ�ȭ�Ͽ� ����� �� �ֵ��� ��
    
 ����) create view ���̸�
      as
      ��������
*/

create view emp_view
as
select * from emp;

-- �λ�� ��
-- �÷��� sal, comm ����

create view emp_insa
as
select empno, ename, job, mgr, hiredate, deptno 
from emp;

select *
from emp_insa;

-- ������ ��
-- �÷��� sal ����
-- ������� ���߽�Ű�� ���ؼ� comm�÷��� ��ȸ�� �� �ְ� �ؾ���
create view emp_sales
as
select empno, ename, job, mgr, hiredate, comm, deptno
from emp;

select *
from emp_sales;

-- ȸ��� ��
-- ��� �÷��� �� �������� ���� ��

create view emp_account
as
select * from emp;

-- emp_view View�� �����͸� �߰��� ����
insert into emp_view
values(9000, 'ANGEL', 'SALSEMAN', 7698, sysdate, 1500, 200, 30);

select * from emp_view;

-- �б� ���� View�� ����� insert, update, delete �� �� ��

-- �б� ���� View�� ����� ��� : ������ �� �������� with read only; �ۼ�

create view emp_view1
as
select * from emp
with read only;

insert into emp_view1
values(9000, 'ANGEL', 'SALSEMAN', 7698, sysdate, 1500, 200, 30);

-- �μ����� �μ��� �޿��հ�, �μ��� �޿������ ����
-- View�� ���� ȭ�鿡 �����ּ���

-- View�� ���� �� �׷��Լ��� ��� �� �ݵ�� ��Ī�� ������ �� �־�� ��
create view emp_sal
as 
select deptno, sum(sal) "�޿��հ�", avg(sal) "�޿����"
from emp
group by deptno;

select * from emp_sal;

-- [����1] emp ���̺��� �̿��Ͽ� emp_dept20 �̶�� View�� ����� ������
-- ��, �μ���ȣ�� 20�� �μ��� ���� ������� ���, �̸�, ������, ������,
-- �μ���ȣ�� �����ֽñ� �ٶ��ϴ�.

create view emp_dept20
as
select empno, ename, job, mgr, deptno
from emp
where deptno = 20;

select * from emp_dept20;

-- [����2] emp ���̺��� �� �μ��� �ִ�޿��� �ּұ޿��� �����ִ� View�� 
-- sal_view ��� �̸����� ����� ȭ�鿡 �����ּ���

create view sal_view
as
select deptno, max(sal) "�ִ�޿�", min(sal) "�ּұ޿�"
from emp
group by deptno;

select * from sal_view;

-- View�� �÷��� ����� ���� ��� ==> ������ ���� �ȵǰ� �ۼ��ϸ� ��
create view emp_view2
as
select * from emp
where deptno = 1;

select * from emp_view2;

/*
�÷� �Ӽ�(���� ����)
 
 ���̺� �������� �ڷᰡ �ԷµǴ� ���� �����ϱ� ���ؼ� 
 ���̺��� ������ �� �� �÷��� ���ؼ� �����ϴ� �������� ��Ģ�� ���� ����.
 
 1) not null
 
    null ���� �Էµ��� ���ϰ� �ϴ� ���� ����
    Ư�� ���� �������� �ߺ� ���οʹ� ��� ���� null�� ������ ������� �ʴ� ���� ������
 
 create table null_test(
    col1 varchar2(10) not null,
    col2 varchar2(10) not null,
    col3 varchar2(10)
 );
 
 2) unique
    
    ���� ������ �������� �ߺ��� ������� �ʰ��� �� �� ����ϴ� ����
    null ���� ����
    
    create table unique_test(
        col1 varchar2(10) unique not null,
        col2 varchar2(10) unique,
        col3 varchar2(10) not null,
        col4 varchar2(10) not null
    );
    
 3) primary key
    
    not null + unique ���� ����
    ���̺� �ϳ��� �����ؾ� ��
    ������ �ֹι�ȣ�� emp ���̺��� �����ȣ
    
 4) foreign key(�ܷ�Ű)
    
    �ٸ� ���̺��� �ʵ�(�÷�)�� �����ؼ� ���Ἲ�� �˻��ϴ� ���� ����

    ����Ű : �θ����̺��� �÷��� �̾߱� ��
    �ܷ�Ű : �ڽ����̺��� �÷��� �̾߱� ��
    �ڽ����̺��� �÷��� ��(������)�� �θ����̺� ���� ��쿡�� ���Ἲ ��Ģ�� ���� ����.
    
    create table foreign_test(
        empno number(4) primary key,
        ename varchar2(20) not null,
        job varchar2(50) not null,
        deptno number(2) references dept(deptno)
    );
    
 5) check
    
    ���� ������ �� �ִ� ���� ���� �Ǵ� ������ ������ �� ���
    �־��� ���� ����ϴ� ����
    
    create table check_test(
        gender varchar(10) constraint gender_ch check(gender in('����', '����')
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

insert into foreign_test values(1111, 'ȫ�浿', '����', 30);
insert into foreign_test values(2222, '������', 'ȸ��', 10);
insert into foreign_test values(3333, '������', 'IT', 50);

select * from foreign_test;

   create table check_test(
        gender varchar(10) constraint gender_ch check(gender in('����', '����'))
    );

insert into check_test values('����');
insert into check_test values('����');
insert into check_test values('��'); -- error

/*
������(Sequence)

 �������� ��ȣ�� ����� �ִ� ���
 ����) 
     create sequence �������̸�
     start with n    (n : ���� ��ȣ ���� - �⺻�� 1)
     increament by n (n : ���� ��ȣ ���� - �⺻�� 1)
     maxvalue n      (n : �ִ� ��ȣ ����)
     minvalue n      (n : �ּ� ��ȣ ����)
     cache / nocache (�������� ���� ������ �����ϱ� ���� ĳ�� �޸� ��� ����)
     
    1) cache : �������� ���� �����ϱ� ���ؼ� �̸� ĳ�� �޸𸮿� ��������
               �־� �ΰ� �غ��ϰ� �ִٰ� ������ �۾��� �ʿ��� �� ����� ��.
               ����Ʈ�δ� 20���� �������� ĳ�� �޸𸮿� �����ϰ� ��.
               ������ ���� �ý����� ������������ ���Ḧ �ϰ� �Ǹ� ĳ�� �޸𸮿�
               �����ϴ� ������ ��ȣ�� ������� ��.
               
    2) nocache : chche ����� ������� �ʰڴٴ� �ǹ�

 ������ ������ ��ȣ�� �˰� ���� �� Ȯ���ϴ� ���
*/

select memo_seq.currval from dual;

/*
Ʈ�����(Transaction)

 ������ ó���� �� ������ ����
 ����Ŭ���� �߻��ϴ� ���� ���� SQL ��ɹ�����
 �ϳ��� ������ �۾� ������ ó���ϴ� ���� ����.
 All or Nothing ������� ó����.
 ��ɾ� ���� ���� ������ ���������� ó���� �Ǹ�
 �����ϰ�, �������� ��ɾ� �߿��� �ϳ��� ��ɾ��̶�
 �߸��� �Ǹ� ��ü�� ����ϴ� ��
 Ʈ������� ����ϴ� ���� : �������� �ϰ����� �����ϸ鼭 
    �������� �������� �����ϱ� ���� ���

 Ʈ����� ��� �� Ʈ����� ��� ���� ��ɾ�
 1) commit : ��� �۾��� ���������� ó���ϰڴٰ� Ȯ���ϴ� ��ɾ�
             Ʈ�����(insert, update, delete) �۾��� ������ ���� DB�� �ݿ�
             ������ �ִ� �����Ϳ� update ������ �߻��� ��
             ��� ����ڰ� ����� �������� ����� �� �� ����
 2) rollback : �۾� �߿� ������ �߻����� �� Ʈ����� ó�� �������� 
               �߻��� ��������� ����Ͽ� ���� ���·� �ǵ����� ��ɾ�.
               Ʈ�����(insert, update, delete) �۾� ������ �����
               ������ commit�� �������� ������ ��
 
 3) savepoint : Ʈ������� �۰� �����ϴ� ���� ����
                ����ڰ� Ʈ����� �߰� �ܰ迡�� ����Ʈ�� �����Ͽ� Ʈ����� ����
                Ư�� savepoint���� rollback�� �� �� �ְ� �ϴ� ��
    ����1) savepoint label_name;
    ����2) rollback to label_name;
    
 1. dept ���̺��� �����Ͽ� dept_02 ���̺��� ����� ����
     create table dept_02
     as
     select * from dept;
 2. dept_02 ���̺��� 40�� �μ��� ���� �Ŀ� commit�� �غ���
    delete from dept_02
    where deptno = 40;
    
    commit;
 3. dept_02 ���̺��� 30�� �μ��� ������ ����
    delete from dept_02
    where deptno = 30;
 4. �� �� savepoint c1�� ������ ������ ����
    savepoint c1;
 5. �μ���ȣ�� 20���� �μ��� �����غ���
    delete from dept_02
    where deptno = 20;
 6. savepoint c2�� ������ ������ ����
    savepoint c2;
 7. ���������� �μ���ȣ�� 10���� �μ��� �����غ���
    delete from dept_02
    where deptno = 10;
 8. �μ���ȣ�� 10���� �����ϱ� �ٷ� ������ �ǵ������� ��
    rollback�� �̿��ϸ� commit �������� �ǵ��ư��� ��
    rollback to c2;
*/

-- rollback ex)
-- 1. dept_01 ���̺��� ���� �� dept ���̺��� �����Ͽ� ����� ����

create table dept_01
as
select * from dept;

-- 2. dept_01 ���̺� ������ ������ ����
delete from dept_01;

commit;

-- 3. �� �� ���� �μ���ȣ�� 20�� �μ��� ���ؼ��� �����ϰ� �;��µ�
-- �߸��Ͽ� ��ü �����͸� ������ ���, �����Ͱ� ������ �Ǿ� �����͸� ã�� �� ���� ��.
rollback;

-- 4. 20�� �μ��� �����ϸ� ��

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

 SQL �����δ� ������ ��ưų� ���� �Ұ����� �۾��� �����ϱ� ����
 ����Ŭ���� �����ϴ� ���α׷��� �� ����.
 �Ϲ� ���α׷��� ������� ��Ҹ� �� ������ ������, �����ͺ��̽� ������
 ó���ϱ� ���� ����ȭ�� ���.
 ����, ���� ó��,�ݺ� ó�� �� �پ��� ����� ����� �� ����.
 
 �⺻ �� ��
 1) �����(Declare) : ��� ������ ����� �����ϴ� �κ�.
 2) �����(Excutable - Begin) : ���� ������ ����Ǵ� �κ�.
                               ���(���ǹ�), �ݺ���, �Լ� ���� ���� 
                               ������ ����ϴ� �κ�
 3) ����ó����(Exception) : ���� ���� ���ܰ� �߻� �� �ذ��ϱ� ����
                          ��ɵ��� ����ϴ� �κ�.
 �⺻ ���� �߿��� ����ο� ���� ó���δ� ������ ����������
 ����δ� �ݵ�� ����(���)�ؾ� ��.
 
 PL/SQL ��� �� ���ǻ���
 1. �⺻ ����(Declare, Begin, Exception) Ű���� �ڿ���
    �����ݷ�(;)�� ������ �ʴ´�.
 2. ���� �� �κп��� �����ؾ� �ϴ� ���� ������ �����ݷ�(;)�� ���δ�.
 3. begin ~ end(�����) �ؿ� �ݵ�� "/"�� �ٿ� �־�� �Ѵ�.
*/

-- "Hello PL/SQL!!" �̶�� ������ ȭ�鿡 ����� ����. 
-- ���� ����� ȭ�鿡 ����ϰڴٰ� �����ϴ� �κ�
set serveroutput on;

begin 
    dbms_output.put_line('Hello PL/SQL');
end;
/

/*
�����(Declare) ������ ������ �����ϴ� ���
 1) ��Į�� �ڷ��� : ����) ������ �ڷ���(ũ��);
                   ��) no number(4); name varchar2(20);
 2) ���۷��� �ڷ��� : ����) ������ ���̺��.�÷���%type;
                     ��) no emp.empno%type;
*/

-- 1) ��Į�� �ڷ���
declare
    v_empno number(4) := 7788;
    v_ename varchar2(20);
begin
    v_ename := 'SCOTT';
    dbms_output.put_line('v_empno >>> ' || v_empno);
    dbms_output.put_line('v_ename >>> ' || v_ename);
end;
/

-- 2) ���۷��� �ڷ���
declare
    v_empno emp.empno%type := 7693;
    v_ename emp.ename%type;
begin
    v_ename := 'SCOTT';
    dbms_output.put_line('v_empno >>> ' || v_empno);
    dbms_output.put_line('v_ename >>> ' || v_ename);
end;
/

-- ����ο� ����� �����ϴ� ���
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
���� ���
 Ư�� ���ǽ��� ���� ��Ȳ�� ���� ������ ������ �޸��ϴ� ����� ��ɾ ����
 
 if ���ǹ�
 1) if~then : Ư�� ������ �����ϴ� ��쿡 �۾� ����
              ����) if ���ǽ� then 
                      ���ǽ��� ���� ��� ���� ����
                   end if
                   
 2) if~then~else : Ư�� ������ �����ϴ� ���� �ݴ��� ��쿡 ���� ������ �۾� ����
                   ����) if ���ǽ� then 
                            ���ǽ��� ���� ��� ���� ����
                        else
                            ���ǽ��� ������ ��� ���� ����
                        end if
                        
 3) if~then~elsif : ���� ���ǿ� ���� ���� ������ �۾��� ����
                    ����) if ���ǽ�1 then 
                            ���ǽ�1�� ���� ��� ���� ����
                        elsif ���ǽ�2 then
                            ���ǽ�2�� ���� ��� ���� ����
                         elsif ���ǽ�3 then
                            ���ǽ�3�� ���� ��� ���� ����
                         else
                            ���ǽ��� ��� ������ ��� ���� ����
                        end if
*/

-- 1) if~then ����
declare
    v_number number(3) := 13;
begin 
    if mod(v_number,2) = 1 then
       dbms_output.put_line(v_number || '(��)�� Ȧ���Դϴ�.');
    end if;
end;
/

-- 2)
declare
    v_number number(3) := 12;
begin 
    if mod(v_number,2) = 1 then
       dbms_output.put_line(v_number || '(��)�� Ȧ���Դϴ�.');
    else
        dbms_output.put_line(v_number || '(��)�� ¦���Դϴ�.');
    end if;
end;
/

-- 3)
declare
    v_score number(3) := 88;
begin 
    if v_score >=90 then
       dbms_output.put_line('A���� �Դϴ�.');
    elsif v_score >=80 then
       dbms_output.put_line('B���� �Դϴ�.');
    elsif v_score >=70 then
        dbms_output.put_line('C���� �Դϴ�.');
    elsif v_score >=60 then
        dbms_output.put_line('D���� �Դϴ�.');
    else
        dbms_output.put_line('F���� �Դϴ�.');
    end if;
end;
/

/*
2. case ���ǹ�
 ����)
     case �� ����
        when ��1 then
            ������ ��ɾ�;
        when ��2 then
            ������ ��ɾ�;
        when ��3 then
            ������ ��ɾ�;
        else    
            ��1 ~ 3�� �ƴ� �ٸ� ���� �ƴ� ��� ������ ��ɾ�;
        end case;
*/

declare
    v_score number(3) := 92;
begin 
    case trunc(v_score/10)
        when 9 then
            dbms_output.put_line('A���� �Դϴ�.');
        when 8 then
            dbms_output.put_line('B���� �Դϴ�.');
        when 7 then
            dbms_output.put_line('C���� �Դϴ�.');
        when 6 then
            dbms_output.put_line('D���� �Դϴ�.');
        else
            dbms_output.put_line('F���� �Դϴ�.');
    end case;
end;
/

declare
    v_score number(3) := 92;
begin 
    case
        when v_score >= 90 then
            dbms_output.put_line('A���� �Դϴ�.');
        when v_score >= 80 then
            dbms_output.put_line('B���� �Դϴ�.');
        when v_score >= 70 then
            dbms_output.put_line('C���� �Դϴ�.');
        when v_score >= 60 then
            dbms_output.put_line('D���� �Դϴ�.');
        else
            dbms_output.put_line('F���� �Դϴ�.');
    end case;
end;
/           
            
/*
�ݺ� ���
 Ư�� �۾��� �ݺ��Ͽ� �����ϰ��� �� �� ����ϴ� ����
 
 �ݺ� ����� ����
 1) �⺻ loop : �⺻ �ݺ���
 2) while loop : Ư�� ������ ����� ���� �ݺ� ����
 3) for loop : �ݺ� Ƚ���� ���Ͽ� �ݺ� ����
 4) cursor for loop : Ŀ���� Ȱ���� �ݺ� ����
 
 �ݺ����� �ݺ� ������ �����Ű�� ��ɾ�
 1) exit : �������� �ݺ� �����ϴ� ��ɾ�
 2) exit-when : �ݺ� ���Ḧ ���� ���ǽ��� �����ϰ� �����ϸ� �ݺ� ����.
 3) continue : ���� ���� �ݺ��� ���� �ֱ⸦ �ǳʶ�
 4) continue-when : Ư�� ���ǽ��� �����ϰ� ���ǽ��� �����ϸ� ���� �ݺ� �ֱ⸦ �ǳʶ�
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
    dbms_output.put_line('while loop ��¹�');
    while v_number <= 10 loop
        dbms_output.put_line('v_number >>> ' || v_number);
        v_number := v_number+1;
    end loop;
end;
/

-- 3)
begin
    dbms_output.put_line('for loop ��¹�');
    for v_number in 1..10 loop
        dbms_output.put_line('v_number >>> ' || v_number);
    end loop;
end;
/

-- test��� ���̺��� ����� ����
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
    
    dbms_output.put_line('��ȣ / �̸� / �ּ�');
    dbms_output.put_line('-------------------');
    dbms_output.put_line(no || '/' || name || '/' || addr);
end;
/






