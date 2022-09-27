package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Hole;
import com.techelevator.model.LeagueScorecard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLeagueScorecardDao implements LeagueScorecardDao {


    private JdbcTemplate jdbcTemplate;

    public JdbcLeagueScorecardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //THIS METHOD IS WORKING
    @Override
    public LeagueScorecard createLeagueScorecard(LeagueScorecard leagueScorecard) {
        String sql = "INSERT INTO public.leaguescorecards(course_name, league_id, match_date, username, tee_selection, hole_1_score, hole_2_score, hole_3_score, hole_4_score, hole_5_score, hole_6_score, hole_7_score, hole_8_score, hole_9_score, hole_10_score, hole_11_score, hole_12_score, hole_13_score, hole_14_score, hole_15_score, hole_16_score, hole_17_score, hole_18_score, total_strokes, total_course_par, round_score_relative_to_par) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING league_scorecard_id;";
        Integer newLeagueScorecardId = jdbcTemplate.queryForObject(sql, Integer.class,
                leagueScorecard.getCourseName(), leagueScorecard.getLeagueId(),leagueScorecard.getMatchDate(),leagueScorecard.getUsername(),leagueScorecard.getTeeSelection(),leagueScorecard.getHole1Score(),leagueScorecard.getHole2Score(),leagueScorecard.getHole3Score(),leagueScorecard.getHole4Score(),leagueScorecard.getHole5Score(),leagueScorecard.getHole6Score(),leagueScorecard.getHole7Score(),leagueScorecard.getHole8Score(),leagueScorecard.getHole9Score(),leagueScorecard.getHole10Score(),leagueScorecard.getHole11Score(),leagueScorecard.getHole12Score(),leagueScorecard.getHole13Score(),leagueScorecard.getHole14Score(),leagueScorecard.getHole15Score(),leagueScorecard.getHole16Score(),leagueScorecard.getHole17Score(),leagueScorecard.getHole18Score(),leagueScorecard.getTotalStrokes(),leagueScorecard.getTotalCoursePar(),leagueScorecard.getRoundScoreRelativeToPar());
        return getLeagueScorecard(newLeagueScorecardId);
    }


    @Override
    public LeagueScorecard getLeagueScorecard(Integer leagueScorecardId) {
        LeagueScorecard leagueScorecard = new LeagueScorecard();
        String sql = "SELECT league_scorecard_id, league_id, course_name, match_date, username, tee_selection, hole_1_score, hole_2_score, hole_3_score, hole_4_score, hole_5_score, hole_6_score, hole_7_score, hole_8_score, hole_9_score, hole_10_score, hole_11_score, hole_12_score, hole_13_score, hole_14_score, hole_15_score, hole_16_score, hole_17_score, hole_18_score, total_strokes, total_course_par, round_score_relative_to_par FROM public.leaguescorecards WHERE league_scorecard_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueScorecardId);
        while (results.next()) {
            leagueScorecard = mapRowToLeagueScorecard(results);
        }
        return leagueScorecard;
    }


    @Override
    public List<LeagueScorecard> getLeagueScorecards(Integer leagueId) {
        List<LeagueScorecard> results = new ArrayList<>();
        String sql = "SELECT league_scorecard_id, league_id, course_name, match_date, username, tee_selection, hole_1_score, hole_2_score, hole_3_score, hole_4_score, hole_5_score, hole_6_score, hole_7_score, hole_8_score, hole_9_score, hole_10_score, hole_11_score, hole_12_score, hole_13_score, hole_14_score, hole_15_score, hole_16_score, hole_17_score, hole_18_score, total_strokes, total_course_par, round_score_relative_to_par FROM public.leaguescorecards WHERE league_id = ? order by round_score_relative_to_par;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (rowSet.next()) {
            LeagueScorecard leagueScorecard = mapRowToLeagueScorecard(rowSet);
            results.add(leagueScorecard);
        }

        return results;
    }


    public LeagueScorecard mapRowToLeagueScorecard(SqlRowSet rowSet) {
        LeagueScorecard leagueScorecard = new LeagueScorecard();

        leagueScorecard.setLeagueScorecardId((Integer)rowSet.getObject("league_scorecard_id"));
        leagueScorecard.setLeagueId((Integer)rowSet.getObject("league_id"));
        leagueScorecard.setCourseName(rowSet.getString("course_name"));
        leagueScorecard.setMatchDate(rowSet.getDate("match_date"));
        leagueScorecard.setUsername(rowSet.getString("username"));
        leagueScorecard.setTeeSelection(rowSet.getString("tee_selection"));

        leagueScorecard.setHole1Score((Integer)rowSet.getObject("hole_1_score"));
        leagueScorecard.setHole2Score((Integer)rowSet.getObject("hole_2_score"));
        leagueScorecard.setHole3Score((Integer)rowSet.getObject("hole_3_score"));
        leagueScorecard.setHole4Score((Integer)rowSet.getObject("hole_4_score"));
        leagueScorecard.setHole5Score((Integer)rowSet.getObject("hole_5_score"));
        leagueScorecard.setHole6Score((Integer)rowSet.getObject("hole_6_score"));
        leagueScorecard.setHole7Score((Integer)rowSet.getObject("hole_7_score"));
        leagueScorecard.setHole8Score((Integer)rowSet.getObject("hole_8_score"));
        leagueScorecard.setHole9Score((Integer)rowSet.getObject("hole_9_score"));
        leagueScorecard.setHole10Score((Integer)rowSet.getObject("hole_10_score"));
        leagueScorecard.setHole11Score((Integer)rowSet.getObject("hole_11_score"));
        leagueScorecard.setHole12Score((Integer)rowSet.getObject("hole_12_score"));
        leagueScorecard.setHole13Score((Integer)rowSet.getObject("hole_13_score"));
        leagueScorecard.setHole14Score((Integer)rowSet.getObject("hole_14_score"));
        leagueScorecard.setHole15Score((Integer)rowSet.getObject("hole_15_score"));
        leagueScorecard.setHole16Score((Integer)rowSet.getObject("hole_16_score"));
        leagueScorecard.setHole17Score((Integer)rowSet.getObject("hole_17_score"));
        leagueScorecard.setHole18Score((Integer)rowSet.getObject("hole_18_score"));

        leagueScorecard.setTotalStrokes((Integer)rowSet.getObject("total_strokes"));
        leagueScorecard.setTotalCoursePar((Integer)rowSet.getObject("total_course_par"));
        leagueScorecard.setRoundScoreRelativeToPar((Integer)rowSet.getObject("round_score_relative_to_par"));



        return leagueScorecard;

    }


}
