package com.danny.bookone.github;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.danny.bookone.Base.StringAdapter;
import com.danny.bookone.R;
import com.danny.bookone.aac.AacActivity;
import com.danny.bookone.databinding.ActivityViewBinding;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding viewBinding;
    StringAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_view);
        adapter = new StringAdapter(Arrays.asList(getResources().getStringArray(R.array.draw)));
        viewBinding.basicRecycler.setLayoutManager(new LinearLayoutManager(this));
        viewBinding.basicRecycler.setAdapter(adapter);
        viewBinding.basicRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(DrawActivity.createIntent(ViewActivity.this));
                        break;
                }
            }
        });
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ViewActivity.class);
    }
}
