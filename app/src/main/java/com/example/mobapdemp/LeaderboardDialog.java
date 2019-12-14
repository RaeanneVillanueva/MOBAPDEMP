package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderboardDialog extends Dialog {

    ArrayList<LeaderboardModel> leaderboardData;
    Button btnClose;
    ListView leaderboardListView;
    LeaderboardAdapter leaderboardAdapter;

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

    }

    public void initializeData() {
        leaderboardData = new ArrayList<>();

        leaderboardData.add(new LeaderboardModel(1, "Raeraeanne", 3));
        leaderboardData.add(new LeaderboardModel(2, "Anne", 2));
        leaderboardData.add(new LeaderboardModel(3, "John", 1));
        leaderboardData.add(new LeaderboardModel(4, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(5, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(6, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(7, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(8, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(9, "Andrew", 0));
        leaderboardData.add(new LeaderboardModel(10, "Andrewanne", 0));


    }
}
