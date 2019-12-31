package com.danny.bookone.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityDataBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataActivity extends AppCompatActivity {
    private ActivityDataBinding dataBinding;
    Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        initData();
    }

    private void initData() {
        map = new HashMap<>();
        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("梁山伯", "祝英台");
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, DataActivity.class);
    }

    public void clickPosition(View view) {
        switch (view.getId()) {
            case R.id.button3:
                Set<String> keys = map.keySet();
                StringBuffer buffer = new StringBuffer();
                for (String s : keys) {
                    buffer.append("key:" + s).append("\n");
//                    buffer.append("value:" + map.get(s)).append("\n");
                }
                dataBinding.textView4.setText(buffer.toString());
                break;

            case R.id.button8:
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                StringBuffer buffer2 = new StringBuffer();
                for (Map.Entry<String, String> item : entrySet) {
                    buffer2.append("key:").append(item.getKey()).append("\n")
                            .append("value:").append(item.getValue());
                }
                dataBinding.textView4.setText(buffer2.toString());
                break;

        }
    }
}
