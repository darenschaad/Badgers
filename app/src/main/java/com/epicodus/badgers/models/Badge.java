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
    String index;
    List<String> address = new ArrayList<>();
    double latitude;
    double longitude;
    double rating;
    List<String> tags = new ArrayList<>();

    public Badge() {}

    public Badge(String name, String imageUrl, String index, ArrayList<String> address, double latitude, double longitude, double rating, ArrayList<String> tags){
        this.name = name;
        this.imageUrl = imageUrl;
        this.index = index;
        this.address = address;
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

    public List<String> getAddress() { return address; }

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
