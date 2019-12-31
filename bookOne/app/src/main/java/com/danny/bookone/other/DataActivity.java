package com.danny.bookone.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityDataBinding;

public class DataActivity extends AppCompatActivity {
    private ActivityDataBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, DataActivity.class);
    }

    public void clickPosition(View view) {
        switch (view.getId()) {
            case R.id.button3:

                break;

        }
    }
}
