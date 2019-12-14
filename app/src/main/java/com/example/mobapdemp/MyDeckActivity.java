package com.example.mobapdemp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyDeckActivity extends AppCompatActivity {

    private CreateCardDialog dialog;
    private EditText deckName;
    private Button btnCreateDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deck);
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
}
