package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private CardStackView cardStackView;
    private CardStackAdapter adapter;
    private CardStackLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cardStackView = findViewById(R.id.card_stack_view);

        Deck carddeck = new Deck();
        carddeck.initializeStandardDeck();

        adapter = new CardStackAdapter(carddeck, this);
        manager = new CardStackLayoutManager(this, this);

        //settings for the swipe features
        manager.setVisibleCount(1);
        manager.setOverlayInterpolator(new OvershootInterpolator());
        manager.setMaxDegree(30);
        manager.setCanScrollVertical(false);

        //set up for cardstackview
        cardStackView.setAdapter(adapter);
        cardStackView.setLayoutManager(manager);
        cardStackView.swipe();


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
