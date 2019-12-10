package com.example.mobapdemp;

public class Character {
    private String characterName;
    private int imagePath;

    public Character(String characterName, int imagePath){
        this.characterName = characterName;
        this.imagePath = imagePath;
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
}
