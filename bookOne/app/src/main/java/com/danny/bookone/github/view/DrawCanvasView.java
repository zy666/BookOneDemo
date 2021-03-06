package com.danny.bookone.github.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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
        //设置画布
        canvas.drawColor(Color.GRAY);
        //划线
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(30);//单位px
        canvas.drawLine(100, 100, 300, 100, mPaint);

        //画点，点的大小取决于setStrokeWidth
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(50);//单位px
        canvas.drawPoint(350, 100, mPaint);

        //想画出圆形的点,设置笔帽
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(450, 100, mPaint);

        //矩形结构

        //填充矩形
        canvas.drawRect(100, 200, 400, 400, mPaint);
        //描边矩形
        mPaint.setStrokeWidth(10);//单位px
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(500, 200, 600, 400, mPaint);

        //圆角矩形
        RectF rect = new RectF(700, 200, 800, 400);
        float radius = 5f;
        mPaint.setStrokeWidth(10);//单位px
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rect, radius, radius, mPaint);

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
        mPaint.setAntiAlias(true);
    }
}
