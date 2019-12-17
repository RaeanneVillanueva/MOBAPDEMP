package com.example.mobapdemp;

import android.os.DeadObjectException;

import java.util.ArrayList;

public class Deck {


    private String id;
    private ArrayList<Card> queue;
    private ArrayList<ScenarioCard> scenarioCards;
    private String name;
    private User owner;

    public Deck(String id, String name, User owner){
        this(id, name);
        this.owner = owner;
    }

    public Deck(String id, String name){
        this(name);
        this.id = id;
    }

    public Deck(String name){
        this();
        this.name = name;
    }

    public Deck(){
        queue = new ArrayList<>();
        scenarioCards = new ArrayList<>();
    }

    public void initializeStandardDeck(){
        this.name = "standard";
        this.id = "0";

        scenarioCards.add(  new ScenarioCard(AppConstants.MOM, "DCAT is coming, you should study!",
                    new Choice("Ok", new Consequence(-5, 0, 15, 0), "Welcome to DLSU"),
                    new Choice("Pfft. No", new Consequence(0, 0, -50, 0), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.DAD, "Here's your allowance, enjoy!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 30), ""),
                new Choice("No need, Dad!", new Consequence(0, 0, 0, 0), "")));


        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "CONGRATULATIONS IT'S TERM 1!",
                new Choice("YAY", new Consequence(), "TERM 1"),
                new Choice("WOW", new Consequence(), "TERM 1")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JAMES, "Hi, I am from Shavier Academy! I like to weightlift in my free time!",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JEAN, " Hi, I am from Dos High School! I know how to play drums!",
                new Choice("Hi!", new Consequence(), ""),
                new Choice("Hi!", new Consequence(), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.BEK, "Hi, I am from Shanghai Shek College! I like to draw!",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JYLE, "Hi, I am from Atenew High School! Reading is my hobby.",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Hey frosh! Would like to join us for dinner? Your blockmates are coming too!",
                new Choice("Sure!", new Consequence(0, 5, 0, -5), ""),
                new Choice("I'm going home", new Consequence(0, -5, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Hey there! I am inviting you to our after party. Can you join us?",
                new Choice("G!", new Consequence(0, 10, 0, -5), "You gained a lot of friends because of the party!"),
                new Choice("Need to go home", new Consequence(0, -5, 0, 0), "You ended up forcefully going to the party. You did not enjoy it.")));

        scenarioCards.add(  new ScenarioCard(AppConstants.MOM, "Go home now!",
                new Choice("Book a Grab", new Consequence(0, 0, 0, -20), ""),
                new Choice("LRT", new Consequence(-5, 0, 0, 0), "")));

        //Recruitment Week

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Welcome to our annual recruitment week!",
                new Choice("Wow!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Nice", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Join our organization and be a part of a committee! Your blockmates are joining too!",
                new Choice("Sure!", new Consequence(0, 5, 0, -15), ""),
                new Choice("Not interested..", new Consequence(0, -5, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JYLE, "They said it can help with our resume in the future. Come on, Join with me!",
                new Choice("Nice!", new Consequence(0, 0, 7, 0), ""),
                new Choice("No thanks..", new Consequence(0, -5, -5, 0), "")));


        scenarioCards.add(  new ScenarioCard(AppConstants.JAMES, "Hey! We’re forming groups of five for the membership, would you like to join us?",
                new Choice("Yes!", new Consequence(0, 10, 0, 10), "You gained more new friends and get to save money from membership fee!"),
                new Choice("No thanks..", new Consequence(0, -5, 0, -20), "You ended up joining and paid the non-discounted membership fee.")));


        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Join our Junior Officership and gain leadership skills! Invite your friends to join too!",
                new Choice("Yes!", new Consequence(0,7,5,0), ""),
                new Choice("No.", new Consequence(0,-5,-5,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.BOB, "Orgs are hassle. I wouldn't join if I were you.",
                new Choice("Okay..", new Consequence(0,-5,5,0), "You and Bob are the only students who don't have an org."),
                new Choice("I'll join for the experience!", new Consequence(0, 5,7,0), "You gained a lot of new experiences in your org.")));


        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "We’ll be having a graded recitation tomorrow. Please be ready and review the slides.",
                new Choice("Ugh", new Consequence(0,0,0,0), ""),
                new Choice("Okay..", new Consequence(0,0,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "We’ll be having our first General Assembly later! I hope you can come!",
                new Choice("I have to study..", new Consequence(0,-5,5,0), ""),
        new Choice("Sure!", new Consequence(0,7,-6,0), "")));


        scenarioCards.add(new ScenarioCard(AppConstants.BEK, "Let’s join the General Assembly, let’s meet new friends! Our other blockmates will come too! Let’s study for the graded recitation after.",
                new Choice("Yea sure!", new Consequence(-6,5,-5,0), "You gained a lot of friends today! However, you were not able to recite."),
                new Choice("Priorities..", new Consequence(7,-5,7,0), "You were able to study of the graded recitation. However, the professor forgot about it.")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "We will have a recitation tomorrow for today's lesson. Please take note of the lessons today.",
                new Choice("I will sleep.", new Consequence(9,0,-7,0), ""),
                new Choice("Noted!", new Consequence(-5,0,6,0), "")));


        scenarioCards.add(new ScenarioCard(AppConstants.BOB, "Hey, wanna play??",
                new Choice("I will sleep.", new Consequence(7,-5,-6,0), ""),
                new Choice("SURE!", new Consequence(-5,0,-6,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "Hey stop playing! Be quiet!",
                new Choice("Let's continue to play XD", new Consequence(0, 10, -10, 0), "You had a pop quiz in class and you got a low grade because you did not listen to the lecture."),
                new Choice("Let's behave.", new Consequence(0, -5, 7, 0),"The professor cancelled the graded recitation")));

        scenarioCards.add(new ScenarioCard(AppConstants.JEANETTE, "Hey! Let's eat at Tokyo Tokyo!",
                new Choice("I don't have money..", new Consequence(0, -5, 0, 3), ""),
                new Choice("G!", new Consequence(5, 5, 0, -5), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.JEAN, "Let's cut class!",
                new Choice("No sir..", new Consequence(0,5, 9, 0), ""),
                new Choice("G!", new Consequence(5, 4, -5, -5), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Would you like my old reviewers for your upcoming Finals?",
                new Choice("Yes please!", new Consequence(0,0, 7, 0), ""),
                new Choice("No thanks.", new Consequence(0, 0, -5, 0), "")));


        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "There will be a Finals Group Study today! Upperclassmen will be teaching too. Will you go?",
                new Choice("Sure!", new Consequence(5,5, 12, 0), "The group study helped you a lot in understanding the lessons taught in class."),
                new Choice("No thanks. I will self-study.", new Consequence(-5, -5, 10, 0), "You had a hard time understanding the lessons. You finished studying late at night.")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "Time for your finals!",
                new Choice("Take it.", new Consequence(), ""),
                new Choice("Pfft.", new Consequence(0,0,0,0), "")));



        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "What's the datatype to store whole numbers?",
                new Choice("Int", new Consequence(0,0,15,0), ""),
                new Choice("Char", new Consequence(0,0,-15,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "What is a function?",
                new Choice("It is a library", new Consequence(0,0,-15,0), ""),
                new Choice("It is a type of procedure or routine", new Consequence(0,0,15,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "What is 1010 in decimal",
                new Choice("10", new Consequence(0,0,15,0), ""),
                new Choice("12", new Consequence(0,0,-15,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "scanf('__', &number)",
                new Choice("%d", new Consequence(0,0,15,0), ""),
                new Choice("%c", new Consequence(0,0,-15,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "Good job! For attending the finals, I'll give you an incentive on your final grade",
                new Choice("Wow", new Consequence(0,0,10,0), ""),
                new Choice("Thanks!", new Consequence(0,0,10,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "CONGRATULATIONS IT'S TERM 2!",
                new Choice("YAY", new Consequence(), "TERM 2 (Coming Soon..)"),
                new Choice("WOW", new Consequence(), "TERM 2 (Coming Soon..)")));


    }

    public void initializeCustomDeck(Deck deck) {
        this.scenarioCards = deck.getCards();
    }

    public void enQueueCards(){
        queue.addAll(scenarioCards);
    }

    public ArrayList<ScenarioCard> getCards() {
        return scenarioCards;
    }

    public ArrayList<Card> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<Card> queue) {
        this.queue = queue;
    }

    public void setCards(ArrayList<ScenarioCard> scenarioCards) {
        this.scenarioCards = scenarioCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ScenarioCard> getScenarioCards() {
        return scenarioCards;
    }

    public void setScenarioCards(ArrayList<ScenarioCard> scenarioCards) {
        this.scenarioCards = scenarioCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
