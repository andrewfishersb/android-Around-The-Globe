package com.fisher.andrew.aroundtheglobe.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fisher.andrew.aroundtheglobe.Fragments.GameFragment;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.util.ArrayList;

/**
 * Created by andrewfisher on 4/28/18.
 */

public class GameScreenPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<City> mCityAnswers;
    int rounds = 3;

    public GameScreenPagerAdapter(FragmentManager fragmentManager, ArrayList<City> cityAnswers){
        super(fragmentManager);
        mCityAnswers = cityAnswers;
    }

    @Override
    public Fragment getItem(int position) {
//todo maybe here or elsewhere generate wrong answers to pass
        return GameFragment.newInstance(mCityAnswers.get(position));//todo add position to determine the round

    }

    @Override
    public int getCount() {
        return rounds;
    }
}
