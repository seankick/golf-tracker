package com.techelevator.model;

public class LeagueUser {
    private Integer userLeagueId;
    private Integer leagueId;
    private Integer userId;

    public LeagueUser(Integer leagueId, Integer userId, Integer userLeagueId) {

        this.leagueId = leagueId;
        this.userId = userId;
        this.userLeagueId = userLeagueId;
    }

    public LeagueUser() {
    }

    public Integer getUserLeagueId() {
        return userLeagueId;
    }

    public void setUserLeagueId(Integer userLeagueId) {
        this.userLeagueId = userLeagueId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
