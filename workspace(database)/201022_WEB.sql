/*
 3) Self Join
 
    �ϳ��� ���̺� ������ ������ �ؾ� �ڷḦ ���� �� �ִµ� 
    �� �״�� �ڱ� �ڽ� ���̺�� ������ �δ� ���� ����.
    
    from �� ������ ���̺� �̸��� ������ �� �� ����� �� ����
    ���� ���� ���̺��� �ϳ� �� �����ϴ� ��ó�� ����� �� �ֵ���
    ���̺� ��Ī�� �ٿ��� ����ؾ� ��.
    
    ex)
    emp ���̺��� �� ����� �������� �̸��� ȭ�鿡 ����غ���
    select e.ename || '�� �Ŵ��� �̸��� ' || em.ename || '�Դϴ�.'
    from emp e join emp em
    on e.mgr = em.empno;
    
    select e.ename || '�� �Ŵ��� �̸��� ' || em.ename || '�Դϴ�.'
    from emp e, emp em
    where e.mgr = em.empno;
    
 4) Outer Join
 
    2�� �̻��� ���̺��� ���ε� �� ��� �� �� ���̺� �ش��ϴ� 
    �����Ͱ� �����ϴµ� �ٸ��� ���̺��� �����Ͱ� �������� �ʴ� ���
    �� �����Ͱ� ��µ��� �ʴ� �������� �ذ��ϱ� ���� ���Ǵ� ���� ���
    
    ������ ������ ���̺��� �÷� �ڿ� '(+)'��ȣ�� �ٿ��� ����� ��.
    
    ex)
    select e.ename || '�� �Ŵ��� �̸��� ' || em.ename || '�Դϴ�.'
    from emp e, emp em
    where e.mgr = em.empno(+);
*/

-- self join

-- emp ���̺��� �Ŵ����� 'KING'�� �������
-- �̸��� �������� ȭ�鿡 �����ּ���
select e.ename, e.job
from emp e, emp em
where em.ename = 'KING' and e.mgr = em.empno;

select e.ename || '�� �Ŵ��� �̸��� ' || em.ename || '�Դϴ�.'
from emp e, emp em
where e.mgr = em.empno(+);

-- outer join
select ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno
order by deptno;

/*
������(sequence)

 ������ �ο��� �� ����ϴ� ����

 ����) create sequence �������̸� 
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

-- �޸� ������ �����
create sequence memo_seq
start with 1
increment by 1;

insert into memo 
values(memo_seq.nextval, '�޸�1', 'ȫ�浿', '����̱�',sysdate);

insert into memo 
values(memo_seq.nextval, '�޸�2', '������', '�������� ��',sysdate);
insert into memo 
values(memo_seq.nextval, '�޸�3', '������', '���Ŵ� ��',sysdate);
insert into memo 
values(memo_seq.nextval, '�޸�4', '�迬��', '���� ��� ��',sysdate);
insert into memo 
values(memo_seq.nextval, '�޸�5', '�̼���', '�屺�� ��',sysdate);

select * from memo;

/*
dual ���̺�

 ����Ŭ���� ��ü������ ������ �ִ� ���̺�
 
 �����ϰ� �Լ��� �̿��ؼ� ���, ������� Ȯ���� �� ����ϴ� ���̺�.
 
 ���� �� ��, �� �÷� ���� ��� �ִ� ���̺�
 
 ��� �뵵 : Ư�� ���̺��� ������ �ʿ� ���� �Լ� �Ǵ� ����� �ϰ� ���� ��쿡 ���
 
 ����Ŭ���� ������ �ִ� �Լ���
 
 1. ��¥�� ���õ� �Լ���
    1) ���� �ý����� ��¥�� ���� ���� �Լ� : sysdate
       select sysdate from dual;
    2) ���� ��¥���� ���� ���� ���� �ִ� �Լ� : add_months(���糯¥, ����(������))
       select add_months(sysdate,5) from dual;
    3) �ٰ��� ��¥(����)�� ���� �ִ� �Լ� : next_day()
       select next_day(sysdate, '�����') from dual;
    4) �ش� ���� ������ ���� �˷��ִ� �Լ� : last_day()
       select last_day(sysdate) from dual;
    5) ���Ŀ� �°� ���ڿ��� ��¥�� ����ϴ� �Լ� : to_char(��¥, '��¥����')
       select to_char(sysdate, 'yyyy"��" mm"��" dd"��"') from dual;
       
 2. ���ڿ� ���õ� �Լ���
    1) ���ڿ��� �����ϴ� �Լ� : concat('���ڿ�1', '���ڿ�2');
       ���ڿ��� �����ϴ� ������ : ||
       select concat('�ȳ�', '�ϼ���') from dual;
    2) �ҹ��ڸ� �빮�ڷ� �ٲپ� �ִ� �Լ� : upper()
       �빮�ڸ� �ҹ��ڷ� �ٲپ� �ִ� �Լ� : lower()
    3) ���ڿ��� x���� y�� ���̸�ŭ ������ ���� �Լ� : substr('���ڿ�', x, y)
       x ���� ������ ��쿡�� �����ʺ��� ���۵ȴ�.
       select substr('ABCDEFG',3,2) from dual;
    4) �ڸ����� �÷��ִ� �Լ�
    
       ���� �ڸ����� �����ִ� �Լ� : lpad('���ڿ�', ��ü�ڸ���, '�þ �ڸ����� �� ���ڿ�');
       ������ �ڸ����� �÷��ִ� �Լ� : rpad('���ڿ�', ��ü�ڸ���, '�þ �ڸ����� �� ���ڿ�');
       
       ����) �ѱ��� 2����Ʈ�� ����� �Ǿ� ó��
       select lpad('ABCDEFG', 15, '*') from dual;
       select rpad('ABCDEFG', 15, '*') from dual;
    5) ���ڸ� �����ִ� �Լ�
       ���� ���ڸ� �����ִ� �Լ� : ltrim()
       ������ ���ڸ� �����ִ� �Լ� : rtrim()
       select ltrim('ABCDEFG', 'A') from dual;
       select rtrim('ABCDEFG', 'G') from dual;
    6) ���ڿ��� ��ü�� �ִ� �Լ� : replace('���� ���ڿ�', '��ü�� ���ڿ�', '��ü���ڿ�')
       select replace('Java Program', 'Java', 'JSP') from dual;

 3. ���ڿ� ���õ� �Լ���
    1) ���밪�� ���ϴ� �Լ� : abs()
    2) ���(1), ����(-1), 0�� ��ȯ�� �ִ� �Լ� : sign()
    3) �ݿø��� �� �ִ� �Լ� : round()
    4) �Ҽ��� ���� �ڸ����� �߶󳻴� �Լ� : trunc()
    5) ������ �ø��� �� �ִ� �Լ� : ceil()
    6) ������ ���ϴ� �Լ� : power()
    7) �������� ���ϴ� �Լ� : mod()
    8) �������� ���ϴ� �Լ� : sqrt()
*/

