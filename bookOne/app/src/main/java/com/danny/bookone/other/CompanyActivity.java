package com.danny.bookone.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityCompanyBinding;
import com.danny.bookone.service.OpenService;

public class CompanyActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCompanyBinding companyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        companyBinding = DataBindingUtil.setContentView(this, R.layout.activity_company);
        companyBinding.button4.setOnClickListener(this);
        companyBinding.button5.setOnClickListener(this);
        companyBinding.button6.setOnClickListener(this);
        companyBinding.button7.setOnClickListener(this);
        sendOrderedBroadcast(new Intent(), null);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, CompanyActivity.class);
    }

    private OpenService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (OpenService.MyBinder) service;
            myBinder.toastData("绑定成功后调用binder方法一次");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CompanyActivity.this, OpenService.class);
        intent.putExtra("key", "我是通过startService启动的");
        switch (v.getId()) {
            case R.id.button4://开启
                startService(intent);
                break;
            case R.id.button5://停止
                stopService(intent);
                break;
            case R.id.button6://绑定
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.button7://解绑
                unbindService(connection);
                break;
        }
    }
}
