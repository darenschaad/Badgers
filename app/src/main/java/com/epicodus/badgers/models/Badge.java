package com.epicodus.badgers.models;

import java.util.ArrayList;

/**
 * Created by Daren on 9/23/2016.
 */

public class Badge {
    private String mName;
    private String mImage;
    private double mIndex;
    private double mLatitude;
    private double mLongitude;
    private double mRating;
    private ArrayList<String> mTags;



    public Badge(String name, String image, double index, double latitude, double longitude, double rating, ArrayList<String> tags){
        this.mName = name;
        this.mImage = image;
        this.mIndex = index;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mRating = rating;
        this.mTags = tags;
    }

    public String getName() {
        return mName;
    }

    public String getImage() {
        return mImage;
    }

    public double getIndex() {
        return mIndex;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getRating() {
        return mRating;
    }

    public ArrayList<String> getTags() {
        return mTags;
    }
}
