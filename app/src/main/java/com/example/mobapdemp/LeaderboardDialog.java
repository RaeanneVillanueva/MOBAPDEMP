package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LeaderboardDialog extends Dialog {

    ArrayList<LeaderboardModel> leaderboardData;
    Button btnClose;

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

    }

    public void initializeData() {
        leaderboardData = new ArrayList<>();

        leaderboardData.add(new LeaderboardModel(1, "Raerae", "3rd Term"));
        leaderboardData.add(new LeaderboardModel(2, "Anne", "2nd Term"));
        leaderboardData.add(new LeaderboardModel(3, "John", "1st Term"));
        leaderboardData.add(new LeaderboardModel(4, "Andrew", "0 Term"));
    }
}
