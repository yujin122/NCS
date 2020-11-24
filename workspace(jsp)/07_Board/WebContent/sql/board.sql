-- board 테이블 생성

create table board(
	board_no number(5) primary key,
	board_writer varchar2(20) not null,
	board_title varchar2(100) not null,
	board_cont varchar2(1000),
	board_pwd varchar2(20) not null,
	board_hit number(5) default 0,
	board_regdate date
	
);

-- board 테이블 시퀀스 작업
create sequence board_seq
start with 1
increement by 1
nocache;

-- board 테이블에 레코드 추가
insert into board values(board_seq.nextval, '홍길동', '제목 1', '길동이 글', '1111', default, sysdate);
insert into board values(board_seq.nextval, '이순신', '제목 2', '이순신 글', '2222', default, sysdate);
insert into board values(board_seq.nextval, '유관순', '제목 3', '유관순 글', '3333', default, sysdate);
insert into board values(board_seq.nextval, '김유신', '제목 4', '김유신 글', '4444', default, sysdate);
insert into board values(board_seq.nextval, '김연아', '제목 5', '김연아 글', '5555', default, sysdate);

