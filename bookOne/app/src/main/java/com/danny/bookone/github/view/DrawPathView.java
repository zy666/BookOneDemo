package com.danny.bookone.github.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 路径绘制
 */
public class DrawPathView extends View {
    private Paint mPaint;

    public DrawPathView(Context context) {
        this(context, null);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //创建画笔
        mPaint = new Paint();
        mPaint.setStrokeWidth(10);//单位px
        mPaint.setColor(Color.RED);//单位px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#f1f1f1"));

        //画直线路径,绘制直线路径涉及：起点、终点和闭环。
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        //第一条线的起点
        path.moveTo(100, 100);
        //第1条线的终点，第二条线的起点
        path.lineTo(400, 300);
        //第2条线的终点，第二条线的终点
        path.lineTo(100, 300);
        path.close();
        canvas.drawPath(path, mPaint);

        //画曲线路径,
        Paint paint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        Path pathCircle = new Path();
        RectF rectF = new RectF(500, 100, 600, 200);
        //指定角度
        pathCircle.arcTo(rectF, 0, 90);
        canvas.drawOval(rectF, paint);
        canvas.drawPath(pathCircle, mPaint);

        //画曲线路径,
        mPaint.setStyle(Paint.Style.STROKE);
        Path pathCircleS = new Path();

        RectF rectFs = new RectF(800, 100, 900, 200);
        //指定角度
        pathCircleS.arcTo(rectFs, 0, 90);
        canvas.drawOval(rectFs, paint);
        canvas.drawPath(pathCircleS, mPaint);
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
}
