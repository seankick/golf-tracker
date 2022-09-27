DROP TABLE IF EXISTS LeagueScorecards;
DROP TABLE IF EXISTS Matches_Holes;
DROP TABLE IF EXISTS Players_Matches;
DROP TABLE IF EXISTS Players_Holes;
DROP TABLE IF EXISTS Players_Leaderboards;
DROP TABLE IF EXISTS Matches;
DROP TABLE IF EXISTS Holes;

DROP TABLE IF EXISTS Courses_Leaderboards;
DROP TABLE IF EXISTS Leagues_Leaderboards;
DROP TABLE IF EXISTS Leaderboards;
DROP TABLE IF EXISTS Users_Leagues;
DROP TABLE IF EXISTS Players;
DROP TABLE IF EXISTS Leagues;
DROP TABLE IF EXISTS Courses;

CREATE TABLE Courses (
        course_id SERIAL NOT NULL PRIMARY KEY,
   	course_name VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state_name VARCHAR(50) NOT NULL,
	postal_code INT NOT NULL,
	google_map_plus_code VARCHAR(55),
	picture_path VARCHAR(255) DEFAULT NULL,
	red_tee BOOLEAN DEFAULT FALSE,
	gold_tee BOOLEAN DEFAULT FALSE,
	white_tee BOOLEAN DEFAULT FALSE,
	black_tee BOOLEAN DEFAULT FALSE,
	blue_tee BOOLEAN DEFAULT FALSE,
	green_tee BOOLEAN DEFAULT FALSE,
	silver_tee BOOLEAN DEFAULT FALSE,
	red_tee_front_par INT DEFAULT NULL,
	gold_tee_front_par INT DEFAULT NULL,
	white_tee_front_par INT DEFAULT NULL,
	black_tee_front_par INT DEFAULT NULL,
	blue_tee_front_par INT DEFAULT NULL,
	green_tee_front_par INT DEFAULT NULL,
	silver_tee_front_par INT DEFAULT NULL,
	red_tee_back_par INT DEFAULT NULL,
	gold_tee_back_par INT DEFAULT NULL,
	white_tee_back_par INT DEFAULT NULL,
	black_tee_back_par INT DEFAULT NULL,
	blue_tee_back_par INT DEFAULT NULL,
	green_tee_back_par INT DEFAULT NULL,
	silver_tee_back_par INT DEFAULT NULL,
	red_tee_front_nine_yardage INT DEFAULT NULL,
	gold_tee_front_nine_yardage INT DEFAULT NULL,
	white_tee_front_nine_yardage INT DEFAULT NULL,
	black_tee_front_nine_yardage INT DEFAULT NULL,
	blue_tee_front_nine_yardage INT DEFAULT NULL,	
	green_tee_front_nine_yardage INT DEFAULT NULL,
	silver_tee_front_nine_yardage INT DEFAULT NULL,
	red_tee_back_nine_yardage INT DEFAULT NULL,
	gold_tee_back_nine_yardage INT DEFAULT NULL,
	white_tee_back_nine_yardage INT DEFAULT NULL,
	black_tee_back_nine_yardage INT DEFAULT NULL,
	blue_tee_back_nine_yardage INT DEFAULT NULL,	
	green_tee_back_nine_yardage INT DEFAULT NULL,
	silver_tee_back_nine_yardage INT DEFAULT NULL	
);

