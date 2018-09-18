package com.example.administrator.demos.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.demos.R;

/**
 * Created by Administrator on 2018/9/15.
 */

public class CircleView extends View {

    private int mColor = Color.BLACK;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int widthSize;
    private int heightSize;

    public CircleView(Context context) {
        super(context);
        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        if(typedArray != null){
            mColor = typedArray.getColor(R.styleable.CircleView_bg_color,Color.BLACK);
            typedArray.recycle();
        }
        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        if(typedArray != null){
            mColor = typedArray.getColor(R.styleable.CircleView_bg_color,Color.BLACK);
            typedArray.recycle();
        }
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (widthMode){
            case MeasureSpec.AT_MOST:
                widthSize = 300;
                break;
        }
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                heightSize = 300;
                break;
        }
        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = widthSize - paddingLeft - paddingRight;
        int height = heightSize - paddingTop - paddingBottom;
        int radius = Math.min(width,height)/2;
        canvas.drawCircle(paddingLeft + width/2,paddingTop + height/2,radius,mPaint);
    }

    private void init(Context context) {
        mPaint.setColor(mColor);
    }

}
