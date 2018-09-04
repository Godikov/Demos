package com.example.administrator.demos.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import com.example.administrator.demos.R;
import com.example.administrator.demos.util.ScreenUtil;

/**
 * Created by Administrator on 2018/8/25.
 */

public class FollowTextView extends AppCompatTextView implements View.OnClickListener{

    private boolean followed = false;
    private Drawable dFollow;
    private Drawable dFollowed;
    private String strFollow = "+关注";
    private String strFollowed = "已关注";

    public FollowTextView(Context context) {
        super(context);
        init(context);
    }

    public FollowTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FollowTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setGravity(Gravity.CENTER);
        dFollow = context.getResources().getDrawable(R.drawable.shape_follow);
        dFollowed = context.getResources().getDrawable(R.drawable.shape_followed);
        setBackgroundDrawable(dFollow);
        setText(strFollow);
        setTextSize(12);
        setTextColor(context.getResources().getColor(R.color.six_three));
        setClickable(true);
        setOnClickListener(this);
        setWidth(ScreenUtil.dp2px(context,50));
        setHeight(ScreenUtil.dp2px(context,22));
        setIncludeFontPadding(false);
    }

    public void setFollowed(boolean followed){
        this.followed = followed;
        if(followed){
            setText(strFollow);
            setBackgroundDrawable(dFollow);
        }else{
            setText(strFollowed);
            setBackgroundDrawable(dFollowed);
        }
    }

    @Override
    public void onClick(View v) {
        if(followed){
            setText(strFollow);
            setBackgroundDrawable(dFollow);
        }else{
            setText(strFollowed);
            setBackgroundDrawable(dFollowed);
        }
        followed = !followed;
    }
}
