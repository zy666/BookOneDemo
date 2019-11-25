package com.danny.bookone.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityFistCodeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FistCodeActivity extends AppCompatActivity {
    private ActivityFistCodeBinding fistCodeBinding;
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
        fistCodeBinding = DataBindingUtil.setContentView(this, R.layout.activity_fist_code);

        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        StringAdapter adapter = new StringAdapter(stringList);
        fistCodeBinding.rcvData.setLayoutManager(new LinearLayoutManager(this));
        fistCodeBinding.rcvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        fistCodeBinding.rcvData.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 6:
                        startActivity(ChapterSevenActivity.createIntent(FistCodeActivity.this));
                        break;
                }
            }
        });

    }
    public static Intent createIntent(Context context) {
        return new Intent(context, FistCodeActivity.class);
    }

}
