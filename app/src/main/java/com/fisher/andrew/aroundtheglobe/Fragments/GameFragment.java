package com.fisher.andrew.aroundtheglobe.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fisher.andrew.aroundtheglobe.Activities.GameActivity;
import com.fisher.andrew.aroundtheglobe.R;
import com.fisher.andrew.aroundtheglobe.models.City;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.answer_a)
    Button mAnswerABtn;
    @Bind(R.id.answer_b)
    Button mAnswerBBtn;
    @Bind(R.id.answer_c)
    Button mAnswerCBtn;
    @Bind(R.id.answer_d)
    Button mAnswerDBtn;
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
        mActivity = (GameActivity) getActivity();
        String[] wrongAnswers = wrongCityAnswers();

        mBtnAnswerArray = Arrays.asList(mAnswerABtn, mAnswerBBtn, mAnswerCBtn, mAnswerDBtn);
        Collections.shuffle(mBtnAnswerArray);


        mBtnAnswerArray.get(0).setText(correctCity.getCityName() + ", " + correctCity.getCountry());//correct answer
        mBtnAnswerArray.get(1).setText(wrongAnswers[0]);
        mBtnAnswerArray.get(2).setText(wrongAnswers[1]);
        mBtnAnswerArray.get(3).setText(wrongAnswers[2]);





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

    }
}
