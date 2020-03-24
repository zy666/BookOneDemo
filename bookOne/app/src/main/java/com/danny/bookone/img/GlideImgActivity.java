package com.danny.bookone.img;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.danny.bookone.R;
import com.danny.bookone.other.CompanyActivity;

public class GlideImgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_img);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, GlideImgActivity.class);
    }
}
