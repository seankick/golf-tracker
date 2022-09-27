package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseDao implements CourseDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //THIS METHOD IS WORKING
    @Override
    public Course createCourse(Course course) {
        String sql = "INSERT INTO public.courses(course_name, city, state_name, postal_code, google_map_plus_code," +
                " picture_path, red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par," +
                " gold_tee_front_par, white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par," +
                " silver_tee_front_par, red_tee_back_par, gold_tee_back_par, white_tee_back_par, black_tee_back_par," +
                " blue_tee_back_par, green_tee_back_par, silver_tee_back_par, red_tee_front_nine_yardage, gold_tee_front_nine_yardage," +
                " white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage," +
                " silver_tee_front_nine_yardage, red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage," +
                " black_tee_back_nine_yardage, blue_tee_back_nine_yardage, green_tee_back_nine_yardage, silver_tee_back_nine_yardage)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                " RETURNING course_id;";
        Integer courseId = jdbcTemplate.queryForObject(sql, Integer.class, course.getCourseName(), course.getCity(), course.getState(), course.getPostalCode(), course.getGooglePlusCode(),
                course.getImagePath(), course.getRedTeeExists(), course.getGoldTeeExists(), course.getWhiteTeeExists(), course.getBlackTeeExists(), course.getBlueTeeExists(),
                course.getGreenTeeExists(), course.getSilverTeeExists(), course.getRedTeeFrontPar(), course.getGoldTeeFrontPar(), course.getWhiteTeeFrontPar(), course.getBlackTeeFrontPar(),
                course.getBlueTeeFrontPar(), course.getGreenTeeFrontPar(), course.getSilverTeeFrontPar(), course.getRedTeeBackPar(), course.getGoldTeeBackPar(), course.getWhiteTeeBackPar(),
                course.getBlackTeeBackPar(), course.getBlueTeeBackPar(), course.getGreenTeeBackPar(), course.getSilverTeeBackPar(), course.getRedTeeFrontYards(), course.getGoldFrontYards(),
                course.getWhiteFrontYards(), course.getBlackFrontYards(), course.getBlueFrontYards(), course.getGreenFrontYards(), course.getSilverFrontYards(), course.getRedTeeBackYards(),
                course.getGoldBackYards(), course.getWhiteBackYards(), course.getBlackBackYards(), course.getBlueBackYards(), course.getGreenBackYards(), course.getSilverBackYards());
        return getCourse(courseId);
    }

    //THIS METHOD IS WORKING
    @Override
    public Course getCourse(Integer courseId) {
        Course course = new Course();

        String sql = "SELECT course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, " +
                "red_tee, gold_tee, white_tee, black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, " +
                "white_tee_front_par, black_tee_front_par, blue_tee_front_par, green_tee_front_par, silver_tee_front_par, red_tee_back_par, " +
                "gold_tee_back_par, white_tee_back_par, black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par," +
                "red_tee_front_nine_yardage, gold_tee_front_nine_yardage, white_tee_front_nine_yardage, black_tee_front_nine_yardage, " +
                "blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, red_tee_back_nine_yardage, " +
                "gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, " +
                "green_tee_back_nine_yardage, silver_tee_back_nine_yardage " +
                "FROM courses " +
                "WHERE course_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            course = mapRowToCourse(results);
        }
        return course;
    }

    //THIS METHOD IS WORKING
    @Override
    public List<Course> getCourses() {
        List<Course> results = new ArrayList<>();
        String sql = "SELECT course_id, course_name, city, state_name, postal_code, google_map_plus_code, picture_path, red_tee, gold_tee, white_tee, " +
                "black_tee, blue_tee, green_tee, silver_tee, red_tee_front_par, gold_tee_front_par, white_tee_front_par, black_tee_front_par, " +
                "blue_tee_front_par, green_tee_front_par, silver_tee_front_par, red_tee_back_par, gold_tee_back_par, white_tee_back_par, " +
                "black_tee_back_par, blue_tee_back_par, green_tee_back_par, silver_tee_back_par, red_tee_front_nine_yardage, gold_tee_front_nine_yardage, " +
                "white_tee_front_nine_yardage, black_tee_front_nine_yardage, blue_tee_front_nine_yardage, green_tee_front_nine_yardage, silver_tee_front_nine_yardage, " +
                "red_tee_back_nine_yardage, gold_tee_back_nine_yardage, white_tee_back_nine_yardage, black_tee_back_nine_yardage, blue_tee_back_nine_yardage, " +
                "green_tee_back_nine_yardage, silver_tee_back_nine_yardage FROM courses;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Course course = mapRowToCourse(rowSet);
            results.add(course);
        }

        return results;
    }
    //THIS METHOD WORKS
    @Override
    public void updateCourse(Course course, Integer courseId) {
        String sql = "UPDATE courses" +
                " SET course_name=?, city=?, state_name=?, postal_code=?, google_map_plus_code=?, picture_path=?," +
                " red_tee=?, gold_tee=?, white_tee=?, black_tee=?, blue_tee=?, green_tee=?, silver_tee=?, red_tee_front_par=?," +
                " gold_tee_front_par=?, white_tee_front_par=?, black_tee_front_par=?, blue_tee_front_par=?, green_tee_front_par=?," +
                " silver_tee_front_par=?, red_tee_back_par=?, gold_tee_back_par=?, white_tee_back_par=?, black_tee_back_par=?, blue_tee_back_par=?," +
                " green_tee_back_par=?, silver_tee_back_par=?, red_tee_front_nine_yardage=?, gold_tee_front_nine_yardage=?, white_tee_front_nine_yardage=?," +
                " black_tee_front_nine_yardage=?, blue_tee_front_nine_yardage=?, green_tee_front_nine_yardage=?, silver_tee_front_nine_yardage=?," +
                " red_tee_back_nine_yardage=?, gold_tee_back_nine_yardage=?, white_tee_back_nine_yardage=?, black_tee_back_nine_yardage=?, " +
                "blue_tee_back_nine_yardage=?, green_tee_back_nine_yardage=?, silver_tee_back_nine_yardage=?" +
                " WHERE course_id =? ;";
        jdbcTemplate.update(sql, course.getCourseName(), course.getCity(), course.getState(), course.getPostalCode(), course.getGooglePlusCode(),
                course.getImagePath(), course.getRedTeeExists(), course.getGoldTeeExists(), course.getWhiteTeeExists(), course.getBlackTeeExists(), course.getBlueTeeExists(),
                course.getGreenTeeExists(), course.getSilverTeeExists(), course.getRedTeeFrontPar(), course.getGoldTeeFrontPar(), course.getWhiteTeeFrontPar(), course.getBlackTeeFrontPar(),
                course.getBlueTeeFrontPar(), course.getGreenTeeFrontPar(), course.getSilverTeeFrontPar(), course.getRedTeeBackPar(), course.getGoldTeeBackPar(), course.getWhiteTeeBackPar(),
                course.getBlackTeeBackPar(), course.getBlueTeeBackPar(), course.getGreenTeeBackPar(), course.getSilverTeeBackPar(), course.getRedTeeFrontYards(), course.getGoldFrontYards(),
                course.getWhiteFrontYards(), course.getBlackFrontYards(), course.getBlueFrontYards(), course.getGreenFrontYards(), course.getSilverFrontYards(), course.getRedTeeBackYards(),
                course.getGoldBackYards(), course.getWhiteBackYards(), course.getBlackBackYards(), course.getBlueBackYards(), course.getGreenBackYards(), course.getSilverBackYards(),  course.getCourseId());

    }

    //THIS METHOD WORKS
    @Override
    public void deleteCourse(Integer courseId) {
        String sql = "DELETE FROM courses WHERE course_id = ?;";
        jdbcTemplate.update(sql, courseId);
    }

    //THIS METHOD IS WORKING
    public Course mapRowToCourse(SqlRowSet rowSet) {
        Course course = new Course();
        course.setCourseId((Integer)rowSet.getObject("course_id"));
        course.setCourseName(rowSet.getString("course_name"));
        course.setCity(rowSet.getString("city"));
        course.setState(rowSet.getString("state_name"));
        course.setPostalCode((Integer)rowSet.getObject("postal_code"));

        course.setGooglePlusCode(rowSet.getString("google_map_plus_code"));
        course.setImagePath(rowSet.getString("picture_path"));

        course.setRedTeeExists(rowSet.getBoolean("red_tee"));
        course.setGoldTeeExists(rowSet.getBoolean("gold_tee"));
        course.setWhiteTeeExists(rowSet.getBoolean("white_tee"));
        course.setBlackTeeExists(rowSet.getBoolean("black_tee"));
        course.setBlueTeeExists(rowSet.getBoolean("blue_tee"));
        course.setGreenTeeExists(rowSet.getBoolean("green_tee"));
        course.setSilverTeeExists(rowSet.getBoolean("silver_tee"));

        course.setRedTeeFrontPar((Integer)rowSet.getObject("red_tee_front_par"));
        course.setGoldTeeFrontPar((Integer)rowSet.getObject("gold_tee_front_par"));
        course.setWhiteTeeFrontPar((Integer)rowSet.getObject("white_tee_front_par"));
        course.setBlackTeeFrontPar((Integer)rowSet.getObject("black_tee_front_par"));
        course.setBlueTeeFrontPar((Integer)rowSet.getObject("blue_tee_front_par"));
        course.setGreenTeeFrontPar((Integer)rowSet.getObject("green_tee_front_par"));
        course.setSilverTeeFrontPar((Integer)rowSet.getObject("silver_tee_front_par"));

        course.setRedTeeBackPar((Integer)rowSet.getObject("red_tee_back_par"));
        course.setGoldTeeBackPar((Integer)rowSet.getObject("gold_tee_back_par"));
        course.setWhiteTeeBackPar((Integer)rowSet.getObject("white_tee_back_par"));
        course.setBlackTeeBackPar((Integer)rowSet.getObject("black_tee_back_par"));
        course.setBlueTeeBackPar((Integer)rowSet.getObject("blue_tee_back_par"));
        course.setGreenTeeBackPar((Integer)rowSet.getObject("green_tee_back_par"));
        course.setSilverTeeBackPar((Integer)rowSet.getObject("silver_tee_back_par"));

        course.setRedTeeFrontYards((Integer)rowSet.getObject("red_tee_front_nine_yardage"));
        course.setGoldFrontYards((Integer)rowSet.getObject("gold_tee_front_nine_yardage"));
        course.setWhiteFrontYards((Integer)rowSet.getObject("white_tee_front_nine_yardage"));
        course.setBlackFrontYards((Integer)rowSet.getObject("black_tee_front_nine_yardage"));
        course.setBlueFrontYards((Integer)rowSet.getObject("blue_tee_front_nine_yardage"));
        course.setGreenFrontYards((Integer)rowSet.getObject("green_tee_front_nine_yardage"));
        course.setSilverFrontYards((Integer)rowSet.getObject("silver_tee_front_nine_yardage"));

        course.setRedTeeBackYards((Integer)rowSet.getObject("red_tee_back_nine_yardage"));
        course.setGoldBackYards((Integer)rowSet.getObject("gold_tee_back_nine_yardage"));
        course.setWhiteBackYards((Integer)rowSet.getObject("white_tee_back_nine_yardage"));
        course.setBlackBackYards((Integer)rowSet.getObject("black_tee_back_nine_yardage"));
        course.setBlueBackYards((Integer)rowSet.getObject("blue_tee_back_nine_yardage"));
        course.setGreenBackYards((Integer)rowSet.getObject("green_tee_back_nine_yardage"));
        course.setSilverBackYards((Integer)rowSet.getObject("silver_tee_back_nine_yardage"));

        return course;
    }
}
