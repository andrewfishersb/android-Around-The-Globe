package com.fisher.andrew.aroundtheglobe.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class City implements Parcelable{
    private double latitude;
    private double longitude;
    private int population;
    private String cityName;
    private String country;
    private String region;
    private String continent;
    private ArrayList<Photo> mPhotos;
//todo maybe add an ID

    public City(String lineFromFile){
        String[] splitCityInformation = lineFromFile.split(",");
        latitude = Double.parseDouble(splitCityInformation[0]);
        longitude = Double.parseDouble(splitCityInformation[1]);
        population = Integer.parseInt(splitCityInformation[2]);
        cityName = splitCityInformation[3];
        country = splitCityInformation[4];
        region = splitCityInformation[5];
        continent = splitCityInformation[6];
        mPhotos = new ArrayList<>();
    }

    protected City(Parcel in) {
        //may need to check this line of code now that i am trying to use an array list
        //in.readParcelableArray()???
//        mPhotos = in.readParcelable(Photo.class.getClassLoader());
        mPhotos = in.createTypedArrayList(Photo.CREATOR);
        latitude = in.readDouble();
        longitude = in.readDouble();
        population = in.readInt();
        cityName = in.readString();
        country = in.readString();
        region = in.readString();
        continent = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public List<Photo> getPhotos(){
        return mPhotos;
    }

    public void addPhoto(Photo photo){
        mPhotos.add(photo);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

//        parcel.writeParcelable((Parcelable) mPhotos,i);
        parcel.writeTypedList(mPhotos);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeInt(population);
        parcel.writeString(cityName);
        parcel.writeString(country);
        parcel.writeString(region);
        parcel.writeString(continent);
    }


}