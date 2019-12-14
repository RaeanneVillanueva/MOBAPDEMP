package com.example.mobapdemp;

public class Choice {
    private String text;
    private Consequence consequence;
    private NarrationCard narration;
    public Choice(String text, Consequence consequence, String narration){
        this.text = text;
        this.consequence = consequence;
        this.narration = new NarrationCard(narration);
    }

    public Choice(){

    }

    public Choice(String text, Consequence consequence){
        this(text, consequence, null);
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


    public NarrationCard getNarration() {
        return narration;
    }

    public void setNarration(NarrationCard narration) {
        this.narration = narration;
    }

}
