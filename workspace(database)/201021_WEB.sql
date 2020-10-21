-- ī�װ� ���̺��� ����� ����
create table category(
    cnum number(5) default '1' not null,
    category_code varchar2(8) not null,
    category_name varchar2(30) not null,
    delete_chk char(1) default 'N' not null,
    primary key(cnum)
);

drop table category purge;

insert into category values(1, '00010000', '������ǰ', 'N');

insert into category values(2, '00010001', 'TV', 'N');
insert into category values(3, '00010002', '��ǻ��', 'N');
insert into category values(4, '00010003', 'MP3', 'N');
insert into category values(5, '00010004', '������', 'N');
insert into category values(6, '00020000', '�Ƿ�', 'N');
insert into category values(7, '00020001', '����', 'N');
insert into category values(8, '00020003', '�ӿ�', 'N');
insert into category values(9, '0002004', '����', 'N');
insert into category values(10, '00030000', '����', 'N');
insert into category values(11, '00030001', '��ǻ�͵���', 'N');
insert into category values(12, '00030002', '�Ҽ�', 'N');

select * from category;

-- ��ǰ �� ���� ���̺��� ����� ����

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
    values(1, '00010001', 'S ������ TV', '00001', 5000000, 8000000, 0, 100000,'�Ｚ','1');
insert into products
    values(2, '00010001', 'D TV', '00002', 300000, 400000, 0, 50000,'���','1');
insert into products
    values(3, '00010004', 'S ������', '00001', 1000000, 1100000, 5000, 100000,'�Ｚ','2'); 
insert into products
    values(4, '00010000', 'C ���', '00003', 200000, 220000, 5500, 0,'����','1');
insert into products
    values(5, '00010004', 'L ������', '00003', 1200000, 1300000, 0, 0,'LG','1');
insert into products
    values(6, '00020001', '��������', '00002', 100000, 150000, 2500, 0,'','1');
insert into products
    values(7, '00020001', '��������', '00002', 120000, 200000, 0, 0,'','3');
insert into products
    values(8, '00020002', '�簢��Ƽ', '00002', 10000, 20000, 0, 0,'���𰡵�','1');
insert into products
    values(9, '00020003', '�ủ����', '00002', 15000, 18000, 0, 0,'','1');
insert into products
    values(10, '00030001', '������ �ø���', '00001', 25000, 30000, 2000, 0,'���','1');

select * from products;

-- [����1] member10 ���̺��� ȸ���� �̸��� ���� ������ ȭ�鿡 �����ּ���
select memname, age, job from member10;
-- [����2] products ���̺��� ��ǰ��, �԰�, ���, �����縦 ȭ�鿡 �����ּ���
select products_name, input_price, output_price, company from products;

-- literal ���ڿ�
-- �÷����̳� ��Ī�� �ƴ� select ��Ͽ� ���ԵǴ� ����, ǥ���� ���ڸ� �ǹ�.
-- ��¥�� ���ڿ��� ��� ���� �ο��ȣ('')�� ����ؾ� �Ѵ�.

-- ex) "KING ����� ������ 60000 �Դϴ�."

select ename || '����� ������' || sal*12 || '�Դϴ�.' "����� ����" from emp;

/*
???????
where ������

��� �ڷḦ �������� ���� �ƴ϶� ����ڰ� ���ϴ� �ڷḸ ��ȸ�� ��� ���

where ���� from ���̺�� �ڿ� ����� �ؾ� �Ѵ�

����) select �÷���1, �÷���2,... from ���̺��̸� where ���ǽ�;

where ������ ��� �� �ڷḦ �˻��� �� ���Ǵ� ������

 1) =   : ������ ������?
 2) <   : ������ ������?
 3) <=  : ������ �۰ų� ������?
 4) >   : ������ ū��?
 5) >=  : ������ ũ�ų� ������?
 6) !=  : ������ ���� ������?
 7) <>  : ������ ���� ������? != ���� �ǹ�
 8) between A and B : A�� B ���̿� �ִ°�?
    ����) ���� ���� �տ� ����ϰ� ū ���� �ڿ� ����ؾ� ��
 9) in(list) : list �� �߿� ��� �ϳ��� ��ġ�ϴ°�?
 10) not between A and B : A�� B ���̿� ���°�?
 11) not in(list) : list ���� ��ġ���� �ʴ°�?
*/

-- emp ���̺��� �������� manager �� ����� ��� ������ ȭ�鿡 �����ּ���
select * from emp where job = 'MANAGER';

select * from emp where job = 'SALESMAN';

select * from emp;
select * from products;
select * from member10;

-- [����1] emp ���̺��� �������� 'CLERK'�� 
-- ����� ��� �̸� ������ �޿��� ȭ�鿡 �����ּ���

select empno, ename, job, sal 
from emp 
where job = 'CLERK';

