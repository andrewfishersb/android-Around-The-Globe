package com.fisher.andrew.aroundtheglobe.Services;


import com.fisher.andrew.aroundtheglobe.Utils.Constants;
import com.fisher.andrew.aroundtheglobe.models.City;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class FlickrService {

    public static void findCityImages(City city, Callback callback){
        OkHttpClient client = new OkHttpClient();



        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.FLICKR_BASE_URL).newBuilder();
        urlBuilder
                .addQueryParameter(Constants.FLICKR_API_KEY_RECEIVER,Constants.FLICKR_API_KEY)
                .addQueryParameter(Constants.FLICKR_METHOD_QUERY_PARAMETER,Constants.FLICKR_SEARCH_METHOD_QUERY_PARAMETER)
                .addQueryParameter(Constants.FLICKR_PRIVACY_FILTER_QUERY_PARAMETER,Constants.FLICKR_PRIVACY_SCOPE)
                .addQueryParameter(Constants.FLICKR_LATITUDE_QUERY_PARAMETER,Double.toString(city.getLatitude()))
                .addQueryParameter(Constants.FLICKR_LONGITUDE_QUERY_PARAMETER,Double.toString(city.getLongitude()))
                .addQueryParameter(Constants.FLICKR_DISTANCE_QUERY_PARAMETER,Constants.FLICKR_DISTANCE_TYPE)
                .addQueryParameter(Constants.FLICKR_FORMAT_PARAMETER,Constants.FLICKR_FORMAT_TYPE)
                .addQueryParameter(Constants.FLICKR_PER_PAGE_QUERY,Constants.FLICKR_IMAGES_PER_PAGE)
                .addQueryParameter(Constants.FLICKR_PAGE_QUERY,Constants.FLICKR_NUMBER_OF_PAGES)
                .addQueryParameter(Constants.FLICKR_MEDIA_TYPE_QUERY,Constants.FLICKR_MEDIA_TYPE)
                .addQueryParameter(Constants.FLICKR_CONTENT_TYPE_QUERY,Constants.FLICKR_CONTENT_TYPE)
                .addQueryParameter(Constants.FLICKR_SORT_TYPE_QUERY, Constants.FLICK_SORT_POPULAR)
                .addQueryParameter(Constants.FLICKR_RETURN_JSON_QUERY,Constants.FLICKR_RETURN_JSON_TYPE);


        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);

        call.enqueue(callback);

    }

}
