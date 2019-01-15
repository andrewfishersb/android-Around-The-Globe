package com.fisher.andrew.aroundtheglobe.AdaptersOld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.fisher.andrew.aroundtheglobe.FlickrAsyncTask;
import com.fisher.andrew.aroundtheglobe.Fragments.GameFragment;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by andrewfisher on 4/28/18.
 */

public class GameScreenPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<City> mCityAnswers;
    private int rounds = 3;

    public GameScreenPagerAdapter(FragmentManager fragmentManager, ArrayList<City> cityAnswers){
        super(fragmentManager);
        mCityAnswers = cityAnswers;
    }

    @Override
    public Fragment getItem(int position) {
//todo maybe here or elsewhere generate wrong answers to pass
        City currentCity = mCityAnswers.get(position);
        try {
            Log.d("CityCheck","In Game Pager");

            new FlickrAsyncTask().execute(currentCity).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        switch (position){
            case 0:
                return GameFragment.newInstance(currentCity);//todo add position to determine the round
            case 1:
                return GameFragment.newInstance(currentCity);//todo add position to determine the round
            case 2:
                return GameFragment.newInstance(currentCity);//todo add position to determine the round
        }

        return null;

    }

    @Override
    public int getCount() {
        return rounds;
    }
}
