package com.techelevator.dao;

import com.techelevator.model.Match;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcMatchDao implements MatchDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMatchDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Match createMatch(Match match) {
        String sql = "INSERT INTO public.matches(course_id, start_date_time, number_of_players)" +
                " VALUES (?, ?, ?)" +
                " RETURNING match_id;";
        Integer matchId = jdbcTemplate.queryForObject(sql, Integer.class, match.getCourseId(),match.getStartDateTime(), match.getNumberOfPlayers());
                return getMatch(matchId);
    }


    //THIS METHOD WORKS
    @Override
    public Match getMatch(Integer matchId) {
        Match match = new Match();
        String sql = "SELECT match_id, courses.course_id, course_name, start_date_time, number_of_players " +
                "FROM matches " +
                "JOIN courses on courses.course_id = matches.course_id " +
                "WHERE match_id=?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchId);
        while(results.next()){
            match = mapRowToMatch(results);
        }
        return match;
    }

    //THIS METHOD WORKS
    @Override
    public List<Match> getMatches() {
        List<Match> results = new ArrayList<>();

        String sql = "SELECT match_id, courses.course_id, course_name, start_date_time, number_of_players " +
                "From matches " +
                " JOIN courses on courses.course_id = matches.course_id ;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Match match = mapRowToMatch(rowSet);
            results.add(match);
        }
        return results;
    }

    //THIS METHOD WORKS
    @Override
    public void updateMatch(Match match, Integer matchId) {
        String sql = "UPDATE matches " +
                "SET  course_id=?, start_date_time=?, number_of_players=?, leaderboard_id=? WHERE match_id=?;";

        jdbcTemplate.update(sql, match.getCourseId(), match.getStartDateTime(), match.getMatchId());

    }

    //THIS METHOD WORKS
    @Override
    public void deleteMatch(Integer matchId) {
        String sql = "DELETE FROM matches " +
                "WHERE match_id=?;";
        jdbcTemplate.update(sql, matchId);
    }

    @Override
    public List<Match> getMatchesByLeague(int leagueId) {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT matches.match_id, matches.course_id, matches.start_date_time, matches.number_of_players," +
                " FROM matches WHERE league_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (results.next()) {
            Match match = mapRowToMatch(results);
            matches.add(match);
        }
        return matches;
    }

    @Override
    public List<Match> getMatchesByPlayer(int playerId) {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT matches.match_id, matches.course_id, matches.start_date_time, matches.number_of_players," +
                " FROM matches JOIN players_matches ON matches.match_id = players_matches.match_id WHERE players_matches.player_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);
        while (results.next()) {
            Match match = mapRowToMatch(results);
            matches.add(match);
        }
        return matches;
    }

    private Match mapRowToMatch(SqlRowSet rowSet) {
    Match match = new Match();
    match.setMatchId((Integer)rowSet.getObject("match_id"));
    match.setCourseId((Integer)rowSet.getObject("course_id"));
    match.setCourseName(rowSet.getString("course_name"));
    match.setStartDateTime(rowSet.getTimestamp("start_date_time"));
    match.setNumberOfPlayers(rowSet.getInt("number_of_players"));

    return match;
    }
}
