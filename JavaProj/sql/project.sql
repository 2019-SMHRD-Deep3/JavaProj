




drop table book cascade constraints;

CREATE TABLE book
 ( b_title varchar2(40) not null,
  b_ISBN NUMBER(13) not null,
  b_author VARCHAR2(20) not null,
 CONSTRAINT book_b_iSBN_pk primary key(b_iSBN));
 
 insert into book values ('���õ� �ؼ� ���ϵ� �ؼ�',9791162540640,'��');
 insert into book values ('���ưų� �����ϴ� �� ���ų�',9791196797706,'�۹��');
 insert into book values ('������ ����',9788954655972,'�迵��');
 insert into book values ('���� ���� ���� �ߴ�',9791187119845,'�����');
 insert into book values ('���� ���� �ʸ� ����',9791157280293,'������');
 
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

insert into member values('admin','1111','�̺���','99999-999999','����','010-3333-3333');
insert into member values('dolli','2222','�Ѹ�','901212-1566811','���ֱ����� �ϱ� ��ȭ���39���� 10','010-1111-1111');
insert into member values('mycall','3333','������','911212-1567811','���ֱ����� �ϱ� ÷�ܿ��ŷ�108���� 86','010-2222-2222');
insert into member values('chensy','1010','��ġ','921212-1568811','���ֱ����� �ϱ� �ϱ� �Ϲ����98���� 20','010-3333-3323');
insert into member values('1','5555','1','931212-2569811','���ֱ����� ���걸 ǳ���� 300','010-5555-5555');
insert into member values('jandong','0000','�嵷��','941212-2571382','���ֱ����� ���� �ϳ���� 710���� 19','010-7777-3277');

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

insert into genre values ('�ϱ�',9791162540640);
insert into genre values ('��',9791196797706);
insert into genre values ('����',9788954655972);
insert into genre values ('�ڼ���',9791187119845);
insert into genre values ('����',9791157280292);

commit;

drop table publisher cascade constraints;
  CREATE TABLE publisher
 ( p_publisher VARCHAR2(20) not null,
  b_isbn number(13),
  CONSTRAINT publisher_b_isbn_fk foreign key(b_isbn) references book(b_isbn));
  
  insert into publisher values ('��',9791162540640);
insert into publisher values ('���Ѻ�',9791196797706);
insert into publisher values ('���е���',9788954655972);
insert into publisher values ('�����ǽ�',9791187119845);
insert into publisher values ('����',9791157280292);
  
  
  commit;
