package com.techelevator.dao;

import com.techelevator.model.LeagueScorecard;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LeagueScorecardDao {
    public LeagueScorecard createLeagueScorecard(LeagueScorecard leagueScorecard);
    public LeagueScorecard getLeagueScorecard(Integer leagueScorecardId);
    public List<LeagueScorecard> getLeagueScorecards(Integer league_id);
}
