--system에 등록된 table 들 확인하기
-- 커서가 있는 곳의 sql문 실행 단축키는 : ctrl + enter
-- 
select * from tab;

--등록된 user(계정)들 확인
select username from dba_users; -- dba_users 테이블에서 username 이라는 컬럼만 확인하기

--dba_users 라는 테이블에는 어떤 컬럼이 있을까
desc dba_users; --기본 구조만 확인(데이터는 확인 x)
select username,account_status from dba_users; --계정과 lock 상태 알아보기

--scott 계정에 비번은 tiger 로 생성
create user scott IDENTIFIED by tiger; -- 오류 발생, 12버젼부터 오류

--12버젼부터는 user명에 공통문자열 c## 이 들어가야 된다
-- 일단 c##scott/ 비번은 tiger로 만들어보자
create user c##scott IDENTIFIED by tiger;

--c##scott 계정을 삭제 후 공통문자열을 안 넣고도 생성하는 방법으로 다시 생성
drop user c##scott;

alter SESSION set "_ORACLE_SCRIPT" = TRUE; --session 변경

--c## 빼고 다시 생성해보자
create user scott IDENTIFIED by tiger;

--angel/a1234 로 만들어보자
CREATE user angel IDENTIFIED by a1234;

select username,account_status from dba_users; --계정과 lock 상태 알아보기

--angel 계정에 lock 설정

alter user angel ACCOUNT lock;

--angel 계정 lock 설정해제

alter user angel ACCOUNT unlock;

-- scott와 angel 계정에 기본 권한을 주자

--connect : 접속할 수 있는 권한
--resource : 데이터 관리할 수 있는 권한
GRANT CONNECT,RESOURCE to angel;
GRANT CONNECT,RESOURCE to scott;

--생성된 계정에서 테이블을 생성하고 데이터 추가하려고 하면
-- table space에 대한 오류 발생

--table space를 unlimit 로 설정(system 계정에서만 할 수 있다)
alter USER angel DEFAULT TABLESPACE users QUOTA UNLIMITED on users;

alter USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED on users;

--angel 의 비번을 a1234 에서 pw1234 로 변경
alter user angel IDENTIFIED by pw1234;