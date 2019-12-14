package com.example.mobapdemp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CharacterListAdapter extends ArrayAdapter<Character> {

    public CharacterListAdapter (Context context, ArrayList<Character> characterList) {
        super(context,0, characterList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_character_spinner,parent,false);
        }

        ImageView imgChar = convertView.findViewById(R.id.img_character);
        TextView txtCharName = convertView.findViewById(R.id.txt_char_name);
        Character character = getItem(position);

        if(character != null) {
            imgChar.setImageResource(character.getImagePath());
            txtCharName.setText(character.getCharacterName());
        }

        return convertView;
    }
}
