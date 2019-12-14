package com.example.mobapdemp;

public class ScenarioCard extends Card {
    private Character character;
    private Choice choiceLeft, choiceRight;

    public ScenarioCard(Character character, String scenarioText, Choice choiceLeft, Choice choiceRight){
        this.character = character;
        super.setScenarioText(scenarioText);
        this.choiceLeft = choiceLeft;
        this.choiceRight = choiceRight;
    }

    public ScenarioCard(){

    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getScenarioText() {
        return super.getScenarioText();
    }

    public void setScenarioText(String scenarioText) {
        super.setScenarioText(scenarioText);
    }

    public Choice getChoiceLeft() {
        return choiceLeft;
    }

    public void setChoiceLeft(Choice choiceLeft) {
        this.choiceLeft = choiceLeft;
    }

    public Choice getChoiceRight() {
        return choiceRight;
    }

    public void setChoiceRight(Choice choiceRight) {
        this.choiceRight = choiceRight;
    }
}
