package com.fisher.andrew.aroundtheglobe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fisher.andrew.aroundtheglobe.models.City;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {
    private int page;
    private City mCity;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(int page, City city){
        ImageFragment fragmentImage = new ImageFragment();
        Bundle args = new Bundle();

        args.putInt("page",page);
        fragmentImage.mCity = city;
        fragmentImage.setArguments(args);
        return fragmentImage;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("page",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_image, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.city_image_view);


switch (page){
    case 0:
        Picasso.with(getContext()).load(mCity.getPhotos().get(0).getPhotoUrl()).into(img);

}



        return view;
    }

}
