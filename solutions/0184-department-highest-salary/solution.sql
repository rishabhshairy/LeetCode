# Write your MySQL query statement below
# select d.name as Department,emp.name as Employee,emp.salary as Salary
# from employee emp join department d
# on emp.DepartmentId  = d.id
# having (emp.salary,emp.DepartmentId ) in (select max(e2.salary),DepartmentId  from employee e2 group by(e2.DepartmentId ));


select d.Name 'Department',e.Name 'Employee',e.Salary 
from Employee e join department d 
on d.id=e.departmentid 
where (e.salary,e.departmentid) in (select max(salary),DepartmentId from Employee group by DepartmentId);
