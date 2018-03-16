package com.example.tranvanmanh.week3_excersise;

/**
 * Created by tranvanmanh on 3/15/2018.
 */

public class Movie {

    private String RealeaseDate;
    private double VoteAvarage;
    private String tille;
    private String discription;
    private String pathpicture;

    public Movie(String realeaseDate, double voteAvarage, String tille, String discription, String pathpicture) {
        RealeaseDate = realeaseDate;
        VoteAvarage = voteAvarage;
        this.tille = tille;
        this.discription = discription;
        this.pathpicture = pathpicture;
    }

    public String getRealeaseDate() {
        return RealeaseDate;
    }

    public double getVoteAvarage() {
        return VoteAvarage;
    }

    public String getTille() {
        return tille;
    }

    public String getDiscription() {
        return discription;
    }

    public String getPathpicture() {
        return pathpicture;
    }
}
