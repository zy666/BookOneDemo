package com.danny.bookone.highLight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityNetworkBinding;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityNetworkBinding networkBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        networkBinding = DataBindingUtil.setContentView(this, R.layout.activity_network);
        networkBinding.login.setOnClickListener(this);
        networkBinding.logout.setOnClickListener(this);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, NetworkActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Log.e("网络请求返回：", "网络请求返回");

//                Request.Builder builder = new Request.Builder().url("http://test.api.uzh.cn/site/user-login");
                Request.Builder builder = new Request.Builder().url("http://test.api.uzh.cn/site/versions");
                Request request = builder.build();
                builder.method("GET", null);
                OkHttpClient okHttpClient = new OkHttpClient();
                final Call call = okHttpClient.newCall(request);
                try {
                    call.execute();
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.e("网络请求返回：", response.body().toString());
                            networkBinding.showInfo.setText(response.body().toString());
                        }
                    });
//
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.logout:
                break;
        }
    }
}
