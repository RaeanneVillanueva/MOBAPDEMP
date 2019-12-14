package com.example.mobapdemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeaderboardAdapter extends ArrayAdapter<LeaderboardModel> {

    private ArrayList<LeaderboardModel> leaderboardList;
    private Context context;
    private TextView txtRank, txtPlayerName, txtScore;

    public LeaderboardAdapter(Context context, ArrayList<LeaderboardModel> leaderboardList) {
        super(context, R.layout.item_leaderboard, leaderboardList);
        this.context = context;
        this.leaderboardList = leaderboardList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public int getCount() {
        return leaderboardList.size();
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_leaderboard, null, true);
        }

        txtRank = convertView.findViewById(R.id.txt_rank);
        txtPlayerName = convertView.findViewById(R.id.txt_player_name);
        txtScore = convertView.findViewById(R.id.txt_score);

        LeaderboardModel leaderboarditem = getItem(position);

        txtRank.setText(leaderboarditem.getRank() + "");
        txtPlayerName.setText(leaderboarditem.getPlayerName());
        txtScore.setText(leaderboarditem.getScore());

        return convertView;
    }
}