-- 2-2

-- [����1] emp ���̺��� ����� �Ʒ��� ���� �������� ȭ�鿡 �����ּ���
-- ��� : "SCOTT�� �������� ANALYST �Դϴ�."
-- ��, concat() �Լ��� �̿��ϼ���.

select concat(concat(ename, '�� �������� '), concat(job, '�Դϴ�.')) from emp where ename = 'SCOTT';

-- [����2] ��� : "SCOTT�� ������ 36000 �Դϴ�."
-- ��, concat() �Լ��� �̿��ϼ���.

select concat(concat(ename, '�� ������ '), concat(sal, '�Դϴ�.')) from emp where ename = 'SCOTT';

-- [����3] member10 ���̺��� ����� �Ʒ��� ���� �������� ȭ�鿡 �����ּ���
-- ��� : "ȫ�浿 ȸ���� ������ �л��Դϴ�."
-- ��, concat() �Լ��� �̿��ϼ���.

select concat(concat(memname, ' ȸ���� ������ '), concat(job, '�Դϴ�.')) from member10 where memname = 'ȫ�浿' and job = '�л�';

-- [����4] emp ���̺��� ��� �̸� �������� ȭ�鿡 �����ּ���
-- ��, �������� �ҹ��ڷ� �����Ͽ� ȭ�鿡 �����ּ���

select empno, ename, lower(job) from emp;

-- 2-3

-- [����1] �������� �ֹε�Ϲ�ȣ �߿��� ��������� �����Ͽ� ȭ�鿡 �����ּ���

-- 2-6

-- [����1] emp ���̺��� �������� 'A'��� ���ڸ� 
-- '$'�� �ٲپ� ȭ�鿡 ����� ������

select replace(job, 'A', '$') from emp;

-- [����2] member10 ���̺��� ������ '�л�'�� ������
-- '���л�'���� �ٲپ� ȭ�鿡 ����� ������

select replace(job, '�л�', '���л�') from member10;

-- [����3] member10 ���̺��� �ּҿ� '�����'��
-- '����Ư����'�� �ٲپ� ȭ�鿡 ����� ������

select replace(addr, '�����', '����Ư����') from member10;

