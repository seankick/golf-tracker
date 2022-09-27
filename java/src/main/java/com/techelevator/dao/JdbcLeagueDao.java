package com.techelevator.dao;

import com.techelevator.model.League;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcLeagueDao implements LeagueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLeagueDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public League createLeague(League league) {
        String sql = "INSERT INTO leagues(" +
                "start_date, end_date, league_name, overview, course_id) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING league_id;";
        Integer leagueId = jdbcTemplate.queryForObject(sql, Integer.class, league.getStartDate(),
                                                        league.getEndDate(), league.getLeagueName(), league.getOverview(), league.getCourseId());

        return getLeague(leagueId);
    }



    @Override
    public League getLeague(Integer leagueId) {
        League league = new League();
        String sql = "SELECT league_id, start_date, end_date, league_name, overview, course_id " +
                "FROM leagues WHERE league_id=?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueId);
        while(results.next()){
            league = mapRowToLeague(results);
        }
        return league;
    }

    @Override
    public List<League> getLeagues() {
        List<League> results = new ArrayList<>();

        String sql = "SELECT league_id, start_date, end_date, league_name, overview, course_id " +
                "FROM leagues ;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            League league = mapRowToLeague(rowSet);
            results.add(league);
        }
        return results;
    }

    @Override
    public void  updateLeague(League league) {
        String sql = "UPDATE leagues " +
                "SET start_date=?, end_date=?, league_name=?, overview=?, course_id=? " +
                "WHERE league_id = ?;";

        jdbcTemplate.update(sql, league.getStartDate(),
                                 league.getEndDate(), league.getLeagueName(), league.getOverview(), league.getCourseId(), league.getLeagueId());

    }

    @Override
    public void deleteLeague(Integer leagueId) {
        String sql = "DELETE FROM leagues " +
                "WHERE league_id = ?;";
        jdbcTemplate.update(sql, leagueId);

    }
    @Override
    public List<League> getLeaguesByPlayer(Integer playerId) {
        List<League> leagues = new ArrayList<>();
        String sql = "SELECT leagues.league_id, leagues.start_date,leagues. end_date, leagues.league_name, leagues.overview, leagues.course_id FROM leagues JOIN players_leagues ON players_leagues.league_id = leagues.league_id WHERE players_leagues.player_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);
        while (results.next()) {
            League league = mapRowToLeague(results);
            leagues.add(league);
        }
        return leagues;
    }

    @Override
    public List<League> getLeaguesByCourse(int courseId) {
        List<League> leagues = new ArrayList<>();
        String sql = "SELECT leagues.league_id, leagues.start_date,leagues. " +
                "end_date, leagues.league_name, leagues.overview, leagues.course_id FROM leagues " +
                "WHERE course_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            League league = mapRowToLeague(results);
            leagues.add(league);
        }
        return leagues;
    }

    public League mapRowToLeague(SqlRowSet rowSet){
        League league = new League();
        league.setLeagueId((Integer)rowSet.getObject("league_id"));
        league.setStartDate(rowSet.getDate("start_date"));
        league.setEndDate(rowSet.getDate("end_date"));
        league.setLeagueName(rowSet.getString("league_name"));
        league.setOverview(rowSet.getString("overview"));
        league.setCourseId((Integer)rowSet.getObject("course_id"));


        return league;
    }
}
