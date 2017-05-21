package com.fisher.andrew.aroundtheglobe;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fisher.andrew.aroundtheglobe.models.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<City> mCities;
    Button mLaunchGame;


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


//        for(int i = 400; i< mCities.size()
//                ;i++) {
//
//            // mCities.size()
//
////            if(i>=){
////                break;
////            }
//
//            getCity(mCities.get(i));
//            Log.d("Index",i+"");
//
//        }

        mLaunchGame = (Button) findViewById(R.id.launch_game);
        mLaunchGame.setOnClickListener(this);

    }



    private ArrayList<City> loadCitiesFromFile() throws IOException {
        ArrayList<City> allCities = new ArrayList<>();

        AssetManager am = this.getAssets();

        InputStream is = am.open("testcities.txt");
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



//        intent.putExtra("cities",mCities);


        startActivity(intent);
    }
}
