package com.techelevator.controller;

import com.techelevator.dao.HoleDao;

import com.techelevator.dao.LeagueScorecardDao;
import com.techelevator.model.Course;
import com.techelevator.model.Hole;
import com.techelevator.model.LeagueScorecard;
import com.techelevator.model.Match;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "")
public class LeagueScorecardController {

    private LeagueScorecardDao leagueScorecardDao;

    public LeagueScorecardController(LeagueScorecardDao leagueScorecardDao) {
        this.leagueScorecardDao = leagueScorecardDao;
    }

    //CREATE METHOD FOR ONE LEAGUESCORECARD
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/leaguescorecards", method = RequestMethod.POST)
    public LeagueScorecard createLeagueScorecard(@Valid @RequestBody LeagueScorecard leagueScorecard) {
        return leagueScorecardDao.createLeagueScorecard(leagueScorecard);
    }

    //GET METHOD FOR GET ONE LEAGUESCORECARD OF A GIVEN "{leagueScorecardId}"
    @RequestMapping(value = "/leaguescorecards/{leagueScorecardId}", method = RequestMethod.GET)
    public LeagueScorecard getLeagueScorecard(@PathVariable Integer leagueScorecardId) {
        return leagueScorecardDao.getLeagueScorecard(leagueScorecardId);
    }

    @RequestMapping(value = "leagues/leaguescorecards/{leagueId}", method = RequestMethod.GET)
    public List<LeagueScorecard> getLeagueScorecards(@PathVariable Integer leagueId) {
        return leagueScorecardDao.getLeagueScorecards(leagueId);
    }

}