package com.example.hp.facebook.model;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.annotations.SerializedName;




public class FacebookPhotosModel {
    @SerializedName("data")
    List<FacebookPhotoModel> model = new ArrayList<>();

    public List<FacebookPhotoModel> getModel() {
        return model;
    }

    public void setModel(List<FacebookPhotoModel> model) {
        this.model = model;
    }
}