-- 시퀀스를 생성해보자
Create SEQUENCE seq1; --1부터 1씩 자동증가하는 시퀀스객체가 생성
Create SEQUENCE seq2 start WITH 1 INCREMENT by 1;-- 위와 같다
Create SEQUENCE seq3 start WITH 1 INCREMENT by 1 NOCACHE;-- 위와 같으나 캐시 사이즈를 20으로 변경
Create SEQUENCE seq4 start WITH 1 INCREMENT by 1 maxvalue 100 nocache;--max 값을 100까지만 
Create SEQUENCE seq5 start WITH 5 INCREMENT by 5 NOCACHE;
--시퀀스 전체 정보를 출력
select * from seq;

--시퀀스 값을 발생시켜보자 - 한 번 발생한 값들은 두 번 다시 안 나온다
select seq1.nextval,seq2.nextval,seq3.nextval,seq4.nextval from dual;

DELETE FROM SEQUENCE;

--시퀀스 제거
drop SEQUENCE seq1;
drop SEQUENCE seq2;
drop SEQUENCE seq3;
drop SEQUENCE seq4;
drop SEQUENCE seq5;
DROP SEQUENCE SEQ_FOOD;

--table 생성
create table test1(
    num number(3) primary key,
    Name varchar2(20) not null,
    Today Date);
    
--구조 확인
desc TEST1;

--데이터를 추가
INSERT INTO TEST1 VALUES (1,'CANDY',SYSDATE); --컬럼명 생략시 모든 컬럼을 순서대로 값을 넣는다

--primary key 에 같은 값을 넣었을 경우 어떤 오류가 나는지?
INSERT INTO TEST1 VALUES (1,'MIRA',SYSDATE); 
-- 오류 보고 : ORA-00001: 무결성 제약 조건(ANGEL.SYS_C008318)에 위배됩니다


-- 이번에는 이름을 빼고 넣어서 확인해보자
INSERT INTO TEST1 (NUM,TODAY) VALUES(2,SYSDATE);
-- 오류 보고 : ORA-01400: NULL을 ("ANGEL"."TEST1"."NAME") 안에 삽입할 수 없습니다

--이번에는 전체 데이터를 넣는데 순서를 바꿔서 넣어보자
insert into test1 (num,today,name) values (2,'2024-11-20','MIRA');

--insert 를 2개 추가한 상태에서 ROLLBACK 해보자
ROLLBACK;

--다시 위의 insert 문 실행 후 넣어보자. 넣은 후 commit 하기
commit;
--commit 을 한 후에 rollback 해도 취소 X
rollback;


--데이터 확인
select * from test1;

--test2는 test1과 같은데 제약조건이름을 추가해서 생성
create table test2(
    num NUMBER(3) CONSTRAINT PK_TEST2_NUM primary key,
    name varchar(20) constraint NN_TEST2_NAME not null,
    TODAY DATE);
    
--오류 발생을 시켜보자
INSERT INTO TEST2 VALUES(1, '이영자',SYSDATE); --추가됨
INSERT INTO TEST2 VALUES(1, '김말자',SYSDATE);
-- 오류 보고 : ORA-00001: 무결성 제약 조건(ANGEL.PK_TEST2_NUM)에 위배됩니다

select * from TEST2;

--테이블에 구조변경, ALTER TABLE
--컬럼 추가 : ADD, 컬럼 삭제 : DROP COLUMN, 컬럼 수정 : MODIFY ,컬럼명 변경 : RENAME COLUMN

--TEST1에 AGE number(3) 컬럼 추가하기
ALTER TABLE TEST1 ADD AGE NUMBER(3);


--TEST1에 ADDR VARCHAR2(30) 추가하는데 기본값을 SEOUL로 주고싶다
ALTER TABLE TEST1 ADD ADDR VARCHAR2(30) DEFAULT 'SEOUL';

--TEST1 에 GAIPDAY DATE 으로 추가하는데 기본값을 현재날짜로
ALTER TABLE TEST1 ADD GAIPDAY DATE DEFAULT SYSDATE;

--TEST1의 TODAY 컬럼 삭제
ALTER TABLE TEST1 DROP COLUMN TODAY;

--TEST1의 NAME을 20에서 30으로 수정해보자
ALTER TABLE TEST1 MODIFY NAME VARCHAR2(30);

--TEST1 의 ADDR 을 ADDRESS 로 컬럼명 변경
ALTER TABLE TEST1 RENAME COLUMN ADDR TO ADDRESS;

