package com.danny.bookone.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.databinding.FragmentTest2Binding;
import com.danny.bookone.github.ViewActivity;

import java.util.Arrays;
import java.util.Collections;

/**
 * github面试合集
 */
public class Test2Fragment extends BaseFragment {
    private FragmentTest2Binding test2Binding;
    StringAdapter adapter;

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
        test2Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test2, container, false);
        return test2Binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new StringAdapter(Arrays.asList(getResources().getStringArray(R.array.github)));
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(ViewActivity.createIntent(getActivity()));
                        break;
                }
            }
        });
        test2Binding.test2Recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        test2Binding.test2Recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        test2Binding.test2Recycler.setAdapter(adapter);
    }

    @Override
    protected void onLazyData() {
        Log.e("Test2-->", "onLazyData");
    }
}
