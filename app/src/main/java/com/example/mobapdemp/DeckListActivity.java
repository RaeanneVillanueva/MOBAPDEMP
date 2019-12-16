package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class DeckListActivity extends AppCompatActivity {

    private CreateCardDialog dialog;
    private EditText deckName;
    private Button btnCreateDeck;
    private DatabaseReference databaseCustomDecks;
    private ArrayList<Deck> decks;
    private DeckListAdapter deckListAdapter;
    private ListView deckListView;
    private Spinner spinnerDeckCategory;
    private String choice = "All Decks";
    private  AlertDialog dialogCreateDeck, editDeckDialog;
    private CircularProgressButton btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_list);
        getSupportActionBar().hide();

        deckListView = findViewById(R.id.deck_list_view);
        decks = new ArrayList<>();
        databaseCustomDecks = FirebaseDatabase.getInstance().getReference("customDecks");

        initializeDeckList();
        deckListAdapter = new DeckListAdapter(DeckListActivity.this, decks);
        deckListView.setAdapter(deckListAdapter);

        //onlicklistener of deck_item
        deckListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Deck selectedDeck = decks.get(position);

                showEditDeckDialog(selectedDeck);
            }
        });


        //spinner
        spinnerDeckCategory = findViewById(R.id.spinner_deck_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_decklist_option, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDeckCategory.setAdapter(adapter);
        spinnerDeckCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choice = spinnerDeckCategory.getSelectedItem().toString();
                databaseCustomDecks.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        decks.clear();
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Deck deck = postSnapshot.getValue(Deck.class);
                            if(choice.equalsIgnoreCase("My Custom Deck")) {
                                if(deck.getOwner().getId().equalsIgnoreCase(AppConstants.user.getId())) {
                                    decks.add(deck);
                                }
                            }else{
                                decks.add(deck);
                            }
                        }
                        deckListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void initializeDeckList() {

        databaseCustomDecks.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                decks.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Deck deck = postSnapshot.getValue(Deck.class);
                    if(choice.equalsIgnoreCase("My Custom Deck")) {
                        if(deck.getOwner().getId().equalsIgnoreCase(AppConstants.user.getId())) {
                            decks.add(deck);
                        }
                    }else{
                        decks.add(deck);
                    }
                }
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

                Intent intent = new Intent(DeckListActivity.this, CustomDeckActivity.class);

                String id = databaseCustomDecks.push().getKey();
                Deck deck = new Deck(id, deckName.getText().toString(), AppConstants.user);
                databaseCustomDecks.child(id).setValue(deck);

                AppConstants.currentDeckEdit = deck;

                dialogCreateDeck.dismiss();
                startActivity(intent);
                finish();
            }
        });

        alertBuilder.setView(dialogView);
        dialogCreateDeck = alertBuilder.create();

        dialogCreateDeck.show();
    }

    public void closeCreateDeck(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    public void showEditDeckDialog(final Deck deck) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edit_deck, null);
        dialogBuilder.setView(dialogView);

        TextView name = dialogView.findViewById(R.id.etxt_new_deck_name);
        Button btnEdit = dialogView.findViewById(R.id.btn_edit);
        Button btnPlay = dialogView.findViewById(R.id.btn_play_deck);
        Button btnDelete = dialogView.findViewById(R.id.btn_delete_deck);

        if(!(deck.getOwner().getId() == AppConstants.user.getId())){
            //disable edit
        }

        name.setText(deck.getName());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeckListActivity.this, CustomDeckActivity.class);
                AppConstants.currentDeckEdit = deck;
                editDeckDialog.dismiss();
                startActivity(intent);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppConstants.deck = deck;

                DatabaseReference dr = FirebaseDatabase.getInstance().getReference("card").child(AppConstants.deck.getId());
                dr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            ScenarioCard sc = postSnapshot.getValue(ScenarioCard.class);
                            AppConstants.deck.getScenarioCards().add(sc);
                        }
                        AppConstants.deck.enQueueCards();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(DeckListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDeck(deck.getId());
                editDeckDialog.dismiss();

            }
        });

        editDeckDialog = dialogBuilder.create();
        editDeckDialog.show();
    }

    private boolean deleteDeck(String id){
//getting the specified artist reference
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("customDecks").child(id);

        //removing artist
        dr.removeValue();

        //getting the tracks reference for the specified artist
        DatabaseReference drCards = FirebaseDatabase.getInstance().getReference("card").child(id);

        //removing all tracks
        drCards.removeValue();
        Toast.makeText(getApplicationContext(), "Deck Deleted", Toast.LENGTH_LONG).show();

        return true;
    }

}