-- [����2] emp ���̺��� 1982�� 1�� 1�� ���Ŀ� �Ի��� 
-- ����� ��� �̸� ������ �޿� �Ի����ڸ� ȭ�鿡 �����ּ���

select empno, ename, job, sal, hiredate 
from emp 
where hiredate > '82/01/01';

-- [����3] emp ���̺��� �޿��� 1300 ~ 1500 ������ �����
-- �̸� ������ �޿� �μ���ȣ�� ȭ�鿡 �����ּ���

select ename, job, sal, deptno 
from emp 
where sal between 1300 and 1500;

-- [����4] emp ���̺��� ����� 7902, 7788, 7566�� �����
-- ��� �̸� �������� ȭ�鿡 �����ּ���

select empno, ename, job 
from emp 
where empno in(7902, 7788, 7566);

-- [����5] emp ���̺��� ���ʽ��� 300�̰ų� 500�̰ų� 1400�� 
-- ����� ��� ������ ȭ�鿡 �����ּ���

select * 
from emp 
where comm = 300 or comm = 500 or comm = 1400;

-- [����6] member10 ���̺��� �̸��� ȫ�浿�̸鼭 ������ �л���
-- ȸ���� ��� ������ ȭ�鿡 �����ּ���

select * 
from member10 
where memname = 'ȫ�浿' and job = '�л�';

-- [����7] products ���̺��� �����簡 '�Ｚ' �Ǵ� '����' �̸鼭
-- �԰��� 100���� ������ ��ǰ�� ��ǰ��� ����� ȭ�鿡 �����ּ���

select products_name, output_price 
from products 
where company in('�Ｚ','����') and input_price <= 1000000;

-- [����8] emp ���̺��� �޿��� 1100 �̻��̰�, �������� 'MANAGER'��
-- ����� ��� �̸� ������ �޿��� ȭ�鿡 �����ּ���.

select empno, ename, job, sal 
from emp 
where sal >= 1100 and job = 'MANAGER'; 

-- like ������ : �˻��ϴ� ������

-- where name like '%S%' ==> ename �÷��� S�ڸ� �����ϴ� ����� �̸��� �˻�
-- where name like '%S' ==> ename �÷��� ù ���ڰ� S�ڷ� �����ϴ� ����� �̸��� �˻�
-- where name like 'S%' ==> ename �÷��� ������ ���ڰ� S�ڷ� ������ ����� �̸��� �˻�
-- where name like '_S%' ==> ename �÷��� �ι�° ���ڰ� S�ڰ� ���� ����� �̸��� �˻�

select ename
from emp
where ename like '__O%';

select * from emp;
select * from products;
select * from member10;

-- [����1] emp ���̺��� �̸��� 'S'�ڷ� ������ 
-- ����� �̸� �������� ȭ�鿡 �����ּ���

select ename, job 
from emp
where ename like '%S';

-- [����2] emp ���̺��� �̸��� ����°�� 'R'�� ����
-- ����� �̸��� ������ �޿��� ȭ�鿡 �����ּ���

select ename, job, sal
from emp
where ename like '__R%';

-- [����3] emp ���̺��� �̸��� �ι�°�� 'O'�� ����
-- ����� ��� ������ ȭ�鿡 �����ּ���

select *
from emp
where ename like '__O%';

-- [����4] emp ���̺��� �Ի�⵵�� 82�⵵�� �����
-- ��� �̸� �Ի����ڸ� ȭ�鿡 �����ּ���

select empno, ename, hiredate
from emp
where hiredate like '82%';

-- [����5] member10 ���̺��� ���� �达�� ȸ����
-- ��� ������ ȭ�鿡 �����ּ���

select *
from member10
where memname like '��%';

-- [����6] member10 ���̺��� �ּҿ� '�����'�� ���Ե�
-- ȸ���� �̸��� �ּ� ������ ȭ�鿡 �����ּ���

select memname, addr, job
from member10
where addr like '%�����%';

/*
order by 
 �ڷḦ �����Ͽ� ��Ÿ�� �� �ʿ��� ����.
 order by ���� ����� ���� select ������ �� �������� ��ġ
 
 asc : �������� ����
 desc : �������� ����
 
 �⺻������ order by �� ��� �ÿ��� default�� ��������
 -> �� ��쿡�� asc ���� ����
 
 null ���� �������������� ���� ���߿� ������, �������������� ���� ���� ����.
*/

-- member10 ���̺��� ���� �� �̸��� �������� ������������ �����Ͽ� ȭ�鿡 �����ּ���
-- ��, �̸��� ���� ��� ���̸� �������� �������� �����Ͽ� ȭ�鿡 �����ּ���

select *
from member10
order by memname asc, age desc;


