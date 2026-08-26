SELECT e.id AS id, e.genotype AS genotype, p.genotype AS parent_genotype
FROM ecoli_data AS e
JOIN ecoli_data AS p ON e.parent_id = p.id
WHERE e.genotype & p.genotype = p.genotype
ORDER BY id ASC;