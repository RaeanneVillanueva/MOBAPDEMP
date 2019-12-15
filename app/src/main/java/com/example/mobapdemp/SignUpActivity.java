package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameSignUp, passwordSignUp;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameSignUp = findViewById(R.id.etxt_username_signup);
        passwordSignUp = findViewById(R.id.etxt_password_signup);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //do db stuff here
                //usernameSignUp.getText();
                //passwordSignUp.getText();

                Intent intent = new Intent(SignUpActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
