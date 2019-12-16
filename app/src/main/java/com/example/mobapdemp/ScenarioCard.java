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

    public ScenarioCard(Character character, String scenarioText){
        this(character, scenarioText, null,null);
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

    public static int getLeftAttributeFromCard(Card card, String attribute){
        switch (attribute) {
            case "health":
                return ((ScenarioCard) card).getChoiceLeft().getConsequence().getHealth();
            case "social":
                return ((ScenarioCard) card).getChoiceLeft().getConsequence().getSocial();
            case "money":
                return ((ScenarioCard) card).getChoiceLeft().getConsequence().getMoney();
            case "grades":
                return ((ScenarioCard) card).getChoiceLeft().getConsequence().getGrades();
            default:
                return 0;
        }
    }

    public static int getRightAttributeFromCard(Card card, String attribute){
        switch (attribute) {
            case "health":
                return ((ScenarioCard) card).getChoiceRight().getConsequence().getHealth();
            case "social":
                return ((ScenarioCard) card).getChoiceRight().getConsequence().getSocial();
            case "money":
                return ((ScenarioCard) card).getChoiceRight().getConsequence().getMoney();
            case "grades":
                return ((ScenarioCard) card).getChoiceRight().getConsequence().getGrades();
            default:
                return 0;
        }
    }

    public static Consequence getLeftConsequence(Card card){
        return ((ScenarioCard) card).getChoiceLeft().getConsequence();
    }

    public static Consequence getRightConsequence(Card card){
        return ((ScenarioCard) card).getChoiceRight().getConsequence();
    }

    public static NarrationCard getLeftNarration(Card card){
        return ((ScenarioCard) card).getChoiceLeft().getNarration();
    }

    public static NarrationCard getRightNarration(Card card){
        return ((ScenarioCard) card).getChoiceRight().getNarration();
    }
}
