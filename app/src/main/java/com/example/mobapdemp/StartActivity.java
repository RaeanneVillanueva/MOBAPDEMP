package com.example.mobapdemp;

import androidx.annotation.NonNull;
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
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    private Button btnPlay, btn_signout;
    private DatabaseReference databaseSample;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        btn_signout = findViewById(R.id.btn_signout);

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

        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_signout:
                        signOut();
                        break;
                }
            }
        });
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

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                    }
                });
    }
}
