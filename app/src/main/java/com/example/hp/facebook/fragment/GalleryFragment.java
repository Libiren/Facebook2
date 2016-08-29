package com.example.hp.facebook.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.facebook.R;
import com.example.hp.facebook.adapter.PhotoAdapter;
import com.example.hp.facebook.model.FacebookPhotosModel;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.hawk.Hawk;


public class GalleryFragment extends Fragment {

    public GalleryFragment() {
    }

    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        String id = getActivity().getIntent().getStringExtra("token");
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + Hawk.get("id") + "/photos",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        String object = response.getJSONObject().toString();
                        JsonParser parser = new JsonParser();
                        Gson gson = new Gson();
                        JsonElement mJson = parser.parse(object);
                        FacebookPhotosModel model = gson.fromJson(mJson, FacebookPhotosModel.class);
                        configureList(model, view);
                    }

                }
        ).executeAsync();
        return view;

    }
    private void configureList(FacebookPhotosModel model, View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 3);

        recyclerView.setLayoutManager(layoutManager);
        PhotoAdapter adapter = new PhotoAdapter(model.getModel(), getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
