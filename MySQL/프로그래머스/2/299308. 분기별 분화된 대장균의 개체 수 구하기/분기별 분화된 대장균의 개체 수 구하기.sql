SELECT CONCAT((EXTRACT(MONTH FROM differentiation_date) - 1) DIV 3 + 1, 'Q') AS quarter, COUNT(*) AS ecoli_count
FROM ecoli_data
GROUP BY (EXTRACT(MONTH FROM differentiation_date) - 1) DIV 3 + 1
ORDER BY (EXTRACT(MONTH FROM differentiation_date) - 1) DIV 3 + 1 ASC;