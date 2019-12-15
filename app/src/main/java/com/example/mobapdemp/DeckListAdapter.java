package com.example.mobapdemp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DeckListAdapter extends ArrayAdapter<Deck> {

    Context context;
    ArrayList<Deck> deckList;
    TextView deckName, creatorName;
    //Button btnPlayDeck;

    public DeckListAdapter(Context context, ArrayList<Deck> deckList) {
        super(context, R.layout.item_deck, deckList);
        this.context = context;
        this.deckList = deckList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public int getCount() {
        return deckList.size();
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_deck, null, true);
        }

        deckName = convertView.findViewById(R.id.etxt_deck_name);
        creatorName = convertView.findViewById(R.id.txt_creator_name);

        Deck deckItem = getItem(position);
        deckName.setText(deckItem.getName());

        return convertView;
    }
}
