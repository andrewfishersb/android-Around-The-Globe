package com.fisher.andrew.aroundtheglobe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.fisher.andrew.aroundtheglobe.models.City;
import com.fisher.andrew.aroundtheglobe.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.city_image) ImageView mCityImage;
    @Bind(R.id.answer_a) Button mAnswerA;
    @Bind(R.id.answer_b) Button mAnswerB;
    @Bind(R.id.answer_c) Button mAnswerC;
    @Bind(R.id.answer_d) Button mAnswerD;

    String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);
        ArrayList<City> cities = this.getIntent().getParcelableArrayListExtra("initial_cities");

        Intent intent = getIntent();

        int[] wrongAnswerIndexes = intent.getIntArrayExtra("wrong_answers");
        City correctCity = intent.getParcelableExtra("correct_city");



        Photo correctPhoto = intent.getParcelableExtra("pic");


        //Attaches correct image
        Picasso.with(this).load(correctPhoto.getPhotoUrl()).into(mCityImage);


        correctAnswer = correctCity.getCityName()+", " + correctCity.getCountry();
        //Set button text
        //ArrayList of buttons meant to randomize where each answer goes
        List<Button> randomizeAnswers = Arrays.asList(mAnswerA,mAnswerB,mAnswerC,mAnswerD);
        Collections.shuffle(randomizeAnswers);

        //attaches answers to the button
        randomizeAnswers.get(0).setText(correctAnswer);//correct answer
        randomizeAnswers.get(1).setText(cities.get(wrongAnswerIndexes[0]).getCityName()+", "+cities.get(wrongAnswerIndexes[0]).getCountry());
        randomizeAnswers.get(2).setText(cities.get(wrongAnswerIndexes[1]).getCityName()+", "+cities.get(wrongAnswerIndexes[1]).getCountry());
        randomizeAnswers.get(3).setText(cities.get(wrongAnswerIndexes[2]).getCityName()+", "+cities.get(wrongAnswerIndexes[2]).getCountry());


        //Set Click Listeners
        mAnswerA.setOnClickListener(this);
        mAnswerB.setOnClickListener(this);
        mAnswerC.setOnClickListener(this);
        mAnswerD.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {


        if(view == mAnswerA){
            if(checkAnswer(mAnswerA.getText().toString(),correctAnswer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Answer was: " +correctAnswer, Toast.LENGTH_SHORT).show();
            }
        }

        if(view == mAnswerB){
            if(checkAnswer(mAnswerB.getText().toString(),correctAnswer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Answer was:" +correctAnswer, Toast.LENGTH_SHORT).show();
            }
        }

        if(view == mAnswerC){
            if(checkAnswer(mAnswerC.getText().toString(),correctAnswer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Answer was:" +correctAnswer, Toast.LENGTH_SHORT).show();
            }
        }

        if(view == mAnswerD){
            if(checkAnswer(mAnswerD.getText().toString(),correctAnswer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Answer was:" +correctAnswer, Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean checkAnswer(String guess, String answer){
        if(guess.equals(answer)){
            return true;
        }else{
            return false;
        }
    }
}