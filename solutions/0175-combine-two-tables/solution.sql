# Write your MySQL query statement below

SELECT p.FirstName,
  p.LastName,
  a.City,
  a.State
FROM Person p left join Address a
on p.PersonId=a.PersonId;
