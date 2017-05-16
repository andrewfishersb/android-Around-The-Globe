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
    public static void findCityImages(Callback callback){

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.TWITTER_CONSUMER_KEY,Constants.TWITTER_CONSUMER_SECRET);

        consumer.setTokenWithSecret(Constants.TWITTER_TOKEN,Constants.TWITTER_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new SigningInterceptor(consumer)).build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TWITTER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.TWITTER_GEOCODE_QUERY_PARAMETER,"45.511102,-122.689507,10mi");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
