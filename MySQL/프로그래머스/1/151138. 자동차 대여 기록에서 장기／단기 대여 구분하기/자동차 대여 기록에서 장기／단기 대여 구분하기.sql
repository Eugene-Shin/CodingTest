SELECT
    *,
    CASE
        WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '장기 대여'
        ELSE '단기 대여'
    END AS rent_type
FROM car_rental_company_rental_history
WHERE start_date BETWEEN '2022-09-01' AND '2022-09-30'
ORDER BY history_id DESC;