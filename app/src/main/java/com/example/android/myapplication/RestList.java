package com.example.android.myapplication;

/**
 * Created by Sanz on 10/09/2017.
 */

public class RestList {
    public String name;
    public double latitude;
    public double longitude;


    public RestList(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
