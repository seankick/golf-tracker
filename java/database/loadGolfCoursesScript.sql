
Begin;

--Populate Course INTO Courses Table

INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Beechmont Country Club', 'Cleveland', 'Ohio', 44122, 'FG6H+HX Beachwood, Ohio', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);

--Populate Course Holes INTO Holes Table

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 1, 5, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 407, DEFAULT, DEFAULT, 407, 407, DEFAULT, DEFAULT, 13, DEFAULT, DEFAULT, 7, 7, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 2, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 390, DEFAULT, DEFAULT, 390, 390, DEFAULT, DEFAULT, 7, DEFAULT, DEFAULT, 11, 11, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 3, 3, DEFAULT, DEFAULT, 3, 3, DEFAULT, DEFAULT, 184, DEFAULT, DEFAULT, 184, 184, DEFAULT, DEFAULT, 15, DEFAULT, DEFAULT, 17, 17, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 4, 4, DEFAULT, DEFAULT, 4, 5, DEFAULT, DEFAULT, 415, DEFAULT, DEFAULT, 415, 415, DEFAULT, DEFAULT, 5, DEFAULT, DEFAULT, 1, 1, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 5, 5, DEFAULT, DEFAULT, 5, 5, DEFAULT, DEFAULT, 521, DEFAULT, DEFAULT, 521, 521, DEFAULT, DEFAULT, 3, DEFAULT, DEFAULT, 5, 5, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 6, 5, DEFAULT, DEFAULT, 5, 5, DEFAULT, DEFAULT, 512, DEFAULT, DEFAULT, 512, 512, DEFAULT, DEFAULT, 1, DEFAULT, DEFAULT, 9, 9, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 7, 4, DEFAULT, DEFAULT, 3, 3, DEFAULT, DEFAULT, 217, DEFAULT, DEFAULT, 217, 217, DEFAULT, DEFAULT, 17, DEFAULT, DEFAULT, 13, 13, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 8, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 435, DEFAULT, DEFAULT, 435, 435, DEFAULT, DEFAULT, 9, DEFAULT, DEFAULT, 3, 3, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 9, 3, DEFAULT, DEFAULT, 3, 3, DEFAULT, DEFAULT, 181, DEFAULT, DEFAULT, 181, 181, DEFAULT, DEFAULT, 11, DEFAULT, DEFAULT, 15, 15, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 10, 5, DEFAULT, DEFAULT, 5, 5, DEFAULT, DEFAULT, 518, DEFAULT, DEFAULT, 518, 518, DEFAULT, DEFAULT, 2, DEFAULT, DEFAULT, 10, 10, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 11, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 384, DEFAULT, DEFAULT, 384, 384, DEFAULT, DEFAULT, 6, DEFAULT, DEFAULT, 6, 6, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 12, 5, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 406, DEFAULT, DEFAULT, 406, 406, DEFAULT, DEFAULT, 12, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 13, 5, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 429, DEFAULT, DEFAULT, 429, 429, DEFAULT, DEFAULT, 4, DEFAULT, DEFAULT, 2, 2, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 14, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 369, DEFAULT, DEFAULT, 369, 369, DEFAULT, DEFAULT, 10, DEFAULT, DEFAULT, 14, 14, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 15, 3, DEFAULT, DEFAULT, 3, 3, DEFAULT, DEFAULT, 171, DEFAULT, DEFAULT, 171, 171, DEFAULT, DEFAULT, 18, DEFAULT, DEFAULT, 18, 18, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 16, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 335, DEFAULT, DEFAULT, 335, 335, DEFAULT, DEFAULT, 16, DEFAULT, DEFAULT, 16, 16, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 17, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 399, DEFAULT, DEFAULT, 399, 399, DEFAULT, DEFAULT, 12, DEFAULT, DEFAULT, 12, 12, DEFAULT, DEFAULT, 1);

INSERT INTO public.holes(
	hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id)
	VALUES (DEFAULT, 18, 4, DEFAULT, DEFAULT, 4, 4, DEFAULT, DEFAULT, 389, DEFAULT, DEFAULT, 389, 389, DEFAULT, DEFAULT, 8, DEFAULT, DEFAULT, 8, 8, DEFAULT, DEFAULT, 1);

COMMIT;