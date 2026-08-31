SELECT fp.product_id, fp.product_name, SUM(fp.price * fo.amount) AS total_sales
FROM food_product AS fp
JOIN food_order AS fo ON fp.product_id = fo.product_id
WHERE fo.produce_date > '2022-04-30' AND fo.produce_date < '2022-06-01'
GROUP BY fp.product_id
ORDER BY total_sales DESC, fp.product_id ASC;