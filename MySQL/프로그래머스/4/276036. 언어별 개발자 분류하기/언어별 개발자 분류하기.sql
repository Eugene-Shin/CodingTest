SELECT CASE
           WHEN (d.skill_code & fe.front_end_code) > 0
            AND (d.skill_code & py.python_code) > 0 THEN 'A'
           WHEN (d.skill_code & cs.csharp_code) > 0 THEN 'B'
           WHEN (d.skill_code & fe.front_end_code) > 0 THEN 'C'
       END AS grade,
       d.id,
       d.email
FROM developers AS d
CROSS JOIN (SELECT SUM(code) AS front_end_code FROM skillcodes WHERE category = 'Front End') AS fe
CROSS JOIN (SELECT code AS python_code FROM skillcodes WHERE name = 'Python') AS py
CROSS JOIN (SELECT code AS csharp_code FROM skillcodes WHERE name = 'C#') AS cs
WHERE (d.skill_code & fe.front_end_code) > 0
   OR (d.skill_code & cs.csharp_code) > 0
ORDER BY grade ASC, d.id ASC;