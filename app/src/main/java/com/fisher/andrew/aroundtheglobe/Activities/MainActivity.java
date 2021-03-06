package com.fisher.andrew.aroundtheglobe.Activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<City> mCities;
    Button mLaunchGame;
    int generateCorrectIndex;

    City correctCity = null;

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mCities = loadCitiesFromFile();
        }catch (IOException e){
           Log.d("Error","File not found");
        }



        //WAS USED TO GENERATE A GAME
//        Random rnd = new Random();
//        generateCorrectIndex = rnd.nextInt(mCities.size());
//        correctCity= mCities.get(generateCorrectIndex);
//        getCity(correctCity);


        mLaunchGame = (Button) findViewById(R.id.launch_game);
        mLaunchGame.setOnClickListener(this);

    }



    private ArrayList<City> loadCitiesFromFile() throws IOException {
        ArrayList<City> allCities = new ArrayList<>();

        AssetManager am = this.getAssets();

        InputStream is = am.open("testcities.txt");
//        InputStream is = am.open("allcities.txt");

        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {
                while ((line = reader.readLine()) != null) {
                    allCities.add(new City(line));
                }
            }
        } finally {
            try { is.close(); } catch (Throwable ignore) {}
        }

        return allCities;
    }




    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, GameActivity.class);
        intent.putParcelableArrayListExtra("initial_cities",mCities);

        //Used to randomize indxes
//        Random rnd = new Random();
//        //generates a random index and then uses that index to generate a random city object
//
//
//        //generates an array of other indexes (or can I just pass their city and country
//        int[] wrongIndexes = new int[3];
//        int loopIndex = 0;
//        while(loopIndex <3){
//            //generate a wrong index
//            int currentIndex = rnd.nextInt(mCities.size());
//            //as long as they arent matching add the
//            if(currentIndex !=generateCorrectIndex){//todo wrong answers may repeat though
//                wrongIndexes[loopIndex] = currentIndex;
//                loopIndex++;
//            }
//        }
//
//        intent.putExtra("wrong_answers",wrongIndexes);
//        intent.putExtra("correct_city",correctCity);

        //pass correct photo to page - have to do as parcelable wont work
        intent.putExtra("cities",mCities);


        startActivity(intent);
    }

//move to frag
//    private void getCity(final City currentCity){
//        final FlickrService flickrService = new FlickrService();
//
//        flickrService.findCityImages(currentCity, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    String jsonData = response.body().string();
//
//                    try{
//
//                        JSONObject jobj = new JSONObject(jsonData);
//                        JSONObject jsonPhotos = jobj.getJSONObject("photos");
//                        JSONArray photoArray = jsonPhotos.getJSONArray("photo");
//
//                        for(int i = 0; i < photoArray.length();i++){
//                            JSONObject curJsonPhoto = photoArray.getJSONObject(i);
//
//
//                            String id = curJsonPhoto.getString("id");
//                            String secret = curJsonPhoto.getString("secret");
//                            String server = curJsonPhoto.getString("server");
//                            int farm = curJsonPhoto.getInt("farm");
//
//                            Photo curPhoto = new Photo(farm,server,id,secret);
//                            currentCity.addPhoto(curPhoto);
//                        }
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
