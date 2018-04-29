package com.fisher.andrew.aroundtheglobe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fisher.andrew.aroundtheglobe.Adapters.GameScreenPagerAdapter;
import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.Services.FlickrService;
import com.fisher.andrew.aroundtheglobe.Utils.NonSwipeableViewPager;
import com.fisher.andrew.aroundtheglobe.models.City;
import com.fisher.andrew.aroundtheglobe.models.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
//    @Bind(R.id.city_image) ImageView mCityImage;
    @Bind(R.id.gamePager)
    NonSwipeableViewPager mPager;
    private List<City> mCities;
    private GameScreenPagerAdapter mAdapter;

//    @Bind(R.id.answer_a) Button mAnswerABtn;
//    @Bind(R.id.answer_b) Button mAnswerBBtn;
//    @Bind(R.id.answer_c) Button mAnswerCBtn;
//    @Bind(R.id.answer_d) Button mAnswerDBtn;
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



        //Game screen pager
        mAdapter = new GameScreenPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

    }

    public NonSwipeableViewPager getPager(){
        return mPager;
    }

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

//    private boolean checkAnswer(String guess, String answer){
//        return guess.equals(answer);
//    }


    private void getCity(final City currentCity){
        final FlickrService flickrService = new FlickrService();

        flickrService.findCityImages(currentCity, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();

                    try{

                        JSONObject jobj = new JSONObject(jsonData);
                        JSONObject jsonPhotos = jobj.getJSONObject("photos");
                        JSONArray photoArray = jsonPhotos.getJSONArray("photo");

                        for(int i = 0; i < photoArray.length();i++){
                            JSONObject curJsonPhoto = photoArray.getJSONObject(i);


                            String id = curJsonPhoto.getString("id");
                            String secret = curJsonPhoto.getString("secret");
                            String server = curJsonPhoto.getString("server");
                            int farm = curJsonPhoto.getInt("farm");

                            Photo curPhoto = new Photo(farm,server,id,secret);
                            currentCity.addPhoto(curPhoto);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
