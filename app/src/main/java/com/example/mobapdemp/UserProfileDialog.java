package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileDialog extends Dialog {

    private CircleImageView viewProfileImg;
    private TextView viewProfileName, viewProfileEmail;
    private Button logout;

    public UserProfileDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewProfileImg = (CircleImageView) findViewById(R.id.view_profile_image);
        viewProfileName = findViewById(R.id.view_profile_name);
        viewProfileEmail = findViewById(R.id.view_profile_email);
        logout = findViewById(R.id.btn_logout);



    }


}
