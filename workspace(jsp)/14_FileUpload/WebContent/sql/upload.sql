create table upload{
	upload_no number(5) primary key,
	upload_writer varchar2(20) not null,
	upload_title varchar2(100) not null,
	upload_cont varchar2(2000) not null,
	upload_pwd varchar2(20) not null,
	upload_file varchar2(500),
	upload_hit number(5) default 0,
	upload_date date
};