SELECT COUNT(*) AS fish_count, MAX(COALESCE(length, 10)) AS max_length, fish_type
FROM fish_info
GROUP BY fish_type
HAVING AVG(COALESCE(length, 10)) >= 33
ORDER BY fish_type ASC;