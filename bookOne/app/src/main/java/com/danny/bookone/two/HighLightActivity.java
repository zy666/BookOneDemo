package com.danny.bookone.two;

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
import com.danny.bookone.one.ChapterSevenActivity;
import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityHighLightBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighLightActivity extends AppCompatActivity {
    private ActivityHighLightBinding highLightBinding;
    private String[] chapters = {
            "第一章",
            "第二章",
            "第三章--view体系与自定义view",
            "第四章",
            "第五章",
            "第六章",
            "第七章",
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
        highLightBinding = DataBindingUtil.setContentView(this, R.layout.activity_high_light);

        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        StringAdapter adapter = new StringAdapter(stringList);
        highLightBinding.rcvList.setLayoutManager(new LinearLayoutManager(this));
        highLightBinding.rcvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        highLightBinding.rcvList.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 2:
                        startActivity(ChapterSevenActivity.createIntent(HighLightActivity.this));
                        break;
                }
            }
        });
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, HighLightActivity.class);
    }

}
