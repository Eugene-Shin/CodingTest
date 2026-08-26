SELECT b.category AS category, SUM(sales) AS total_sales
FROM book AS b
JOIN book_sales AS bs ON b.book_id = bs.book_id
WHERE sales_date > '2021-12-31' AND sales_date < '2022-02-01'
GROUP BY b.category
ORDER BY category ASC;