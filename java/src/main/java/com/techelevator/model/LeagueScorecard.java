package com.techelevator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.sql.Date;

public class LeagueScorecard {
    private Integer leagueScorecardId;
    private Integer leagueId;
    private String courseName;
    private Date matchDate;
    private String username;
    private String teeSelection;
    private Integer hole1Score;
    private Integer hole2Score;
    private Integer hole3Score;
    private Integer hole4Score;
    private Integer hole5Score;
    private Integer hole6Score;
    private Integer hole7Score;
    private Integer hole8Score;
    private Integer hole9Score;
    private Integer hole10Score;
    private Integer hole11Score;
    private Integer hole12Score;
    private Integer hole13Score;
    private Integer hole14Score;
    private Integer hole15Score;
    private Integer hole16Score;
    private Integer hole17Score;
    private Integer hole18Score;
    private Integer totalStrokes;
    private Integer totalCoursePar;
    private Integer roundScoreRelativeToPar;

    public LeagueScorecard() {
    }

    public LeagueScorecard(Integer leagueScorecardId, Integer leagueId, String courseName, Date matchDate, String username, String teeSelection, Integer hole1Score, Integer hole2Score, Integer hole3Score, Integer hole4Score, Integer hole5Score, Integer hole6Score, Integer hole7Score, Integer hole8Score, Integer hole9Score, Integer hole10Score, Integer hole11Score, Integer hole12Score, Integer hole13Score, Integer hole14Score, Integer hole15Score, Integer hole16Score, Integer hole17Score, Integer hole18Score, Integer totalStrokes, Integer totalCoursePar, Integer roundScoreRelativeToPar) {
        this.leagueScorecardId = leagueScorecardId;
        this.leagueId = leagueId;
        this.courseName = courseName;
        this.matchDate = matchDate;
        this.username = username;
        this.teeSelection = teeSelection;
        this.hole1Score = hole1Score;
        this.hole2Score = hole2Score;
        this.hole3Score = hole3Score;
        this.hole4Score = hole4Score;
        this.hole5Score = hole5Score;
        this.hole6Score = hole6Score;
        this.hole7Score = hole7Score;
        this.hole8Score = hole8Score;
        this.hole9Score = hole9Score;
        this.hole10Score = hole10Score;
        this.hole11Score = hole11Score;
        this.hole12Score = hole12Score;
        this.hole13Score = hole13Score;
        this.hole14Score = hole14Score;
        this.hole15Score = hole15Score;
        this.hole16Score = hole16Score;
        this.hole17Score = hole17Score;
        this.hole18Score = hole18Score;
        this.totalStrokes = totalStrokes;
        this.totalCoursePar = totalCoursePar;
        this.roundScoreRelativeToPar = roundScoreRelativeToPar;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getLeagueScorecardId() {
        return leagueScorecardId;
    }

    public void setLeagueScorecardId(Integer leagueScorecardId) {
        this.leagueScorecardId = leagueScorecardId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeeSelection() {
        return teeSelection;
    }

    public void setTeeSelection(String teeSelection) {
        this.teeSelection = teeSelection;
    }

    public Integer getHole1Score() {
        return hole1Score;
    }

    public void setHole1Score(Integer hole1Score) {
        this.hole1Score = hole1Score;
    }

    public Integer getHole2Score() {
        return hole2Score;
    }

    public void setHole2Score(Integer hole2Score) {
        this.hole2Score = hole2Score;
    }

    public Integer getHole3Score() {
        return hole3Score;
    }

    public void setHole3Score(Integer hole3Score) {
        this.hole3Score = hole3Score;
    }

    public Integer getHole4Score() {
        return hole4Score;
    }

    public void setHole4Score(Integer hole4Score) {
        this.hole4Score = hole4Score;
    }

    public Integer getHole5Score() {
        return hole5Score;
    }

    public void setHole5Score(Integer hole5Score) {
        this.hole5Score = hole5Score;
    }

    public Integer getHole6Score() {
        return hole6Score;
    }

    public void setHole6Score(Integer hole6Score) {
        this.hole6Score = hole6Score;
    }

    public Integer getHole7Score() {
        return hole7Score;
    }

    public void setHole7Score(Integer hole7Score) {
        this.hole7Score = hole7Score;
    }

    public Integer getHole8Score() {
        return hole8Score;
    }

    public void setHole8Score(Integer hole8Score) {
        this.hole8Score = hole8Score;
    }

    public Integer getHole9Score() {
        return hole9Score;
    }

    public void setHole9Score(Integer hole9Score) {
        this.hole9Score = hole9Score;
    }

    public Integer getHole10Score() {
        return hole10Score;
    }

    public void setHole10Score(Integer hole10Score) {
        this.hole10Score = hole10Score;
    }

    public Integer getHole11Score() {
        return hole11Score;
    }

    public void setHole11Score(Integer hole11Score) {
        this.hole11Score = hole11Score;
    }

    public Integer getHole12Score() {
        return hole12Score;
    }

    public void setHole12Score(Integer hole12Score) {
        this.hole12Score = hole12Score;
    }

    public Integer getHole13Score() {
        return hole13Score;
    }

    public void setHole13Score(Integer hole13Score) {
        this.hole13Score = hole13Score;
    }

    public Integer getHole14Score() {
        return hole14Score;
    }

    public void setHole14Score(Integer hole14Score) {
        this.hole14Score = hole14Score;
    }

    public Integer getHole15Score() {
        return hole15Score;
    }

    public void setHole15Score(Integer hole15Score) {
        this.hole15Score = hole15Score;
    }

    public Integer getHole16Score() {
        return hole16Score;
    }

    public void setHole16Score(Integer hole16Score) {
        this.hole16Score = hole16Score;
    }

    public Integer getHole17Score() {
        return hole17Score;
    }

    public void setHole17Score(Integer hole17Score) {
        this.hole17Score = hole17Score;
    }

    public Integer getHole18Score() {
        return hole18Score;
    }

    public void setHole18Score(Integer hole18Score) {
        this.hole18Score = hole18Score;
    }

    public Integer getTotalStrokes() {
        return totalStrokes;
    }

    public void setTotalStrokes(Integer totalStrokes) {
        this.totalStrokes = totalStrokes;
    }

    public Integer getTotalCoursePar() {
        return totalCoursePar;
    }

    public void setTotalCoursePar(Integer totalCoursePar) {
        this.totalCoursePar = totalCoursePar;
    }

    public Integer getRoundScoreRelativeToPar() {
        return roundScoreRelativeToPar;
    }

    public void setRoundScoreRelativeToPar(Integer roundScoreRelativeToPar) {
        this.roundScoreRelativeToPar = roundScoreRelativeToPar;
    }
}
