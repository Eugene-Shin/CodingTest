SELECT history_id, 
    FLOOR(daily_fee * duration * (1 - COALESCE(discount_rate, 0) / 100)) AS fee
FROM (
    SELECT h.history_id,
        c.car_type,
        c.daily_fee,
        DATEDIFF(h.end_date, h.start_date) + 1 AS duration
    FROM car_rental_company_car AS c
    JOIN car_rental_company_rental_history AS h ON c.car_id = h.car_id
    WHERE c.car_type = '트럭'
) AS r
LEFT JOIN car_rental_company_discount_plan AS p
    ON p.car_type = r.car_type
    AND p.duration_type = CASE
            WHEN r.duration >= 90 THEN '90일 이상'
            WHEN r.duration >= 30 THEN '30일 이상'
            WHEN r.duration >= 7  THEN '7일 이상'
        END
ORDER BY fee DESC, history_id DESC;