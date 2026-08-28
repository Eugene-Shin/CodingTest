SELECT o.animal_id, o.name
FROM animal_ins AS i
RIGHT JOIN animal_outs AS o ON i.animal_id = o.animal_id
WHERE i.datetime IS NULL
ORDER BY o.animal_id ASC;