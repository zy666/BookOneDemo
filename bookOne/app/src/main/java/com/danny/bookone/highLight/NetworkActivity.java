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
import com.danny.bookone.api.ApiService;
import com.danny.bookone.api.VersionBean;
import com.danny.bookone.databinding.ActivityNetworkBinding;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;

//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityNetworkBinding networkBinding;
    private String api = "";

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
//                okhttpRequest();
                retrofitRequest();
                break;
            case R.id.logout:
                break;
        }
    }

    private void retrofitRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.api.uzh.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<VersionBean> beanCall = service.getVersion();
        beanCall.enqueue(new Callback<VersionBean>() {
            @Override
            public void onResponse(Call<VersionBean> call, Response<VersionBean> response) {
                Log.e("网络请求返回：onFailure", response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<VersionBean> call, Throwable t) {
                Log.e("网络请求返回：onFailure", t.getMessage());
            }
        });
    }

    private void okhttpRequest() {
//        Request.Builder builder = new Request.Builder().url("http://test.api.uzh.cn/site/versions");
//        Request request = builder.build();
//        builder.method("GET", null);
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Call call = okHttpClient.newCall(request);
////        try {
////            call.execute();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("网络请求返回：onFailure", e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("网络请求返回：onResponse", new Gson().toJson(response.body()));
//            }
//        });
    }
}
