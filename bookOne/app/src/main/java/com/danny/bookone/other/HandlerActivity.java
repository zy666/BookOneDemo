package com.danny.bookone.other;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityHandlerBinding;

public class HandlerActivity extends AppCompatActivity {
    private ActivityHandlerBinding handlerBinding;
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlerBinding = DataBindingUtil.setContentView(this, R.layout.activity_handler);
        myHandler = new MyHandler();
        handlerBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Message message = myHandler.obtainMessage();
                        message.what = 1;
                        myHandler.sendMessage(message);
                        Looper.prepare();
                        Handler handler = new Handler() {
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                            }
                        };

                    }
                }).start();

            }
        });

        handlerBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = myHandler.obtainMessage();
                        message.what = 2;
                        myHandler.sendMessage(message);
                    }
                }).start();

            }
        });
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, HandlerActivity.class);
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    handlerBinding.textView.setText("2");
                    break;
                case 2:
                    handlerBinding.textView.setText(getString(R.string.default_data));
                    break;
            }
        }
    }
}
