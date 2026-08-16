SELECT book_id, published_date FROM book
WHERE EXTRACT(YEAR FROM published_date) = 2021 AND category = '인문'
ORDER BY published_date ASC;