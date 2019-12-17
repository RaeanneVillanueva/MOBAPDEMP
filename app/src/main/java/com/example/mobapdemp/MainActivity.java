package com.example.mobapdemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.tech.NfcA;
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
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

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
        AppConstants.player = new Player(name);

        //player points
        playerScore = findViewById(R.id.txt_points);


        //getting the marks
        markHealth = findViewById(R.id.mark_health);
        markSocial = findViewById(R.id.mark_social);
        markMoney = findViewById(R.id.mark_money);
        markGrades = findViewById(R.id.mark_grades);

        //scenario and character text view
        txtScenario = findViewById(R.id.txt_scenario);
        txtCharacterName = findViewById(R.id.txt_character_name);

        AppConstants.player = new Player(name);
        playerScore.setText("TERM: "+AppConstants.player.getTerm());
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Card topcard = AppConstants.deck.getQueue().get(manager.getTopPosition());

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
        Log.d("CHECKCARD", (manager.getTopPosition()-1)+ "" + "   prev card: " + manager.getTopPosition() + "");
        Card card = AppConstants.deck.getQueue().get(manager.getTopPosition()-1);

        NarrationCard narrationCard = null;
        if(card instanceof DeathCard){
            gameOver();
        }
        if(card instanceof ScenarioCard) {

            if(direction.equals(Direction.Left)) {
                AppConstants.player.change(ScenarioCard.getLeftConsequence(card));
                if(((ScenarioCard)card).getChoiceRight().getNarration()!= null && ((ScenarioCard)card).getChoiceLeft().getNarration().getScenarioText() != null)
                    if(!((ScenarioCard)card).getChoiceLeft().getNarration().getScenarioText().equalsIgnoreCase(""))
                        narrationCard = ScenarioCard.getLeftNarration(card);
            }else {
                AppConstants.player.change(ScenarioCard.getRightConsequence(card));

                if(((ScenarioCard)card).getChoiceRight().getNarration()!= null && ((ScenarioCard)card).getChoiceRight().getNarration().getScenarioText() != null)
                    if(!((ScenarioCard)card).getChoiceRight().getNarration().getScenarioText().equalsIgnoreCase(""))
                        narrationCard = ScenarioCard.getRightNarration(card);
            }
        }

        if(card instanceof NarrationCard && ((NarrationCard)card).getScenarioText().matches("TERM")){
            AppConstants.player.setTerm(Integer.parseInt(((NarrationCard)card).getScenarioText().replaceAll("\\D+", "")));
            playerScore.setText(AppConstants.player.getTerm());
        }


        progressBar_grades.setProgress(AppConstants.player.getGrades());
        progressBar_health.setProgress(AppConstants.player.getHealth());
        progressBar_money.setProgress(AppConstants.player.getMoney());
        progressBar_social.setProgress(AppConstants.player.getSocial());
        playerScore.setText(AppConstants.player.getTerm());

        if(!AppConstants.player.isSurviving()){
            DeathCard dc = null;
            switch (AppConstants.player.causeOfDeath()){
                case "health0":
                    dc = new DeathCard(AppConstants.VOMIT, "You got sick. The university kicked you out of the school for excessive amounts of absences.");
                    break;
                case "health100":
                    dc = new DeathCard(AppConstants.DRUGS, "You were so healthy that you thought you were immune to anything. So you overdosed");
                    break;
                case "social0":
                    dc = new DeathCard(AppConstants.LONELINESS, "You neglected your friends so they left you.");
                    break;
                case "social100":
                    dc = new DeathCard(AppConstants.DRUGS, "You were such a people pleaser that you easily caved in to peer pressure and overdosed drugs");
                    break;
                case "money0":
                    dc = new DeathCard(AppConstants.STARVE, "You are broke. You starved.");
                    break;
                case "money100":
                    dc = new DeathCard(AppConstants.LONELINESS, "You were so rich.");
                    break;
                case "grades0":
                    dc = new DeathCard(AppConstants.LONELINESS, "You failed every subject imaginable");
                    break;
                case "grades100":
                    dc = new DeathCard(AppConstants.VOMIT, "You got a 4.0 in every subject imaginable. The university suspected you of cheating and kicked you out");
                    break;
            }
            AppConstants.deck.getQueue().add(manager.getTopPosition(), dc);

            adapter = new CardStackAdapter(AppConstants.deck, this);

        }

        if(narrationCard!=null){
            AppConstants.deck.getQueue().add(manager.getTopPosition(), narrationCard);
            adapter = new CardStackAdapter(AppConstants.deck, this);
        }

        if(AppConstants.deck.getQueue().size() == 0){
            //win
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

        Log.d("CheckAppearedCard", position+"" + " top position: " + manager.getTopPosition() + "");
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

        adapter = new CardStackAdapter(AppConstants.deck, this);

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
            LeaderboardModel curr = new LeaderboardModel(AppConstants.player.getName(), AppConstants.player.getTerm(), AppConstants.user.getName());

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                leaders.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    LeaderboardModel leaderboardModel = postSnapshot.getValue(LeaderboardModel.class);
                    leaders.add(leaderboardModel);
                }

                Collections.sort(leaders);

                if(leaders.size() < 10 || leaders.get(leaders.size()-1).getScore() < curr.getScore()) {
                    leaders.add(curr);


                    Collections.sort(leaders);

                    int size = 10;

                    int k = leaders.size();
                    if (k > size)
                        leaders.subList(10, k).clear();

                    db.removeValue();
                    for(LeaderboardModel lm: leaders) {
                        String id = db.push().getKey();
                        lm.setId(id);
                        db.child(id).setValue(lm);
                    }

                    Toast.makeText(getApplicationContext(), "Congratulations you are rank " + (leaders.indexOf(curr)+1) + " in the leaderboard!", Toast.LENGTH_LONG).show();
                }
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
