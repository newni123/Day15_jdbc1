select * from emp;

select deptno from emp;

select avg(sal) from emp;
select avg(sal),deptno from emp group by deptno;

select max(hiredate) from emp;
select ename,sal from emp where sal = (select min(sal) from emp);

select comm from emp;
select sum(comm) from emp;
select avg(nvl(comm,0)) from emp;
select count(sal) from EMP;
select count(comm) from EMP;
select count(nvl(comm,0)) from EMP;

-- 사원의 이름,월급
-- 전체사원의 평균보다 많이 받는 사원들

select ename,sal from emp where sal >= (select avg(sal) from emp);


select * from dept;

select deptno,sum(sal) total, avg(sal) avg from emp group by deptno order by deptno asc;

select empno,ename,sal,job from emp where ename = 'SMITH';