--TEST1 의 GAIPDAY를 WRITEAY로 컬럼명 변경
ALTER TABLE TEST1 RENAME COLUMN GAIPDAY TO WRITEDAY;

--TEST1의 제약조건 중 SYS_C008317을 제거해보자
ALTER TABLE TEST1 DROP CONSTRAINT SYS_C008317;

--TEST1의 제약조건을 추가하는데 AGE의 나이범위가 10 ->30으로, 제약조건명 : CK_TEST1_AGE
ALTER TABLE TEST1 ADD CONSTRAINT CK_TEST1_AGE CHECK( AGE>=10 AND AGE<=30);

--AGE 에 범위를 벗어나게 추가해서 오류 확인
INSERT INTO TEST1(NUM,NAME,AGE) VALUES(3,'SON',34);
--오류보고:ORA-02290: 체크 제약조건(ANGEL.CK_TEST1_AGE)이 위배되었습니다

--5분 문제
--TEST2 에 BLOOD VARCHAR2(10) 초기값은 A로 추가하기
ALTER TABLE TEST2 ADD BLOOD VARCHAR2(10) default 'A';
--TEST2에서 TODAY 컬럼 제거하기
ALTER TABLE TEST2 DROP COLUMN TODAY;
--TEST2의 NAME을 SAWON_NAME으로 컬럼 이름 변경
ALTER TABLE TEST2 RENAME COLUMN NAME TO SAWON_NAME;

--4. BLOOD 에 제약조건 추가(A,B,O,AB 만 가능하도록 CHECK) CK_TEST2_BLOOD
ALTER TABLE TEST2 ADD CONSTRAINT CK_TEST2_BLOOD CHECK(BLOOD IN('A','B','O','AB'));
--5. NN_TEST2_NAME 이라는 제약조건 제거
ALTER TABLE TEST2 DROP CONSTRAINT NN_TEST2_NAME;

--연습용 테이블 제거하기
DROP TABLE TEST1;
DROP TABLE TEST2;
----------------------------------------------------------
--시퀀스 생성
CREATE SEQUENCE SEQ1 NOCACHE;-- 1부터 1씩 증가하는 CACHE가 없는 시퀀스 생성
--테이블 생성
CREATE TABLE SAWON (
    NUM NUMBER(3) CONSTRAINT PK_SAWON_NUM PRIMARY KEY,
    NAME VARCHAR2(20),
    BUSEO VARCHAR2(20),
    GENDER VARCHAR2(10) DEFAULT '남자',
    AGE NUMBER(3),
    HEIGHT NUMBER(1,1),
    WRITEDAY DATE);
    
-- 제약조건 추가 : 부서명 "'홍보부','교육부','관리부'"만 가능하다 CK_SAWON_BUSEO
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_BUSEO CHECK(BUSEO IN('홍보부','교육부','관리부'));


-- 제약조건 추가 : 성별은 '남자','여자'만 가능하다 CK_SAWON_BUSEO
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_GENDER CHECK(GENDER IN ('남자','여자'));


--데이터 추가
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL,'이진','홍보부','여자',29,167.9,SYSDATE);
INSERT INTO SAWON (NUM,NAME,BUSEO,AGE) VALUES (SEQ1.NEXTVAL,'강호동','관리부',35);
INSERT INTO SAWON (NUM,NAME,BUSEO,height) VALUES (SEQ1.NEXTVAL,'유재석','홍보부',179.4);
COMMIT;

--UPDATE 수정
UPDATE SAWON SET HEIGHT = 186.5; --만약 WHERE 조건 안 쓰면 전체 데이터가 수정
--다시 취소
ROLLBACK;
--NUM=3인 경우만 수정
UPDATE SAWON SET HEIGHT = 186.4 WHERE NUM =7;
--여러 컬럼 수정
UPDATE SAWON SET BUSEO ='홍보부', AGE=39,HEIGHT=152.1 WHERE NAME = '이진';
--WRITEDAY 가 NULL 일 경우 '2024-12-12' 로 변경을 해보자
UPDATE SAWON SET WRITEDAY = '2024-12-12' WHERE WRITEDAY IS NULL;

COMMIT;

--삭제 DELETE FROM 테이블명;
DELETE FROM SAWON; --WHERE 조건 안 쓰면 전체 데이타 삭제
ROLLBACK;

--AGE 가 NULL 인 데이터는 모두 삭제
DELETE FROM SAWON WHERE AGE IS NULL;

--GROUP BY 연습
--부서별 인원 수와 평균 나이를 구하시오
SELECT BUSEO,COUNT(*),AVG(AGE) FROM SAWON GROUP BY BUSEO;
--성별 인원 수와 평균 나이를 구하시오
SELECT GENDER,COUNT(*),AVG(AGE) FROM SAWON GROUP BY GENDER;

