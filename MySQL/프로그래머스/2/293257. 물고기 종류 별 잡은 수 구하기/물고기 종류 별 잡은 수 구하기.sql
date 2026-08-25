SELECT COUNT(*) AS fish_count, fn.fish_name AS fish_name
FROM fish_info AS f
JOIN fish_name_info AS fn ON f.fish_type = fn.fish_type
GROUP BY fn.fish_name
ORDER BY fish_count DESC;