package com.fisher.andrew.aroundtheglobe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fisher.andrew.aroundtheglobe.models.City;
import com.fisher.andrew.aroundtheglobe.models.Photo;

import java.util.List;


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

        List<Photo> listOfPhotos = mCity.getPhotos();
        switch (position){
            case 0:
                return ImageFragment.newInstance(0,listOfPhotos.get(0));
            case 1:
                return ImageFragment.newInstance(1,listOfPhotos.get(1));
            case 2:
                return ImageFragment.newInstance(2,listOfPhotos.get(2));
            case 3:
                return ImageFragment.newInstance(3,listOfPhotos.get(3));
            case 4:
                return ImageFragment.newInstance(4,listOfPhotos.get(4));
            case 5:
                return ImageFragment.newInstance(5,listOfPhotos.get(5));
            case 6:
                return ImageFragment.newInstance(6,listOfPhotos.get(6));
            case 7:
                return ImageFragment.newInstance(7,listOfPhotos.get(7));
            case 8:
                return ImageFragment.newInstance(8,listOfPhotos.get(8));
            case 9:
                return ImageFragment.newInstance(9,listOfPhotos.get(9));
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
