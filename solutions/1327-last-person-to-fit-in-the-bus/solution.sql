# Write your MySQL query statement below
select person_name
from (select person_name, turn, sum(weight) over(order by turn) as weight_sum from queue) q
where weight_sum <=1000
order by turn desc limit 1
