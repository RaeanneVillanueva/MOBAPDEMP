package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LeaderboardDialog extends Dialog {

    ArrayList<LeaderboardModel> leaderboardData;
    Button btnClose;
    ListView leaderboardListView;
    LeaderboardAdapter leaderboardAdapter;
    private DatabaseReference databaseSample;

    public LeaderboardDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_leaderboard);

        btnClose = findViewById(R.id.btn_close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        initializeData();
        leaderboardListView = findViewById(R.id.leaderboard_list_view);
        leaderboardAdapter = new LeaderboardAdapter(this.getContext(), leaderboardData);
        leaderboardListView.setAdapter(leaderboardAdapter);

        databaseSample = FirebaseDatabase.getInstance().getReference("leaderBoard");

    }

    public void initializeData() {
        leaderboardData = new ArrayList<>();

        leaderboardData.add(new LeaderboardModel("Raeraeanne", 3));
        leaderboardData.add(new LeaderboardModel("Anne", 2));
        leaderboardData.add(new LeaderboardModel( "John", 1));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrew", 0));
        leaderboardData.add(new LeaderboardModel( "Andrewanne", 0));


    }
}
