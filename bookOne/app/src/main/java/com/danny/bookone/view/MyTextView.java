package com.danny.bookone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.danny.bookone.R;

/**
 * myTextUnderline  是否添加下划线
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {

    private TextPaint textPaint;
    private boolean addLine;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0);

        addLine = typedArray.getBoolean(R.styleable.MyTextView_myTextUnderline, false);

        typedArray.recycle();

        textPaint = getPaint();
        if (addLine) {
            textPaint.setUnderlineText(true);
        }
    }
}
