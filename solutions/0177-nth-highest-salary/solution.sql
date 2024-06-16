CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
SELECT Salary 
FROM Employee e1
WHERE N-1 = (
SELECT count(distinct Salary)
FROM Employee e2
WHERE e2.Salary > e1.Salary )
  LIMIT 1);
END
