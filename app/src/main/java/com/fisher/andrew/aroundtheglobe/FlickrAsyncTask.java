package com.fisher.andrew.aroundtheglobe;

import android.os.AsyncTask;
import android.util.Log;

import com.fisher.andrew.aroundtheglobe.Utils.Constants;
import com.fisher.andrew.aroundtheglobe.models.City;
import com.fisher.andrew.aroundtheglobe.models.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlickrAsyncTask extends AsyncTask<City, Void, Void> {
     OkHttpClient client = new OkHttpClient();

        @Override
        protected Void doInBackground(City... cities) {
            City city = cities[0];

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


            String cityUrl = urlBuilder.build().toString();

//https://stackoverflow.com/questions/38217201/making-http-request-using-okhttp-library-inside-doinbackground-of-asynctask-bl?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
//https://www.learn2crack.com/2013/10/android-asynctask-json-parsing-example.html
            Request.Builder builder = new Request.Builder();
            builder.url(cityUrl);

            Request request = builder.build();
            try{
                Response response = client.newCall(request).execute();
                String jsonData = response.body().string();
                Log.d("TestJSON","blah");

                try{

                    JSONObject jobj = new JSONObject(jsonData);
                    JSONObject jsonPhotos = jobj.getJSONObject("photos");
                    JSONArray photoArray = jsonPhotos.getJSONArray("photo");

                    for(int i = 0; i < photoArray.length();i++){
                        JSONObject curJsonPhoto = photoArray.getJSONObject(i);


                        String id = curJsonPhoto.getString("id");
                        String secret = curJsonPhoto.getString("secret");
                        String server = curJsonPhoto.getString("server");
                        int farm = curJsonPhoto.getInt("farm");

                        Photo curPhoto = new Photo(farm,server,id,secret);
                        city.addPhoto(curPhoto);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }

    }

