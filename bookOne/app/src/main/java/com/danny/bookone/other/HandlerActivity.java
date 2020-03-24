package com.danny.bookone.other;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityHandlerBinding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHandlerBinding handlerBinding;
    private MyHandler myHandler;
    private static final int FILE_SIZE = 0;
    private static final int DOWNLOAD_PROGRESS = 1;
    private static final int DOWNLOAD_SUCCESS = 2;
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private String downLoadUrl = "https://ww1.sinaimg.cn/mw690/8f0b8983gy1gcum0n2g5tj21yu2jou0z.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlerBinding = DataBindingUtil.setContentView(this, R.layout.activity_handler);
        myHandler = new MyHandler();
        handlerBinding.button2.setOnClickListener(this);
        handlerBinding.button.setOnClickListener(this);
        handlerBinding.btnDown.setOnClickListener(this);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, HandlerActivity.class);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                new FuckTianyiAsyncTask(this).execute(downLoadUrl);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_down:
                handlerBinding.ivDown.setImageURI(null);
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    if (ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
                    } else {
                        new FuckTianyiAsyncTask(this).execute(downLoadUrl);
                    }
                }

                break;
            case R.id.button2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = myHandler.obtainMessage();
                        message.what = 2;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.button:
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
                break;
        }
    }


    static class FuckTianyiAsyncTask extends AsyncTask<String, Integer, Integer> {
        private HandlerActivity activity;

        public FuckTianyiAsyncTask(HandlerActivity activity) {
            this.activity = activity;
        }

        @Override
        protected Integer doInBackground(String... params) {
            //完成下载任务
            try {
                String s = params[0];//这里是从Excute方法中传过来的参数，即下载地址
                URL url = new URL(s);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                int size = conn.getContentLength();//获取到最大值后，设置到进度条的max
                publishProgress(FILE_SIZE, size);
                //开始下载
                byte[] bytes = new byte[10];//方便测试故意设置较小
                int len = -1;
                InputStream in = conn.getInputStream();
                FileOutputStream out = new FileOutputStream(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOWNLOADS).getPath() + "chutian.jpg");
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    publishProgress(DOWNLOAD_PROGRESS, len);
                    out.flush();
                }
                out.close();
                in.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return DOWNLOAD_SUCCESS;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            activity.handlerBinding.progressBar.setProgress(0);
        }

        /**
         * 更新执行状态onProgressUpdate这个行为，
         * AsyncTask里面默认是不调用的，
         * 需要我们手动在doInBackground方法里面调用publishProgress方法，
         * 这样我们的AsyncTask才会执行onProgressUpdate方法。
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            switch (values[0]) {
                case FILE_SIZE:
                    activity.handlerBinding.progressBar.setMax(values[1]);
                    break;
                case DOWNLOAD_PROGRESS:
                    activity.handlerBinding.progressBar.incrementProgressBy(values[1]);
                    break;
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (integer == DOWNLOAD_SUCCESS) {
                activity.handlerBinding.ivDown.setImageURI(
                        Uri.parse(Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DOWNLOADS).getPath() + "chutian.jpg"));

            }
        }
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
