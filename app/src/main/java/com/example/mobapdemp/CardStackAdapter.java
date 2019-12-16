package com.example.mobapdemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CardStackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Deck deck;
    Context context;

    public CardStackAdapter(Deck deck, Context context){
        this.deck = deck;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;

        switch (viewType){
            case 1:
                view = layoutInflater.inflate(R.layout.item_scenario_card, parent, false);
                return new ScenarioCardViewHolder(view);

            case 2:
                view = layoutInflater.inflate(R.layout.item_narration_card, parent, false);
                return new NarrationCardViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Card card = deck.getQueue().get(position);

        if(card instanceof ScenarioCard) {
            ((ScenarioCardViewHolder)holder).choiceLeft.setText(((ScenarioCard) card).getChoiceLeft().getText());
            ((ScenarioCardViewHolder)holder).choiceRight.setText(((ScenarioCard) card).getChoiceRight().getText());
            Glide.with(context).load(((ScenarioCard) card).getCharacter().getImagePath()).into(((ScenarioCardViewHolder)holder).cardImage);

        }else if(card instanceof NarrationCard) {
            ((NarrationCardViewHolder)holder).txtNarration.setText(card.getScenarioText());
        }

    }


    @Override
    public int getItemViewType(int position) {

        if(deck.getQueue().get(position) instanceof ScenarioCard) {
            return 1;
        }else if(deck.getQueue().get(position) instanceof NarrationCard) {
            return 2;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return deck.getQueue().size();
    }

    public class ScenarioCardViewHolder extends RecyclerView.ViewHolder {

        private TextView charName;
        private ImageView cardImage;
        private TextView choiceLeft;
        private TextView choiceRight;
        private TextView txtScenario;

        public ScenarioCardViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.cardImage);
            choiceLeft = itemView.findViewById(R.id.left_overlay);
            choiceRight = itemView.findViewById(R.id.right_overlay);
        }
    }

    public class NarrationCardViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNarration;

        public NarrationCardViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNarration = itemView.findViewById(R.id.txt_narration);
        }
    }
}
