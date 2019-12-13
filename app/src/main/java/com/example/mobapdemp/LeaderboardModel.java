package com.example.mobapdemp;

import java.util.ArrayList;

public class LeaderboardModel {

    private int rank;
    private String name, score;

    public LeaderboardModel(int rank, String name, String score) {
        this.rank = rank;
        this.name = name;
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public String getPlayerName() {
        return name;
    }

    public String getScore() {
        return score;
    }

}
