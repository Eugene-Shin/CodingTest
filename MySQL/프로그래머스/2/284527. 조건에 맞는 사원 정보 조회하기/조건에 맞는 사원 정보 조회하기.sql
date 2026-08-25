SELECT SUM(score) AS score, e.emp_no, e.emp_name, e.position, e.email
FROM hr_employees AS e
JOIN hr_department AS d ON e.dept_id = d.dept_id
JOIN hr_grade AS g ON e.emp_no = g.emp_no
GROUP BY e.emp_no
ORDER BY score DESC
LIMIT 1;