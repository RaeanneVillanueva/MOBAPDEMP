package com.example.mobapdemp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CardListAdapter extends ArrayAdapter<Card> {

    private Context context;
    private ArrayList<Card> cardList;

    public CardListAdapter(Context context, ArrayList<Card> cardList) {
        super(context, 0, cardList);
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return null;
    }

    public int getCount() {
        return cardList.size();
    }
}
