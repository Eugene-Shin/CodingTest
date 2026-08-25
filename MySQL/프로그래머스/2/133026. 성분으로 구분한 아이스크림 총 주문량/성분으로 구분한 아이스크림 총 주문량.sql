SELECT i.ingredient_type, SUM(f.total_order) AS total_order
FROM icecream_info AS i
JOIN first_half AS f ON i.flavor = f.flavor
GROUP BY i.ingredient_type
ORDER BY total_order ASC;
