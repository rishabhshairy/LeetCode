/* Write your PL/SQL query statement below */
select max(Salary) SecondHighestSalary
from (select Salary, dense_rank() over(order by Salary desc) r from Employee) 
where  r = 2;
