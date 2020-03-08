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

public class SplitTextView extends LinearLayout {
    public SplitTextView(Context context) {
        super(context, null);
    }

    public SplitTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SplitTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setGravity(LinearLayout.HORIZONTAL);
    }

    public void setData(String data) {

        if (TextUtils.isEmpty(data)) return;
        removeAllViews();
        int count = 1;
        char[] childData = data.toCharArray();
        for (int i = 0; i < childData.length; i++) {
            if (count % 3 == 0) {
                buildChild(String.valueOf(childData[i]), true);
                if (i != childData.length - 1) {
                    buildChild(",", false);
                }
            } else {
                buildChild(String.valueOf(childData[i]), true);
            }
            count += 1;
        }
    }

    private void buildChild(String data, boolean isNeedBg) {
        TextView tvChild = new TextView(this.getContext());
        if (isNeedBg) {
            tvChild.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.number_tv_bg));
            ViewGroup.MarginLayoutParams params = new MarginLayoutParams(ScreenUtils.dip2px(getContext(), 21f), ScreenUtils.dip2px(getContext(), 28f));
            params.rightMargin = 10;
            tvChild.setLayoutParams(params);
        } else {
            ViewGroup.MarginLayoutParams params = new MarginLayoutParams(ScreenUtils.dip2px(getContext(), 8f), ScreenUtils.dip2px(getContext(), 28f));
            params.rightMargin = 10;
            tvChild.setLayoutParams(params);
        }
        tvChild.setGravity(Gravity.CENTER);
        tvChild.setTextSize(ScreenUtils.dip2px(getContext(), 8f));
        tvChild.setText(data);
        tvChild.setTextColor(Color.parseColor("#2E384D"));
        addView(tvChild);
    }
}
