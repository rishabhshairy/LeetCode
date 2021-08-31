/* Write your PL/SQL query statement below */
SELECT Score,
DENSE_RANK() OVER (ORDER BY Score DESC) AS "Rank"
FROM Scores
