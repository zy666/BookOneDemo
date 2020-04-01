package com.danny.bookone.github.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 画布用法
 */
public class DrawCanvasView extends View {
    private Paint mPaint;

    public DrawCanvasView(Context context) {
        this(context, null);
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //半径
        float radius = 100;

        //红色圆
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);//描边
        mPaint.setAntiAlias(true);
        canvas.drawCircle(200, 200, radius, mPaint);

        //蓝色圆
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);//填充
        canvas.drawCircle(550, 200, radius, mPaint);
        //绿色圆
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//描边填充
        canvas.drawCircle(850, 200, radius, mPaint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    public int measureWidth(int measureSpec) {
        int result = 0;
        int speMode = MeasureSpec.getMode(measureSpec);
        int speSize = MeasureSpec.getSize(measureSpec);
        if (speMode == MeasureSpec.EXACTLY) {
            result = speSize;
        } else {
            result = 1000;
            if (speMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, speSize);
            }
        }
        return result;
    }

    public int measureHeight(int measureSpec) {
        int result = 0;
        int speMode = MeasureSpec.getMode(measureSpec);
        int speSize = MeasureSpec.getSize(measureSpec);
        if (speMode == MeasureSpec.EXACTLY) {
            result = speSize;
        } else {
            result = 1000;
            if (speMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, speSize);
            }
        }
        return result;
    }



    private void init() {
        //创建画笔
        mPaint = new Paint();
        mPaint.setStrokeWidth(10);//单位px
    }
}
