package com.fisher.andrew.aroundtheglobe.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.models.Photo;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {
    private int page;
    private Photo mPhoto;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(int page, Photo photo){
        ImageFragment fragmentImage = new ImageFragment();
        Bundle args = new Bundle();

        args.putInt("page",page);
        fragmentImage.mPhoto = photo;
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
        View view =  inflater.inflate(R.layout.fragment_image_slide_page, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.city_image_view);
        Picasso.with(getContext()).load(mPhoto.getPhotoUrl()).resize(300,300).onlyScaleDown().centerCrop().into(img);


        return view;
    }

}
