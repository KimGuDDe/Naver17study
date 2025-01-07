-- cmd창에서 접속시
-- mysql -u root -p 엔터 누른 후
-- 비번 1234 입력후 엔터로 접속
show databases; -- databases 전체 종류
-- 연습용 databases study502 생성하기
create database study502;

-- cmd 창에서 접속한 경우 use databases 명으로 이동한다

-- databases 제거
-- 연습용 생성 후 제거해보기
create database test; -- 생성
drop database test;-- 제거
show databases;-- 확인
