--emp 테이블로 연습
--job 컬럼의 데이터 중 중복되는 테이터는 한번만 출력해보자
select DISTINCT job from emp;
select DISTINCT job,ename from emp; -- 다른 컬럼하고 같이 쓸 경우 적용 x, 또는 오류
select * from emp; -- 전체 컬럼 조회
select ename, job from emp;
select ename, job from emp order by ename; -- ename 의 오름차순 조회(asc 인 경우는 생략)
select ename, job from emp order by ename desc; -- ename의 내림차순 조회(desc 인 경우는 생략 X)

--job 의 오름차순 , 같은 job 일 경우 ename 의 내림차순 조회
select job, ename from emp order by  job,ename desc;
--job의 오름차순, 같은 job 일 경우 ename 도 오름차순조회
select job, ename from emp order by  job,ename;

--순서를 정할 때 컬럼명 대신 컬럼번호로 해도 된다(첫번째 컬럼은 1)
select job, ename from emp order by  1,2; --job(1),ename(2)

--sall 의 오름차순 정렬
select * from emp order by 6;

--empno 의 오름차순 조회
select ename,sal,comm,job,empno from emp order by 5;

--ename 의 내림차순
select ename,sal,comm,job,empno from emp order by 1 desc;

--where 조건문
select ename,job,sal,comm from emp where sal>=1500;
select ename,job,sal,comm from emp where ename='allen'; -- 데이터는 대소문자 정확하게 합시다
select ename,job,sal,comm from emp where ename='ALLEN';

-- ENAME 이 A로 시작하는 데이터를 조회하고 싶어
select ename,job,sal,comm from emp where ename LIKE 'A%';
-- ENAME 에 A가 포함되는 데이터를 조회하고 싶어
select ename,job,sal,comm from emp where ename LIKE '%A%';
-- ENAME 에 A로 시작하거나 S로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename LIKE 'A%' or ename LIKE 'S%';
--ENAME 에 A와 S를 모두 포함하는 데이터 조회
select ename,job,sal,comm from emp where ename LIKE '%A%' and ename LIKE '%S%';

--ENAME 의 두 번째 글자가 A인 사람만 조회하고 싶어
select ename,job,sal,comm from emp where ename LIKE '_A%';
--ENAME 의 세 번째 글자가 A인 사람만 조회하고 싶어
select ename,job,sal,comm from emp where ename LIKE '__A%';
--ENAME 의 두 번째 글자나 세 번째 글자가 A인 사람만 조회하고 싶어
select ename,job,sal,comm from emp where ename LIKE '__A%' or ename LIKE '_A%';
--ENAME 의 두 번째 글자나 세 번째 글자가 A인 사람만 조회하고 싶어(여기에 오름차순 추가)
select ename,job,sal,comm from emp where ename LIKE '__A%' or ename LIKE '_A%' ORDER by ename;

--ENAME 이 n이나 k로 끝나는 사람 조회
select ename,job,sal,comm from emp where ename like '%N' or ename like '%K';

--job 이 ANALYST 이면서 SAL 이 1500 이상인 사람 조회
select ename,job,sal,comm from emp where job = 'ANALYST' and SAL>=1500;

--SAL 이 1200~2000 사이값 조회
select ename,job,sal,comm from emp where SAL>=1200 and SAL<=2000; --방법 1
select ename,job,sal,comm from emp where SAL BETWEEN 1200 and 2000 order by sal desc; --방법 2

-- job 이 manager,salesman, analyst 이 3가지 직업의 사람을 조회
--방법 1
select ename,job,sal,comm from emp where job = 'MANAGER' OR job ='SALESMAN' OR job ='ANALYST';
--방법 2
select ename,job,sal,comm from emp where job in ('MANAGER','SALESMAN','ANALYST');

--EMPNO 7654,7788,7844,7902 인 사람 조회
select empno,ename,job,sal,comm from emp where empno in(7654,7788,7844,7902);

--comm 이 null 인 데이터만 조회
select ename,job,sal,comm from emp where COMM is null;

--comm 이 null 이 아닌 데이터만 조회
select ename,job,sal,comm from emp where COMM is not null;

--mgr이 null 아닌경우만 조회
select * from emp where mgr is not null;

--comm 이 null 인 경우는 0으로 출력
select ename,job,sal,NVL(mgr,111111),NVL(comm,0) from emp;

select sal,comm,sal+comm from emp; -- comm이 null 일경우 sal+comm 도 null
-- 위의 경우 sal+comm 이 경우 comm이 null 이면 0으로 계산
select sal,comm,NVL(sal+comm,0) from emp;

--컬럼 제목에 별칭 주기(alias)
select ename as "사원명",sal as "월급여" from emp; --생략없이 alias 지정하는 방법
select ename "사원명",sal "월급여" from emp; -- as 생략 alias 지정하는 법
select ename 사원명,sal 월급여 from emp; --alias 에 공백이 없으면 ""도 생략 가능 ok?
select ename "사원 이름",sal "월 급여" from emp; -- alias 에 공백이 있다? "" 없으면 오류나요

--총 레코드 갯수(데이터 갯수)
select count(*) from emp; -- 이 경우는 컬럼명이 count(*)
select count(*) count from emp; -- 이 경우는 컬럼명이 count
select count(*) 총갯수 from emp; -- 이 경우는 컬럼명이 총갯수

