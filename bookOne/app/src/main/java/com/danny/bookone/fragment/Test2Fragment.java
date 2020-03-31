package com.danny.bookone.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danny.bookone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test2Fragment extends Fragment {

    public Test2Fragment() {
        // Required empty public constructor
    }
    public static Test2Fragment newInstance() {
        Test2Fragment fragment = new Test2Fragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test2, container, false);
    }
}
