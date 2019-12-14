package com.example.mobapdemp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    private LeaderboardDialog leaderboardDialog;
    private EditText playerName;
    private Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
    }

    public void openLeaderboard(View view) {

        leaderboardDialog = new LeaderboardDialog(this);
        leaderboardDialog.show();

    }

    public void createDeck(View view) {
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
