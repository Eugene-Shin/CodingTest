SELECT i.flavor FROM icecream_info AS i
LEFT JOIN first_half AS f ON i.flavor = f.flavor
WHERE f.total_order > 3000 AND i.ingredient_type = 'fruit_based'
ORDER BY f.total_order DESC;


