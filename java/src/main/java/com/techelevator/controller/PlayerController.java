package com.techelevator.controller;

import com.techelevator.dao.PlayerDao;
import com.techelevator.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController

@RequestMapping(path = "/players")
public class PlayerController {

    private PlayerDao playerDao;

    public PlayerController(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }


    //THIS METHOD WORKS
    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable Integer playerId) {
        return playerDao.getPlayer(playerId);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Player> getPlayers() {
        return playerDao.getPlayers();
    }

    //THIS METHOD WORKS
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerDao.createPlayer(player);
    }

    //THIS METHOD WORKS
    @RequestMapping(value = "/{playerId}", method = RequestMethod.DELETE)
    public void deletePlayer(@PathVariable Integer playerId) {
        playerDao.deletePlayer(playerId);
    }

    @RequestMapping(value = "/{playerId}", method = RequestMethod.PUT)
    public void updatePlayer(@PathVariable Integer playerId, @RequestBody Player player) {
        playerDao.updatePlayer(playerId, player);

    }

}