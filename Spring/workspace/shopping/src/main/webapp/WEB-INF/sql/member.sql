CREATE TABLE member(
id                             VARCHAR2(10)  NOT NULL  PRIMARY KEY,
passwd                         VARCHAR2(20)  NOT NULL,
mname                          VARCHAR2(20)  NOT NULL,
tel                            VARCHAR2(14)  NULL ,
email                          VARCHAR2(50)  NOT NULL UNIQUE,
zipcode                        VARCHAR2(7)      NULL ,
address1                       VARCHAR2(150)  NULL ,
address2                       VARCHAR2(50)  NULL ,
job                            VARCHAR2(20)  NOT NULL,
mdate                          DATE          NOT NULL,
fname                          VARCHAR2(50)  DEFAULT 'member.jpg'  NOT NULL,
grade                          VARCHAR2(1)  DEFAULT 'H'  NOT NULL
);
 
COMMENT ON TABLE member is '회원';
COMMENT ON COLUMN member.id is '아이디';
COMMENT ON COLUMN member.passwd is '비밀번호';
COMMENT ON COLUMN member.mname is '성명';
COMMENT ON COLUMN member.tel is '전화번호';
COMMENT ON COLUMN member.email is '이메일';
COMMENT ON COLUMN member.zipcode is '우편번호';
COMMENT ON COLUMN member.address1 is '주소';
COMMENT ON COLUMN member.address2 is '상세주소';
COMMENT ON COLUMN member.job is '직업';
COMMENT ON COLUMN member.mdate is '가입일';
COMMENT ON COLUMN member.fname is '회원사진';
COMMENT ON COLUMN member.grade is '회원등급';

