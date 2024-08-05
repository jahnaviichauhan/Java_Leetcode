# Write your MySQL query statement below
WITH TotalUsers AS (
    SELECT COUNT(*) AS total_users
    FROM Users
),
ContestRegistrations AS (
    SELECT
        contest_id,
        COUNT(user_id) AS registered_users
    FROM Register
    GROUP BY contest_id
)
SELECT 
    cr.contest_id,
    ROUND((cr.registered_users * 100.0) / tu.total_users, 2) AS percentage
FROM 
    ContestRegistrations cr,
    TotalUsers tu
ORDER BY 
    percentage DESC,
    contest_id ASC;