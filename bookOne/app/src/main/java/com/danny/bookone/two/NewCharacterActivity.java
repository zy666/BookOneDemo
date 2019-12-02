package com.danny.bookone.two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.danny.bookone.R;
import com.danny.bookone.adatper.LightAdapter;
import com.danny.bookone.databinding.ActivityNewCharacterBinding;

import java.util.ArrayList;
import java.util.List;

public class NewCharacterActivity extends AppCompatActivity {
    ActivityNewCharacterBinding newCharacterBinding;
    private LightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newCharacterBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_character);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("第" + i + "条数据");
        }
        adapter = new LightAdapter(list, this);
        newCharacterBinding.rcvNew.setLayoutManager(new LinearLayoutManager(this));
//        newCharacterBinding.rcvNew.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            decoration.setDrawable(getDrawable(R.drawable.item_shape));
        }
        newCharacterBinding.rcvNew.addItemDecoration(decoration);
        newCharacterBinding.rcvNew.setAdapter(adapter);
    }


    public static Intent createIntent(Context context) {
        return new Intent(context, NewCharacterActivity.class);
    }
}