--create 
INSERT INTO member(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('user1', '1234', '개발자1', '123-1234', 'email1@mail.com',  
'123-123','인천시', '남동구' ,'A01', sysdate, 'member.jpg', 'H'); 
 
INSERT INTO member(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('user2', '1234', '개발자2', '123-1234', 'email2@mail.com',  
'123-123','광명시','남동구' ,'A01', sysdate, 'man.jpg', 'H'); 
 
INSERT INTO member(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('user3', '1234', '개발자3', '123-1234', 'email3@mail.com',  
'123-123','용인시','남동구' ,'A01', sysdate, 'myface.jpg', 'H'); 
 
--관리자 계정
INSERT INTO member(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('admin', '1234', '관리자', '02-1234-1234', 'admin@mail.com',  
'123-123','서울시 서초구','남부터미널' ,'A01', sysdate, 'member.jpg', 'A');  
 
--중복 아이디 검사 관련 SQL 
-- 0: 중복 아님, 1: 중복  
SELECT COUNT(id)  
FROM member  
WHERE id='user1'; 
 
 
--이메일 중복 확인
SELECT COUNT(email) as cnt  
FROM member  
WHERE email='email3@mail.com'; 
 
 
--user1 회원 정보 보기 
SELECT id, passwd, mname, tel, email, zipcode, address1, address2, 
    job, mdate, fname, grade 
FROM member  
WHERE id='user1'; 
 
 
--회원 사진 이미지의 수정
UPDATE member 
SET fname='' 
WHERE id='user1'; 
 
 
--패스워드 변경
UPDATE member
SET passwd='1234'
WHERE id='';
 
 
--회원 정보 수정 
UPDATE member  
SET passwd='TEST',
tel='123-123', 
email='email10',
zipcode='TEST',  
    address1='수원', 
    address2='팔달구', 
    job='TEST'
WHERE id = 'user3'; 
 
 
--'user3' 회원 삭제 
DELETE FROM member WHERE id='user3';
 
 
--로그인 관련 SQL 
SELECT COUNT(id) as cnt 
FROM member 
WHERE id = 'user1' AND passwd = '1234';  
 
 
 
--list
SELECT id, mname, tel, email, zipcode, address1, address2,
fname,  r
from(
SELECT id, mname, tel, email, zipcode, address1, address2,
fname, rownum r
from(
SELECT id, mname, tel, email, zipcode, address1, 
address2, fname
FROM member
where mname like '%홍%'
ORDER BY mdate DESC 
)
)where r >= 1 and r <= 5


/**********************************/
/* Table Name: 상품분류 */
/**********************************/
CREATE TABLE category(
                cateno                                  NUMBER(10)     NOT NULL,
                catename                              VARCHAR2(50)     NOT NULL,
                categrpno                              NUMBER(10)      NULL,
        PRIMARY KEY (cateno),
        FOREIGN KEY (categrpno) REFERENCES category     
);
 
COMMENT ON TABLE category is '상품분류';
COMMENT ON COLUMN category.cateno is '분류번호';
COMMENT ON COLUMN category.catename is '분류명';
COMMENT ON COLUMN category.categrpno is '상위번호';

insert into category(cateno, catename, categrpno)
values((select nvl(max(cateno),0)+1 from category),
        'Jean', null);
insert into category(cateno, catename, categrpno)
values((select nvl(max(cateno),0)+1 from category),
        'Bag', null);
insert into category(cateno, catename, categrpno)
values((select nvl(max(cateno),0)+1 from category),
        'Shoes', null);
        
select cateno, catename
from category
where categrpno is null;
 
 
/**********************************/
/* Table Name: 컨텐츠 */
/**********************************/
CREATE TABLE contents(
                contentsno                            NUMBER(10)         NOT NULL    PRIMARY KEY,
                cateno                                  NUMBER(10)         NULL ,
                pname                                 VARCHAR2(50)       NOT NULL,
                price                                   NUMBER(10)           NOT NULL,
                filename                                VARCHAR2(100)     NULL ,
                detail                                  CLOB             NOT NULL,
                rdate                                   DATE             NOT NULL,
                stock                                   NUMBER(10)    DEFAULT 0      NOT NULL,
  FOREIGN KEY (cateno) REFERENCES category (cateno)
);
 
COMMENT ON TABLE contents is '컨텐츠';
COMMENT ON COLUMN contents.contentsno is '상품번호';
COMMENT ON COLUMN contents.cateno is '분류번호';
COMMENT ON COLUMN contents.pname is '상품명';
COMMENT ON COLUMN contents.price is '가격';
COMMENT ON COLUMN contents.filename is '상품이미지';
COMMENT ON COLUMN contents.detail is '상세내용';
COMMENT ON COLUMN contents.rdate is '등록일';
COMMENT ON COLUMN contents.stock is '재고량';

insert into contents(contentsno, cateno, pname, price, filename, detail, rdate, stock)
values((select nvl(max(contentsno),0)+1 from contents), 1, 'Ripped Skinny Jeans', 
50000, 'jean.jpg','찢어진 스키니 청바지 입니다.',sysdate,10);
 
select contentsno, cateno, pname, price, filename, detail, stock 
from contents 
where contentsno = 1;
 
update contents
set pname ='Ripped Skinny Jeans2',
    price = 55000,
    filename = 'jean1.jpg',
    detail = '청바지'
where contentsno = 1;
 
delete from contents
where contentsno = 1;
 
select contentsno, cateno, pname, price, filename, stock, r
from (
    select contentsno, cateno, pname, price, filename, stock, rownum r
    from(
        select contentsno, cateno,pname, price, filename, stock
        from contents
        order by contentsno desc
    )
)where r >= 1 and r <= 12;

select contentsno, cateno, pname, price, filename, stock,  r
from (
    select contentsno, cateno, pname, price, filename, stock, rownum r
    from(
        select contentsno, cateno,pname, price, filename, stock
        from contents
         
        where pname like '%Jean%'
 
          and cateno = 1
       
        order by contentsno desc
    )
 
)where r >= 1 and r <= 5





CREATE TABLE cart(
		cartno                        		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		ID                            		VARCHAR2(10)		 NULL ,
  FOREIGN KEY (ID) REFERENCES member (ID)
);

/**********************************/
/* Table Name: 주문 */
/**********************************/
CREATE TABLE orders(
orderno                        NUMBER(10)  NOT NULL  PRIMARY KEY,
id                             VARCHAR2(10)  NOT NULL,
contentsno                     NUMBER(10)  NULL ,
cartno                         NUMBER(10)  NULL ,
odate                          DATE  NOT NULL,
quantity                       NUMBER(10)  NOT NULL,
total                          NUMBER(10)  NOT NULL,
payment                        VARCHAR2(50)  NOT NULL,
mname                          VARCHAR2(20)  NOT NULL,
pname                          VARCHAR2(50)  NOT NULL,
  FOREIGN KEY (contentsno) REFERENCES contents (contentsno),
  FOREIGN KEY (cartno) REFERENCES cart (cartno)
);
 
insert into orders(
orderno, cartno, contentsno, odate, quantity, total, payment, id, mname, pname)
values((select nvl(max(orderno),0)+1 from orders),null,1,sysdate,1,90000,'신용카드',
'user1','홍길동','Mega Ripped Jeans');
 
insert into orders(
orderno, cartno, contentsno, odate, quantity, total, payment, id, mname, pname)
values((select nvl(max(orderno),0)+1 from orders),null,10,sysdate,1,33000,'신용카드',
'user1','홍길동','Crocodile bag');



select  m.id, m.mname, m.fname, m.zipcode, m.address1, m.address2,
         o.orderno,o.odate,o.pname,o.quantity,o.total,o.contentsno
 from  member m left outer join orders o
    on  m.id = o.id
where  m.id='user1';


