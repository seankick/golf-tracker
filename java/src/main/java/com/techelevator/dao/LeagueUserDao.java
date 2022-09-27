package com.techelevator.dao;

import com.techelevator.model.LeagueUser;

public interface LeagueUserDao {

    public LeagueUser createLeagueUser(LeagueUser leagueUser);

    public LeagueUser getLeagueUser(Integer userLeagueId);

}
