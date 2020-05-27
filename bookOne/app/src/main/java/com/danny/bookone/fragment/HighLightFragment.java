package com.danny.bookone.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.databinding.FragmentHighLightBinding;
import com.danny.bookone.highLight.HighLightActivity;
import com.danny.bookone.highLight.NetworkActivity;
import com.danny.bookone.highLight.NewCharacterActivity;
import com.danny.bookone.highLight.ViewScrollActivity;
import com.danny.bookone.img.GlideImgActivity;
import com.danny.bookone.one.OneActivity;
import com.danny.bookone.one.ThreeActivity;

import java.util.ArrayList;
import java.util.List;

public class HighLightFragment extends BaseFragment {
    private List<String> arraylist = new ArrayList<>();
    private FragmentHighLightBinding highLightBinding;

    public HighLightFragment() {
        // Required empty public constructor
    }

    public static HighLightFragment newInstance() {
        HighLightFragment fragment = new HighLightFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        highLightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_high_light, container, false);
        return highLightBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
        StringAdapter adapter = new StringAdapter(arraylist);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(NewCharacterActivity.createIntent(getActivity()));
                        break;
                    case 2:
                        startActivity(ViewScrollActivity.createIntent(getActivity()));
                        break;
                    case 4:
                        startActivity(NetworkActivity.createIntent(getActivity()));
                        break;
                }
            }
        });

        highLightBinding.rcvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        highLightBinding.rcvList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        highLightBinding.rcvList.setAdapter(adapter);

    }

    @Override
    protected void onLazyData() {
        initData();
        Log.e("Test-->", "onLazyData");
    }

    private void initData() {
        arraylist.add("第一章--Android新特性");
        arraylist.add("第二章");
        arraylist.add("第三章--view体系与自定义view");
        arraylist.add("第四章");
        arraylist.add("第五章--网络编程与网络框架");
    }
}