--JOIN 연습용 테이블 생성하기
CREATE TABLE FOOD(
    FOODNUM NUMBER(3) PRIMARY KEY,
    FOODNAME VARCHAR2(20),
    FOODPRICE NUMBER(7),
    FOODSIZE VARCHAR2(20));
    
CREATE TABLE BOOKING(
    BNUM NUMBER(3) CONSTRAINT PK_BOOKING_BNUM PRIMARY KEY,
    BNAME VARCHAR2(20) CONSTRAINT NN_BOOKING_BNAME NOT NULL,
    BHP VARCHAR2(20) CONSTRAINT UQ_BOOKING_BHP UNIQUE,
    FOODNUM NUMBER(3),
    BOOKINGDAY DATE,
    CONSTRAINT FK_FOODNUM FOREIGN KEY(FOODNUM) REFERENCES FOOD(FOODNUM));
    
--메뉴 등록
INSERT INTO FOOD VALUES (100,'짜장면',9000,'보통');
INSERT INTO FOOD VALUES (101,'짬뽕',10000,'보통');
INSERT INTO FOOD VALUES (200,'짜장면',11000,'곱배기');
INSERT INTO FOOD VALUES (201,'짬뽕',12000,'곱배기');
INSERT INTO FOOD VALUES (300,'탕수육',15000,'보통');
INSERT INTO FOOD VALUES (301,'탕수육',17000,'곱배기');
INSERT INTO FOOD VALUES (400,'칠리새우',25000,'소');
INSERT INTO FOOD VALUES (401,'칠리새우',30000,'대');
COMMIT;
SELECT * FROM FOOD ORDER BY FOODNUM;

--시퀀스 생성
CREATE SEQUENCE SEQ_FOOD START WITH 10 INCREMENT BY 10 NOCACHE;

--예약
INSERT INTO BOOKING VALUES(SEQ_FOOD.NEXTVAL,'이영자','010-1234-5689',200,'2024-12-24');
INSERT INTO BOOKING VALUES(SEQ_FOOD.NEXTVAL,'이영애','010-1234-5698',201,'2024-12-23');
INSERT INTO BOOKING VALUES(SEQ_FOOD.NEXTVAL,'이영호','010-2134-5689',401,'2024-12-25');
INSERT INTO BOOKING VALUES(SEQ_FOOD.NEXTVAL,'이영자','010-1267-5689',203,'2024-12-24');
--오류 보고 : ORA-02291: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 부모 키가 없습니다
COMMIT;

--INNER JOIN 으로 예약 손님의 주문정보 확인
SELECT
    BNAME,BHP,FOODNAME,FOODPRICE,FOODSIZE,TO_CHAR(BOOKINGDAY,'YYYY-MM-DD')BOOKINGDAY
FROM FOOD F,BOOKING B
WHERE F.FOODNUM=B.FOODNUM;

--OUTER JOIN 으로 한 번도 예약하지 않은 메뉴 조회
SELECT
    F.FOODNUM,BNAME,FOODNAME,FOODPRICE,FOODSIZE
FROM FOOD F,BOOKING B
WHERE F.FOODNUM=B.FOODNUM(+);-- 이 때 아무도 주문하지 않은 메뉴는 주문자가 NULL 로 조회

--위의 SQL문을 이용해서 주문자 이름을 빼고 NULL 인 경우만 출력하면 아무도 주문하지 않은 메뉴 조회 가능
SELECT
    F.FOODNUM,FOODNAME,FOODPRICE,FOODSIZE
FROM FOOD F,BOOKING B
WHERE F.FOODNUM=B.FOODNUM(+)AND BNAME IS NULL;

--BOOKING(자식테이블) 에 추가된 메뉴를 FOOD(부모테이블)에서 삭제할 수 있을까?
--자식 테이블 생성 시 ON DELETE CASCADE 설정을 안했을 경우 못 지운다
DELETE FROM FOOD WHERE FOODNUM =200; -- 200번 메뉴는 이영자가 주문했기에 안 지워짐

DELETE FROM FOOD WHERE FOODNUM = 300; 

DROP TABLE FOOD; -- 자식테이블 먼저 삭제하는 거 아닌 이상 삭제 안됨

--booking 먼저 제거 후 food 제거 -외부 키로 서로 연결되어 있으므로

drop table BOOKING;
drop table food;

--sawon  테이블도 일단 삭제
drop table sawon;


COMMIT;