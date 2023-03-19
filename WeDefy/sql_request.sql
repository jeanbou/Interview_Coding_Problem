-- Aproximate memorized SQL request
-- you have to write it in 30 seconds , otherwise you failed
SELECT res_id, resto_name, count(menu_id) FROM ext_restaurant_table
INNER JOIN ext_category_table WHERE ext_restaurant_table.res_id = ext_category_table.cat_rest_id
GROUP BY res_id
