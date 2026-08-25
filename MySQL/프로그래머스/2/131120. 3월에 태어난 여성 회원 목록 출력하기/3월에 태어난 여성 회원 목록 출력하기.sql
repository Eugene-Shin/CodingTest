SELECT member_id, member_name, gender, date_of_birth
FROM member_profile
WHERE EXTRACT(MONTH FROM date_of_birth) = 3 AND gender = 'W' AND tlno IS NOT NULL
ORDER BY member_id ASC;