package com.fisher.andrew.aroundtheglobe.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fisher.andrew.aroundtheglobe.Constants;

import okhttp3.HttpUrl;

/**
 * Created by andrewfisher on 5/20/17.
 */

public class Photo implements Parcelable {
    private int farm;
    private String server;
    private String photoId;
    private String secretId;



    public Photo(int farm, String server, String photoId, String secretId) {
        this.farm = farm;
        this.server = server;
        this.photoId = photoId;
        this.secretId = secretId;

    }

    protected Photo(Parcel in) {
        farm = in.readInt();
        server = in.readString();
        photoId = in.readString();
        secretId = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getPhotoId() {
        return photoId;
    }

    public void setId(String photoId) {
        this.photoId = photoId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getPhotoUrl(){

        //Base Url: https://farm" + farm +".staticflickr.com
        String baseUrl = Constants.FLICKR_IMAGE_BASE_URL + farm + Constants.FLICKR_IMAGE_URL_DOT_COM;

        // Last Path: photoId+"_"+secretId.jpg";
        String lastPath = photoId + "_" + secretId + Constants.FLICKR_IMAGE_URL_FILE_FORMAT;

        //Builds base url
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl).newBuilder();

        //adds two paths onto the url adding necessities to display the correct image
        urlBuilder.addPathSegment(server).addPathSegment(lastPath);

       String url = urlBuilder.build().toString();

        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(farm);
        parcel.writeString(server);
        parcel.writeString(photoId);
        parcel.writeString(secretId);
    }
}
