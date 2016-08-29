package com.example.hp.facebook.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.facebook.R;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PhotoShareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PhotoShareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoShareFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private CallbackManager callbackManager;
    private LoginManager loginManager;

    public PhotoShareFragment() {
        // Required empty public constructor
    }


    public static PhotoShareFragment newInstance(String param1, String param2) {
        PhotoShareFragment fragment = new PhotoShareFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_photo_share, container, false);



        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}