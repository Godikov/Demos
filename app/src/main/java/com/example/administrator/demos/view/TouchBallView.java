package com.example.administrator.demos.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/9/4.
 */

public class TouchBallView extends View {

    private int lastX = 0;
    private int lastY = 0;

    public TouchBallView(Context context) {
        super(context);
    }

    public TouchBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //点击的坐标
        int touchX = (int) event.getRawX();
        int touchY = (int) event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int translationX = (int) (touchX - lastX);
                int translationY = (int) (touchY - lastY);
                setTranslationX(getTranslationX()+translationX);
                setTranslationY(getTranslationY()+translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        lastX = touchX;
        lastY = touchY;

        return true;
    }
}
