package com.danny.bookone.github;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityPathBinding;

public class PathActivity extends AppCompatActivity {
    private ActivityPathBinding pathBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pathBinding = DataBindingUtil.setContentView(this, R.layout.activity_path);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, PathActivity.class);
    }
}
