package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpDialog extends Dialog {

    private EditText usernameSignUp, passwordSignUp;
    private Button btnSubmit;

    public SignUpDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sign_up);

        usernameSignUp = findViewById(R.id.etxt_username_signup);
        passwordSignUp = findViewById(R.id.etxt_password_signup);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StartActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });
    }
}
