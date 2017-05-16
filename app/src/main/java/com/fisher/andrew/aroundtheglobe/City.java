package com.fisher.andrew.aroundtheglobe;


public class City {
    private double latitude;
    private double longitude;
    private String cityName;
    private String country;

    public City(String lineFromFile){
        String[] splitCityInformation = lineFromFile.split(",");
        latitude = Double.parseDouble(splitCityInformation[0]);
        longitude = Double.parseDouble(splitCityInformation[1]);
        cityName = splitCityInformation[2];
        country = splitCityInformation[3];
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


}