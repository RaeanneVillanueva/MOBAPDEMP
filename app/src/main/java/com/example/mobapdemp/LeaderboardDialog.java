package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

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
        leaderboardAdapter.notifyDataSetChanged();
        leaderboardListView.setAdapter(leaderboardAdapter);

        databaseSample = FirebaseDatabase.getInstance().getReference("leaderBoard");

    }

    public void initializeData() {
        leaderboardData = new ArrayList<>();
        databaseSample.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    LeaderboardModel lm = postSnapshot.getValue(LeaderboardModel.class);
                    leaderboardData.add(lm);
                }

                Collections.sort(leaderboardData);
                leaderboardAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