select sal,comm,NVL(sal+comm,0)sum from emp;
--sal,comm,NVL(sal+comm,0) 열의 컬럼명은 sum으로 변경
select sal 월급여,comm 커미션,NVL(sal+comm,0)총금액 from emp;
--컬럼명이 다 한글로

--문자열을 컬럼에 추가시 || 연산자 사용
select '내이름' ||ename||'입니다' 자기소개 from emp;

-- 내 직업은 salesman 이고 내 월 급여는 1600입니다 라고 컬럼명 "자기소개" 에 나오도록
select '내 직업은'||job||'이고 내 월 급여는'||sal||'입니다' 자기소개 from emp;

--sal 이 1500~2000 사이가 아닌 경우만 조회
select * from emp where sal not between 1500 and 2000;
--not in 을 사용하여 job 이 salesman, clerk 가 아닌경우
select * from emp where job not in ('SALESMAN','CLERK');

--group 함수(count,sum,avg,max,min)
select count(*) from emp; --전체 데이터 수
select sum(sal) from emp; -- sal의 총 합계
select avg(sal) from emp; -- sal의 평균(소숫점 이하가 너무 많이 나옴)
select round(avg(sal),2) from emp; --
--round:소숫점 반올림함수
--sal의 평균을 구하는데 소숫점 이하 2자리로 구한다
select max(sal) from emp; --최고 급여액수
select min(sal) from emp; --최저 급여액수

--평균급여보다 sal 이 더 높은 사람을 조회하시오
select ename,sal from emp where sal>(select round(avg(sal),2)from emp);

--scott의 직업과 같은 직업을 가진 사람을 조회
select * from emp where job=(select job from emp where ename = 'SCOTT');

--scott의 mgr 과 같은 mgr을 가진 사람 조회
select * from emp where mgr = (select mgr from emp where ename = 'SCOTT');

--Group By
select job from emp GROUP by JOB; -- JOB이 그룹별로 나열

--job의 Group 별로 인원수를 구해보자
select job,count(*) from emp GROUP by job;

--제목에 별칭을 부여하고 싶다면
select job 직업,count(*) 인원수 from emp GROUP by job;

--job의 group 별로 인원 수를 구해보자(인원이 3명이상인 경우만 조회) - 인원순으로
select job 직업,count(*) 인원수 from emp GROUP by job having count(job)>=3 order by count(*);
select job 직업,count(*) 인원수 from emp GROUP by job having count(job)>=3 order by 2;

--직업별 인원수, 최저연봉, 최고연봉, 평균연봉(소숫점이하없이) 을 구하시오
select job 직업, count(*) 인원수,min(sal)최저연봉,max(sal)최고연봉,
round(avg(sal),0)평균연봉 from emp group by job order by 1;

--오라클 sql 기초 ppt . p48 숫자함수
select abs(-5),abs(5) from dual; -- 절대값 출력(결과값: 5,5)
--round 반올림, ceil 올림, floor(내림)
select round(3.6,0),ceil(3.6), floor(3.6) from dual;
select round(3.4,0),ceil(3.4), floor(3.4) from dual;
select round(328947,-5) from dual; -- -가 붙으면 정수값으로 변한다

select round(avg(sal),0),ceil(avg(sal)),floor(avg(sal)) from emp;

--power(M,N) : M의N승값을 구함
--MOD(m,n): M을 n으로 나눈 나머지
select power(3,3), mod(10,3) from dual;

--문자함수 CONCAT(두문자더하기), LOWER(소문자), UPPER(대문자), INITCAP(첫글자만대문자)
select ename,concat(ename,'님'),Lower(Ename),upper(ENAME),initcap(Ename) from emp;

select Lpad(sal,10,'*') from emp; --총 10자리의 남는 부분을 * 채움(왼쪽부터 채움)
select rpad(sal,10,'*') from emp; --총 10자리의 남는 부분을 * 채움(오른쪽부터채움)

select substr('HAPPY DAY',7,3) from dual; --7번 글자부터 3글자 추출
select substr('HAPPY DAY',-6,3) from dual; --뒤에서부터 6번째글자부터 3글자 추출

--emp table의 ename에서 왼쪽에서 3글자를 추출 후 총 7자리 중 우축 빈공간은 *로 채워서 출력
select Rpad((substr(ename,1,3)),7,'*')from emp;

--length 길이구하기
select ename 이름,length(ename) 문자길이 from emp;

--replace - happy를 good으로 변경
select replace('Happy Day','Happy','good') from dual;

--TRIM : 앞뒤 공백제거
select '*'||'  LEE SU JI  '||'*' from dual; 
select '*'||trim(' Lee Su Ji  ')||'*' from dual; -- 앞뒤 공백 제거됨

-- 일단 현재 날짜를 나타내는 sysdate
select sysdate from dual; -- 현재 날짜
select sysdate+7 from dual;
select sysdate+1 from dual;

--to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자
select to_char(sysdate,'yyyy-mm-dd') from dual;
--mm:월 mi:분 hh:12시간표시 am 또는 pm : 오전이나 오후 표시
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual;

select to_char(sysdate,'yyyy-mm-dd  hh24:mi') from dual;

select to_char(sysdate,'month') from dual; --12월(지역화에 따라 다르게 나오므로 잘 사용안함)

--현재년도 4자리만 추출
select to_char(sysdate,'yyyy')from dual;

--현재 월 추출
select to_char(sysdate,'mm') from dual;
select to_char(to_date('2024-5-10'),'mm') from dual;

--emp 의 hiredate 는 날짜타입
select to_char(hiredate, 'yyyy-mm-dd') 입사일 from emp;