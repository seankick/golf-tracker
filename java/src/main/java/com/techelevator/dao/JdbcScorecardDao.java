package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Hole;
import com.techelevator.model.Scorecard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.IsolationLevelDataSourceAdapter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcScorecardDao implements ScorecardDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcScorecardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Scorecard getScorecard(Integer courseId, String teeSelection) {

        String sql2 = "SELECT hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, holes.course_id FROM holes JOIN courses ON Holes.course_id=Courses.course_id WHERE courses.course_id = ?;";
        SqlRowSet holeResults = jdbcTemplate.queryForRowSet(sql2, courseId);
        List<Hole> holes = new ArrayList<>();
        while (holeResults.next()) {
            Hole hole = mapRowToHole(holeResults);
            holes.add(hole);
        }
        Hole[] myArray = new Hole[holes.size()];
        holes.toArray(myArray);

        Course course = new Course();
        String sql1 = "SELECT course_name, red_tee_front_par, red_tee_back_par, red_tee_front_nine_yardage, red_tee_back_nine_yardage FROM courses WHERE course_id = ? LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql1, courseId);
        while (results.next()) {
            course = mapRowToCourse(results);
        }

        Scorecard scorecard = courseHolesMapper(course, myArray, teeSelection);
        return scorecard;


    }


    public Scorecard courseHolesMapper(Course course, Hole[] myArray, String teeSelection) {
        Scorecard scorecard = new Scorecard();

        scorecard.setCourseName(course.getCourseName());
        scorecard.setTeeSelection(teeSelection);

        scorecard.setFrontPar(course.getRedTeeFrontPar());
        scorecard.setBackPar(course.getRedTeeBackPar());
        scorecard.setFrontYardage(course.getRedTeeFrontYards());
        scorecard.setBackYardage(course.getRedTeeBackYards());

        scorecard.setFrontPar(course.getRedTeeFrontPar());
        scorecard.setBackPar(course.getRedTeeBackPar());
        scorecard.setFrontYardage(course.getRedTeeFrontYards());
        scorecard.setBackYardage(course.getRedTeeBackYards());
        
        scorecard.setHoles1(myArray[0]);
        scorecard.setHoles2(myArray[1]);
        scorecard.setHoles3(myArray[2]);
        scorecard.setHoles4(myArray[3]);
        scorecard.setHoles5(myArray[4]);
        scorecard.setHoles6(myArray[5]);
        scorecard.setHoles7(myArray[6]);
        scorecard.setHoles8(myArray[7]);
        scorecard.setHoles9(myArray[8]);
        scorecard.setHoles10(myArray[9]);
        scorecard.setHoles11(myArray[10]);
        scorecard.setHoles12(myArray[11]);
        scorecard.setHoles13(myArray[12]);
        scorecard.setHoles14(myArray[13]);
        scorecard.setHoles15(myArray[14]);
        scorecard.setHoles16(myArray[15]);
        scorecard.setHoles17(myArray[16]);
        scorecard.setHoles18(myArray[17]);

        return scorecard;
    }


    public Course mapRowToCourse(SqlRowSet rowSet) {
        Course course = new Course();
        course.setCourseName(rowSet.getString("course_name"));
        course.setRedTeeFrontPar((Integer) rowSet.getObject("red_tee_front_par"));
        course.setRedTeeBackPar((Integer) rowSet.getObject("red_tee_back_par"));
        course.setRedTeeFrontYards((Integer) rowSet.getObject("red_tee_front_nine_yardage"));
        course.setRedTeeBackYards((Integer) rowSet.getObject("red_tee_back_nine_yardage"));


        return course;
    }

    public Hole mapRowToHole(SqlRowSet rowSet) {
        Hole hole = new Hole();
        hole.setHoleId((Integer) rowSet.getObject("hole_id"));
        hole.setHoleNumber((Integer) rowSet.getObject("hole_number"));

        hole.setParRed((Integer) rowSet.getObject("par_red"));
        hole.setParGold((Integer) rowSet.getObject("par_gold"));
        hole.setParWhite((Integer) rowSet.getObject("par_white"));
        hole.setParBlack((Integer) rowSet.getObject("par_black"));
        hole.setParBlue((Integer) rowSet.getObject("par_blue"));
        hole.setParGreen((Integer) rowSet.getObject("par_green"));
        hole.setParSilver((Integer) rowSet.getObject("par_silver"));

        hole.setYardageRed((Integer) rowSet.getObject("yardage_red"));
        hole.setYardageGold((Integer) rowSet.getObject("yardage_gold"));
        hole.setYardageWhite((Integer) rowSet.getObject("yardage_white"));
        hole.setYardageBlack((Integer) rowSet.getObject("yardage_black"));
        hole.setYardageBlue((Integer) rowSet.getObject("yardage_blue"));
        hole.setYardageGreen((Integer) rowSet.getObject("yardage_green"));
        hole.setYardageSilver((Integer) rowSet.getObject("yardage_silver"));

        hole.setHandicapRed((Integer) rowSet.getObject("handicap_red"));
        hole.setHandicapGold((Integer) rowSet.getObject("handicap_gold"));
        hole.setHandicapWhite((Integer) rowSet.getObject("handicap_white"));
        hole.setHandicapBlack((Integer) rowSet.getObject("handicap_black"));
        hole.setHandicapBlue((Integer) rowSet.getObject("handicap_blue"));
        hole.setHandicapGreen((Integer) rowSet.getObject("handicap_green"));
        hole.setHandicapSilver((Integer) rowSet.getObject("handicap_silver"));

        hole.setCourseId((Integer) rowSet.getObject("course_id"));

        return hole;

    }
}


