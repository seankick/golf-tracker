package com.techelevator.dao;

import com.techelevator.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PlayerDao {
    Player getPlayer(Integer playerId);
    List<Player> getPlayers();
    Player createPlayer(Player player);
    public void updatePlayer( Integer playerId, Player player);
    void deletePlayer(Integer playerId);
}

