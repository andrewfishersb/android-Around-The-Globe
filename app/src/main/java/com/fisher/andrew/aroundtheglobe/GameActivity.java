package com.fisher.andrew.aroundtheglobe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.fisher.andrew.aroundtheglobe.models.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GameActivity extends AppCompatActivity {
    @Bind(R.id.city_image) ImageView mCityImage;
    @Bind(R.id.answer_a) Button mAnswerA;
    @Bind(R.id.answer_b) Button mAnswerB;
    @Bind(R.id.answer_c) Button mAnswerC;
    @Bind(R.id.answer_d) Button mAnswerD;
    City mCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);
        ArrayList<City> cities = this.getIntent().getParcelableArrayListExtra("initial_cities");

        //wrong answer array
        int[] wrongAnswerIndexes = new int[3];

        mCity = cities.get(39);
        getCity(mCity);


        mAnswerA.setText(cities.get(39).getCityName()+", "+cities.get(39).getCountry());
        mAnswerB.setText(cities.get(28).getCityName()+", "+cities.get(28).getCountry());
        mAnswerC.setText(cities.get(16).getCityName()+", "+cities.get(16).getCountry());
        mAnswerD.setText(cities.get(48).getCityName()+", "+cities.get(48).getCountry());

    }


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
//                        Log.d("JSON",jsonData);

                        JSONObject jobj = new JSONObject(jsonData);
                        JSONObject jsonPhotos = jobj.getJSONObject("photos");
                        JSONArray photoArray = jsonPhotos.getJSONArray("photo");

                        //testing with first image
                        JSONObject pa = (JSONObject) photoArray.get(28);
                        String id = pa.getString("id");
                        String secret = pa.getString("secret");
                        String server = pa.getString("server");
                        int farm = pa.getInt("farm");

                        mCity.setPhoto(farm,server,id,secret);
                        Log.d("URL",mCity.createPhotoUrl());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


//                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
