package com.example.mobapdemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CardListAdapter extends ArrayAdapter<Card> {

    private Context context;
    private ArrayList<Card> cardList;
    private TextView cardname;

    public CardListAdapter(Context context, ArrayList<Card> cardList) {
        super(context, R.layout.item_card, cardList);
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public int getCount() {
        return cardList.size();
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_card, null, true);
        }

        cardname = convertView.findViewById(R.id.etxt_deck_name);


        cardname.setText("Card " + (position+1)+ "");

        return convertView;
    }
}
