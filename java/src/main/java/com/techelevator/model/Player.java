package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Player {
    private Integer playerId;
    private String imagePath;
    private String firstName;
    private String lastName;

    public Player() {
    }

    public Player(Integer playerId, String imagePath, String firstName, String lastName) {
        this.playerId = playerId;
        this.imagePath = imagePath;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}