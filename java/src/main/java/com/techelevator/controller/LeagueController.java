package com.techelevator.controller;

import com.techelevator.dao.LeagueDao;
import com.techelevator.model.League;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path= "")
public class LeagueController {

    private LeagueDao leagueDao;

    public LeagueController(LeagueDao leagueDao){
        this.leagueDao = leagueDao;
    }
    //THIS METHOD WORKS
    @RequestMapping(value = "/leagues/{leagueId}", method = RequestMethod.GET)
    public League getLeague(@PathVariable Integer leagueId){
        return leagueDao.getLeague(leagueId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    public List<League> getLeagues(){
        return leagueDao.getLeagues();
    }

    //THIS METHOD WORKS
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( value = "/leagues", method = RequestMethod.POST)
    public League createLeague(@Valid @RequestBody League league){
        return leagueDao.createLeague(league);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/leagues{leagueId}", method = RequestMethod.DELETE)
    public  void deleteLeague(@PathVariable Integer leagueId){
        leagueDao.deleteLeague(leagueId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/leagues/{leagueId}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody League league, @PathVariable Integer leagueId){
        leagueDao.updateLeague(league);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/players/{playerId}/leagues", method = RequestMethod.GET)
    public List<League> getLeaguesByPlayerId (@PathVariable int playerId) {
        return leagueDao.getLeaguesByPlayer(playerId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/courses/{courseId}/leagues", method = RequestMethod.GET)
    public List<League> getLeaguesByCourse(@PathVariable int courseId){
        return leagueDao.getLeaguesByCourse(courseId);
    }
}
