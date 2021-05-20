
-- 员工employees表
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

-- 薪水表
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));


-- 员工表dept_emp
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

-- 部门经理表dept_manager
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
-- 员工职称表titles
CREATE TABLE titles (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);

-- 部门表departments
CREATE TABLE `departments` (
`dept_no` char(4) NOT NULL,
`dapt_name` varchar(50) NOT NULL,
PRIMARY KEY (`dept_no`));



-- 01.请你查找employees里最晚入职员工的所有信息:
select emp_no,birth_date,first_name,last_name,gender,hire_date
from employees
order by hire_date desc
limit 1
-- 02.请你查找employees里入职员工时间排名倒数第三的员工所有信息:
select emp_no,birth_date,first_name,last_name,gender,hire_date
from employees
where hire_date = (
SELECT DISTINCT hire_date
    from  employees
    order by hire_date desc
    limit 1 offset 2
)
-- 03.请你查找各个部门领导薪水详情以及其对应部门编号dept_no，输出结果以salaries.emp_no升序排序，并且请注意输出结果里面dept_no列是最后一列:
select s.emp_no,s.salary,s.from_date,s.to_date,d.dept_no
from salaries s
inner join dept_manager d
on s.emp_no = d.emp_no
order by s.emp_no asc

-- 04.请你查找所有已经分配部门的员工的last_name和first_name以及dept_no，未分配的部门的员工不显示:
select e.last_name,e.first_name,d.dept_no
from employees e
inner join dept_emp d
on e.emp_no = d.emp_no
-- 05.请你查找所有已经分配部门的员工的last_name和first_name以及dept_no，也包括暂时没有分配具体部门的员工:
select e.last_name,e.first_name,d.dept_no
from employees e
left join dept_emp d
on e.emp_no = d.emp_no
-- 07.请你查找薪水记录超过15次的员工号emp_no以及其对应的记录次数t:
select emp_no,count(1) as t
from salaries
group by emp_no
having t > 15

select *
from (
    select emp_no,count(distinct salary) as t
    from salaries
    group by emp_no
    ) as T1
where t>15
-- 08.请你找出所有员工具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示:
-- 单表用distinct 多表用 group by  .大表一般用distinct效率不高
select distinct(salary) from salaries
order by salary desc;

select salary
from salaries
group by  salary
order by salary desc;
-- 10.请你找出所有非部门领导的员工emp_no，以上例子输出:
-- not in在实际使用中，因为not in会转化成多表连接，而且不使用索引，在这里，觉得还是用left_join代替会好一点
SELECT emp_no FROM
(SELECT * FROM employees LEFT JOIN dept_manager
ON employees.emp_no = dept_manager.emp_no)
WHERE dept_no IS NULL

SELECT emp_no FROM employees
WHERE emp_no NOT IN (SELECT emp_no FROM dept_manager)

select employees.emp_no from employees left join dept_manager dm on employees.emp_no = dm.emp_no
where dept_no  is null
-- 11.获取所有的员工和员工对应的经理，如果员工本身是经理的话则不显示
select de.emp_no,dm.emp_no
from dept_emp de
inner join dept_manager dm
on de.dept_no = dm.dept_no
where de.emp_no <> dm.emp_no
-- 12.获取每个部门中当前员工薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary，按照部门编号升序排列
select emp_salary.dept_no,emp_salary.emp_no,max_salary.maxSalary
from (
select de.dept_no,max(s.salary) as maxSalary
from dept_emp de,salaries s
where de.emp_no = s.emp_no
group by de.dept_no
) as max_salary,(
select de.emp_no,de.dept_no,s.salary
from dept_emp de
inner join salaries s
on de.emp_no = s.emp_no
) as emp_salary
where max_salary.dept_no = emp_salary.dept_no and max_salary.maxSalary = emp_salary.salary
order by emp_salary.dept_no;
-- 15.请你查找employees表所有emp_no为奇数，且last_name不为Mary的员工信息，并按照hire_date逆序排列
select emp_no,birth_date,first_name,last_name,gender,hire_date
from employees
where emp_no % 2 == 1 and last_name <> 'Mary'
order by hire_date desc;
-- 16.请你统计出各个title类型对应的员工薪水对应的平均工资avg。结果给出title以及平均工资avg，并且以avg升序排序
select title,avg(s.salary)
from
titles,salaries s
where s.emp_no = titles.emp_no
group by title;
-- 17.请你获取薪水第二多的员工的emp_no以及其对应的薪水salary
select emp_no, salary from salaries
where salary = (select distinct salary from salaries order by salary desc limit 1,1)
-- 18.请你查找薪水排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，不能使用order by完成
select e.emp_no, s.salary ,e.last_name,e.first_name
from salaries s
inner join employees e
on s.emp_no  = e.emp_no
where s.salary = (
select s2.salary from
salaries s1,salaries s2
where s1.salary >= s2.salary
group by s2.salary
having count(distinct s1.salary) = 2
)
-- 19.请你查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
select e.last_name,e.first_name,dm.dept_name
from (employees e left join dept_emp de on e.emp_no = de.emp_no)
left join departments dm
 on de.dept_no = dm.dept_no
