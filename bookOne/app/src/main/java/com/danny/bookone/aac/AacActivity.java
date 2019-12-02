package com.danny.bookone.aac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.danny.bookone.R;
import com.danny.bookone.two.HighLightActivity;

public class AacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aac);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, AacActivity.class);
    }

}
