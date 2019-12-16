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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileDialog extends Dialog {

    private Context context;
    private CircleImageView viewProfileImg;
    private TextView viewProfileName, viewProfileEmail;
    private Button logout;
    private GoogleSignInClient mGoogleSignInClient;


    public UserProfileDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        viewProfileImg = findViewById(R.id.view_profile_image_dialog);
        viewProfileName = findViewById(R.id.view_profile_name_dialog);
        viewProfileEmail = findViewById(R.id.view_profile_email_dialog);
        logout = findViewById(R.id.btn_logout_dialog);

//        Glide.with(context)
////                        .load(String.valueOf("https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/4252rscbv5M/photo.jpg\n"))
////                        .into(viewProfileImg);
//                if(AppConstants.user.getPhoto() != null) {
//                    Glide.with(getContext())
//                            .load(String.valueOf(AppConstants.user.getPhoto()))
//                            .into(viewProfileImg);
//                }
                viewProfileName.setText(AppConstants.user.getName());
                viewProfileEmail.setText(AppConstants.user.getEmail());
    }




}
