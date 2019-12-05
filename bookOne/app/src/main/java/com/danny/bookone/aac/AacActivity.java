package com.danny.bookone.aac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityAacBinding;
import com.danny.bookone.two.HighLightActivity;

import java.util.logging.Logger;

public class AacActivity extends AppCompatActivity {
    private ActivityAacBinding aacBinding;
    MutableLiveData<String> liveData = new MutableLiveData<>();
    StringBuffer buffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aacBinding = DataBindingUtil.setContentView(this, R.layout.activity_aac);
        aacBinding.btnLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveData.postValue("发送了livedata");
            }
        });
        getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResume() {
                Log.e("aac", "getLifecycle--onResume");
            }
        });

        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("aac", "liveData--收到了发送的值" + s);
                buffer.append(s).append("\n");
                aacBinding.tvData.setText(buffer.toString());

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aac", "AacActivity--onResume");
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, AacActivity.class);
    }

}
