package com.fisher.andrew.aroundtheglobe;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by andrewfisher on 5/16/17.
 */

public class TwitterService {


    //maybe feed in longitude and latitude
    public static void findCityImages(City city, Callback callback){

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.TWITTER_CONSUMER_KEY,Constants.TWITTER_CONSUMER_SECRET);

        consumer.setTokenWithSecret(Constants.TWITTER_TOKEN,Constants.TWITTER_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new SigningInterceptor(consumer)).build();

        //Create Geocode string (lat,long,radius)
        StringBuilder geocodeStringBuilder = new StringBuilder();
        geocodeStringBuilder.append(city.getLatitude())
                .append(",")
                .append(city.getLongitude())
                .append(",")
                .append(Constants.TWITTER_RADIUS_QUERY_PARAMETER);



        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TWITTER_BASE_URL).newBuilder();
        urlBuilder
                .addQueryParameter(Constants.TWITTER_GEOCODE_QUERY_PARAMETER,geocodeStringBuilder.toString())
                .addQueryParameter(Constants.TWITTER_FILTER_QUERY_PARAMETER,Constants.TWITTER_FILTER_TYPE_QUERY_PARAMETER);
//                .addQueryParameter(Constants.TWITTER_COUNT_QUERY_PARAMETER,Constants.TWITTER_MAX_COUNT_QUERY_PARAMETER);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
