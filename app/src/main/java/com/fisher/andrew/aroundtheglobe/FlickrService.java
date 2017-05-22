package com.fisher.andrew.aroundtheglobe;


import com.fisher.andrew.aroundtheglobe.models.City;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class FlickrService {


    //maybe feed in longitude and latitude
    public static void findCityImages(City city, Callback callback){

//        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.TWITTER_CONSUMER_KEY,Constants.TWITTER_CONSUMER_SECRET);
////
//        consumer.setTokenWithSecret(Constants.TWITTER_TOKEN,Constants.TWITTER_TOKEN_SECRET);
////
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

    //Possibly a new method to find the image url

  /* POSSIBLE IMAGE URL CALL
        String farmId="5";//or something
        String serverId = "4567";//or something
        String imageId = "98afh98sdf";//or something
        String secretId = "0asudfiluhb";//or something

        //Create the base url  "https://farm{farm-id}.staticflickr.com"
        StringBuilder prePathUrl = new StringBuilder().append(Constants.FLICKR_IMAGE_BASE_URL).append(farmId).append(Constants.FLICKR_IMAGE_URL_DOT_COM);

        //Appends the end section of the url "/{id}_{secret}.jpg"
        StringBuilder endOfUrl = new StringBuilder().append(imageId).append("_").append(secretId);
        HttpUrl.Builder imageUrlBuilder = HttpUrl.parse(prePathUrl.toString()).newBuilder();

        //Strings the base url with the corresponding segments
        imageUrlBuilder.addPathSegment(serverId).addPathSegment(endOfUrl.toString());

     */



}
