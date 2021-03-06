package com.danny.bookone.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPageViewPager extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> title = new ArrayList<>();

    public MainPageViewPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public MainPageViewPager(FragmentManager fm, List<Fragment> fragments, List<String> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size() > 0 ? fragments.size() : 0;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.title.get(position);
    }
}
