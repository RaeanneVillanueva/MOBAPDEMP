package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomDeckActivity extends AppCompatActivity {

    private CreateCardDialog createCardDialog;
    private TextView deckName;
    private DatabaseReference databaseCustomDecks;
    private Deck deck;
    private ListView cardListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_deck);
        getSupportActionBar().hide();

        databaseCustomDecks = FirebaseDatabase.getInstance().getReference("customDecks");

        deckName = findViewById(R.id.txt_deck_name);

        Intent intent = getIntent();
        String inputDeckName = intent.getStringExtra("Inputted Deck Name");
        deckName.setText(inputDeckName);

        String id = databaseCustomDecks.push().getKey();
        deck = new Deck(id, inputDeckName);
        databaseCustomDecks.child(id).setValue(deck);

        //listener for each item card
        cardListView = findViewById(R.id.card_list_view);
        cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //edit the card here..
            }
        });

    }

    public void openAddCard(View view) {
        createCardDialog = new CreateCardDialog(this, deck);
        createCardDialog.show();
    }

    public void closeCustomDeck(View view) {
        Intent intent = new Intent(this, MyDeckActivity.class);
        startActivity(intent);
        finish();
    }
}
