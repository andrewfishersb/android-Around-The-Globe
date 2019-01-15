package com.fisher.andrew.aroundtheglobe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.fisher.andrew.aroundtheglobe.Fragments.GameFragment;
import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.gameScreen)
    FrameLayout mScreen;
    private List<City> mCities;
    private int mRound;
    private int mTotalRounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);


        Intent intent = getIntent();

        mCities = intent.getParcelableArrayListExtra("initial_cities");
        mRound = 0;
        mTotalRounds = 0;

        Random rnd = new Random();
        //eventually make sure none of the same indexes // maybe a secondary method that checks
        int slide1 = rnd.nextInt(mCities.size());
        int slide2 = rnd.nextInt(mCities.size());
        int slide3= rnd.nextInt(mCities.size());

        City city1= mCities.get(slide1);
        City city2= mCities.get(slide2);
        City city3= mCities.get(slide3);


        ArrayList<City> answers = new ArrayList<>();
        answers.add(city1);
        answers.add(city2);
        answers.add(city3);


        FragmentManager fm = getSupportFragmentManager();
        GameFragment gFrag = GameFragment.newInstance(city1);
        fm.beginTransaction().replace(R.id.gameScreen,gFrag).commit();

    }


    public List<City> getCities(){
        return mCities;
    }

    public void setNumberOfRounds(int rounds){
         mTotalRounds = rounds;
    }

    public int getNumberOfRounds(){
        return mTotalRounds;
    }

    public void incrementCurrentRound(){
        mRound++;
    }

    public int getCurrentRound(){
        return mRound;
    }

    public void goToNextRound(int round){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        City nextCity = mCities.get(round);
        GameFragment gFrag = GameFragment.newInstance(nextCity);
        ft.setCustomAnimations(R.anim.start_anim_enter_right,R.anim.end_anim_exit_left);
        ft.replace(R.id.gameScreen,gFrag).commit();
    }




//nothing for now
    @Override
    public void onClick(View view) {

    }


}
