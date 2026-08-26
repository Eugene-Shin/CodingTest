SELECT COUNT(*) AS fish_count
FROM fish_info AS f
JOIN fish_name_info AS fn ON f.fish_type = fn.fish_type
WHERE fish_name IN ('BASS', 'SNAPPER');
