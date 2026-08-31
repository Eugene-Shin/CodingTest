SELECT e3.id
FROM ecoli_data AS e3
JOIN ecoli_data AS e2 ON e3.parent_id = e2.id
JOIN ecoli_data AS e1 ON e2.parent_id = e1.id
WHERE e1.parent_id IS NULL
ORDER BY e3.id ASC;