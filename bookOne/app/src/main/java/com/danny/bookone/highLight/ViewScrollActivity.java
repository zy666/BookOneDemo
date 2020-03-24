package com.danny.bookone.highLight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;

import com.danny.bookone.R;
import com.danny.bookone.databinding.ActivityViewScrollBinding;

public class ViewScrollActivity extends AppCompatActivity {
    private ActivityViewScrollBinding viewScrollBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewScrollBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_scroll);

        //动画移动
//        viewScrollBinding.btnScroll.setAnimation(AnimationUtils.loadAnimation(ViewScrollActivity.this, R.anim.translate));
        //弹性滑动
//        viewScrollBinding.btnScroll.smoothScroll(-400, 0);
        StringBuffer buffer = new StringBuffer();
        buffer.append("1.layout" + "\n")
                .append("2.offsetLeftAndRight和offsetTopAndBottom" + "\n")
                .append("3.setLayoutParams" + "\n")
                .append("4.使用动画" + "\n")
                .append("5.使用Scroller类" + "\n")
                .append("6.使用scrollBy或者scrollTo" + "\n");
        viewScrollBinding.tvContext.setText(buffer.toString());
        //
        viewScrollBinding.tvSplit.setData("123456789");
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ViewScrollActivity.class);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatchTouchEvent", "activity");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("onTouchEvent", "activity");
        return super.onTouchEvent(event);
    }
}
