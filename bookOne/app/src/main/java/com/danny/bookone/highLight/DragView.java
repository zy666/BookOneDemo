package com.danny.bookone.highLight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class DragView extends TextView {
    private int lastX, lastY;
    private Scroller scroller;

    public DragView(Context context) {
        super(context);
//        scroller = new Scroller(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);

    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (scroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScroll(int destX, int destY) {
        int x = getScrollX();
        int offsetX = destX - x;

        scroller.startScroll(x, 0, offsetX, 0, 2000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                //第一种
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//                //第2种
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

                //第3种
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);
                //第4种
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);//移动整个控件
//                scrollBy(-offsetX, -offsetY);//移动布局内的文字
                //第5种,使用动画view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate));
                //第6种,使用scroller

                break;
        }
        return true;

    }

}
