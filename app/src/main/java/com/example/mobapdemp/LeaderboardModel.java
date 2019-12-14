package com.example.mobapdemp;

import java.util.ArrayList;

public class LeaderboardModel implements Comparable {

    private int score;
    private String name;

    public LeaderboardModel( String name, int score) {
        this.name = name;
        this.score = score;
    }

    public LeaderboardModel(){

    }


    public void setPlayerName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return  ((LeaderboardModel) o).getScore() - this.score;
    }
}
