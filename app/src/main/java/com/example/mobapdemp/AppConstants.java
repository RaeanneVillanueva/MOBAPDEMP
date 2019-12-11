package com.example.mobapdemp;

public class AppConstants {
    Player player;
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
                            PROFESSOR1 = new Character ("Upperclassmen", R.drawable.prof1),
                            PROFESSOR2 = new Character ("Upperclassmen", R.drawable.prof2);


    public void init(){
        player = new Player();
    }
}
