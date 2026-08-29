SELECT f.category, f.price, f.product_name
FROM food_product AS f
WHERE f.category IN ('과자', '국', '김치', '식용유') AND f.price = (
    SELECT MAX(f2.price)
    FROM food_product AS f2
    WHERE f.category = f2.category
)
GROUP BY f.category
ORDER BY f.price DESC;