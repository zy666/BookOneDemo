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
import com.danny.bookone.aac.AacActivity;
import com.danny.bookone.databinding.FragmentHeroBinding;
import com.danny.bookone.highLight.HighLightActivity;
import com.danny.bookone.img.GlideImgActivity;
import com.danny.bookone.one.HandlerActivity;
import com.danny.bookone.one.HeroActivity;
import com.danny.bookone.one.OneActivity;
import com.danny.bookone.one.ThreeActivity;
import com.danny.bookone.other.CompanyActivity;
import com.danny.bookone.other.DataActivity;

import java.util.ArrayList;
import java.util.List;

public class HeroFragment extends BaseFragment {
    private FragmentHeroBinding heroBinding;
    private StringAdapter adapter;

    public HeroFragment() {
        // Required empty public constructor
    }

    public static HeroFragment newInstance() {
        HeroFragment fragment = new HeroFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        heroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hero, container, false);
        return heroBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("HeroFragment-->", "onViewCreated");
        List<String> arraylist = new ArrayList<>();
        arraylist.add("第一章-体系与系统架构");
        arraylist.add("第二章-开发工具");
        arraylist.add("第三章-架构控件与自定义控件详解");
        arraylist.add("第四章");
        arraylist.add("第五章");
        arraylist.add("第六章");
        arraylist.add("第七章-Android动画机制与使用技巧");
        arraylist.add("第八章");
        arraylist.add("第九章");
        arraylist.add("第十章");
        arraylist.add("第十一章");
        arraylist.add("第十二章");
        arraylist.add("第十三章");
        adapter = new StringAdapter(arraylist);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(OneActivity.Companion.createIntent(getActivity()));
                        break;
                    case 1:
                        Toast.makeText(getActivity(), "暂无重点，先跳过", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        startActivity(ThreeActivity.Companion.createIntent(getActivity()));//Jetpack架构篇
                        break;
                    case 6:
                        startActivity(GlideImgActivity.createIntent(getActivity()));//android基础组件篇。服务，广播，activity
                        break;
                }
            }
        });

        heroBinding.rcvData.setLayoutManager(new LinearLayoutManager(getActivity()));
        heroBinding.rcvData.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        heroBinding.rcvData.setAdapter(adapter);
    }

    @Override
    protected void onLazyData() {
        initData();
        Log.e("HeroFragment-->", "onLazyData");
    }

    private void initData() {
        Log.e("HeroFragment-->", "initData");


    }
}
