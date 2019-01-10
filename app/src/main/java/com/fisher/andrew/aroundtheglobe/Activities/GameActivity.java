package com.fisher.andrew.aroundtheglobe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.fisher.andrew.aroundtheglobe.Adapters.GameScreenPagerAdapter;
import com.fisher.andrew.aroundtheglobe.Fragments.GameFragment;
import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
//    @BindView(R.id.city_image_view)
//    ImageView mCityImage;
//    @BindView(R.id.gamePager)
//    NonSwipeableViewPager mPager;
    @BindView(R.id.gameScreen)
    FrameLayout mScreen;
    private List<City> mCities;
    private GameScreenPagerAdapter mAdapter;
    private int mRound;
    private int mTotalRounds;

//    @BindView(R.id.answer_a) Button mAnswerABtn;
//    @BindView(R.id.answer_b) Button mAnswerBBtn;
//    @BindView(R.id.answer_c) Button mAnswerCBtn;
//    @BindView(R.id.answer_d) Button mAnswerDBtn;
//    private List<Button> mBtnAnswerArray;
//    private String correctAnswer;


//    FragmentPagerAdapter adapterViewPager;

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

        //us async instead
//        new RetrieveCityAnswerTasks().execute(city1);
//        getCity(city1);
//        getCity(city2);
//        getCity(city3);

        Log.d("PhotoSize", "Size: " + city1.getPhotos().size());
        ArrayList<City> answers = new ArrayList<>();
        answers.add(city1);
        answers.add(city2);
        answers.add(city3);


        FragmentManager fm = getSupportFragmentManager();
        GameFragment gFrag = GameFragment.newInstance(city1);
        fm.beginTransaction().replace(R.id.gameScreen,gFrag).commit();












//        ArrayList<City> cities = this.getIntent().getParcelableArrayListExtra("initial_cities");
//        int[] wrongAnswerIndexes = intent.getIntArrayExtra("wrong_answers");
//        City correctCity = intent.getParcelableExtra("correct_city");
//
//
//        correctAnswer = correctCity.getCityName()+", " + correctCity.getCountry();
//
//        //ArrayList of buttons meant to randomize where each answer goes
//        mBtnAnswerArray = Arrays.asList(mAnswerABtn, mAnswerBBtn, mAnswerCBtn, mAnswerDBtn);
//        Collections.shuffle(mBtnAnswerArray);


        //attaches answers to the button
//        mBtnAnswerArray.get(0).setText(correctAnswer);//correct answer
//        mBtnAnswerArray.get(1).setText(cities.get(wrongAnswerIndexes[0]).getCityName()+", "+cities.get(wrongAnswerIndexes[0]).getCountry());
//        mBtnAnswerArray.get(2).setText(cities.get(wrongAnswerIndexes[1]).getCityName()+", "+cities.get(wrongAnswerIndexes[1]).getCountry());
//        mBtnAnswerArray.get(3).setText(cities.get(wrongAnswerIndexes[2]).getCityName()+", "+cities.get(wrongAnswerIndexes[2]).getCountry());


        //Set Click Listeners
//        mAnswerABtn.setOnClickListener(this);
//        mAnswerBBtn.setOnClickListener(this);
//        mAnswerCBtn.setOnClickListener(this);
//        mAnswerDBtn.setOnClickListener(this);


        //Image Pager Stuff
//        ViewPager viewPager;
//        viewPager = (ViewPager) findViewById(R.id.city_view_pager);
//        adapterViewPager = new ImagePagerAdapter(getSupportFragmentManager(),correctCity);
//        viewPager.setAdapter(adapterViewPager);


//        GameFragment.newInstance(mCities.get(0));
//        Log.d("CityCheck",mCities.get(0).getCityName() + " Size " + mCities.size());


        //Game screen pager
//        mAdapter = new GameScreenPagerAdapter(getSupportFragmentManager(),answers);
//        mPager.setAdapter(mAdapter);

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
        City nextCity = mCities.get(round);
        GameFragment gFrag = GameFragment.newInstance(nextCity);
        fm.beginTransaction().replace(R.id.gameScreen,gFrag).commit();
    }


//    public NonSwipeableViewPager getPager(){
//        return mPager;
//    }


//nothing for now
    @Override
    public void onClick(View view) {








//
//        if(view == mAnswerABtn){
//
//            if(checkAnswer(mAnswerABtn.getText().toString(),correctAnswer)){
//                mAnswerABtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//            }else{
//                mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//                mAnswerABtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_wrong));
//            }
//
//        }
//
//        if(view == mAnswerBBtn){
//            if(checkAnswer(mAnswerBBtn.getText().toString(),correctAnswer)){
//                mAnswerBBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//            }else{
//                mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//                mAnswerBBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_wrong));
//            }
//        }
//
//        if(view == mAnswerCBtn){
//            if(checkAnswer(mAnswerCBtn.getText().toString(),correctAnswer)){
//                mAnswerCBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//            }else{
//                mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//                mAnswerCBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_wrong));
//            }
//        }
//
//        if(view == mAnswerDBtn){
//            if(checkAnswer(mAnswerDBtn.getText().toString(),correctAnswer)){
//                mAnswerDBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//            }else{
//                mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_correct));
//                mAnswerDBtn.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.answer_btn_wrong));
//            }
//
//        }

    }


}
