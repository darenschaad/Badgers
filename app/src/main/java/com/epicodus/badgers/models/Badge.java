package com.epicodus.badgers.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daren on 9/23/2016.
 */

@Parcel
public class Badge {
    String name;
    String imageUrl;
    String comments;
    String description;
    String proof;
    double index;
    int category;
    double latitude;
    double longitude;
    double pushId;
//    List<String> tags = new ArrayList<>();

    public Badge() {}

    public Badge(String name, String imageUrl, String comments, String description, String proof,double index, int category, double latitude, double longitude, double pushId){
        this.name = name;
        this.imageUrl = imageUrl;
        this.comments = comments;
        this.description = description;
        this.proof = proof;
        this.index = index;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pushId = pushId;
//        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCategory() { return category; }

    public double getIndex() {
        return index;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

//    public List<String> getTags() {
//        return tags;
//    }

    public double getPushId() { return pushId; }

    public String getComments() { return comments; }

    public String getDescription() { return description; }

    public String getProof() { return proof; }
}
