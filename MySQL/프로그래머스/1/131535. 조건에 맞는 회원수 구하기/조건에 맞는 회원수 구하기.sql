SELECT COUNT(*) FROM user_info
WHERE EXTRACT(YEAR FROM joined) = 2021 AND age >= 20 AND age <= 29;