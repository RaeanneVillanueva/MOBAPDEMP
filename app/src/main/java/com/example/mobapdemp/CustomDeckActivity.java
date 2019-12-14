package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomDeckActivity extends AppCompatActivity {

    private CreateCardDialog createCardDialog;
    private TextView deckName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_deck);
        getSupportActionBar().hide();

        deckName = findViewById(R.id.txt_deck_name);

        Intent intent = getIntent();
        String inputDeckName = intent.getStringExtra("Inputted Deck Name");
        deckName.setText(inputDeckName);
    }

    public void openAddCard(View view) {
        createCardDialog = new CreateCardDialog(this);
        createCardDialog.show();
    }

    public void closeCustomDeck(View view) {
        Intent intent = new Intent(this, MyDeckActivity.class);
        startActivity(intent);
        finish();
    }
}
