package com.example.mobapdemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private CardStackView cardStackView;
    private CardStackAdapter adapter;
    private CardStackLayoutManager manager;
    private Deck carddeck;
    private TextView playerName, playerScore;

    private ImageView markHealth, markSocial, markGrades, markMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cardStackView = findViewById(R.id.card_stack_view);

        carddeck = new Deck();
        carddeck.initializeStandardDeck();
        carddeck.enQueueCards();

        adapter = new CardStackAdapter(carddeck, this);
        manager = new CardStackLayoutManager(this, this);

        //settings for the swipe features
        manager.setVisibleCount(1);
        manager.setOverlayInterpolator(new OvershootInterpolator());
        manager.setMaxDegree(50);
        manager.setCanScrollVertical(false);
        manager.setSwipeableMethod(SwipeableMethod.Manual);


        //set up for cardstackview
        cardStackView.setAdapter(adapter);
        cardStackView.setLayoutManager(manager);
        cardStackView.swipe();

        //reflect the inputted name from dialog
        playerName = findViewById(R.id.player_name);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Inputted Player Name");
        playerName.setText(name);


        //getting the marks
        markHealth = findViewById(R.id.mark_health);
        markSocial = findViewById(R.id.mark_social);
        markMoney = findViewById(R.id.mark_money);
        markGrades = findViewById(R.id.mark_grades);
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Card topcard = carddeck.getQueue().get(manager.getTopPosition());
        ScenarioCard card = (ScenarioCard)topcard;

        //markings
        if(card.getChoiceLeft().getConsequence().getHealth() != 0 || card.getChoiceRight().getConsequence().getHealth() != 0){
            markHealth.setAlpha(1f);
        }
        if(card.getChoiceLeft().getConsequence().getSocial() != 0 || card.getChoiceRight().getConsequence().getSocial() != 0){
            markSocial.setAlpha(1f);
        }
        if(card.getChoiceLeft().getConsequence().getMoney() != 0 || card.getChoiceRight().getConsequence().getMoney() != 0){
            markMoney.setAlpha(1f);
        }
        if(card.getChoiceLeft().getConsequence().getGrades() != 0 || card.getChoiceRight().getConsequence().getGrades() != 0){
            markGrades.setAlpha(1f);
        }
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
        markHealth.setAlpha(0f);
        markSocial.setAlpha(0f);
        markMoney.setAlpha(0f);
        markGrades.setAlpha(0f);
    }

    @Override
    public void onCardAppeared(View view, int position) {
        markHealth.setAlpha(0f);
        markSocial.setAlpha(0f);
        markMoney.setAlpha(0f);
        markGrades.setAlpha(0f);
    }

    @Override
    public void onCardDisappeared(View view, int position) {
        markHealth.setAlpha(0f);
        markSocial.setAlpha(0f);
        markMoney.setAlpha(0f);
        markGrades.setAlpha(0f);
    }

}
