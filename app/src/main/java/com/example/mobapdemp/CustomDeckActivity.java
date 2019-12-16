package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomDeckActivity extends AppCompatActivity {

    private CreateCardDialog createCardDialog;
    private TextView deckName;
    private DatabaseReference databaseCustomDecks;
    private Deck deck;
    private ListView cardListView;
    private CardListAdapter cardListAdapter;
    private ArrayList<Card> cardList;

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
        deck = new Deck(id, inputDeckName, AppConstants.user);
        databaseCustomDecks.child(id).setValue(deck);


        //set up of card list view and adapter
        initializeCardListData();
        cardListView = findViewById(R.id.card_list_view);
        cardListAdapter = new CardListAdapter(this, cardList);
        cardListAdapter.notifyDataSetChanged();
        cardListView.setAdapter(cardListAdapter);


        //listener for each item card
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
        Intent intent = new Intent(this, DeckListActivity.class);
        startActivity(intent);
        finish();
    }

    public void saveCustomDeck(View view){
        DatabaseReference drUpdate = FirebaseDatabase.getInstance().getReference("customDecks").child(deck.getId());

        drUpdate.setValue(deck);
        finish();
    }

    public void initializeCardListData() {
        cardList = new ArrayList<>();
    }
}
