SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
FROM appointment AS a
JOIN patient AS p ON a.pt_no = p.pt_no
JOIN doctor AS d ON a.mddr_id = d.dr_id
WHERE a.apnt_ymd > '2022-04-12' AND a.apnt_ymd < '2022-04-14'
    AND a.mcdp_cd = 'CS' AND a.apnt_cncl_ymd IS NULL
ORDER BY a.apnt_ymd ASC;