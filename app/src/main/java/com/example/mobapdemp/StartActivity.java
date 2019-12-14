package com.example.mobapdemp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private LeaderboardDialog leaderboardDialog;
    private EditText playerName;
    private Button btnPlay;
    DatabaseReference databaseSample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        databaseSample = FirebaseDatabase.getInstance().getReference("leaderboard");

    }

    public void openLeaderboard(View view) {

//        String id = databaseSample.push().getKey();
//
//        Deck deck = new Deck("sampleDeck");
//        ScenarioCard card = new ScenarioCard(AppConstants.MOM, "hello", new Choice("Ok", new Consequence(1,2,3,4)), new Choice("No", new Consequence(5,6,7,8)));
//        deck.getCards().add(card);
//        databaseSample.child(id).setValue(deck);
        leaderboardDialog = new LeaderboardDialog(this);
        leaderboardDialog.show();

    }

    public void createDeck(View view) {

//        databaseSample.addValueEventListener(new ValueEventListener() {
//            // Database entries are all DataSnapshots
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                ArrayList<Deck> decks = new ArrayList<>();
//
//                //iterating through all the nodes
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    //getting artist
//                    Deck deck= postSnapshot.getValue(Deck.class);
//                    //adding a0rtist to the list
//                    decks.add(deck);
//                }
//
//                for(Deck deck: decks){
//                    Log.d("CHECKDECK", deck.getName());
//                    Log.d("CHECKDECK", deck.getName());
//                    Log.d("CHECKDECK", deck.getName());
//                    Log.d("CHECKDECK", deck.getName());
//                    Log.d("CHECKDECK", deck.getName());
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        Intent intent = new Intent(this, MyDeckActivity.class);
        startActivity(intent);
        finish();
    }

    public void startGame(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_player_name, null);
        playerName = dialogView.findViewById(R.id.etxt_playername);
        btnPlay = dialogView.findViewById(R.id.btn_play);

        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("Inputted Player Name", playerName.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        alertBuilder.setView(dialogView);
        AlertDialog dialog = alertBuilder.create();

        dialog.show();
    }
}
