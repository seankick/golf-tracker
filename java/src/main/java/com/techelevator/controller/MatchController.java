package com.techelevator.controller;

import com.techelevator.dao.MatchDao;
import com.techelevator.model.Match;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path= "")

public class MatchController {

    private MatchDao matchDao;

    public MatchController(MatchDao matchDao){
        this.matchDao = matchDao;
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/matches/{matchId}")
    public Match getMatch(@PathVariable Integer matchId){
        return matchDao.getMatch(matchId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value="/matches", method = RequestMethod.GET)
    public List<Match> getMatches(){
        return  matchDao.getMatches();
    }

    //THIS METHOD WORKS

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( value = "/matches", method = RequestMethod.POST)
    public Match createMatch(@Valid @RequestBody Match match){
        return matchDao.createMatch(match);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/matches/{matchId}", method = RequestMethod.PUT)
    public void updateMatch(@Valid @RequestBody Match match, @PathVariable Integer matchId){
        matchDao.updateMatch(match, matchId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/matches/{matchId}", method = RequestMethod.DELETE)
    public void deleteMatch(@PathVariable Integer matchId){
        matchDao.deleteMatch((matchId));
    }

    //THIS METHOD WORKS
    @RequestMapping(value="/leagues/{leagueId}/matches", method = RequestMethod.GET)
    public List<Match> getMatchesByLeague(@PathVariable int leagueId){
        return  matchDao.getMatchesByLeague(leagueId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value="/players/{playerId}/matches", method = RequestMethod.GET)
    public List<Match> getMatchesByPlayer(@PathVariable int playerId){
        return  matchDao.getMatchesByPlayer(playerId);
    }
}
