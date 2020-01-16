drop table book cascade constraints;
drop table member cascade constraints;
drop table loan cascade constraints;
drop table genre cascade constraints;
drop table publisher cascade constraints;


CREATE TABLE book
 ( b_title varchar2(30) not null,
  b_ISBN NUMBER(13) not null,
  b_author VARCHAR2(20) not null,
 CONSTRAINT book_b_iSBN_pk primary key(b_iSBN));
 
 commit;

CREATE TABLE member
  (m_id varchar2(10) not null,
  m_pw varchar2(10) not null,
  m_name varchar2(10) not null,
  m_socialNumber VARCHAR(7) not null,
  m_address VARCHAR2(30) not null,
  m_phone varchar2(7) not null,
  CONSTRAINT member_m_id_pk primary key(m_id),
  CONSTRAINT member_m_socialNumber_uk unique(m_socialNumber),
  CONSTRAINT member_m_phone_uk unique(m_phone));

commit;

 CREATE TABLE loan
   (l_loandate date not null,
   l_returndate date not null,
   l_isOverdue char(1) ,
   l_count number(3) not null,
   m_id VARCHAR2(10),
  b_isbn number(13),
   CONSTRAINT loan_m_id_fk foreign key(m_id) references member(m_id),
  CONSTRAINT loan_b_isbn_fk foreign key(b_isbn) references book(b_isbn));

commit;

  CREATE TABLE genre
  ( g_genre VARCHAR2(20) not null,
   b_isbn number(13),
   CONSTRAINT genre_b_isbn_fk foreign key(b_isbn) references book(b_isbn));

commit;

 CREATE TABLE publisher
 ( p_publisher VARCHAR2(20) not null,
  b_isbn number(13),
  CONSTRAINT publisher_b_isbn_fk foreign key(b_isbn) references book(b_isbn));
  
  commit;