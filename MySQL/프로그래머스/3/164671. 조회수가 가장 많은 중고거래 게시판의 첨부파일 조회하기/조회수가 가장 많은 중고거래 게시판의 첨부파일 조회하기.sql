SELECT CONCAT('/home/grep/src/', b.board_id, '/', f.file_id, f.file_name, f.file_ext) AS file_path
FROM used_goods_board AS b
JOIN used_goods_file AS f ON b.board_id = f.board_id
WHERE b.views = (
    SELECT views
    FROM used_goods_board AS b2
    ORDER BY views DESC
    LIMIT 1
)
ORDER BY f.file_id DESC;