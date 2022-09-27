package com.techelevator.dao;

import com.techelevator.model.Hole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcHoleDao implements HoleDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcHoleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //THIS METHOD IS WORKING
    @Override
    public Hole createHole(Integer courseId, Hole hole) {
        String sql = "INSERT INTO public.holes(hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, " +
                "yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, " +
                "handicap_black, handicap_blue, handicap_green, handicap_silver, course_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING hole_id;";
        Integer newHoleId = jdbcTemplate.queryForObject(sql, Integer.class,
                hole.getHoleNumber(),hole.getParRed(),hole.getParGold(),hole.getParWhite(), hole.getParBlack(), hole.getParBlue(), hole.getParGreen(),
                hole.getParSilver(), hole.getYardageRed(), hole.getYardageGold(), hole.getYardageWhite(), hole.getYardageBlack(), hole.getYardageBlue(),
                hole.getYardageGreen(), hole.getYardageSilver(), hole.getHandicapRed(), hole.getHandicapGold(), hole.getHandicapWhite(), hole.getHandicapBlack(),
                hole.getHandicapBlue(),hole.getHandicapGreen(),hole.getHandicapSilver(),hole.getCourseId());
        return getHoleByCourseId(courseId, hole.getHoleNumber());
    }

    @Override
    public List<Hole> getAllHoles() {
        List<Hole> holes = new ArrayList<>();
        String sql = "SELECT hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id FROM public.holes;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Hole hole = mapRowToHole(results);
            holes.add(hole);
        }
        return holes;
    }

    @Override
    public Hole getHole(Integer holeId) {
        Hole hole = new Hole();
        String sql = "SELECT hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, " +
                "yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, " +
                "handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id " +
                "FROM holes WHERE hole_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, holeId);
        while (results.next()) {
            hole = mapRowToHole(results);
        }
        return hole;
    }

    //THIS METHOD IS WORKING
    @Override
    public List<Hole> getHolesByCourseId(Integer courseId) {
        List<Hole> holes = new ArrayList<>();
        String sql = "SELECT hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, " +
                "yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, " +
                "handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id FROM public.holes WHERE course_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            Hole hole = mapRowToHole(results);
            holes.add(hole);
        }
        return holes;

    }

    //THIS METHOD IS WORKING
    @Override
    public Hole getHoleByCourseId(Integer courseId, Integer holeNumber) {
        Hole hole = new Hole();
        String sql = "SELECT hole_id, hole_number, par_red, par_gold, par_white, par_black, par_blue, par_green, par_silver, yardage_red, " +
                "yardage_gold, yardage_white, yardage_black, yardage_blue, yardage_green, yardage_silver, handicap_red, handicap_gold, " +
                "handicap_white, handicap_black, handicap_blue, handicap_green, handicap_silver, course_id FROM public.holes " +
                "WHERE course_id = ? AND hole_number = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId, holeNumber);
        while(results.next()) {
            hole = mapRowToHole(results);
        }
        return hole;
    }

    //THIS METHOD IS WORKING
    @Override
    public void updateHole(Hole hole, Integer holeId) {
        String sql = "UPDATE public.holes" +
                " SET hole_number=?, par_red=?, par_gold=?, par_white=?, par_black=?, par_blue=?," +
                " par_green=?, par_silver=?, yardage_red=?, yardage_gold=?, yardage_white=?, yardage_black=?," +
                " yardage_blue=?, yardage_green=?, yardage_silver=?, handicap_red=?, handicap_gold=?, handicap_white=?," +
                " handicap_black=?, handicap_blue=?, handicap_green=?, handicap_silver=?, course_id=?" +
                " WHERE hole_id=?;";
        jdbcTemplate.update(sql, hole.getHoleNumber(), hole.getParRed(), hole.getParGold(), hole.getParWhite(), hole.getParBlack(), hole.getParBlue(),
                hole.getParGreen(), hole.getParSilver(), hole.getYardageRed(), hole.getYardageGold(), hole.getYardageWhite(), hole.getYardageBlack(),
                hole.getYardageBlue(), hole.getYardageGreen(), hole.getYardageSilver(), hole.getHandicapRed(), hole.getHandicapGold(), hole.getHandicapWhite(),
                hole.getHandicapBlack(), hole.getHandicapBlue(), hole.getHandicapGreen(), hole.getHandicapSilver(), hole.getCourseId(), hole.getHoleId());
    }

    //THIS METHOD IS WORKING
    @Override
    public void deleteHole(Integer holeId) {
        String sql = "DELETE FROM holes WHERE hole_id = ?;";
        jdbcTemplate.update(sql, holeId);
    }

    //THIS METHOD IS WORKING

    public Hole mapRowToHole(SqlRowSet rowSet) {
        Hole hole = new Hole();
        hole.setHoleId((Integer)rowSet.getObject("hole_id"));
        hole.setHoleNumber((Integer)rowSet.getObject("hole_number"));

        hole.setParRed((Integer)rowSet.getObject("par_red"));
        hole.setParGold((Integer)rowSet.getObject("par_gold"));
        hole.setParWhite((Integer)rowSet.getObject("par_white"));
        hole.setParBlack((Integer)rowSet.getObject("par_black"));
        hole.setParBlue((Integer)rowSet.getObject("par_blue"));
        hole.setParGreen((Integer)rowSet.getObject("par_green"));
        hole.setParSilver((Integer)rowSet.getObject("par_silver"));

        hole.setYardageRed((Integer)rowSet.getObject("yardage_red"));
        hole.setYardageGold((Integer)rowSet.getObject("yardage_gold"));
        hole.setYardageWhite((Integer)rowSet.getObject("yardage_white"));
        hole.setYardageBlack((Integer)rowSet.getObject("yardage_black"));
        hole.setYardageBlue((Integer)rowSet.getObject("yardage_blue"));
        hole.setYardageGreen((Integer)rowSet.getObject("yardage_green"));
        hole.setYardageSilver((Integer)rowSet.getObject("yardage_silver"));

        hole.setHandicapRed((Integer)rowSet.getObject("handicap_red"));
        hole.setHandicapGold((Integer)rowSet.getObject("handicap_gold"));
        hole.setHandicapWhite((Integer)rowSet.getObject("handicap_white"));
        hole.setHandicapBlack((Integer)rowSet.getObject("handicap_black"));
        hole.setHandicapBlue((Integer)rowSet.getObject("handicap_blue"));
        hole.setHandicapGreen((Integer)rowSet.getObject("handicap_green"));
        hole.setHandicapSilver((Integer)rowSet.getObject("handicap_silver"));

        hole.setCourseId((Integer)rowSet.getObject("course_id"));

        return hole;

    }
}
