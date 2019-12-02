package com.danny.bookone.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityHeroBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 《android群英传》
 */
public class HeroActivity extends AppCompatActivity {
    private ActivityHeroBinding heroBinding;
    private String[] chapters = {
            "第一章",
            "第二章",
            "第三章",
            "第四章",
            "第五章",
            "第六章",
            "第七章-Android动画机制与使用技巧",
            "第八章",
            "第九章",
            "第十章",
            "第十一章",
            "第十二章",
            "第十三章"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heroBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero);

        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        StringAdapter adapter = new StringAdapter(stringList);
        heroBinding.rcvData.setLayoutManager(new LinearLayoutManager(this));
        heroBinding.rcvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        heroBinding.rcvData.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 6:
                        startActivity(ChapterSevenActivity.createIntent(HeroActivity.this));
                        break;
                }
            }
        });

    }
    public static Intent createIntent(Context context) {
        return new Intent(context, HeroActivity.class);
    }

}
