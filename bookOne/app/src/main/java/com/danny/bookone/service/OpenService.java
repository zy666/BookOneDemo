package com.danny.bookone.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class OpenService extends Service {
    public OpenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String data = intent.getStringExtra("key");
        Toast.makeText(OpenService.this, data, Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyBinder extends Binder {
        public void toastData(String string) {
            Toast.makeText(OpenService.this, string, Toast.LENGTH_LONG).show();
        }
    }
}
