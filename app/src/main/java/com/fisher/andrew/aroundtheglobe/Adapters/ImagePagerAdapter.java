package com.fisher.andrew.aroundtheglobe.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.fisher.andrew.aroundtheglobe.Fragments.ImageFragment;
import com.fisher.andrew.aroundtheglobe.models.Photo;

import java.util.List;


public class ImagePagerAdapter extends FragmentPagerAdapter{

//    City mCity;
    List<Photo> mPhotoList;
    private static int NUM_ITEMS = 10;

//    public ImagePagerAdapter(FragmentManager fragmentManager, City city) {
public ImagePagerAdapter(FragmentManager fragmentManager, List<Photo> photoList) {

    super(fragmentManager);
    mPhotoList = photoList;
    Log.d("Check","Got here " + mPhotoList.get(0).getPhotoUrl());

}

    //returns correct fragment
    @Override
    public Fragment getItem(int position) {

                        Log.d("Check","Got here " + mPhotoList.get(position).getPhotoUrl());


//        List<Photo> listOfPhotos = mCity.getPhotos();
        switch (position){
            case 0:
//                Log.d("Check","Got here " + mCity.getCityName() + " " + mPhotoList.size());

                return ImageFragment.newInstance(0,mPhotoList.get(0));
            case 1:
                return ImageFragment.newInstance(1,mPhotoList.get(1));
            case 2:
                return ImageFragment.newInstance(2,mPhotoList.get(2));
            case 3:
                return ImageFragment.newInstance(3,mPhotoList.get(3));
            case 4:
                return ImageFragment.newInstance(4,mPhotoList.get(4));
            case 5:
                return ImageFragment.newInstance(5,mPhotoList.get(5));
            case 6:
                return ImageFragment.newInstance(6,mPhotoList.get(6));
            case 7:
                return ImageFragment.newInstance(7,mPhotoList.get(7));
            case 8:
                return ImageFragment.newInstance(8,mPhotoList.get(8));
            case 9:
                return ImageFragment.newInstance(9,mPhotoList.get(9));
        }
        Log.d("Check","But also here");
        return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
