package com.danny.bookone.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.Toast;

import com.danny.bookone.R;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class HandlerActivity extends AppCompatActivity {
    MyAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander);

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        asyncTask = new MyAsyncTask();
        asyncTask.execute();

        MyThread myThread = new MyThread();
        myThread.start();

        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(myCallable);
        try {
            Log.e("callable", (String) future.get());
        } catch (Exception e) {

        }
    }

    public class MyCallable implements Callable {
        @Override
        public String call() throws Exception {
            return "hello callable";
        }
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, HandlerActivity.class);
    }

    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            Log.e("runnable", "hello runnable");
        }
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            Log.e("MyThread", "hello MyThread");
        }
    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }
    }

}
