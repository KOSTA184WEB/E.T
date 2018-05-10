alter table member drop column deposit
insert into member values('et','1234','이티',19910109,20,'여','0101111111','etet@gmail.com','이름뭐야','et','c',0);
insert into member values('et2','1234','이티2',19981223,20,'여','0101111111','etet1@gmail.com','이름뭐야','et','c',0);
select *from member
select *from participant
/* member */
CREATE TABLE member (
	member_id VARCHAR2(20) PRIMARY KEY, 
	member_pw VARCHAR2(20) NOT NULL, 
	member_name VARCHAR2(20) NOT NULL, 
	member_birth NUMBER NOT NULL, 
	member_age NUMBER NOT NULL, 
	member_gender VARCHAR2(5) NOT NULL, 
	member_phone VARCHAR2(20) NOT NULL,
	member_email VARCHAR2(40) NOT NULL, 
	member_question VARCHAR2(40) NOT NULL,
	member_answer VARCHAR2(40) NOT NULL, 
	email_confirm VARCHAR2(5), 
	deposit NUMBER NOT NULL,
	report_count NUMBER 
);




/* meeting */
CREATE TABLE meeting (
	meeting_id VARCHAR2(100) PRIMARY KEY, 
	member_id VARCHAR2(20) REFERENCES MEMBER(MEMBER_ID), 
	res_id VARCHAR2(100) REFERENCES RESTAURANT(RES_ID),
	apply_num NUMBER NOT NULL, 
	menu VARCHAR2(20) NOT NULL, 
	max_num NUMBER NOT NULL,
	meeting_date DATE NOT NULL,
	deadline DATE NOT NULL, 
	meeting_description VARCHAR2(4000) NOT NULL, 
	meeting_title VARCHAR2(100) NOT NULL, 
	meeting_url VARCHAR2(300) NOT NULL, 
	gender_option VARCHAR2(5) NOT NULL 
);






/* PARTICIPANT */
CREATE TABLE PARTICIPANT (
	PARTICIPANT_ID VARCHAR2(100) PRIMARY KEY, /* PARTICIPANT_ID */
	member_id VARCHAR2(20) REFERENCES MEMBER(MEMBER_ID), /* member_id */
	meeting_id VARCHAR2(100) REFERENCES MEETING(MEETING_ID), /* meeting_id */
	PARTICIPANT_CANCEL VARCHAR2(5), /* cancel */
	PARTICIPANT__DATE DATE NOT NULL /* apply_date */
);

/* log */
CREATE TABLE log (
	log_id VARCHAR2(20) PRIMARY KEY, /* ?? ?÷? */
	member_id VARCHAR2(20) REFERENCES MEMBER(MEMBER_ID), /* id */
	meeting_id VARCHAR2(100) REFERENCES MEETING(MEETING_ID), /* meeting_id */
	ip VARCHAR2(100) NOT NULL, /* ip */
	access_time DATE NOT NULL /* access_time */
);


/* restaurant */
CREATE TABLE restaurant (
	res_id VARCHAR2(100) PRIMARY KEY, /* restaurant_id */
	res_name VARCHAR2(30) NOT NULL, /* restaurant_name */
	res_kind VARCHAR2(20) NOT NULL, /* kind */
	res_address VARCHAR2(200) NOT NULL, /* address */
	res_phone VARCHAR2(20), /* restaurant_call */
	res_rate NUMBER NOT NULL, /* avg_rate */
	lat NUMBER(13,10) NOT NULL, /* lat */
	lng NUMBER(13,10) NOT NULL, /* lng */
	meeting_count NUMBER NOT NULL /* number_of_meeting */
);


/* admin */
CREATE TABLE admin (
	admin_id VARCHAR2(20) PRIMARY KEY, /* admin_id */
	admin_pw VARCHAR2(20) NOT NULL /* admin_pw */
);


/* review */
CREATE TABLE review (
	review_id VARCHAR2(100) PRIMARY KEY, /* review_id */
	PARTICIPANT_ID VARCHAR2(100) REFERENCES PARTICIPANT(PARTICIPANT_ID), /* participation_id */
	member_id VARCHAR2(20) REFERENCES MEMBER(MEMBER_ID), /* id */
	meeting_id VARCHAR2(100) REFERENCES MEETING(MEETING_ID), /* meeting_id */
	res_id VARCHAR2(100) REFERENCES RESTAURANT(RES_ID), /* restaurant_id */
	review_title VARCHAR2(100) NOT NULL, /* title */
	review_contents VARCHAR2(4000) NOT NULL, /* contents */
	review_writeday DATE NOT NULL, /* writeday */
	review_readnum NUMBER NOT NULL, /* readnum */
	file_name VARCHAR2(50), /* file_name */
	file_size NUMBER, /* file_size */
	board_pw VARCHAR2(20) NOT NULL, /* board_pw */
	point NUMBER NOT NULL /* point */
);


/* admin_board */
CREATE TABLE admin_board (
	admin_board_id VARCHAR2(100) PRIMARY KEY, /* admin_board_id */
	admin_id VARCHAR2(20) REFERENCES ADMIN(ADMIN_ID), /* admin_id */
	admin_title VARCHAR2(100) NOT NULL, /* title */
	admin_contents VARCHAR2(4000) NOT NULL, /* contents */
	admin_writeday DATE NOT NULL, /* writeday */
	admin_readnum NUMBER NOT NULL, /* readnum */
	file_name VARCHAR2(50), /* file_name */
	file_size NUMBER, /* file_size */
	isPublic VARCHAR2(5) NOT NULL /* public */
);

select * from meeting;
select * from member;
select *from PARTICIPANT
select*from  participant  where member_id='et' and meeting_id='m-1'



/***************************** 여기부터 실행!!!!!!**************************************/

/************************ deposit ************************/
drop table deposit;

Create table deposit(
deposit_id varchar2(100) primary key, 
member_id varchar2(20) references member(member_id),
deposit_description varchar2(20),
plus_deposit number,
minus_deposit number,
current_deposit number not null,
deposit_update_date date not null
);
create sequence d_seq;
commit;
insert into deposit values(1,'et','충전',0,null,0,'2018-01-01');
commit;

/************************ admin ************************/
drop table admin_board;
drop table admin;
CREATE TABLE admin (
	member_id VARCHAR2(20) PRIMARY KEY REFERENCES MEMBER(MEMBER_ID)
);

/************************ admin_board ************************/
CREATE TABLE admin_board (
	admin_board_id VARCHAR2(100) PRIMARY KEY, /* admin_board_id */
	member_id VARCHAR2(20) REFERENCES admin(member_id), /* member_id */
	admin_title VARCHAR2(100) NOT NULL, /* title */
	admin_contents VARCHAR2(4000) NOT NULL, /* contents */
	admin_writeday DATE NOT NULL, /* writeday */
	admin_readnum NUMBER NOT NULL, /* readnum */
	file_name VARCHAR2(50), /* file_name */
	file_size NUMBER, /* file_size */
	isPublic VARCHAR2(5) NOT NULL /* public */
);
commit;
