package com.danny.bookone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.danny.bookone.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
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
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<String> stringList = new ArrayList<>(Arrays.asList(chapters));
        MyAdapter adapter = new MyAdapter(this, stringList);
        mainBinding.rcvChapter.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rcvChapter.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mainBinding.rcvChapter.setAdapter(adapter);
    }

}
