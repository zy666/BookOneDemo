package com.danny.bookone.highLight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyLayoutView extends LinearLayout {
    public MyLayoutView(Context context) {
        super(context, null);
    }

    public MyLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatchTouchEvent", "父类分发");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("onInterceptTouchEvent", "父类拦截了");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("onTouchEvent", "父类消耗了");
        return super.onTouchEvent(event);
    }
}
