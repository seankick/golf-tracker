package com.techelevator.dao;

import com.techelevator.model.Scorecard;

public interface ScorecardDao {
    public Scorecard getScorecard(Integer courseId, String teeSelection);


}
