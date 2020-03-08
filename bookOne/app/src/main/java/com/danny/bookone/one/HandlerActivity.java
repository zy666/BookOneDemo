package com.danny.bookone.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.widget.Toast;

import com.danny.bookone.R;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander);

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

    public static Intent createIntent(Context context) {
        return new Intent(context, HandlerActivity.class);
    }

    public class MyRunnable implements Runnable {

        @Override
        public void run() {
            Toast.makeText(HandlerActivity.this,"子线程的土司",Toast.LENGTH_LONG).show();
        }
    }

    public class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
