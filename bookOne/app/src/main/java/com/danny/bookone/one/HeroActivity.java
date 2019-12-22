package com.danny.bookone.one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityHeroBinding;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 《android群英传》
 */
public class HeroActivity extends AppCompatActivity {
    private ActivityHeroBinding heroBinding;
    private MyHandler myHandler;
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
        myHandler = new MyHandler(this);
        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        StringAdapter adapter = new StringAdapter(stringList);
        heroBinding.rcvData.setLayoutManager(new LinearLayoutManager(this));
        heroBinding.rcvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        heroBinding.rcvData.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
//                        startActivity(ChapterSevenActivity.createIntent(HeroActivity.this));
                        Message message = new Message();
                        message.what = 2;
                        myHandler.sendEmptyMessage(message.what);
                        break;
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

    public String getMethodOne() {
        return "getMethodOne";
    }

    public String getMethodTwo(String str) {
        return "getMethodTwo:" + str;
    }

    public static class MyHandler extends Handler {

        HeroActivity activity;

        public MyHandler(HeroActivity activity) {
            this.activity = new WeakReference<>(activity).get();
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    String data = activity.getMethodOne();
                    Toast.makeText(activity, data, Toast.LENGTH_LONG).show();
                    break;

                case 2:
                    String datad = activity.getMethodTwo("我是方法2");
                    Toast.makeText(activity, datad, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
