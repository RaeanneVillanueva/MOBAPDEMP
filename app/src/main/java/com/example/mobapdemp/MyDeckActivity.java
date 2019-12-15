package com.example.mobapdemp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyDeckActivity extends AppCompatActivity {

    private CreateCardDialog dialog;
    private EditText deckName;
    private Button btnCreateDeck;
    private DatabaseReference databaseSample;
    private ArrayList<Deck> decks;
    private DeckListAdapter deckListAdapter;
    private ListView deckListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deck);
        getSupportActionBar().hide();

        deckListView = findViewById(R.id.deck_list_view);
        decks = new ArrayList<>();
        databaseSample = FirebaseDatabase.getInstance().getReference("customDecks");

        initializeDeckList();
        deckListAdapter = new DeckListAdapter(MyDeckActivity.this, decks);
        deckListView.setAdapter(deckListAdapter);

        deckListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Deck selectedDeck = decks.get(position);

                //play the selected deck
            }
        });
    }

    public void initializeDeckList() {

        databaseSample.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                decks.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Deck deck = postSnapshot.getValue(Deck.class);
                    decks.add(deck);
                }
                deckListAdapter.notifyDataSetChanged();

                deckListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void createNewDeck(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_new_deck, null);
        deckName = dialogView.findViewById(R.id.etxt_deck_name);
        btnCreateDeck = dialogView.findViewById(R.id.btn_create_new_deck);

        btnCreateDeck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MyDeckActivity.this, CustomDeckActivity.class);
                intent.putExtra("Inputted Deck Name", deckName.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        alertBuilder.setView(dialogView);
        AlertDialog dialog = alertBuilder.create();

        dialog.show();
    }

    public void closeCreateDeck(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

//    public void showEditDeckDialog(String deckName) {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.dialog_edit_deck, null);
//        dialogBuilder.setView(dialogView);
//
//        TextView name = dialogView.findViewById(R.id.etxt_new_deck_name);
//        Button btnEdit = dialogView.findViewById(R.id.btn_edit);
//        Button btnPlay = dialogView.findViewById(R.id.btn_play_deck);
//
//        name.setHint(deckName);
//
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MyDeckActivity.this, CustomDeckActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        AlertDialog editDeck = dialogBuilder.create();
//        editDeck.show();
//    }

}
