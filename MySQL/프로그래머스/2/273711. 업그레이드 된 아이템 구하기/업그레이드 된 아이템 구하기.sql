SELECT i.item_id AS item_id, i.item_name AS item_name, i.rarity AS rarity
FROM item_tree AS t
JOIN item_info AS i ON i.item_id = t.item_id
JOIN item_info AS p ON p.item_id = t.parent_item_id
WHERE p.rarity = 'RARE'
ORDER BY i.item_id DESC;