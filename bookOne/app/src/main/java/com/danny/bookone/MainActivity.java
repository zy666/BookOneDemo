package com.danny.bookone;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.danny.bookone.databinding.ActivityMainBinding;
import com.danny.bookone.fragment.MainPageViewPager;
import com.danny.bookone.fragment.Test2Fragment;
import com.danny.bookone.fragment.Test3Fragment;
import com.danny.bookone.fragment.BookFragment;
import com.danny.bookone.fragment.ThirdFrameFragment;
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
        stringList.add("four");

        fragments.add(BookFragment.newInstance());
        fragments.add(Test2Fragment.newInstance());
        fragments.add(Test3Fragment.newInstance());
        fragments.add(ThirdFrameFragment.newInstance());

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
                    case R.id.item_bottom_4:
                        mainBinding.viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }
}
