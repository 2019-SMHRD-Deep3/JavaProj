




drop table book cascade constraints;

CREATE TABLE book
 ( b_title varchar2(40) not null,
  b_ISBN NUMBER(13) not null,
  b_author VARCHAR2(20) not null,
 CONSTRAINT book_b_iSBN_pk primary key(b_iSBN));
 
 insert into book values ('오늘도 팽수 내일도 팽수',9791162540640,'놀');
 insert into book values ('지쳤거나 좋아하는 게 없거나',9791196797706,'글배우');
 insert into book values ('여행의 이유',9788954655972,'김영하');
 insert into book values ('나는 나로 살기로 했다',9791187119845,'김수현');
 insert into book values ('꽃을 보듯 너를 본다',9791157280293,'나태주');
 
 commit;



 
drop table member cascade constraints;

CREATE TABLE member
  (m_id  VARCHAR2(10) not null,
  m_pw  VARCHAR2(10) not null,
  m_name  VARCHAR2(10) not null,
  m_socialNumber VARCHAR2(14) not null,
  m_address VARCHAR2(60) not null,
  m_phone VARCHAR2(14) not null,
  CONSTRAINT member_m_id_pk primary key(m_id),
  CONSTRAINT member_m_socialNumber_uk unique(m_socialNumber),
  CONSTRAINT member_m_phone_uk unique(m_phone));

insert into member values('admin','1111','이보람','99999-999999','광주','010-3333-3333');
insert into member values('dolli','2222','둘리','901212-1566811','광주광역시 북구 각화대로39번길 10','010-1111-1111');
insert into member values('mycall','3333','마이콜','911212-1567811','광주광역시 북구 첨단연신로108번길 86','010-2222-2222');
insert into member values('chensy','1010','또치','921212-1568811','광주광역시 북구 북구 북문대로98번길 20','010-3333-3323');
insert into member values('1','5555','1','931212-2569811','광주광역시 광산구 풍영로 300','010-5555-5555');
insert into member values('jandong','0000','장돈건','941212-2571382','광주광역시 서구 하남대로 710번길 19','010-7777-3277');

commit;
 
drop table loan cascade constraints;
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
drop table genre cascade constraints;
CREATE TABLE genre
  ( g_genre VARCHAR2(20) not null,
   b_isbn number(13),
   CONSTRAINT genre_b_isbn_fk foreign key(b_isbn) references book(b_isbn));

insert into genre values ('일기',9791162540640);
insert into genre values ('시',9791196797706);
insert into genre values ('수필',9788954655972);
insert into genre values ('자서전',9791187119845);
insert into genre values ('수필',9791157280292);

commit;

drop table publisher cascade constraints;
  CREATE TABLE publisher
 ( p_publisher VARCHAR2(20) not null,
  b_isbn number(13),
  CONSTRAINT publisher_b_isbn_fk foreign key(b_isbn) references book(b_isbn));
  
  insert into publisher values ('놀',9791162540640);
insert into publisher values ('강한별',9791196797706);
insert into publisher values ('문학동네',9788954655972);
insert into publisher values ('마음의숲',9791187119845);
insert into publisher values ('지혜',9791157280292);
  
  
  commit;
