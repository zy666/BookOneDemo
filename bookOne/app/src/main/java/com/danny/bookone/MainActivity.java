package com.danny.bookone;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.aac.AacActivity;
import com.danny.bookone.databinding.ActivityMainBinding;
import com.danny.bookone.fragment.MainPageViewPager;
import com.danny.bookone.fragment.Test2Fragment;
import com.danny.bookone.fragment.Test3Fragment;
import com.danny.bookone.fragment.TestFragment;
import com.danny.bookone.highLight.HighLightActivity;
import com.danny.bookone.img.GlideImgActivity;
import com.danny.bookone.one.HandlerActivity;
import com.danny.bookone.one.HeroActivity;
import com.danny.bookone.other.CompanyActivity;
import com.danny.bookone.other.DataActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    MainPageViewPager mainPageViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Fragment> fragments = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        fragments.add(TestFragment.newInstance());
        fragments.add(Test2Fragment.newInstance());
        fragments.add(Test3Fragment.newInstance());
        mainPageViewPager = new MainPageViewPager(getSupportFragmentManager(), fragments);
        mainPageViewPager.setTitle(stringList);
        mainBinding.viewPager.setAdapter(mainPageViewPager);
        mainBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mainBinding.bottomNav.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mainBinding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_bottom_1:
                        mainBinding.viewPager.setCurrentItem(0);
                        break;
                    case R.id.item_bottom_2:
                        mainBinding.viewPager.setCurrentItem(1);
                        break;
                    case R.id.item_bottom_3:
                        mainBinding.viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }
}
