package com.danny.bookone.other;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class OpenService extends Service {

    public OpenService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String data = intent.getStringExtra("key");
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends Binder {
        public void toastData(String data) {
            Toast.makeText(OpenService.this, data, Toast.LENGTH_LONG).show();
        }
    }

}