/*
���� ����
 
 �ϳ��� ������ �ȿ� ���ԵǾ� �ִ� �� �ϳ��� �������� ����.
 ������ �ȿ� �� �ٸ� �������� �����ϴ� ������
 
 ���������� ���� ������ ���������� �����ϴ� �������� ������.
 
 ���� �� ������ �����ؼ� ���� �� �ִ� ����� �ϳ��� ��ø��
 ������������ �����ϰ� ����� ���� �� �ִ�.

 ���ǻ���
 1. ���������� ��ȣ�� ��� ���
 2. �������� �ȿ��� order by ���� ����� �� ����.
 3. ������ �����ʿ� ����ؾ� �Ѵ�.
 
 ����� : �켱�� ���ʿ� �ִ� �������� ���� ��, �� ������� ������ �ٱ��� �������� ����
 
 ex) 
 emp ���̺��� �̸��� 'SCOTT'�� ����� �޿����� �� ���� �޿��� �޴� �����
 ��� �̸� ������ �޿��� ȭ�鿡 ����ϼ���
 
 select empno, ename, job, sal
 from emp
 where sal > (select sal from emp where ename = 'SCOTT')
*/
select * from emp;

select empno, ename, job, sal
from emp
where sal > (select sal from emp where ename = 'SCOTT');

-- [����1] emp ���̺��� ��ձ޿����� ���� �޴� ����� 
-- ��� �̸� ������ �޿� �μ���ȣ�� ȭ�鿡 �����ּ���

select empno, ename, job, sal, deptno
from emp
where sal < (select avg(sal) from emp);

-- [����2] emp ���̺��� ����� 7521�� ����� �������� ���� 
-- �޿��� 7934�� ������� ���� �޴� ����� ��� �̸� ������ �޿���
-- ȭ�鿡 �����ּ���

select empno, ename, job, sal
from emp
where job = (select job from emp where empno = 7521)
and sal  > (select sal from emp where empno = 7934);

-- [����3] emp ���̺��� �������� 'MANAGER'�� ����� �ּұ޿�����
-- �����鼭, �������� 'CLERK'�� �ƴ� ����� ��� �̸� ������ �޿�

select empno, ename, job, sal
from emp
where sal < (select min(sal) from emp where job = 'MANAGER')
and job != 'CLERK';

-- [����4] �μ���ġ�� 'DALLAS'�� ����� ��� �̸� �μ���ȣ ������

select empno, ename, d.deptno, job
from emp e join dept d
on e.deptno = d.deptno
where loc = 'DALLAS';

select empno, ename, deptno, job
from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

-- [����5] member10 ���̺� �ִ� ���� ���� �� ���ϸ����� ���� ����
-- ���� ��� ����

select * from member10;
select *
from member10
where mileage = (select max(mileage) from member10);

-- [����6] emp ���̺��� 'SMITH'�� ������� �� ���� �޿��� �޴�
-- ����� �̸��� �޿�

select ename, sal
from emp
where sal > (select sal from emp where ename = 'SMITH');

-- [����7] emp ���̺��� 10�� �μ� �޿��� ��ձ޿����� ���� �޿��� �޴�
-- ������� �̸� �޿� �μ���ȣ

select ename, sal, deptno
from emp
where sal < (select avg(sal) from emp where deptno = 10);

-- [����8] emp ���̺��� 'BLAKE'�� ���� �μ��� �ִ� ������� 
-- �̸� �Ի�����

select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename = 'BLAKE')
and ename<>'BLAKE';

-- [����9] emp ���̺��� ��ձ޿����� �� ���� �޴� ������� ���,
-- �̸� �޿�

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);

-- [����10] emp ���̺��� �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ���
-- �ٹ��ϰ� �ִ� ����� ����� �̸�

select empno, ename
from emp
where deptno in(select deptno from emp where ename like '%T%');

-- [����11] 'SALES' �μ����� �ٹ��ϰ� �ִ� ������� �μ���ȣ �̸� ������

select empno, ename, job
from emp e join dept d
on e.deptno = d.deptno
where dname = 'SALES';

-- [����12] emp ���̺��� 'KING'���� �����ϴ� ��� ����� 
-- �̸� �޿� ������

select ename, sal, mgr
from emp
where mgr in(select mgr from emp
where mgr = (select empno from emp where ename = 'KING'));

-- [����13] emp ���̺��� �ڽ��� �޿��� ��ձ޿����� ����, �̸���
-- 'S'�ڰ� ���� ����� ������ �μ����� �ٹ��ϴ� ��� ����� ���
-- �̸� �޿�

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp) 
and deptno in(select deptno from emp where ename like '%S%');

-- [����14] emp ���̺��� ���ʽ��� �޴� ����� �μ���ȣ �޿��� ����
-- ����� �̸� �޿� �μ���ȣ�� ȭ�鿡 �����ּ���

select ename, sal, deptno
from emp
where deptno in(select deptno from emp 
where comm > 0) and
sal in(select sal from emp 
where comm > 0);

