-- sql developer tool������ �ּ���

/*
����Ŭ���� DB�� ���̺� ���� �ֿ� �ڷ���(data type) - ���� p.99

 1. number(n,n1) : - n : ��ü �ڸ���
                  - n1 : �Ҽ��� �ڸ���
                  - n - n1 : ���� �ڸ���
    ex) number(7,2) : ��ü �ڸ����� 7, �Ҽ��� �ڸ����� 2, ���� �ڸ��� 5

 2. char(n) : ���ڿ��� n���� ����Ǵ� �ڷ��� ==> ���� �ڷ���

 3. varchar(n) : ���ڿ��� n���� ����Ǵ� �ڷ��� ==> ���� ������� �ʴ� �ڷ���

 4. varchar2(n) : ���ڿ��� n���� ����Ǵ� �ڷ��� ==> ���� �ڷ���
                  �ѱ��� ������ �� ���ڴ� 2byte�� �Ҹ�.
 
 5. data : ��¥�� ����Ǵ� �ڷ��� ==> �ý����� ���� ��¥ �� �ð��� ����
*/

/*
 ���Ἲ(Integrity) : �����ͺ��̽��� ����� ������ ���� �װ��� ǥ���ϴ� ���� ������
                    ���� ���� ��ġ�ϴ� ��Ȯ���� �ǹ���.
                    
 ���Ἲ �������� : �����ͺ��̽��� ����� �������� ��Ȯ���� �����ϱ� ���ؼ� ��Ȯ����
                �ʴ� �����Ͱ� �����ͺ��̽� ���� ����Ǵ� ���� �����ϱ� ���� ����.
                
 �����ͺ��̽� ���� ���� ���� ����
 
 1. unique ���� ���� : �ߺ��� �Ǹ� �ȵǴ� ����.
 
 2. not null ���� ���� : ������ ������� �ʴ� ����.
 
 3. check ���� ���� : Ư���� ���� �ƴ� �����Ͱ� ������ ���ϰ� �ϴ� ����.
 
 4. primary key ���� ���� : unique + not null ���� ����.
    
    �⺻Ű�� �ش� ���̺��� ��ǥ�ϴ� �÷����μ��� ������ �����ϸ�, �ٸ� ���̺���
    �ܷ�Ű���� ������ �� �ִ� Ű�μ��� �ڰ��� ������. �̸� ���� ���Ἲ�̶�� ��.
*/

/*
 �л� ���̺��� ����� ����

 �÷� : �й�, �̸�, �а�, �г�, ����, ����ó, �ּ�, �����(������) ��� 

 ����) create table ���̺��̸�(
        �й� �ڷ���(ũ��) (��������),
        �̸� �ڷ���(ũ��) (��������),
        �а� �ڷ���(ũ��) (��������),
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

-- ���̺� �÷��� �߰�
-- ����) alter table ���̺��̸� add(�÷��� ������Ÿ��(ũ��) ��������);

-- student ���̺��� ������ �ּ� �÷��� �߰��غ���.

alter table student add(addr varchar2(200));

-- ���̺��� �÷��� ����(�ڷ��� ����)
-- ����) alter table ���̺��̸� modify(�÷��� ������Ÿ��(ũ��));

alter table student modify(age varchar2(3));

-- ���̺��� �÷��� ����
-- ����) alter table ���̺��̸� drop column �÷���;

alter table student drop column age;

alter table student add(age number(3));

-- student ���̺� �����͸� �߰��� ����

/*
 ����1) insert into ���̺��̸� values(�й�, '�̸�', '�а�', 
            �г�, '��ȣ', '�����(sysdate)', '�ּ�', ����);           
 ����2) insert into ���̺��̸�(�й� �÷���,�̸� �÷���,�а� �÷���,��ȣ �÷���)
                    values(�й�, �̸�, �а�, ��ȣ);
            
*/

insert into student 
values(20201020, 'ȫ�浿', '��ǻ�Ͱ���', 3, '010-7154-8652', sysdate, '����� ������', 25);

insert into student(id, name, major,phone) 
values(20201546, '������', '������', '010-2343-8470');

insert into student 
values(20205432, '�̼���', '�ؾ��а�', 2, '010-6587-4251', sysdate, '��õ�� ����', 23);

insert into student(id, name, major,phone) 
values(20203521, '�迬��', '��ü��', '010-3645-9465');

insert into student 
values(20208456, '������', '�濵�а�', 4, '010-3147-4682', sysdate, '����� ���빮��', 26);

insert into student(id, name, major,phone,addr) 
values(20208456, '������', '�濵�а�', '010-3147-4682', '����� ���빮��');


select * from student;

desc student;

select * from emp;

select empno, ename, job, deptno from emp;

-- [����] emp ���̺��� �̸�, �Ի���, �޿��� ȭ�鿡 �����ּ���
select ename, hiredate, sal from emp;

