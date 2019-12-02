package com.danny.bookone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.databinding.ActivityMainBinding;
import com.danny.bookone.one.HeroActivity;
import com.danny.bookone.two.HighLightActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    private String[] chapters = {
            "Android群英传",
            "Android进阶之光",
            "AAC系列",
    };

//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        StringAdapter adapter = new StringAdapter(stringList);
        mainBinding.rcvChapter.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rcvChapter.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mainBinding.rcvChapter.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(HeroActivity.createIntent(MainActivity.this));
                        break;
                    case 1:
                        startActivity(HighLightActivity.createIntent(MainActivity.this));
                        break;
                    case 2:
                        startActivity(HighLightActivity.createIntent(MainActivity.this));
                        break;
                }
            }
        });

    }

}
