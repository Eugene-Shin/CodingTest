SELECT a.author_id, a.author_name, b.category, SUM(b.price * bs.sales) AS total_sales
FROM book AS b
JOIN author AS a ON b.author_id = a.author_id
JOIN book_sales AS bs ON bs.book_id = b.book_id
WHERE bs.sales_date > '2021-12-31' AND bs.sales_date < '2022-02-01'
GROUP BY a.author_id, b.category
ORDER BY a.author_id ASC, b.category DESC;