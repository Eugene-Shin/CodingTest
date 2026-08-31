SELECT e.emp_no, e.emp_name, 
    CASE
        WHEN AVG(g.score) >= 96 THEN 'S'
        WHEN AVG(g.score) >= 90 THEN 'A'
        WHEN AVG(g.score) >= 80 THEN 'B'
        ELSE 'C'
    END AS grade, 
    CASE
        WHEN AVG(g.score) >= 96 THEN 0.2
        WHEN AVG(g.score) >= 90 THEN 0.15
        WHEN AVG(g.score) >= 80 THEN 0.1
        ELSE 0
    END * e.sal AS bonus
FROM hr_employees AS e
JOIN hr_department AS d ON e.dept_id = d.dept_id
JOIN hr_grade AS g ON e.emp_no = g.emp_no
GROUP BY e.emp_no
ORDER BY e.emp_no ASC;