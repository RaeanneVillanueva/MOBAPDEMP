package com.example.mobapdemp;

import android.graphics.Bitmap;

public class Character {
    private String characterName;
    private int imagePath;
    private String imageName;
    private Bitmap bm;

    public Character(String characterName, int imagePath){
        this.characterName = characterName;
        this.imagePath = imagePath;
    }

    public Character(String characterName, int imagePath, String imageName){
        this(characterName,imagePath);
        this.imageName = imageName;
        this.bm = bm;
    }

    public Character(){

    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

}
