package com.example.mobapdemp;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateCardDialog extends Dialog{

    private Button btnAdd, btnCancel;

    //for spinner
    private Spinner charSpinner;
    private ArrayList<Character> characterList;
    private CharacterListAdapter charAdapter;
    private Deck deck;

    private EditText etxt_choice_left, etxt_choice_right, etxt_scenario, etxt_social, etxt_grades, etxt_money, etxt_health;
    private ScenarioCard card;

    private DatabaseReference dbRef;

    public CreateCardDialog(@NonNull Context context, Deck deck) {
        super(context);
        this.deck = deck;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_create_card);

        dbRef = FirebaseDatabase.getInstance().getReference("card").child(deck.getId());

        card = new ScenarioCard();

        etxt_choice_left = findViewById(R.id.etxt_choice_left);
        etxt_choice_right = findViewById(R.id.etxt_choice_right);
        etxt_scenario = findViewById(R.id.etxt_scenario);
        etxt_social = findViewById(R.id.etxt_social);
        etxt_grades = findViewById(R.id.etxt_grades);
        etxt_money = findViewById(R.id.etxt_money);
        etxt_health = findViewById(R.id.etxt_health);



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
                card.setCharacter(selectedChar);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                int social = Integer.parseInt(etxt_social.getText().toString());
                int grades = Integer.parseInt(etxt_grades.getText().toString());
                int money = Integer.parseInt(etxt_money.getText().toString());
                int health = Integer.parseInt(etxt_health.getText().toString());
                card.setScenarioText(etxt_scenario.getText().toString());
                card.setChoiceLeft(new Choice(etxt_choice_left.getText().toString(), new Consequence(health,social,grades,money)));
                card.setChoiceRight(new Choice(etxt_choice_right.getText().toString(), new Consequence(-health,-social,-grades,-money)));

                String id = dbRef.push().getKey();
                dbRef.child(id).setValue(card);
                Toast.makeText(getContext(), "Card added", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });
    }

    private void initCharacterList() {
        characterList = new ArrayList<>();

        characterList.add(new Character("Mom", R.drawable.mom, "mom.png"));
        characterList.add(new Character("Dad", R.drawable.dad, "dad.png"));
        characterList.add(new Character("Jyle", R.drawable.jyle, "jyle.png"));
        characterList.add(new Character("Jeanette", R.drawable.jean, "jean.png"));
        characterList.add(new Character("Jean", R.drawable.jean_boy, "jean_boy.png"));
        characterList.add(new Character("James", R.drawable.james, "james.png"));
        characterList.add(new Character("Bek", R.drawable.bek, "bek.png"));
        characterList.add(new Character("Bob", R.drawable.bob, "bob.png"));
        characterList.add(new Character("Upperclassmen", R.drawable.upperclass1, "upperclass1.png"));
        characterList.add(new Character("Upperclassmen", R.drawable.upperclass2, "upperclass2.png"));
        characterList.add(new Character("Professor", R.drawable.prof1, "prof1.png"));
        characterList.add(new Character("Professor", R.drawable.prof2, "prof2.png"));
    }
}
