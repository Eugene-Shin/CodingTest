SELECT e.id, 
    CASE
        WHEN RANK() OVER (ORDER BY size_of_colony DESC) / COUNT(*) OVER () * 100 <= 25 THEN 'CRITICAL'
        WHEN RANK() OVER (ORDER BY size_of_colony DESC) / COUNT(*) OVER () * 100 <= 50 THEN 'HIGH'
        WHEN RANK() OVER (ORDER BY size_of_colony DESC) / COUNT(*) OVER () * 100 <= 75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS colony_name
FROM ecoli_data AS e
ORDER BY e.id ASC;