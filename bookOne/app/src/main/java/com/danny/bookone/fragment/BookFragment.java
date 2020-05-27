package com.danny.bookone.fragment;

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
import com.danny.bookone.aac.AacActivity;
import com.danny.bookone.databinding.FragmentBookBinding;
import com.danny.bookone.highLight.HighLightActivity;
import com.danny.bookone.img.GlideImgActivity;
import com.danny.bookone.one.HandlerActivity;
import com.danny.bookone.one.HeroActivity;
import com.danny.bookone.other.CompanyActivity;
import com.danny.bookone.other.DataActivity;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends BaseFragment {
    private List<String> arraylist = new ArrayList<>();
    private FragmentBookBinding bookBinding;
    private ArrayList<Fragment> mFragments;

    public BookFragment() {
        // Required empty public constructor
    }

    public static BookFragment newInstance() {
        BookFragment fragment = new BookFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bookBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false);
        return bookBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        StringAdapter adapter = new StringAdapter(arraylist);
//        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (position) {
//                    case 0:
//                        startActivity(HeroActivity.Companion.createIntent(getActivity()));//Android群英传
//                        break;
//                    case 1:
//                        startActivity(HighLightActivity.createIntent(getActivity()));//android进阶之光
//                        break;
//                    case 2:
//                        startActivity(AacActivity.createIntent(getActivity()));//Jetpack架构篇
//                        break;
//                    case 3:
//                        startActivity(HandlerActivity.createIntent(getActivity()));//handler线程篇
//                        break;
//                    case 4:
//                        startActivity(DataActivity.createIntent(getActivity()));//数据结构篇。hashMap
//                        break;
//                    case 5:
//                        startActivity(CompanyActivity.createIntent(getActivity()));//android基础组件篇。服务，广播，activity
//                        break;
//                    case 6:
//                        startActivity(GlideImgActivity.createIntent(getActivity()));//android基础组件篇。服务，广播，activity
//                        break;
//                }
//            }
//        });
//
//
//        bookBinding.rcvChapter.setLayoutManager(new LinearLayoutManager(getActivity()));
//        bookBinding.rcvChapter.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//        bookBinding.rcvChapter.setAdapter(adapter);
        mFragments = new ArrayList<>();
        mFragments.add(new HeroFragment());
        mFragments.add(new HeroFragment());
        bookBinding.tabLayout.setViewPager(bookBinding.bookViewPager, new String[]{"Android群英传", "Android进阶之光"}, getActivity(), mFragments);

    }

    @Override
    protected void onLazyData() {
        initData();
        Log.e("Test-->", "onLazyData");
    }

    private void initData() {
        arraylist.add("Android群英传");
        arraylist.add("Android进阶之光");
        arraylist.add("AAC系列");
        arraylist.add("handler原理解析");
        arraylist.add("java数据结构");
        arraylist.add("Android四大组件");
        arraylist.add("glide图片加载框架设计");
    }
}