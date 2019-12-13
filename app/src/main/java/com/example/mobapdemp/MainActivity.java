package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Deck carddeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cardStackView = findViewById(R.id.card_stack_view);

        carddeck = new Deck();
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
        Log.d("CHECKTOPCARD", manager.getTopPosition()+ "");
    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d("CHECKTOPCARD", manager.getTopPosition()+ "");

        if(direction.equals(Direction.Left)) {
            Card card = carddeck.getCards().get(manager.getTopPosition()-1);

            if(card instanceof ScenarioCard) {
                int health = ((ScenarioCard)card).getChoiceRight().getConsequence().getHealth();
                String name = ((ScenarioCard)card).getCharacter().getCharacterName();
                Log.d("ChoiceLeft", health+"" + " " + name);
            }
        }
    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {
        Log.d("POSITION", position+"");
    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}
