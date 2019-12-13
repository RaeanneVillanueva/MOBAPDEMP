package com.example.mobapdemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    ArrayList<LeaderboardModel> leaderboardData;
    Context context;

    public LeaderboardAdapter(ArrayList<LeaderboardModel> data, Context context) {
        this.leaderboardData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_leaderboard, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        holder.txtRank.setText(leaderboardData.get(position).getRank());
        holder.txtRank.setText(leaderboardData.get(position).getPlayerName());
        holder.txtScore.setText(leaderboardData.get(position).getScore());
    }


    @Override
    public int getItemCount() {
        return this.leaderboardData.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        private TextView txtRank, txtPlayername, txtScore;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRank = itemView.findViewById(R.id.txt_rank);
            txtPlayername = itemView.findViewById(R.id.txt_player_name);
            txtScore = itemView.findViewById(R.id.txt_score);

        }
    }
}
