select * from person;
desc person;
alter table person modify name varchar(30);
alter table person add hp varchar(20);
alter table person drop column today;
-- 5. hp 에 데이터 넣기
update person set hp='010-2222-3333' where num =2;

-- join 연습용 테이블 생성하기
-- 부모 테이블은 person 으로 하고 person 의 num을 외부키로 갖는 stu 생성
create table stu(
	idx tinyint auto_increment primary key,
    num smallint,
    kor smallint default 0,
    eng smallint default 0,
    sum smallint,
    constraint fK_stu_num foreign key(num) references person(num)
     on delete cascade);
     -- person 데이터 삭제 시 stu 추가된 데이터는 자동 삭제
	-- stu 에 데이터 추가하기
    insert into stu(num,kor,eng) values (1,78,89);
    insert into stu(num,kor,eng) values (2,100,99);
    insert into stu(num,kor,eng) values (3,76,45);
    insert into stu(num,kor,eng) values (4,28,69);
    insert into stu(num,kor,eng) values (5,58,69);
    -- 전체 학생들 sum 구하기
    update stu set sum=kor+eng;
    -- person 과 stu 를 join 해서 전체 출력하는 법
	-- 방법 1
select * from person p,stu s where p.num=s.num;
	-- 방법 2
select p.name,p.blood,p.age,s.kor,s.eng,s.sum
from person p,stu s where p.num=s.num;
-- 방법3
select name,blood,age,hp,kor,eng,sum
from person p inner join stu s on p.num=s.num;

-- stu 생성시 on delete cascade 설정
-- person 에서 1번 삭제 시 stu에서도 같이 삭제됨

delete from person where num=1;

-- stu만 조회
select * from stu;

select name,age,blood,hp,date_format(writeday,"%Y-%m-%d %H:%i") today from person; 

select name,blood,age,hp,kor,eng,sum
from person p inner join stu s on p.num=s.num;

select blood,count(*) count,round(avg(age),1) avgage from person
group by blood order by count;

alter table person rename column writeday to today;

-- 연습용 테이블 생성

create table shop1shop1(
idx smallint auto_increment primary key,
sangpum varchar(30),
su smallint default 1,
danga int,
ipgoday datetime);

create table foodrest
(
num smallint auto_increment primary key,
foodname varchar(20),
foodprice int,
foodsize varchar(20) default "보통");

create table foodorder
(
idx smallint auto_increment primary key,
num	smallint,
ordername varchar(20),
ordercnt smallint,
bookingday datetime,
constraint fk_foodorder_num foreign key(num) references foodrest(num));

alter table foodorder modify bookingday varchar(30);

desc foodorder;

select
	idx,ordername,foodname,foodprice,
	foodsize,ordercnt,bookingday
from foodrest fr,foodorder fo
where fr.num=fo.num;

create table gamer
(
