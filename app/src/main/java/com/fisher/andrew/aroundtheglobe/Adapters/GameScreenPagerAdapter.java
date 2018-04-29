package com.fisher.andrew.aroundtheglobe.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fisher.andrew.aroundtheglobe.Fragments.GameFragment;

/**
 * Created by andrewfisher on 4/28/18.
 */

public class GameScreenPagerAdapter extends FragmentPagerAdapter{

    int rounds = 3;

    public GameScreenPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        return GameFragment.newInstance();//todo add position to determine the round

    }

    @Override
    public int getCount() {
        return rounds;
    }
}
