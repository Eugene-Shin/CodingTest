SELECT car_id, car_type, fee
FROM (
    SELECT 
        c.car_id, 
        c.car_type, 
        c.daily_fee * 30 * (1 - COALESCE(p.discount_rate, 0) / 100) AS fee
    FROM car_rental_company_car AS c 
    LEFT JOIN car_rental_company_discount_plan AS p
        ON c.car_type = p.car_type
        AND p.duration_type = '30일 이상'
    WHERE c.car_type IN ('세단', 'SUV')
        AND NOT EXISTS (
            SELECT 1
            FROM car_rental_company_rental_history AS h
            WHERE c.car_id = h.car_id
                AND h.start_date <= '2022-11-30'
                AND h.end_date >= '2022-11-01'
        )
) AS r
WHERE fee >= 500000 AND fee < 2000000
ORDER BY fee DESC, car_type ASC, car_id DESC;