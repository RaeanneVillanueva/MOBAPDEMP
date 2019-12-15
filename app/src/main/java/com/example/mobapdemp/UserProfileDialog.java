package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileDialog extends Dialog {

    private CircleImageView viewProfileImg;
    private TextView name, email;
    private Button logout;

    public UserProfileDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewProfileImg = findViewById(R.id.view_profile_img);
        name = findViewById(R.id.view_profile_name);
        email = findViewById(R.id.view_profile_email);
        logout = findViewById(R.id.btn_logout);
    }
}
