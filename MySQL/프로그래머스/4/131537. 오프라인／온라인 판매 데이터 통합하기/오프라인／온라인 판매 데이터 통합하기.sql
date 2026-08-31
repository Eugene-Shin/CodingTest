SELECT sales_date, product_id, user_id, sales_amount
FROM (
    SELECT sales_date, product_id, user_id, sales_amount
    FROM online_sale
    WHERE sales_date > '2022-02-28' AND sales_date < '2022-04-01'

    UNION ALL

    SELECT sales_date, product_id, NULL AS user_id, sales_amount
    FROM offline_sale
    WHERE sales_date > '2022-02-28' AND sales_date < '2022-04-01'
) AS combined
ORDER BY sales_date ASC, product_id ASC, user_id ASC;