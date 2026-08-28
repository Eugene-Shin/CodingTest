SELECT EXTRACT(MONTH FROM start_date) AS month, car_id, COUNT(*) AS records
FROM car_rental_company_rental_history
WHERE start_date > '2022-07-31' AND start_date < '2022-11-01'
GROUP BY EXTRACT(MONTH FROM start_date), car_id
HAVING car_id IN (
    SELECT car_id
    FROM car_rental_company_rental_history
    WHERE start_date > '2022-07-31' AND start_date < '2022-11-01'
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)
ORDER BY month ASC, car_id DESC;