    CREATE TABLE member
    (member_id varchar2(30) not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20) not null,
    member_socialNumber NUMBER(7) not null,
    member_address VARCHAR2(30) not null,
    member_phone varchar2(20) not null,
    CONSTRAINT member_member_id_pk primary key(member_id),
    CONSTRAINT member_member_socialNumber_uk unique(member_socialNumber),
  CONSTRAINT member_member_phone_uk unique(member_phone));
  
  commit;
  
      CREATE TABLE book
    (book_loan date,
    book_return date,
    book_title varchar2(100) not null,
    book_id VARCHAR2(30) not null,
    book_author VARCHAR2(30) not null,
    book_publisher VARCHAR2(30) not null,
    member_id VARCHAR2(30),
    CONSTRAINT book_book_id_pk primary key(book_id),
   CONSTRAINT book_member_id_uk unique(member_id),
  CONSTRAINT book_member_id_fk foreign key(member_id) references member(member_id));
  
  commit;