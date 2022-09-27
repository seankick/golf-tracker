package com.techelevator.dao;

import com.techelevator.model.Match;

import java.sql.Timestamp;
import java.util.List;

import java.util.Date;

public interface MatchDao {
    Match createMatch(Match match);

    Match getMatch(Integer matchId);

    List<Match> getMatches();

    void updateMatch(Match match, Integer matchId);

    void deleteMatch(Integer matchId);

    List<Match> getMatchesByLeague(int leagueId);

    List<Match> getMatchesByPlayer(int playerId);
}
