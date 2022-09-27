package com.techelevator.controller;

import com.techelevator.dao.LeagueUserDao;
import com.techelevator.model.Course;
import com.techelevator.model.LeagueUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/league-users")

public class LeagueUserController {

    private LeagueUserDao leagueUserDao;

    public LeagueUserController(LeagueUserDao leagueUserDao) {
        this.leagueUserDao = leagueUserDao;
    }

    //create course works
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public LeagueUser createLeagueUser(@Valid @RequestBody LeagueUser leagueUser) {
        return leagueUserDao.createLeagueUser(leagueUser);
    }

    @RequestMapping(value = "/{userLeagueId}", method = RequestMethod.GET)
    public LeagueUser getLeagueUser(@PathVariable Integer userLeagueId) {

        return leagueUserDao.getLeagueUser(userLeagueId);
    }
}