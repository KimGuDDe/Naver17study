--equi join 또는 inner join : 두 테이블의 결합

--방법 1, 컬럼명 앞에 테이블명이나 테이블별칭을 붙인다
select
    e.ename,e.job,e.sal,d.dname,d.loc
from emp e,dept d
where e.deptno=d.deptno;

--방법 2, join 할 테이블에 컬럼명이 겹치지 않는 경우 테이블명이나 별칭 안 붙여도 됨
select
   e.deptno,ename,job,sal,dname,loc
from emp e,dept d
where e.deptno=d.deptno;
--decode 함수 : 다중 if문 같은 함수
select ename,deptno,decode(deptno,10,'홍보부',20,'교육부',30,'인사부')부서명 from emp;