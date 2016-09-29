package com.epicodus.badgers.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daren on 9/23/2016.
 */

public class Badge {
    String name;
    String imageUrl;
    String index;
    double latitude;
    double longitude;
    double rating;
    List<String> tags = new ArrayList<>();

    public Badge() {}

    public Badge(String name, String imageUrl, String index, double latitude, double longitude, double rating, ArrayList<String> tags){
        this.name = name;
        this.imageUrl = imageUrl;
        this.index = index;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getIndex() {
        return index;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getTags() {
        return tags;
    }
}
