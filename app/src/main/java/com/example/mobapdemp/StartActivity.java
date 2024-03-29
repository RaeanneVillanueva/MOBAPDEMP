package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class StartActivity extends AppCompatActivity {

    private LeaderboardDialog leaderboardDialog;
    private UserProfileDialog profileDialog;
    private EditText playerName;
    private Button btnPlay, btn_signout, btnLogout;
    private DatabaseReference databaseSample;
    private CircleImageView profileImg;
    private AlertDialog dialogUserProfile, dialogStartGame;

    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;


    private String personName, personGivenName, personFamilyName, personEmail, personId;
    private Uri personPhoto;

    public StartActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (acct != null) {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            personId = acct.getId();
            personPhoto = acct.getPhotoUrl();
        }else
        if(currentUser != null){
            personName = currentUser.getDisplayName();
            personEmail = currentUser.getEmail();
            personId = currentUser.getUid();
            personPhoto = currentUser.getPhotoUrl();
        }

        AppConstants.user = new User(personId, personName, personEmail, personPhoto);


        profileImg = findViewById(R.id.profile_image);
        Glide.with(this).load(String.valueOf("https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/4252rscbv5M/photo.jpg")).into(profileImg);
        if(AppConstants.user.getPhoto() != null){
            Glide.with(this).load(String.valueOf(AppConstants.user.getPhoto())).into(profileImg);

        }
    }


    public void openUserDialog(View view){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_user_profile, null);
        TextView viewProfileName = dialogView.findViewById(R.id.view_profile_name_dialog);
        TextView viewProfileEmail = dialogView.findViewById(R.id.view_profile_email_dialog);
        CircleImageView viewProfileImage = dialogView.findViewById(R.id.view_profile_image_dialog);
        btnLogout = dialogView.findViewById(R.id.btn_logout_dialog);

        viewProfileName.setText(AppConstants.user.getName());
        viewProfileEmail.setText(AppConstants.user.getEmail());
        Glide.with(this)
                .load(String.valueOf("https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/4252rscbv5M/photo.jpg\n"))
                .into(viewProfileImage);
        if(AppConstants.user.getPhoto() != null) {
            Glide.with(this)
                    .load(String.valueOf(AppConstants.user.getPhoto()))
                    .into(viewProfileImage);
        }

        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialogUserProfile.dismiss();
                signOut();
            }
        });

        alertBuilder.setView(dialogView);
        dialogUserProfile = alertBuilder.create();
        dialogUserProfile.show();
    }



    public void openLeaderboard(View view) {
        leaderboardDialog = new LeaderboardDialog(this);
        leaderboardDialog.show();

    }

    public void createDeck(View view) {
        Intent intent = new Intent(this, DeckListActivity.class);
        startActivity(intent);
    }

    public void startGame(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_player_name, null);
        playerName = dialogView.findViewById(R.id.etxt_playername);
        btnPlay = dialogView.findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialogStartGame.dismiss();
                AppConstants.initStandardDeck();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("Inputted Player Name", playerName.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        alertBuilder.setView(dialogView);
        dialogStartGame = alertBuilder.create();

        dialogStartGame.show();
    }

    private void signOut() {
        AppConstants.user = null;
        FirebaseAuth.getInstance().signOut();

        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }


}