-- 21.请你查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序，以上例子输出为
-- （注:可能有employees表和salaries表里存在记录的员工，有对应的员工编号和涨薪记录，但是已经离职了，离职的员工salaries表的最新的to_date!='9999-01-01'，这样的数据不显示在查找结果里面，以上emp_no为2的就是这样的）
select e.emp_no,(s.salary-s2.salary) as groupth
from employees e
inner join salaries s
on e.emp_no = s.emp_no and s.to_date = '9999-01-01'
inner join salaries s2
on e.emp_no = s2.emp_no and s2.from_date = e.hire_date
order by groupth asc

-- 22.请你统计各个部门的工资记录数，给出部门编码dept_no、部门名称dept_name以及部门在salaries表里面有多少条记录sum，按照dept_no升序排序
select dd.dept_no,dp.dept_name,dd.sum
from (
    select de.dept_no,count(1)as sum from dept_emp de left join salaries s on de.emp_no = s.emp_no group by de.dept_no) as dd
left join departments dp
on dd.dept_no = dp.dept_no
order by dd.dept_no asc
-- 23.对所有员工的薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
select s1.emp_no,s1.salary,count(distinct s2.salary) as t_rank
from salaries AS s1, salaries AS s2
where s1.to_date = '9999-01-01' and s2.to_date = '9999-01-01' and s1.salary <= s2.salary
group by s1.emp_no,s1.salary
order by s1.salary desc,s1.emp_no asc
-- 24.获取所有非manager员工薪水情况，给出dept_no、emp_no以及salary
select de.dept_no, s.emp_no, s.salary
from
dept_emp  de
inner join salaries s
on de.emp_no = s.emp_no
left join dept_manager dm
on de.emp_no = dm.emp_no
where s.to_date='9999-01-01' and dm.dept_no   is null

-- 25.获取员工其当前的薪水比其manager当前薪水还高的相关信息，
-- 第一列给出员工的emp_no，
-- 第二列给出其manager的manager_no，
-- 第三列给出该员工当前的薪水emp_salary,
-- 第四列给该员工对应的manager当前的薪水manager_salary
select de.emp_no,dm.emp_no as manager_no,s1.salary as emp_salary,s2.salary as manager_salary
from
dept_emp  de,dept_manager dm,salaries s1,salaries s2
where de.dept_no = dm.dept_no
and de.emp_no = s1.emp_no
and dm.emp_no = s2.emp_no
and de.to_date='9999-01-01'
and s1.to_date='9999-01-01'
and dm.to_date='9999-01-01'
and s2.to_date='9999-01-01'
and s1.salary > s2.salary
-- 26.汇总各个部门当前员工的title类型的分配数目，即结果给出部门编号dept_no、dept_name、其部门下所有的员工的title以及该类型title对应的数目count，结果按照dept_no升序排序
select de.dept_no,dp.dept_name,t.title,count(1) count
from titles t
inner join dept_emp de
 on t.emp_no  = de.emp_no and de.to_date = '9999-01-01' and t.to_date = '9999-01-01'
inner  join departments dp
on de.dept_no = dp.dept_no
GROUP BY de.dept_no, t.title
order by de.dept_no