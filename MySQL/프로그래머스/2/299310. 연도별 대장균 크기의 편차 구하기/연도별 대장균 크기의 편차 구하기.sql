SELECT EXTRACT(YEAR FROM e1.differentiation_date) AS year, 
    (
        SELECT MAX(e2.size_of_colony) - e1.size_of_colony
        FROM ecoli_data AS e2
        WHERE EXTRACT(YEAR FROM e1.differentiation_date) = EXTRACT(YEAR FROM e2.differentiation_date)
    ) AS year_dev, e1.id AS id
FROM ecoli_data AS e1
ORDER BY year ASC, year_dev ASC;