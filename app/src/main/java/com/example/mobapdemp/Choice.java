package com.example.mobapdemp;

public class Choice {
    private String text;
    private Consequence consequence;

    public Choice(String text, Consequence consequence){
        this.text = text;
        this.consequence = consequence;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public void setConsequence(Consequence consequence) {
        this.consequence = consequence;
    }
}
