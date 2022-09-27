package com.techelevator.dao;

import com.techelevator.controller.PlayerController;
import com.techelevator.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.*;

@Component
public class JdbcPlayerDao implements PlayerDao {
    public static final Logger logger = LoggerFactory.getLogger(PlayerController.class);


    private JdbcTemplate jdbcTemplate;

    public JdbcPlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //THIS METHOD IS WORKING
    @Override
    public Player createPlayer(Player player) {
        String sql = "INSERT INTO public.players(image_path, first_name, last_name) VALUES (?, ?, ?) RETURNING player_id;";
        Integer newPlayerId = jdbcTemplate.queryForObject(sql, Integer.class, player.getImagePath(), player.getFirstName(), player.getLastName());

        return getPlayer(newPlayerId);
    }

    //THIS METHOD IS WORKING
    @Override
    public Player getPlayer(Integer playerId) {
        Player result = new Player();
        String sql = "SELECT player_id, image_path, first_name, last_name FROM public.players WHERE player_id = ? LIMIT 1;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, playerId);
        while (rowSet.next()) {
            Player player = mapRowToPlayer(rowSet);
            result = player;
        }
        return result;
    }

    //THIS METHOD IS WORKING
    @Override
    public List<Player> getPlayers() {
        List<Player> results = new ArrayList<>();

        String sql = "SELECT player_id, image_path, first_name, last_name FROM players;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Player player = mapRowToPlayer(rowSet);
            results.add(player);
        }
        return results;
    }

    //THIS METHOD IS WORKING
    @Override
    public void updatePlayer(Integer playerId, Player player) {
        String sql = "UPDATE public.players SET image_path=?, first_name=?, last_name=? WHERE player_id=?";
        jdbcTemplate.update(sql, player.getImagePath(), player.getFirstName(), player.getLastName(), player.getPlayerId());
    }

    //THIS METHOD IS WORKING
    @Override
    public void deletePlayer(Integer playerId) {
        String sql = "DELETE FROM players " +
                "WHERE player_id=?;";

        jdbcTemplate.update(sql, playerId);
    }

    public Player mapRowToPlayer(SqlRowSet rowSet) {
        Player player = new Player();
        player.setPlayerId((Integer) rowSet.getObject("player_id"));
        player.setImagePath(rowSet.getString("image_path"));
        player.setFirstName(rowSet.getString("first_name"));
        player.setLastName((rowSet.getString("last_name")));

        return player;
    }


}