CREATE TABLE leagues (
    league_id serial PRIMARY KEY,
	start_date DATE DEFAULT CURRENT_TIMESTAMP,
	end_date DATE DEFAULT NULL,
	league_name VARCHAR(50) NOT NULL,
	overview VARCHAR(250) NOT NULL,
	course_id INT,
	FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
Create TABLE Players (
	player_id SERIAL PRIMARY KEY,
	image_path VARCHAR(255) DEFAULT NULL,
	first_name VARCHAR(50) DEFAULT NULL,
	last_name VARCHAR(50) DEFAULT NULL,
	username VARCHAR(60),
	FOREIGN KEY (username) REFERENCES Users(username),
	FOREIGN KEY (player_id) REFERENCES Users(user_id)
);
CREATE TABLE Users_Leagues (
        user_league_id serial,
	user_id Int,
	league_id INT,
	FOREIGN KEY (user_id) REFERENCES Users(user_id),
	FOREIGN KEY (league_id) REFERENCES Leagues(league_id)
);
CREATE TABLE Leaderboards (
        leaderboard_id SERIAL PRIMARY KEY,
	start_date DATE DEFAULT CURRENT_TIMESTAMP,
	end_date DATE DEFAULT NULL	
);
CREATE TABLE Leagues_Leaderboards (
        league_id INT,
	leaderboard_id INT,
	PRIMARY KEY (league_id, leaderboard_id),
	FOREIGN KEY (league_id) REFERENCES Leagues(league_id),
	FOREIGN KEY (leaderboard_id) REFERENCES Leaderboards(leaderboard_id)
);
CREATE TABLE Courses_Leaderboards (
        course_id INT,
	leaderboard_id INT,
	PRIMARY KEY (course_id, leaderboard_id),
	FOREIGN KEY (course_id) REFERENCES Courses(course_id),
	FOREIGN KEY (leaderboard_id) REFERENCES Leaderboards(leaderboard_id)
);

CREATE TABLE Matches (
        match_id serial PRIMARY KEY,
        course_id int NOT NULL,
	start_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	number_of_players int NOT NULL,
	FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Holes (
        hole_id SERIAL PRIMARY KEY,
	hole_number INT NOT NULL,
	par_red INT DEFAULT NULL,
	par_gold INT DEFAULT NULL,
	par_white INT DEFAULT NULL,
	par_black INT DEFAULT NULL,
	par_blue INT DEFAULT NULL,
	par_green INT DEFAULT NULL,
	par_silver INT DEFAULT NULL,
	yardage_red INT DEFAULT NULL,
	yardage_gold INT DEFAULT NULL,
	yardage_white INT DEFAULT NULL,
	yardage_black INT DEFAULT NULL,
	yardage_blue INT DEFAULT NULL,
	yardage_green INT DEFAULT NULL,
	yardage_silver INT DEFAULT NULL,
	handicap_red INT DEFAULT NULL,
	handicap_gold INT DEFAULT NULL,
	handicap_white INT DEFAULT NULL,
	handicap_black INT DEFAULT NULL,
	handicap_blue INT DEFAULT NULL,
	handicap_green INT DEFAULT NULL,
	handicap_silver INT DEFAULT NULL,
	course_id INT,
	FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);


CREATE TABLE Players_Leaderboards (
        player_id INT,
	leaderboard_id INT,
	PRIMARY KEY (player_id, leaderboard_id),
	FOREIGN KEY (player_id) REFERENCES Players(player_id),
	FOREIGN KEY (leaderboard_id) REFERENCES Leaderboards(leaderboard_id)
);
CREATE TABLE Players_Holes (
    player_id INT,
	hole_id INT,
	PRIMARY KEY (player_id, hole_id),
	FOREIGN KEY (player_id) REFERENCES Players(player_id),
	FOREIGN KEY (hole_id) REFERENCES Holes(hole_id)
);
CREATE TABLE Players_Matches (
        player_id INT,
	match_id INT,
	PRIMARY KEY (player_id, match_id),
	FOREIGN KEY (player_id) REFERENCES Players(player_id),
	FOREIGN KEY (match_id) REFERENCES Matches(match_id)
);
CREATE TABLE Matches_Holes (
        hole_id INT,
	match_id INT,
	PRIMARY KEY (hole_id, match_id),
	FOREIGN KEY (hole_id) REFERENCES Holes(hole_id),
	FOREIGN KEY (match_id) REFERENCES Matches(match_id)
);

CREATE TABLE LeagueScorecards (
        league_scorecard_id SERIAL PRIMARY KEY,
        league_id INT NOT NULL,
        course_name VARCHAR(60),
        match_date DATE DEFAULT CURRENT_TIMESTAMP,
        username VARCHAR(60),
        tee_selection VARCHAR(10),
        hole_1_score INT NOT NULL,
        hole_2_score INT NOT NULL,
        hole_3_score INT NOT NULL,
        hole_4_score INT NOT NULL,
        hole_5_score INT NOT NULL,
        hole_6_score INT NOT NULL,
        hole_7_score INT NOT NULL,
        hole_8_score INT NOT NULL,
        hole_9_score INT NOT NULL,
        hole_10_score INT NOT NULL,
        hole_11_score INT NOT NULL,
        hole_12_score INT NOT NULL,
        hole_13_score INT NOT NULL,
        hole_14_score INT NOT NULL,
        hole_15_score INT NOT NULL,
        hole_16_score INT NOT NULL,
        hole_17_score INT NOT NULL,
        hole_18_score INT NOT NULL,
        total_strokes INT NOT NULL,
        total_course_par INT NOT NULL,
        round_score_relative_to_par INT NOT NULL,
        FOREIGN KEY (league_id) REFERENCES Leagues(league_id),
        FOREIGN KEY (username) REFERENCES Users(username)
);

Begin;

--Populate Sample Course into Courses Table

INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Beechmont Country Club', 'Cleveland', 'Ohio', 44122, 'FG6H+HX Beachwood, Ohio', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);


INSERT INTO public.courses(
	course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, 
	red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par,
	red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)
	VALUES (DEFAULT, 'Chartiers Country Club', 'Pittsburgh', 'Pennsylvania', 15205, 'CWM4+XR Pittsburgh, Pennsylvania', DEFAULT, 'TRUE', DEFAULT, DEFAULT, 'TRUE', 'TRUE', DEFAULT,
			DEFAULT, 38, DEFAULT, DEFAULT, 35, 35, DEFAULT, DEFAULT, 38, DEFAULT, DEFAULT, 36, 36, DEFAULT, DEFAULT, 3262, DEFAULT, DEFAULT, 3262, 3262, DEFAULT, DEFAULT,
		   3400,DEFAULT,DEFAULT,3400,3400,DEFAULT,DEFAULT);

--Populate Sample Course Holes into Holes Table

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

--Populate a Match
INSERT INTO public.matches(course_id, start_date_time, number_of_players) 
VALUES (1, '2022-09-10', 3);


COMMIT;

--Populate Sample League into Leagues Table


INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/08/10', '2022/09/10', 'Test League', 'This league is just a test', 1);
	
--

INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/08/10', '2022/09/10', 'Test League', 'This league is just a test', 1);
	
--

INSERT INTO leagues(
	league_id, start_date, end_date, league_name, overview, course_id)
	VALUES(DEFAULT, '2022/08/10', '2022/09/10', 'Test League', 'This league is just a test', 1);
	
--Populate Sample Players into Players Table

INSERT INTO public.players(
player_id, image_path, first_name, last_name)
VALUES (DEFAULT, DEFAULT, 'John', 'Doe');
	
INSERT INTO public.players(
player_id, image_path, first_name, last_name)
VALUES (DEFAULT, DEFAULT, 'Bill', 'Bob');
	
INSERT INTO public.players(
player_id, image_path, first_name, last_name)
VALUES (DEFAULT, DEFAULT, 'John', 'Doe');

--Populate Sample Matches into Matches Table



INSERT INTO public.matches(course_id, start_date_time, number_of_players) VALUES (1, null, 4);

INSERT INTO public.matches(course_id, start_date_time, number_of_players)
VALUES (2, null, 4);
INSERT INTO public.matches(
course_id, start_date_time, number_of_players)
	VALUES (1, null, 3);
	
--Populate Sample Matches into Leaderboards Table

INSERT INTO public.leaderboards(start_date, end_date) VALUES (null, null);	
INSERT INTO public.leaderboards(start_date, end_date) VALUES (null, null);
INSERT INTO public.leaderboards(start_date, end_date) VALUES (null, null);
	
--Add permissions

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;