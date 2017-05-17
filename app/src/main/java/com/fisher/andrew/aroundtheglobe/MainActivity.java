package com.fisher.andrew.aroundtheglobe;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<City> mCities;

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mCities = extractCities();
        }catch (IOException e){
           Log.d("Error","File not found");
        }

        int indexOfNY = 0;
        for (int i = 0; i < mCities.size();i++){
            Log.d(mCities.get(i).getCityName(),mCities.get(i).getCountry());
            if(mCities.get(i).getCityName().equalsIgnoreCase("New York")){
                indexOfNY=i;
            }
        }


        getCity(mCities.get(indexOfNY));
    }



    private ArrayList<City> extractCities() throws IOException {
        ArrayList<City> allCities = new ArrayList<>();

        AssetManager am = this.getAssets();

        InputStream is = am.open("allcities.txt");
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


    private void getCity(City currentCity){
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

                        JSONArray ar = jobj.getJSONArray("statuses");
                        int  arLen = ar.length();
                        Log.d("statuses size",arLen+"");


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