-- [����] emp ���̺��� ���, �̸�, ������, ���ʽ��� ȭ�鿡 �����ּ���
select empno, ename, job, comm from emp;

-- student ���̺��� Ư�� �÷��� ������ ����
-- ����) update ���̺��̸� set �÷��̸� = �÷��������� where primary key�� �Ǿ� �ִ� �÷��� = �÷�������;

update student set grade = 2, regdate = sysdate, age = 21, addr = '����� �߱�' where id = 20201546;
update student set grade = 3, regdate = sysdate, age = 20, addr = '����� ���빮��' where id = 20203521;

select * from student;

-- student ���̺��� Ư�� �÷��� ������ ����
-- ����) delete from ���̺��̸� where �⺻Ű�� ������ �÷��� = �÷� ������;
delete from student where id = 20208456;
delete from student where id = 20208456;
-- DB�� �Ϻ��ϰ� �����Ű���� �� ���� commit Ű���� ���

-- emp ���̺��� ���, �̸�, �޿�, ���ʽ�, �޿�+���ʽ� �� ȭ�鿡 �����ּ���
select empno, ename, sal, comm, sal+comm from emp;

-- null ���� ���� �÷��� �ٸ� �÷��� ������ �ϰ� �Ǹ� ��� null ������ ó��

-- nvl() �Լ� : null ���� Ư���� ������ �����ϴ� �Լ�
--             ��� ������ Ÿ�Կ� ������ �����ϴ�.
--             nvl() �Լ��� ����� ���� ��ȯ�Ǵ� ���� �ڷ����� ��ġ���Ѿ� �Ѵ�.
-- ����) nvl(null ���� ��� �ִ� �÷���, ������ ��)

select empno, ename, sal, nvl(comm,0), sal+nvl(comm,0) from emp;

-- nvl2() �Լ� : �ڹٿ����� ���׿����ڿ� ����� �Լ�.
-- ����) nvl2(�÷���, expr1, expr2)

-- �÷����� ���� null�� �ƴ� ��쿡�� expr1 ���� ��ȯ�ϰ�,
-- �÷����� ���� null�� ��쿡�� expr2 ���� ��ȯ�ϴ� �Լ�.

-- as : �÷� ���� �̸��� �����ϴ� Ű���� ==> ��Ī(����)
--      �÷��� �ٷ� �ڿ� ���

select empno, ename, sal, comm, sal+nvl2(comm, comm, 0) as total from emp;
select empno, ename, sal, comm, sal+nvl2(comm, comm, 0) total from emp;

-- [����] emp ���̺��� ���, �����, �޿�, �޿��� 10% �λ���� ȭ�鿡 �����ּ���

select empno, ename, sal, sal*1.1 "10% �λ� �޿�" from emp;

-- emp ���̺��� �� ����� ������(job)�� ȭ�鿡 �����ּ���

select job from emp;

/*
 distinct Ű���� : �ߺ��� �����ϴ� Ű����
                  �ַ� �ϳ��� �÷����� �ߺ��� ���� �����ϰ� ������ �� �����
                  distinct Ű����� �׻� select Ű���� ������ ���
                  distinct Ű���� �ڿ� ������ �÷����� ��� distinct ������ �޴´�.
*/

select distinct job from emp;

-- ���� emp ���̺��� �������� �μ���ȣ�� �ߺ��� ������ �� ȭ�鿡 �����ּ���
select distinct job, deptno from emp;

-- member ��� ���̺��� ����� ����

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

-- member10 ���̺� �� ������ ������ ����
insert into member10 
values(1,'id1', 'ȫ�浿', '1111', 25, 0, '�л�', '�λ�� ������', '2013-08-08');

insert into member10 
values(2,'id2', '��浿', '2222', 30, 1500, '������', '����� ������', '2013-09-05');

insert into member10 
values(3,'id3', '������', '3333', 33, 10000, '������', '�λ�� �߱�', '2013-09-09');

insert into member10 
values(4,'id4', '�迵��', '4444', 18, 3000, '�л�', '��󳲵� �̻��', '2012-01-01');

insert into member10 
values(5,'id5', '�ڸ���', '5555', 45, 5000, '�ֺ�', '��⵵ �����ֽ�', '2013-05-05');

insert into member10 
values(6,'id6', '��ö��', '6666', 55, 0, '����', '���ֵ� ��������', '2013-08-08');

insert into member10 
values(7,'id7', 'ȫ�浿', '7777', 14, 6000, '�л�', '���ϵ� ���ֽ�', '2012-12-25');

insert into member10 
values(8,'id8', '�����', '8888', 31, 0, '����', '����� ������', '2013-04-18');

insert into member10 
values(9,'id9', '������', '9999', 25, 0, '�л�', '������ ������', '2013-02-06');

insert into member10 
values(10,'id10', 'ȫ�浿', '0000', 52, 10000, '�ֺ�', '����� ���ϱ�', '2013-09-15');

select * from member10;

commit;




