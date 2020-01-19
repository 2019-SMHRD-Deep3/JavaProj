drop table book cascade constraints;
drop table member cascade constraints;
drop table loan cascade constraints;
drop table genre cascade constraints;
drop table publisher cascade constraints;
drop table genreid cascade constraints;
drop table publisherid cascade constraints;


 CREATE TABLE book
 ( b_title varchar2(50) not null,
  b_ISBN NUMBER(13) not null,
  b_author VARCHAR2(20) not null,
    b_count number(3),
 CONSTRAINT book_b_iSBN_pk primary key(b_iSBN));
 
 insert into book values ('���õ� �ؼ� ���ϵ� �ؼ�',9791162540640,'��',52);
 insert into book values ('���ưų� �����ϴ� �� ���ų�',9791196797706,'�۹��',11);
 insert into book values ('������ ����',9788954655972,'�迵��',18);
 insert into book values ('���� ���� ���� �ߴ�',9791187119845,'�����',7);
 insert into book values ('���� ���� �ʸ� ����',9791157280293,'������',36);
 insert into book values ('���̾�', 9791159036514, '�츣�� �켼', 9);
 insert into book values ('�ڽ���', 9788983711892, 'Į ���̰�', 22);
 insert into book values ('���ǿ���', 9788934972464, '���� �϶�', 6);
 
 commit;

 CREATE TABLE member
  (m_id varchar2(10) not null,
  m_pw varchar2(10) not null,
  m_name varchar2(10) not null,
  m_socialNumber VARCHAR(14) not null,
  m_address VARCHAR2(60) not null,
  m_phone varchar2(14) not null,
  CONSTRAINT member_m_id_pk primary key(m_id),
  CONSTRAINT member_m_socialNumber_uk unique(m_socialNumber),
  CONSTRAINT member_m_phone_uk unique(m_phone));

insert into member values('admin','1111','�̺���','99999-999999','����','010-3333-3333');
insert into member values('dolli','2222','�Ѹ�','901212-1566811','���ֱ����� �ϱ� ��ȭ���39���� 10','010-1111-1111');
insert into member values('mycall','3333','������','911222-1565811','���ֱ����� �ϱ� ÷�ܿ��ŷ�108���� 86','010-2222-2222');
insert into member values('chensy','1010','��ġ','921212-1568811','���ֱ����� �ϱ� �ϱ� �Ϲ����98���� 20','010-3333-3323');
insert into member values('1','5555','1','931201-1111111','���ֱ����� ���걸 ǳ���� 300','010-5555-5555');
insert into member values('jandongun','0000','�嵷��','941115-2566612','���ֱ����� ���� �ϳ���� 710���� 19','010-7777-3277');

commit;
 
 CREATE TABLE loan
   (l_loandate date ,
   l_returndate date ,
   l_isOverdue char(1) ,
   l_count number(3) not null,
   m_id VARCHAR2(10),
  b_isbn number(13),
   CONSTRAINT loan_m_id_fk foreign key(m_id) references member(m_id),
  CONSTRAINT loan_b_isbn_fk foreign key(b_isbn) references book(b_isbn));

insert into loan values('19/12/25', '20/01/14', 'n', 2, 'dolli', 9791162540640);
insert into loan values('20/01/04', '20/01/28', 'n', 1, 'dolli', 9791196797706);
insert into loan values('19/12/26', '20/01/15', 'y', 2, '1', 9788954655972);
insert into loan values('20/01/04', '20/01/28', 'n', 3, 'mycall', 9791187119845);  
insert into loan values('20/01/04', '20/01/28', 'n', 1, 'chensy', 9791157280293);
  
  
commit;


 CREATE TABLE genre
  ( g_genre VARCHAR2(20) not null,
   b_isbn number(13),
   CONSTRAINT genre_b_isbn_fk foreign key(b_isbn) references book(b_isbn));

insert into genre values ('�ϱ�',9791162540640);
insert into genre values ('��',9791196797706);
insert into genre values ('����',9788954655972);
insert into genre values ('�ڼ���',9791187119845);
insert into genre values ('����',9791157280293);
insert into genre values ('�Ҽ�', 9791159036514);
insert into genre values ('õ����', 9788983711892);
insert into genre values ('�ι�', 9788934972464);

commit;


 CREATE TABLE publisher
 ( p_publisher VARCHAR2(20) not null,
  b_isbn number(13),
  CONSTRAINT publisher_b_isbn_fk foreign key(b_isbn) references book(b_isbn));
    
insert into publisher values ('��',9791162540640);
insert into publisher values ('���Ѻ�',9791196797706);
insert into publisher values ('���е���',9788954655972);
insert into publisher values ('�����ǽ�',9791187119845);
insert into publisher values ('����',9791157280293);
insert into publisher values ('������', 9791159036514); 
insert into publisher values ('���̾𽺺Ͻ�', 9788983711892);  
insert into publisher values ('�迵��', 9788934972464);  
  
  commit;
  
  create table genreid
(g_genreid varchar2(10) not null,
constraint genreid_g_genreid_pk primary key(g_genreid));

insert into genreid
values ('000');
insert into genreid
values ('100');
insert into genreid
values ('200');
insert into genreid
values ('300');
insert into genreid
values ('400');
insert into genreid
values ('500');
insert into genreid
values ('600');
insert into genreid
values ('700');
insert into genreid
values ('800');
insert into genreid
values ('900');

alter table genre
add (g_genreid varchar2(10));

alter table genre
add constraint genre_g_genreid_fk foreign key(g_genreid) references genreid(g_genreid);

create table publisherid
(p_publisherid number(3) not null,
constraint publisherid_p_publisherid_pk primary key(p_publisherid));

alter table publisher
add (p_publisherid number(3));

alter table publisher
add constraint publisher_p_publisherid_fk foreign key(p_publisherid) references publisherid(p_publisherid);



