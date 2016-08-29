package com.example.hp.facebook.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 8/29/2016.
 */
public class FacebookPhotoModel {

    @SerializedName("created_time")
    public String time;
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}