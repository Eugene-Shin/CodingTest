SELECT p.item_id, p.item_name, p.rarity
FROM item_tree AS t
JOIN item_info AS i ON t.item_id = i.item_id
RIGHT JOIN item_info AS p ON t.parent_item_id = p.item_id
WHERE i.item_id IS NULL
ORDER BY p.item_id DESC;