package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateCardDialog extends Dialog{

    private Button btnAdd, btnCancel;

    //for spinner
    private Spinner charSpinner;
    private ArrayList<Character> characterList;
    private CharacterListAdapter charAdapter;

    public CreateCardDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_create_card);

        btnAdd = findViewById(R.id.btn_add);
        btnCancel = findViewById(R.id.btn_cancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        charSpinner = findViewById(R.id.spinner_characters);
        initCharacterList();
        charAdapter = new CharacterListAdapter(this.getContext(),characterList);
        charSpinner.setAdapter(charAdapter);
        charSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Character selectedChar = (Character) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), selectedChar.getCharacterName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initCharacterList() {
        characterList = new ArrayList<>();

        characterList.add(new Character("Mom", R.drawable.mom));
        characterList.add(new Character("Dad", R.drawable.dad));
        characterList.add(new Character("Jyle", R.drawable.jyle));
        characterList.add(new Character("Jeanette", R.drawable.jean));
        characterList.add(new Character("Jean", R.drawable.jean_boy));
        characterList.add(new Character("James", R.drawable.james));
        characterList.add(new Character("Bek", R.drawable.bek));
        characterList.add(new Character("Bob", R.drawable.bob));
        characterList.add(new Character("Upperclassmen", R.drawable.upperclass1));
        characterList.add(new Character("Upperclassmen", R.drawable.upperclass2));
        characterList.add(new Character("Professor", R.drawable.prof1));
        characterList.add(new Character("Professor", R.drawable.prof2));
    }
}
