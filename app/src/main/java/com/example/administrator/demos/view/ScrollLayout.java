package com.example.administrator.demos.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ScrollLayout extends FrameLayout {

    private final Scroller scroller;
    private String TAG = ScrollLayout.class.getSimpleName();

    public ScrollLayout(@NonNull Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        if(scroller.computeScrollOffset()){
            this.scrollTo(scroller.getCurrX(),scroller.getCurrY());
            this.postInvalidate();
        }
    }

    public void scrollTo(int y){
        scroller.startScroll(getScrollX(),getScrollY(),0,y);
        this.invalidate();
    }

}
