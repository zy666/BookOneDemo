package com.danny.bookone.highLight;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.danny.bookone.R;
import com.danny.bookone.ScreenUtils;

public class SplitTextViewLayout extends LinearLayout {
    public SplitTextViewLayout(Context context) {
        super(context, null);
    }

    public SplitTextViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SplitTextViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(LinearLayout.HORIZONTAL);
    }

    public void setData(String text) {
        if (TextUtils.isEmpty(text)) return;
        removeAllViews();
        int count = 1;
        char[] charArrays = text.toCharArray();
        for (int i = 0; i < charArrays.length; i++) {
            if (count % 3 == 0) {
                buildView(String.valueOf(charArrays[i]), true);
                if (i != charArrays.length - 1) {
                    buildView(",", false);
                }
            } else {
                buildView(String.valueOf(charArrays[i]), true);
            }
            count = count + 1;
        }
    }

    private void buildView(String text, boolean isNeedBg) {
        TextView textView = new TextView(this.getContext());

        if (isNeedBg) {
            textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.number_tv_bg));
            ViewGroup.MarginLayoutParams params = new MarginLayoutParams(ScreenUtils.dip2px(getContext(), 21f),
                    ScreenUtils.dip2px(getContext(), 28f));
            params.rightMargin = 10;
            textView.setLayoutParams(params);
        } else {
            ViewGroup.MarginLayoutParams params = new MarginLayoutParams(ScreenUtils.dip2px(getContext(), 8f),
                    ScreenUtils.dip2px(getContext(), 28f));
            params.rightMargin = 10;
            textView.setLayoutParams(params);
        }

        textView.setText(text);
        textView.setTextSize(ScreenUtils.dip2px(getContext(), 8f));
        textView.setTextColor(Color.parseColor("#333333"));
        textView.setGravity(Gravity.CENTER);
        addView(textView);
    }
}
