package com.techelevator.controller;

import com.techelevator.dao.HoleDao;
import com.techelevator.dao.ScorecardDao;
import com.techelevator.model.Hole;
import com.techelevator.model.Scorecard;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ScorecardController {

    private ScorecardDao scorecardDao;

    public ScorecardController(ScorecardDao scorecardDao) {this.scorecardDao = scorecardDao;}


    //GET METHOD FOR GET ONE SCORECARD DATASET
    @RequestMapping(value = "/scorecards/{courseId}/{teeSelection}", method = RequestMethod.GET)
    public Scorecard getScorecard(@PathVariable Integer courseId, @PathVariable String teeSelection) {
        return scorecardDao.getScorecard(courseId, teeSelection);}




}
