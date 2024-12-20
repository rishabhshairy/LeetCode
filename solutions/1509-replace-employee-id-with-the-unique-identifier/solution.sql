# Write your MySQL query statement below
select unique_id, name
from Employees e left join EmployeeUNI eun
on e.id = eun.id
