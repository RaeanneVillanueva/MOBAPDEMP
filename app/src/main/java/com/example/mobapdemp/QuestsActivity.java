package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        getSupportActionBar().hide();
    }
}
