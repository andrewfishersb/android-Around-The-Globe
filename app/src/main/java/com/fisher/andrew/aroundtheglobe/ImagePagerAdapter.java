package com.fisher.andrew.aroundtheglobe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fisher.andrew.aroundtheglobe.models.City;



public class ImagePagerAdapter extends FragmentPagerAdapter{

    City mCity;
    private static int NUM_ITEMS = 10;

    public ImagePagerAdapter(FragmentManager fragmentManager, City city) {
        super(fragmentManager);
        mCity=city;
    }

    //returns correct fragment
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ImageFragment.newInstance(0,mCity);
            case 1:
                return ImageFragment.newInstance(1,mCity);
            case 2:
                return ImageFragment.newInstance(2,mCity);
            case 3:
                return ImageFragment.newInstance(3,mCity);
            case 4:
                return ImageFragment.newInstance(4,mCity);
            case 5:
                return ImageFragment.newInstance(5,mCity);
            case 6:
                return ImageFragment.newInstance(6,mCity);
            case 7:
                return ImageFragment.newInstance(7,mCity);
            case 8:
                return ImageFragment.newInstance(8,mCity);
            case 9:
                return ImageFragment.newInstance(9,mCity);
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
