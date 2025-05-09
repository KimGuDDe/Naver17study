--join table 연습 - on delete caScade 로 자식 테이블 생성

--부모 테이블 shop을 만들어보자 - 상품을 등록하는 테이블
CREATE TABLE SHOP(
    SANGCODE VARCHAR2(10) CONSTRAINT PK_SHOP_SANGPUM PRIMARY KEY,
    SANGNAME VARCHAR2(30),
    SANGPRICE NUMBER(7));
    
--SHOP 의 상품코드를 참조해서 CART 에 담을 수 있도록 테이블을 생성
--상품을 지우면 CART 의 데이터도 자동으로 지워지도록 ON DELETE CASCADE 를 설정해서 생성

CREATE TABLE CART(
    CARTNUM NUMBER(3) CONSTRAINT PK_CART_CARTNUM PRIMARY KEY,
    SANGCODE VARCHAR2(10),
    CNTNUM NUMBER(3) DEFAULT 1,
    CARTDAY DATE,
    CONSTRAINT FK_CART_SANGCODE FOREIGN KEY(SANGCODE) REFERENCES SHOP(SANGCODE) ON DELETE CASCADE);
    
--CART 에 들어갈 시퀀스 생성
CREATE SEQUENCE SEQCART NOCACHE;

--상품등록을 하자
INSERT INTO SHOP VALUES('A100','체크블라우스',23000);
INSERT INTO SHOP VALUES('A200','브이넥티셔츠',19000);
INSERT INTO SHOP VALUES('A300','레이스블라우스',34000);
INSERT INTO SHOP VALUES('A400','블랙진바지',56000);
INSERT INTO SHOP VALUES('A500','실크스카프',12000);
INSERT INTO SHOP VALUES('A600','인견자켓',59000);
INSERT INTO SHOP VALUES('A700','롱오리털코트',123000);
INSERT INTO SHOP VALUES('A800','체크티셔츠',35000);
INSERT INTO SHOP VALUES('A900','실크블라우스',89000);

COMMIT;
SELECT * FROM SHOP;

--CART 에 원하는 상품을 담아보자
INSERT INTO cart (CARTNUM,SANGCODE, CARTDAY) VALUES(SEQCART.NEXTVAL,'A500',SYSDATE);
INSERT INTO cart (CARTNUM,SANGCODE, CARTDAY) VALUES(SEQCART.NEXTVAL,'A700',SYSDATE);
INSERT INTO cart (CARTNUM,SANGCODE,CNTNUM, CARTDAY) VALUES(SEQCART.NEXTVAL,'A800',3,SYSDATE);
INSERT INTO cart (CARTNUM,SANGCODE,CNTNUM, CARTDAY) VALUES(SEQCART.NEXTVAL,'A100',2,SYSDATE);
INSERT INTO cart (CARTNUM,SANGCODE,CNTNUM, CARTDAY) VALUES(SEQCART.NEXTVAL,'A500',1,SYSDATE);
INSERT INTO cart (CARTNUM,SANGCODE,CNTNUM, CARTDAY) VALUES(SEQCART.NEXTVAL,'A400',2,SYSDATE);
COMMIT;
SELECT * FROM CART;

--JOIN SQL 문을 이용해서 다음 순서로 출력
--CARTNUM,SANGCODE,SANGNAME,SANGPRICE,CNTNUM,CARTDAY(YYYY-MM-DD HH:MM)
select
    c.cartnum,s.sangcode, S.SANGNAME, S.SANGPRICE,c.cntnum,
    TO_CHAR(CARTDAY,'YYYY-MM-DD HH24:MI') CARTDAY
from shop s, cart c
where s.sangcode = c.sangcode;

--OUTER JOIN 을 이용해서 아무도 카트에 담지 않은 상품을 알아보자
select
    c.cartnum,s.sangcode, S.SANGNAME, S.SANGPRICE,c.cntnum,
    TO_CHAR(CARTDAY,'YYYY-MM-DD HH24:MI') CARTDAY
from shop s, cart c
where s.sangcode = c.sangcode(+) AND CARTNUM IN NULL;

-- ON DELETE CASCADE 로 생성한 경우 카트에 담긴 데이터도 부모테이블인 SHOP에서 삭제가 가능하다
-- 이 때 상품 삭제 시 카트에 담긴 상품은 자동 삭제

-- SHOP에서 A500을 제거해보자(카트에 2개가 담겨있음)
DELETE FROM SHOP WHERE SANGCODE = 'A500';

--다시 JOIN으로 CART 확인
select
    c.cartnum,s.sangcode, S.SANGNAME, S.SANGPRICE,c.cntnum,
    TO_CHAR(CARTDAY,'YYYY-MM-DD HH24:MI') CARTDAY
from shop s, cart c
where s.sangcode = c.sangcode;

