-- 전체 table 확인하기
show tables;
-- 현재날짜와 시간 구하기 (모두 같은 결과)
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜함수들(2025-01-02 기준)
select year(now()) from dual; -- year(날짜) : 2025 (년도를 숫자로 반환해준다)
select month(now()) from dual;-- month(날짜) : 1 (월을 숫자로 반환해준다)
select day(now()) from dual;-- day(날짜) : 2 (일을 숫자로 반환해준다)
select dayofmonth(now()) from dual; -- dayofmonth(날짜) : 2 (일을 숫자로 반환해준다)
select monthname(now()) from dual; -- 현재 월을 영어로
select dayname(now()) from dual; -- 현재 일을 영어로

-- date_format(날짜,'형식') -> 오라클의 to_char 와 같다
-- %Y = (년도 4자리),%y(소문자 y는 년도 2자리만) %M(월을 영어로), %d(날짜)
select date_format(now(),'%Y-%M-%d') from dual;
-- '2025-January-02'(결과값)
select date_format(now(),'%y-%M-%d') from dual;
-- '25-January-02'(결과값)
select date_format(now(),'%y-%M-%d  %H:%i') from dual;
-- '25-January-02  15:02'(결과값)
select date_format(now(),'%y-%M-%d %h:%i') from dual;
-- '25-January-02 03:03'(결과값)
select date_format(now(),'%y-%M-%d  %H시:%i분') from dual;
-- '25-January-02  15시:04분'

-- 문자함수들
-- concat(a,b) : 문자열 결합 ,여러 개 가능만 가능(오라클은 2개만 가능)
select concat('happy','day') from dual;
select concat('happy','day','after','tomorrow') from dual;
-- replace('문자열','기존문자열','새로운 문자열') : 문자열 변경
select replace('bitcamp', 'bit', '비트')from dual;
-- instr('문자열','찾는문자열'):위치 반환
select instr('김희영희문','영희') from dual; -- 2(2번쨰에 있다는 뜻)
select instr('김영희','철수') from dual; -- 0(0은 없다는 뜻)
-- left('문자열',갯수) : 왼쪽에서 추출
-- right('문자열',갯수) : 오른쪽에서 추출
-- mid('문자열',시작위치,갯수) : 시작위치부터 갯수만큼 추출
-- substring('문자열',시작위치,갯수) : 시작위치부터 갯수만큼 추출
select left('have a nice day',4) from dual; -- have
select right('have a nice day',4) from dual; -- day
select mid('have a nice day',8,4) from dual; -- nice
select substring('have a nice day',8,4) from dual; -- nice

-- ltrim,rtrim,trim(왼쪽만 공백제거, 오른쪽만 공백제거,공백 다 제거)
select concat('*',ltrim('    happy     '),'*') from dual; -- '*happy     *'
select concat('*',rtrim('    happy     '),'*') from dual; -- '*    happy*'
select concat('*',trim('    happy     '),'*') from dual; -- '*happy*'

-- lower,lcase : 소문자 변환,
-- upper,ucase : 대문자 변환
select lower('HapPy DaAy HahahaA') from dual;
select lcase('HapPy DaAy HahahaA') from dual;
select upper('HapPy DaAy HahahaA') from dual;
select ucase('HapPy DaAy HahahaA') from dual;
select reverse('HapPy DaAy HahahaA') from dual;

-- 조건함수
-- if(조건식,참일때값,거짓일때 값)
select if(100>200,'맞음','틀림') from dual;
select if(100>200,'맞음','틀림') result from dual; -- 컬럼 제목 변경

-- ifnull(컬럼값, null일 때의 대치값)
select ifnull(null,1) from dual; -- 1
select ifnull('ny',1) from dual;

-- 숫자함수
-- abs : 절대값
select abs(6),abs(-6) from dual;
-- ceiling : 무조건 올림, floor : 무조건 내림
select ceiling(3.2),floor(3.2) from dual;
select ceiling(3.9),floor(3.9) from dual;
-- 반올림
select round(3.16,1) from dual;
select round(2545336,-4) from dual;

-- pow : 지수승, mod : 나머지
select pow(2,3), mod(10,3) from dual ; -- 2의 3승과 10 나누기 3의 나머지는?

-- greatest(숫자1,숫자2,............) 가장 큰 숫자 (오라클도 있다)
-- least(숫자1, 숫자2,............)가장 작은 숫자 (오라클도 있다)
select greatest(100,432,325464,23,2346,12314) from dual;
select least(100,432,325464,23,2346,12314) from dual;

-- 데이타타입
   -- 문자 : char,varchar
--    숫자 :  tinyint  1 byte
--           smallint  2byte
--           mediumint 3byte
--           int       4byte
--           bigint    8byte
--           float     실수타입 4byte
--           double      "      8byte
--           decimal(m,n) : m자리수,n소숫점자릿수
-- 	날짜 :    date   CCYY-MM-DD  :now() 로 저장한다해도 날짜만 저장된다
--           datetime   CCYY-MM-DD hh:mm:ss : now() 로 저장하면 날짜와 시간이저장된다
--           timestamp     "
--           time          hh:mm:ss
--           year        CCYY 또는 YY

create table person(
	num smallint auto_increment primary key,
    name varchar(20),
    blood varchar(10) default 'B',
    age smallint,
    today date,
    writeday datetime);
    
    -- table 구조 확인
    desc person;
    show create table person; -- desc 보다 디테일한 구조로 확인
    
-- 데이터 추가하기
insert into person(name,age,today,writeday) value ('장원영',23,now(),now());    
-- 모든 컬럼명 생략하고 순서대로 넣기 - num은 시퀀스 컬럼이라 null로 줘도 숫자로 변환
insert into person values ( null,'나띠','A',25,now(),now());
insert into person values ( null,'안유진','O',26,now(),now());
insert into person values ( null,'고민시','A',21,now(),now());
insert into person values ( null,'현우진','AB',30,now(),now());
insert into person values ( null,'손예진','A',32,now(),now());

-- 각종 조회 연습
select num,name,age from person order by age asc;
select num,name,age from person order by age desc;
select * from person where age>=25 and age<=30;
select * from person where age between 25 and 30;
select * from person where blood='A' or blood= 'O' or blood='AB';
select * from person where blood in ('A','O','AB');
select * from person where name like "나%";
select * from person where name like "%우%";
select * from person where name like "_민%";

-- 그룹함수 : count, avg, sum, max, min
select count(*) from person; -- 총갯수
select avg(age) from person; -- 평균나이
select round(avg(age),0) from person; -- 평균나이(정수타입)
select max(age) 최고나이, min(age) 최소나이 from person;

-- 혈액형별 인원 수와 평균나이를 구해보자
select blood,count(*) 인원수, round(avg(age),0) 평균나이
from person group by blood order by blood asc;

-- limit 시작위치, 가져올 글의 갯수
select * from person limit 0,3;
select * from person limit 2,3;

-- where 조건과 limit 사용 시
select * from person where age >= 20 limit 1,2;

-- update
update person set blood = 'O',age=18 where name = '고민시';

-- delete

delete from study502.person where name = '안유진';





