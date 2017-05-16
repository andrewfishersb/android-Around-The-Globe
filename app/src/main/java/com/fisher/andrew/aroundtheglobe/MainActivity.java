package com.fisher.andrew.aroundtheglobe;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<City> mCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mCities = extractCities();
        }catch (IOException e){
           Log.d("Error","File not found");
        }

        for (int i = 0; i < mCities.size();i++){
            Log.d(mCities.get(i).getCityName(),mCities.get(i).getCountry());
        }
    }



    private ArrayList<City> extractCities() throws IOException {
        ArrayList<City> allCities = new ArrayList<>();

        AssetManager am = this.getAssets();

        InputStream is = am.open("cities.txt");
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










//
//        //sets text file name to a variable
//        String fileName = "cities.txt";
//
//        //will contain one line at a time
//        String line = null;
//
//        //Could I in principle put this all in a different method
//        try{
//            // reads file in default encoding
//            FileReader fileReader = new FileReader(fileName);
//
//            //Wrap filereader in BufferedReader
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            //Read through every line
//            while((line= bufferedReader.readLine())!=null){
//                //Create a city object for every line
//                allCities.add(new City(line));
//            }
//
//            bufferedReader.close();
//
//
//        }catch(FileNotFoundException ex) {
//            Log.d("Error","Unable to open file" + fileName);
//            ex.printStackTrace();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                            + fileName + "'");
//        }

        return allCities;
    }
}
