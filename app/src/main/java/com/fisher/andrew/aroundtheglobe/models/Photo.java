package com.fisher.andrew.aroundtheglobe.models;

/**
 * Created by andrewfisher on 5/20/17.
 */

public class Photo {

    private String id;
    private String secretId;
    private String server;
    private int farm;


    public Photo(int farm, String server, String id, String secretId) {
        this.id = id;
        this.secretId = secretId;
        this.server = server;
        this.farm = farm;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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






}
