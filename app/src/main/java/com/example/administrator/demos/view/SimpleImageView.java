package com.example.administrator.demos.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.demos.R;
import com.example.administrator.demos.util.ImageUtil;

/**
 * Created by humu on 2018/5/21.
 */

public class SimpleImageView extends View {

    private Drawable drawable;
    private int mWidth;
    private int mHeight;
    private Paint paint;

    public SimpleImageView(Context context) {
        super(context);
    }

    public SimpleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = null;
        if(attrs != null){
            try {
                typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.SimpleImageView);
                drawable = typedArray.getDrawable(R.styleable.SimpleImageView_src);
                measureDrawable();
            }finally {
                if(typedArray != null){
                    typedArray.recycle();
                }
            }
        }
    }

    private void measureDrawable() {
        if(drawable != null){
            mWidth = drawable.getIntrinsicWidth();
            mHeight = drawable.getIntrinsicHeight();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMode,widthSize),measureHeight(heightMode,heightSize));
    }

    private int measureHeight(int mode,int size) {
        switch (mode){
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
                mHeight = size;
        }
        return mHeight;
    }

    private int measureWidth(int mode,int size) {
        switch (mode){
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = size;
        }
        return mWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(drawable == null){
            return;
        }
        Bitmap bitmap = Bitmap.createScaledBitmap(ImageUtil.drawableToBitmap(drawable),
                getMeasuredWidth(),getMeasuredHeight(),true);
        canvas.drawBitmap(bitmap,getLeft(),getTop(),paint);

        canvas.save();
        canvas.rotate(90);
        paint.setColor(Color.YELLOW);
        paint.setTextSize(30);
        canvas.drawText("左竖向文本测试",getLeft() + 50,getTop() - 50,paint);
        canvas.restore();

    }
}