-- [����1] emp ���̺��� �μ���ȣ�� �������� ������ �ϰ�, �μ���ȣ�� ���� ���
-- �޿��� �������� �������� ������ �Ͽ� ȭ�鿡 �����ּ���

select *
from emp
order by deptno asc, sal desc;

-- [����2] products ���̺��� �ǸŰ����� �������� ������������ �����Ͽ�
--  ��� ������ ȭ�鿡 �����ּ���

select *
from products
order by output_price desc;

-- [����3] products ���̺��� ��ۺ� ������������ �����Ͻÿ�
-- ��, ��ۺ� ���� ��� ���ϸ����� �������� ������������ �����Ͽ�
-- ��� ������ ȭ�鿡 �����ּ���

select *
from products
order by trans_cost desc, mileage desc;

-- [����4] emp ���̺��� �Ի����ڰ� ������ ������� �ֱٿ� �Ի��� �����
-- �������� �����ϵ�, ����� �Ի����ڸ� ȭ�鿡 �����ּ���

select ename, hiredate
from emp
order by hiredate;

-- [����5] emp ���̺��� �޿��� �������� ������������ �����Ͽ� 
-- ��� ������ ȭ�鿡 �����ּ���

select *
from emp
order by sal desc;

-- [����6] emp ���̺��� �޿��� 1100 �̻��� ������� ��� ������
-- �����ֵ�, �Ի����� ���� ������ ��� ������ ȭ�鿡 �����ּ���

select *
from emp
where sal >= 1100
order by hiredate;

-- [����7] emp ���̺��� �μ���ȣ�� �������� �������� �����Ͽ� ��Ÿ����,
-- �μ���ȣ�� ���� ��� �������� ������������ �����ϼ���. ���� �������� 
-- ���ٰ� �Ѵٸ�, �޿��� �������� ���� ������ �����Ͽ� ��� ������ ȭ�鿡 �����ּ���

select *
from emp
order by deptno asc, job asc, sal desc;

/*
not : ����

 �ϴ��� ������ �ۼ� �� ������ �ƴ� ������ �������� �ۼ� �Ŀ�
 ������ �ǹ��� not�� �ٿ��ָ� ���.
*/

-- emp ���̺��� �������� 'MANAGE', 'CLERK', 'ANALYST'��
-- �ƴ� ����� ��� �̸� ������ �޿��� ȭ�鿡 �����ּ���

select *
from emp
where job not in('MANAGER', 'CLERK', 'ANALYST');

-- [����1] emp ���̺��� �̸� 'S'�ڰ� ���� �ʴ�
-- ����� �̸��� ȭ�鿡 �����ּ���

select ename
from emp
where ename not like '%S%';

-- [����2] emp ���̺��� �μ���ȣ�� 10�� �μ��� �ƴ� �����
-- �̸� ������ �μ���ȣ�� ȭ�鿡 �����ּ���

select ename, job, deptno
from emp
where deptno != 10;

-- [����3] member10 ���̺��� �ּҰ� '����'�� �ƴ� ȸ����
-- ��� ������ ȭ�鿡 �����ּ���

select *
from member10
where addr not like '%����%';

-- [����4] products ���̺��� ����� 100���� �̸��� �ƴ�
-- ��ǰ�� ��ǰ�� ����� ȭ�鿡 �����ּ���

select products_name, output_price
from products
where output_price >= 1000000;

/*
�׷��Լ�

 ���� �� �Ǵ� ���̺� ��ü�� ���Ͽ� �Լ��� ����Ǿ� 
 �ϳ��� ��� ���� �������� �Լ�
 
 1) avg() : ��հ��� ���ϴ� �Լ�
 2) count() : ���� ������ ���ϴ� �Լ�
              -> null ���� ������.
 3) max() : �ִ��� ���ϴ� �Լ�
 4) min() : �ּڰ��� ���ϴ� �Լ�
 5) sum() : ������ ���ϴ� �Լ� 
*/

-- emp ���̺��� ����� ������ �ִ� ��� ����� ���� ȭ�鿡 �����ּ���

select count(comm)
from emp;

select * 
from emp;

-- [����1] emp ���̺��� ������(mgr)�� ���� 
-- ȭ�鿡 �����ּ���

select count(distinct mgr) "������ ��"
from emp;

-- [����2] emp ���̺��� ���ʽ��� ���� �����
-- ���� ȭ�鿡 �����ּ���

select count(comm)
from emp;

-- [����3] emp ���̺��� ��� SALESMAN��
-- �޿� ��հ� �޿� �ְ�� �޿������� �޿��հ���� 
-- ȭ�鿡 �����ּ���

select avg(sal) "�޿� ���", max(sal) "�޿� �ְ��", min(sal) "�޿� ������", sum(sal) "�޿� �հ��"
from emp
where job = 'SALESMAN';

