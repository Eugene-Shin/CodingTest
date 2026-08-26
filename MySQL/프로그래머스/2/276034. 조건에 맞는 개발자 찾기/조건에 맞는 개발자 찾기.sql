SELECT d.id AS id, d.email AS email, d.first_name AS first_name, d.last_name AS last_name
FROM developers AS d
WHERE (
    SELECT SUM(s.code)
    FROM skillcodes AS s
    WHERE s.name = 'Python' OR s.name = 'C#'
) & d.skill_code != 0
ORDER BY id ASC;