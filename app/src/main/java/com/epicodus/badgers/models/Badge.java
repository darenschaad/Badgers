package com.epicodus.badgers.models;

import org.parceler.Parcel;

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
    String index;
    String creator;
    String date;
    int category;
    double latitude;
    double longitude;
    int pushId;
    String tags;
    String challenges;

    public Badge() {}




    public Badge(String name, String imageUrl, String comments, String description, String proof, String index, String creator, String date, int category, double latitude, double longitude, int pushId, String tags, String challenges){
        this.name = name;
        this.imageUrl = imageUrl;
        this.comments = comments;
        this.description = description;
        this.proof = proof;
        this.index = index;
        this.creator = creator;
        this.date = date;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pushId = pushId;
        this.tags = tags;
        this.challenges = challenges;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCategory() { return category; }

    public String getIndex() {
        return index;
    }

    public String getDate() { return date; }

    public String getCreator() { return creator; }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

//    public List<String> getTags() {
//        return tags;
//    }

    public int getPushId() { return pushId; }

    public String getComments() { return comments; }

    public String getDescription() { return description; }

    public String getProof() { return proof; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTags() {
        return tags;
    }

    public String getChallenges() {
        return challenges;
    }
}
