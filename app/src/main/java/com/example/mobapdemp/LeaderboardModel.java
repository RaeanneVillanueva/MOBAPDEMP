package com.example.mobapdemp;

import java.util.ArrayList;

public class LeaderboardModel implements Comparable {

    private String id;
    private int score;
    private String name;

    public LeaderboardModel( String name, int score, String id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public LeaderboardModel(){

    }


    public String getId() {
        return id;
    }

    public void setId(String user) {
        this.id = user;
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
