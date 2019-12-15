package com.example.mobapdemp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
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
    private DatabaseReference databaseSample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            //set name and pic here
        }
    }

    public void openLeaderboard(View view) {


        leaderboardDialog = new LeaderboardDialog(this);
        leaderboardDialog.show();

    }

    public void createDeck(View view) {
//        databaseSample = FirebaseDatabase.getInstance().getReference("leaderboard");
//        LeaderboardModel lm = new LeaderboardModel("Sample Name1", 10);
//        String id = databaseSample.push().getKey();
//        databaseSample.child(id).setValue(lm);

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
