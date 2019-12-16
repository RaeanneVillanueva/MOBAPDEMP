package com.example.mobapdemp;

import java.util.ArrayList;

public class LeaderboardModel implements Comparable {

    private String user;
    private int score;
    private String name;

    public LeaderboardModel( String name, int score, String user) {
        this.name = name;
        this.score = score;
        this.user = user;
    }

    public LeaderboardModel(){

    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return  ((LeaderboardModel) o).getScore() - this.score;
    }
}
