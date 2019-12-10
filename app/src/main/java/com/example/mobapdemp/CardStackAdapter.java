package com.example.mobapdemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardStackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ScenarioCard> data;
    Context context;

    public CardStackAdapter(ArrayList<ScenarioCard> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        FrameLayout card;
        TextView charName;
        ImageView cardImage;
        TextView choiceLeft;
        TextView choiceRight;
        TextView txtScenario;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            charName = itemView.findViewById(R.id.characterName);
            cardImage = itemView.findViewById(R.id.cardImage);
            card = itemView.findViewById(R.id.card);
            choiceLeft = itemView.findViewById(R.id.item_swipe_left_indicator);
            choiceRight = itemView.findViewById(R.id.item_swipe_right_indicator);
            txtScenario = itemView.findViewById(R.id.txtScenario);
        }
    }
}
