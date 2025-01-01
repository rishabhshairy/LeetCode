# Write your MySQL query statement below
select e1.employee_id , e1.department_id
from Employee e1
where e1.primary_flag='Y'  or 
e1.employee_id in 
(   select employee_id 
    from Employee 
    group by employee_id
    having count(department_id)=1)
group by e1.employee_id
