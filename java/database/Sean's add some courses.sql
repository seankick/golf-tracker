INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Plumbrook Golf Course', 'Sterling Heights', 'Michigan', 44122, 'H2F4+GW Sterling Heights, Michigan', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);
INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Rambler Golf Club', 'Utica', 'Michigan', 44122, 'H2H7+98 Sterling Heights, Michigan', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);
INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Sanctuary Lake Golf Course', 'Troy', 'Michigan', 44122, 'JVFW+2F Troy, Michigan', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);	
		   
INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/06/10', '2022/08/10', 'Plumbrook Summer Mens League', 'Mens league playing at Plumbrook Golf Course in Sterling Heights, Michigan', 1);
	
INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/06/10', '2022/08/10', 'Plumbrook Summer Womens League', 'Womens league playing at Plumbrook Golf Course in Sterling Heights, Michigan', 1);
	
INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/06/10', '2022/08/10', 'Rambler Summer Mens League', 'Mens league playing at Plumbrook Golf Course in Sterling Heights, Michigan', 1);
	
INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/06/10', '2022/08/10', 'Rambler Summer Womens League', 'Womens league playing at Plumbrook Golf Course in Sterling Heights, Michigan', 1);
	


