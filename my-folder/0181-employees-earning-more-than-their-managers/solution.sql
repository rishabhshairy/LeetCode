# Write your MySQL query statement below
select emp.name as Employee
from Employee emp join employee man
WHERE emp.salary > man.salary and emp.managerid = man.id
