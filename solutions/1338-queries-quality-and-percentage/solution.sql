# Write your MySQL query statement below
select q1.query_name, 
round(avg(q1.rating/q1.position),2) as quality,
round(avg(q1.rating < 3) * 100,2) as poor_query_percentage 
from Queries q1 join Queries q2
on q1.query_name = q2.query_name
group by query_name
