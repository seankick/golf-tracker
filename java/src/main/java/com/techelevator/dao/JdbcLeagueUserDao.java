package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.LeagueUser;
import com.techelevator.model.Match;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcLeagueUserDao implements LeagueUserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLeagueUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //THIS METHOD IS WORKING
    @Override
    public LeagueUser createLeagueUser(LeagueUser leagueUser) {
        String sql = "INSERT INTO public.users_leagues(user_id, league_id) VALUES (?, ?) RETURNING user_league_id;";
        Integer userLeagueId = jdbcTemplate.queryForObject(sql, Integer.class, leagueUser.getUserId(), leagueUser.getLeagueId());
        return getLeagueUser(userLeagueId);
    }

    @Override
    public LeagueUser getLeagueUser(Integer leagueUserId) {
        LeagueUser leagueUser = new LeagueUser();

        String sql = "SELECT user_league_id, user_id, league_id FROM public.users_leagues;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueUserId);
        while (results.next()) {
            leagueUser = mapRowToLeagueUser(results);
        }
        return leagueUser;
    }

    public LeagueUser mapRowToLeagueUser(SqlRowSet rowSet) {
        LeagueUser leagueUser = new LeagueUser();
        leagueUser.setUserLeagueId((Integer) rowSet.getObject("user_league_id"));
        leagueUser.setUserId((Integer) rowSet.getObject("user_id"));
        leagueUser.setLeagueId((Integer) rowSet.getObject("league_id"));

        return leagueUser;
    }

}