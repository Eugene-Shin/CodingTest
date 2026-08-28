SELECT f.id AS id, fn.fish_name AS fish_name, f.length AS length
FROM fish_info AS f
JOIN fish_name_info AS fn ON f.fish_type = fn.fish_type
WHERE f.length = (
    SELECT MAX(length)
    FROM fish_info AS f2
    WHERE f.fish_type = f2.fish_type
)
ORDER BY id ASC;