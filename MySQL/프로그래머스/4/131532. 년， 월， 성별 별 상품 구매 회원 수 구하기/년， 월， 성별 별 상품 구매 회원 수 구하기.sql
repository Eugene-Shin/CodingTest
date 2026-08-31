SELECT EXTRACT(YEAR FROM os.sales_date) AS year, EXTRACT(MONTH FROM os.sales_date) AS month, u.gender AS gender, COUNT(DISTINCT u.user_id) AS users
FROM user_info AS u
JOIN online_sale AS os ON u.user_id = os.user_id
WHERE u.gender IS NOT NULL
GROUP BY EXTRACT(YEAR FROM os.sales_date), EXTRACT(MONTH FROM os.sales_date), u.gender
ORDER BY year ASC, month ASC, gender ASC;