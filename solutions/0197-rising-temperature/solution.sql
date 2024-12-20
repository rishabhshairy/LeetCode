# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT W1.Id
FROM Weather AS W1 JOIN Weather AS W2 
ON TIMESTAMPDIFF(DAY,W2.recordDate,W1.recordDate)=1
WHERE W1.Temperature > W2.Temperature
