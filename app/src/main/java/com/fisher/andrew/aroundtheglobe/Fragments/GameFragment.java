package com.fisher.andrew.aroundtheglobe.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fisher.andrew.aroundtheglobe.Activities.GameActivity;
import com.fisher.andrew.aroundtheglobe.FlickrAsyncTask;
import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.adapters.ImageViewAdapter;
import com.fisher.andrew.aroundtheglobe.models.City;
import com.fisher.andrew.aroundtheglobe.models.Photo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.answer_a)
    Button mAnswerABtn;
    @BindView(R.id.answer_b)
    Button mAnswerBBtn;
    @BindView(R.id.answer_c)
    Button mAnswerCBtn;
    @BindView(R.id.answer_d)
    Button mAnswerDBtn;
    @BindView(R.id.rvPhotoView)
    RecyclerView mRvPhotoView;
    private GameActivity mActivity;
    private List<Button> mBtnAnswerArray;

    public GameFragment() {
        // Required empty public constructor
    }

    public static GameFragment newInstance(City city) {
        GameFragment frag = new GameFragment();
        Bundle args = new Bundle();
        args.putParcelable("city",city);
        frag.setArguments(args);
        // will pass data through here in a bundle
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this,v);

        City correctCity = getArguments().getParcelable("city");
        try {
            new FlickrAsyncTask().execute(correctCity).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mActivity = (GameActivity) getActivity();
        String[] wrongAnswers = wrongCityAnswers();

        mBtnAnswerArray = Arrays.asList(mAnswerABtn, mAnswerBBtn, mAnswerCBtn, mAnswerDBtn);
        Collections.shuffle(mBtnAnswerArray);


        mBtnAnswerArray.get(0).setText(correctCity.getCityName() + ", " + correctCity.getCountry());//correct answer
        mBtnAnswerArray.get(1).setText(wrongAnswers[0]);
        mBtnAnswerArray.get(2).setText(wrongAnswers[1]);
        mBtnAnswerArray.get(3).setText(wrongAnswers[2]);


        mBtnAnswerArray.get(0).setOnClickListener(this);
        mBtnAnswerArray.get(1).setOnClickListener(this);
        mBtnAnswerArray.get(2).setOnClickListener(this);
        mBtnAnswerArray.get(3).setOnClickListener(this);


        Log.d("Check","City Photos " + correctCity.getCityName() + " " + correctCity.getPhotos().size()+"");


        List<Photo> cityPhotos = correctCity.getPhotos();
        ImageViewAdapter adapter = new ImageViewAdapter(cityPhotos,getContext());
        mRvPhotoView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRvPhotoView.setLayoutManager(linearLayoutManager);



        return v;
    }

    //doesnt check for repeats or if even a repeat of the correct answer
    public String[] wrongCityAnswers(){
        String [] optionArray = new String[3];

        List<City> cities = mActivity.getCities();

        Random rnd = new Random();
        for(int i = 0; i < 3;i++){
            int index = rnd.nextInt(cities.size());
            City curCity = cities.get(index);
            String cityName = curCity.getCityName();
            String country = curCity.getCountry();
            optionArray[i] = cityName + ", " + country;
        }

        return optionArray;

    }


    @Override
    public void onClick(View view) {

        if(view == mBtnAnswerArray.get(0)){
            mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.answer_btn_correct));
        }else{
            mBtnAnswerArray.get(0).setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.answer_btn_correct));
            view.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.answer_btn_wrong));

        }

        mActivity.incrementCurrentRound();
        int nextRoundIndex = mActivity.getCurrentRound();
        Log.d("IndexCheck",""+nextRoundIndex);
        mActivity.goToNextRound(nextRoundIndex);

//        int incrementPagerIndex = mActivity.getPager().getCurrentItem() + 1;
//        mActivity.getPager().setCurrentItem(incrementPagerIndex);

    }

}
