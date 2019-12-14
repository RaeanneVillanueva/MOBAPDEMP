package com.example.mobapdemp;

import java.util.ArrayList;

public class LeaderboardModel implements Comparable {

    private int rank, score;
    private String name;

    public LeaderboardModel(int rank, String name, int score) {
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public String getPlayerName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return this.score - ((LeaderboardModel) o).getScore();
    }
}
