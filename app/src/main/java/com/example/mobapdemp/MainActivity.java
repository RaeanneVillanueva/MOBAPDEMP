package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private CardStackView cardStackView;
    private CardStackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardStackView = findViewById(R.id.card_stack_view);

        ArrayList<ScenarioCard> data = new ArrayList<>();

        adapter = new CardStackAdapter(data, this);


    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}
