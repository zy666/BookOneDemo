package com.danny.bookone.github;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityDataBinding;
import com.danny.bookone.databinding.ActivityDrawBinding;

public class DrawActivity extends AppCompatActivity {
    private ActivityDrawBinding drawBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawBinding = DataBindingUtil.setContentView(this, R.layout.activity_draw);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, DrawActivity.class);
    }
}
