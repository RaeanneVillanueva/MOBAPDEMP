package com.example.mobapdemp;

import android.net.Uri;

public class AppConstants {
    public static Player player;
    public static User user;
    public static Deck deck;
    final static Character  MOM = new Character("Mom", R.drawable.mom),
                            DAD = new Character("Dad", R.drawable.dad),
                            JYLE = new Character("Jyle", R.drawable.jyle),
                            BOB = new Character("Bob", R.drawable.bob),
                            BEK = new Character("Bek", R.drawable.bek),
                            JAMES = new Character("James", R.drawable.james),
                            JEANETTE = new Character("Jeanette", R.drawable.jean),
                            JEAN = new Character("Jean", R.drawable.jean_boy),

                            UPPERCLASSMEN1 = new Character ("Upperclassmen", R.drawable.upperclass1),
                            UPPERCLASSMEN2 = new Character ("Upperclassmen", R.drawable.upperclass2),
                            PROFESSOR1 = new Character ("Professor", R.drawable.prof1),
                            PROFESSOR2 = new Character ("Professor", R.drawable.prof2),

                            DRUGS = new Character("", R.drawable.drug),
                            VOMIT = new Character("", R.drawable.vomit),
                            STARVE = new Character("", R.drawable.starve),
                            LONELINESS = new Character("", R.drawable.loneliness);


    public static void initStandardDeck(){
        deck = new Deck();
        deck.initializeStandardDeck();
        deck.enQueueCards();
    }

}
