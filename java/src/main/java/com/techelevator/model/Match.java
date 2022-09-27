package com.techelevator.model;

import javax.swing.text.DateFormatter;
import java.sql.Timestamp;
import java.util.Date;

public class Match {
    private Integer matchId;
    private Integer courseId;
    private String courseName;
    private Timestamp startDateTime;
    private int numberOfPlayers;


    public Match() {

    }

    public Match(Integer matchId, Integer courseId, String courseName, Timestamp startDateTime, int numberOfPlayers) {
        this.matchId = matchId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDateTime = startDateTime;
        this.numberOfPlayers = numberOfPlayers;

    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDatetime) {
        this.startDateTime = startDatetime;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}