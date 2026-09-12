SELECT
    EXTRACT(year FROM o.sales_date) AS year,
    EXTRACT(month FROM o.sales_date) AS month,
    COUNT(DISTINCT u.user_id) AS puchased_users,
    ROUND(COUNT(DISTINCT u.user_id) / 
          (SELECT COUNT(*) FROM user_info WHERE joined > '2020-12-31' AND joined < '2022-01-01'), 1) AS puchased_ratio
FROM online_sale AS o
JOIN user_info AS u ON u.user_id = o.user_id
WHERE u.joined > '2020-12-31' AND u.joined < '2022-01-01'
GROUP BY EXTRACT(year FROM o.sales_date), EXTRACT(month FROM o.sales_date)
ORDER BY year ASC, month ASC;