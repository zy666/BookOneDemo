package com.danny.bookone.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danny.bookone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test3Fragment extends BaseFragment {

    public Test3Fragment() {
        // Required empty public constructor
    }

    public static Test3Fragment newInstance() {
        Test3Fragment fragment = new Test3Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test3, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("Test3", isVisibleToUser + "");
    }


    @Override
    protected void onLazyData() {
        Log.e("Test3-->", "onLazyData");

    }
}
