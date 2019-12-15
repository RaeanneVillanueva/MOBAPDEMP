package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnLogin, btnGoogleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        btnLogin = findViewById(R.id.btn_login);
        btnGoogleSignIn = findViewById(R.id.btn_google_signin);

    }

    public void login(View view) {
        //on click listener for login button
        //db stuff here

        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSignUpDialog(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_sign_up, null);
        dialogBuilder.setView(dialogView);

        EditText usernameSignUp = dialogView.findViewById(R.id.etxt_username_signup);
        EditText passwordSignUp = dialogView.findViewById(R.id.etxt_password_signup);
        Button submit = dialogView.findViewById(R.id.btn_submit);

        //use this to get the inputted username and password
        //usernameSignUp.getText();
        //passwordSignUp.getText();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });


        AlertDialog signupDialog = dialogBuilder.create();
        signupDialog.show();
    }
}
