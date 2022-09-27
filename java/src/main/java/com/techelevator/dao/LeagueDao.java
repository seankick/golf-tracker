package com.techelevator.dao;

import com.techelevator.model.League;

import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;

public interface LeagueDao {

    League createLeague(League league);

    League getLeague(Integer leagueId);

    List<League> getLeagues();

    void  updateLeague(League league);

    void deleteLeague(Integer leagueId);

    List<League> getLeaguesByPlayer(Integer playerId);

    List<League> getLeaguesByCourse(int courseId);
}
