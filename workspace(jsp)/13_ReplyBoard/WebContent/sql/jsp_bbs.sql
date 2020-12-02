-- jsp_bbs 테이블 생성
-- BBS(Bullertin Board System : 전자게시판)
-- 게시판 컬럼 구성

create table jsp_bbs(
	board_no number(5) primary key,
	board_writer varchar2(20) not null,
	board_title varchar2(100) not null,
	board_cont varchar2(2000) not null,
	board_pwd varchar2(20) not null,
	board_hit number(5) default 0,
	board_date date, 
	board_group number(4),					-- 게시판 글 그룹
	board_step number(4),					-- 게시판 글 답변 단계
	board_indent number(4)					-- 게시판 답변글 들여쓰기
);

-- 시퀀스 생성
create sequence bbs_seq
start with 1
increament by 1
nocache;

-- jsp_bbs 테이블에 글 추가
insert into jsp_bbs 
	values(bbs_seq.nextval, '홍길동', '제목1', '내용1', '1111', default, sysdate, bbs_seq.currval, 0, 0)
insert into jsp_bbs 
	values(bbs_seq.nextval, '이순신', '제목2', '내용2', '2222', default, sysdate, bbs_seq.currval, 0, 0)
insert into jsp_bbs 
	values(bbs_seq.nextval, '유관순', '제목3', '내용3', '3333', default, sysdate, bbs_seq.currval, 0, 0)
insert into jsp_bbs 
	values(bbs_seq.nextval, '김유신', '제목4', '내용4', '4444', default, sysdate, bbs_seq.currval, 0, 0)
insert into jsp_bbs 
	values(bbs_seq.nextval, '김연아', '제목5', '내용5', '5555', default, sysdate, bbs_seq.currval, 0, 0)