-- [����4] emp ���̺��� ��ϵǾ� �ִ� ����� �� ��,
-- ���ʽ��� null�� �ƴ� �ο��� ���ʽ��� ��� ��ϵǾ� �ִ�
-- �μ��� ���� ȭ�鿡 �����ּ���

select count(*) "��� �� ��", count(comm) "���ʽ� �޴� �����", avg(comm) "���ʽ� ���"
from emp;

/*
join ~ on Ű����

 ���̺�� ���̺��� �����Ͽ� Ư���� �����͸� ����� �� �� �����
 �� �� �̻��� ���̺� ������ �������� ����.
 �ߺ��ؼ� �����Ͱ� ����Ǵ� ���� ���� ����
 
 emp ���̺� �μ��� ���������� ������ �Ѵٸ� 10�� �μ��� �Ҽӵ� 
 ����� 3���̹Ƿ� �μ���� �ٹ����� 3�� �ߺ��Ǿ� ������ ��
 �̷��� �ߺ��Ǿ� ����� �����ʹ� ���� ����, ����, ���� �� �̻� ������ 
 �߻��� �� �ְԵȴ�.
 
 �̷��� ������ �߻����� �ʰ� �Ϸ��� ��, �����Ͱ� �ߺ��� �Ǿ� ������� 
 �ʰ� �Ϸ��� �����ͺ��̽����� �� �� �̻��� ���̺� ������ ����� ����
 
 ������ �̷��� �ΰ��� ���̺�� ������ �Ǹ� �����ʹ� �ߺ��� �߻����� ������ ���ϴ�
 ������ �������� ���� �� ���Ǹ� �ؾ� �ϴ� �������� �߻���
 
 Ư�� ����� �Ҽӵ� �μ����� �˾Ƴ��� ���� emp ���̺�� dept ���̺��� �ѳ����
 �۾��� ����Ƿ� ����� �����ϰ� ��. �׷��� SQL ������ �� ���� ���̺��� �����ؼ�
 ���ϴ� ����� �� �� �ֵ��� �ϴ� �����̶�� ����� ������
 
 ������ ����
 
 1) Cross Join 
 
    �� �� �̻��� ���̺��� ���ε� �� ������ ���� ���̺��� ������ �̷������ ����
    �׷��� ������ ���̺� ��ü ���� �÷��� ������ �ȴ�.
    Cross Join�� ����� ����
    
 2) Equi Join
    
    ���� ���� ����ϴ� ���� ���
    
    ������ ����� �Ǵ� �� ���̺��� ���������� �����ϴ� �÷��� ���� 
    ��ġ�Ǵ� ���� �����Ͽ� ����� �����ϴ� ���
    
    �� ���̺��� �����Ϸ��� ��ġ�Ǵ� ���� �÷��� ����ؾ� ��.
    �÷��� �̸��� ������ ȥ���� ���� ������ �÷� �̸� �տ� ���̺��� �̸��� ����ؾ� ��
    
    ex) 
    emp ���̺��� ����� ��� �̸� ������ �μ���ȣ �μ��� �ٹ���ġ��
    ȭ�鿡 �����ּ��� ==> dept ���̺�� ������ �Ǿ�� ��
    
    select empno, ename, job, e.deptno, dname, loc
    from emp e join dept d
    on e.deptno = d.deptno;
    
    emp ���̺��� ������� 'SCOTT'�� ����� �μ����� �˰���� ���
    select ename, dname
    from emp e join dept d
    on e.deptno = d.deptno
    where ename = 'SCOTT';
 
 3) Self Join
 4) Outer Join
*/

-- Equi Join
-- [����1] �μ����� 'RESEARCH'�� �����
-- ��� �̸� �޿� �μ��� �ٹ���ġ�� ȭ�鿡 �����ּ���

select empno, ename, sal, dname, loc
from emp e join dept d
on e.deptno = d.deptno
where dname = 'RESEARCH';

-- [����2] emp ���̺��� 'NEWYORK'�� �ٹ��ϴ� �����
-- �̸��� �޿� �μ���ȣ�� ȭ�鿡 �����ּ���

select ename, sal, d.deptno
from emp e join dept d
on e.deptno = d.deptno
where loc = 'NEW YORK';

-- [����3] emp ���̺��� 'ACCOUNTING' �μ� �Ҽ� �����
-- �̸��� ������ �Ի��� �μ���ȣ �μ����� ȭ�鿡 �����ּ���

select ename, job, hiredate, d.deptno, dname
from emp e join dept d
on e.deptno = d.deptno
where dname = 'ACCOUNTING';

-- [����4] emp ���̺��� �������� 'MANAGER'�� ����� 
-- �̸��� �μ����� ȭ�鿡 �����ּ���

select ename, dname
from emp e join dept d
on e.deptno = d.deptno
where job = 'MANAGER';

commit;
