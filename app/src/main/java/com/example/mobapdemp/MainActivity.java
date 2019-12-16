package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private CardStackView cardStackView;
    private CardStackAdapter adapter;
    private CardStackLayoutManager manager;
    private TextView txtScenario, txtCharacterName, playerName, playerScore;

    private ProgressBar progressBar_health, progressBar_social, progressBar_money, progressBar_grades;


    private ImageView markHealth, markSocial, markGrades, markMoney;

    private DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cardStackView = findViewById(R.id.card_stack_view);

        progressBar_health = findViewById(R.id.progressBar_health);
        progressBar_social = findViewById(R.id.progressBar_social);
        progressBar_money = findViewById(R.id.progressBar_money);
        progressBar_grades = findViewById(R.id.progressBar_grades);


        //adapter
        adapter = new CardStackAdapter(AppConstants.deck, this);
        manager = new CardStackLayoutManager(this, this);

        //settings for the swipe features
        manager.setVisibleCount(1);
        manager.setOverlayInterpolator(new OvershootInterpolator());
        manager.setMaxDegree(30);
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

        //scenario and character text view
        txtScenario = findViewById(R.id.txt_scenario);
        txtCharacterName = findViewById(R.id.txt_character_name);

        AppConstants.player = new Player(name);
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Card topcard = AppConstants.deck.getQueue().get(manager.getTopPosition());
//        ScenarioCard card = (ScenarioCard)topcard;


        if((topcard instanceof ScenarioCard) && draggedLeft(direction)) {
            if(((ScenarioCard)topcard).getChoiceLeft().getConsequence().getHealth() != 0){
                markHealth.setAlpha(1f);
            }else{
                markHealth.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceLeft().getConsequence().getSocial() != 0){
                markSocial.setAlpha(1f);
            }else{
                markSocial.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceLeft().getConsequence().getMoney() != 0){
                markMoney.setAlpha(1f);
            }else{
                markMoney.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceLeft().getConsequence().getGrades() != 0){
                markGrades.setAlpha(1f);
            }else{
                markGrades.setAlpha(0f);
            }
        }

        if((topcard instanceof ScenarioCard) && !draggedLeft(direction)) {
            if(((ScenarioCard)topcard).getChoiceRight().getConsequence().getHealth() != 0){
                markHealth.setAlpha(1f);
            }else{
                markHealth.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceRight().getConsequence().getSocial() != 0){
                markSocial.setAlpha(1f);
            }else{
                markSocial.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceRight().getConsequence().getMoney() != 0){
                markMoney.setAlpha(1f);
            }else{
                markMoney.setAlpha(0f);
            }
            if(((ScenarioCard)topcard).getChoiceRight().getConsequence().getGrades() != 0){
                markGrades.setAlpha(1f);
            }else{
                markGrades.setAlpha(0f);
            }
        }

    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d("CHECKTOPCARD", manager.getTopPosition()+ "");
        Card card = AppConstants.deck.getQueue().get(manager.getTopPosition()-1);

        NarrationCard narrationCard = null;

        if(card instanceof ScenarioCard) {
            if(direction.equals(Direction.Left)) {
                AppConstants.player.change(ScenarioCard.getLeftConsequence(card));
                narrationCard = ScenarioCard.getLeftNarration(card);
            }else {
                AppConstants.player.change(ScenarioCard.getRightConsequence(card));
                narrationCard = ScenarioCard.getRightNarration(card);
            }
        }else if(card instanceof DeathCard){
            gameOver();
        }

        if(narrationCard!=null){
            AppConstants.deck.getQueue().add(manager.getTopPosition()-1, narrationCard);
            adapter.notifyDataSetChanged();
        }

        progressBar_grades.setProgress(AppConstants.player.getGrades());
        progressBar_health.setProgress(AppConstants.player.getHealth());
        progressBar_money.setProgress(AppConstants.player.getMoney());
        progressBar_social.setProgress(AppConstants.player.getSocial());

        if(!AppConstants.player.isSurviving()){
            switch (AppConstants.player.causeOfDeath()){
                case "health0":
                    //add death card to respective death
                    break;
                case "health100":
                    break;
                case "social0":
                    break;
                case "social100":
                    break;
                case "money0":
                    break;
                case "money100":
                    break;
                case "grades0":
                    break;
                case "grades100":
                    break;
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

        Card card = AppConstants.deck.getQueue().get(position);

        if(card instanceof ScenarioCard) {
            txtScenario.setText(((ScenarioCard)card).getScenarioText());
            txtCharacterName.setText(((ScenarioCard)card).getCharacter().getCharacterName());

        }else if(card instanceof NarrationCard) {
            txtCharacterName.setText("");
            txtScenario.setText("");
        }

    }

    @Override
    public void onCardDisappeared(View view, int position) {
        markHealth.setAlpha(0f);
        markSocial.setAlpha(0f);
        markMoney.setAlpha(0f);
        markGrades.setAlpha(0f);
    }

    public boolean draggedLeft(Direction direction) {
        if(direction.toString().equalsIgnoreCase("Left")){
            return true;
        }
        return false;
    }

    public boolean draggedRight(Direction direction){
        return !draggedLeft(direction);
    }


    private void gameOver(){

        db = FirebaseDatabase.getInstance().getReference("leaderboard");

        //check leaderboard
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            ArrayList<LeaderboardModel> leaders = new ArrayList<>();
            LeaderboardModel curr = new LeaderboardModel(AppConstants.player.getName(), 15, AppConstants.user.getName());

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                leaders.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    LeaderboardModel leaderboardModel = postSnapshot.getValue(LeaderboardModel.class);
                    leaders.add(leaderboardModel);
                }

                Collections.sort(leaders);

                if(leaders.get(leaders.size()-1).getScore() < curr.getScore()) {
                    leaders.add(curr);


                    Collections.sort(leaders);

                    int size = 10;

                    int k = leaders.size();
                    if (k > size)
                        leaders.subList(10, k).clear();

                    Toast.makeText(getApplicationContext(), "Congratulations you are rank "+ leaders.indexOf(curr) +" in the leaderboard!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