-- [����15] products ���̺��� ��ǰ�� �ǸŰ����� �ǸŰ�����
-- ��պ��� ū ��ǰ�� ��ü ����

select *
from products
where output_price > (select avg(output_price) from products);

-- [����16] products ���̺� �ִ� �ǸŰ��ݿ��� ��հ��� �̻���
-- ��ǰ����� ���ϵ�, ����� ���� �� ������ ���� ū �ݾ��� ��ǰ�� �����ϰ�
-- ����� ���Ͽ� ȭ�鿡 �����ּ���

select products_name
from products
where output_price >= (select avg(output_price) from products 
where output_price <> (select max(output_price) from products));

-- [����17] products ���̺��� ī�װ��� �̸��� '������'�̶��
-- �ܾ ���Ե� ī�װ��� ���ϴ� ��ǰ����� ȭ�鿡 �����ּ���

select products_name
from products p join category c
on c.category_code = p.category_fk
where category_name like '%������%';

select products_name
from products
where category_fk = (select category_code from category 
where category_name like '%������%');

-- [����18] member10 ���̺� �ִ� ������ �� ���ϸ����� ���� ���� �ݾ���
-- ������ ������ ���ʽ� ���ϸ��� 5000���� �� �־� ���� ���ϸ���
-- ���ϸ���+5000���� ȭ��

select memname, mileage, mileage+5000 "�߰� ���ϸ���"
from member10
where mileage = (select max(mileage) from member10);

/*
group by ��

������ Ư�� �÷��� �������� ���踦 ���ϴµ� ���� ����

������ �׷��Լ��� �Բ� ����ϸ� ȿ�������� Ȱ���� ����
*/

select deptno from emp order by deptno;

select deptno
from emp
group by deptno;

-- emp ���̺��� �μ����� �� �μ��� �ο��� Ȯ���ϰ� ���� ���
select deptno, count(*)
from emp
group by deptno
order by deptno desc;

-- emp ���̺��� �μ����� �޿��� �հ踦 ȭ�鿡 ���
select deptno, sum(sal) "�޿��հ�"
from emp
group by deptno
order by sum(sal);

-- [����] emp ���̺��� �μ����� �׷��� ��� �μ��� �޿� �հ��
-- �μ��� �ο� ��, �μ��� ��� �޿�, �μ��� �ִ� �޿�, �μ��� �ּ� �޿���
-- ���Ͽ� ȭ�鿡 �����ּ���
-- ��, �޿� �հ踦 �������� ������������ �����Ͽ� ȭ�鿡 �����ּ���

select deptno, count(*) "�ο���", avg(sal) "��� �޿�", max(sal) "�ִ� �޿�", min(sal) "�ּ� �޿�"
from emp
group by deptno
order by sum(sal) desc;

/*
having ��

 group by �� ������ ���� �������� group by ���� ����� ������ �־
 ������ �� �� ����� �Ѵ�.
 
 group by ������ where ���� �� �� ����.
*/

-- products ���̺��� ī�װ� ���� ��ǰ�� ������ ȭ�鿡 �����ּ���

select category_fk, count(*)
from products
group by category_fk
having count(*) >= 2
order by category_fk;

-- [����1] member10 ���̺��� ������ ������ �ش� ������ ����
-- �ּ� ���ϸ����� �����ֵ�, ���ϸ����� 0�� ���� �����ϰ�
-- ȭ�鿡 �����ּ���

select job, min(mileage)
from member10
group by job
having min(mileage) <> 0;

-- [����2] member10 ���̺��� ������ ������ ������ ���� ȸ�� ����
-- �����ֵ�, ȸ�� ���� 2�� �̻��� �������� ������ ȭ�鿡 �����ּ���

select job, count(*)
from member10
group by job
having count(*) >= 2;

-- [����3] emp ���̺��� �μ���ȣ�� �� �μ��� ���� �ο��� ȭ�鿡 �����ֵ�,
-- �ش� �μ��� ���� �ο��� 4�� �̻��� �μ��� ȭ�鿡 �����ּ���

select deptno, count(*)
from emp
group by deptno
having count(*) >= 4;

-- [����4] emp ���̺��� �������� �޿� �Ѿ��� ȭ�鿡 �����ֵ�
-- �޿� �Ѿ��� 5000 �̻��� �������� ȭ�鿡 �����ּ���
-- ����1) �������� 'SALSEMAN'�� �����ϰ� �޿� �Ѿ��� ȭ�鿡 ������ ��
-- ����2) �޿��Ѿ��� ������������ �����Ͽ� ������ ��

select deptno, sum(sal)
from emp
where job <> 'SALESMAN'
group by deptno
having sum(sal) >= 5000
order by sum(sal) desc;

commit;