package com.example.administrator.demos.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demos.R;
import com.example.administrator.demos.evaluator.SimpleEvaluator;
import com.example.administrator.demos.interpolator.SimpleInterpolator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  动画demo
 * */
public class AnimationActivity extends BaseActivity {

    private AnimatorSet animatorSet;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ImageView iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);




/*        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getBackground();
        animationDrawable.start();

        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.tween_test);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float alpha = (Float) animation.getAnimatedValue();
                iv.setAlpha(alpha);
            }
        });
        valueAnimator.start();*/

/*
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"alpha",1.0f,0.5f,0.0f,0.5f,1.0f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
*/

        init();

        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(iv,"alpha",1.0f,0.5f,0.0f,0.5f,1.0f);
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(iv,"rotation",90,0,-90,0,90,0,-90,0,90,0,-90,0,90,0,-90,0);
        ObjectAnimator translateXAnimator = ObjectAnimator.ofFloat(iv,"translationX",500,0,-500,0);
        translateXAnimator.setInterpolator(new SimpleInterpolator());
        ObjectAnimator translateYAnimator = ObjectAnimator.ofFloat(iv,"translationY",500,0,-500,0);
        translateYAnimator.setInterpolator(new SimpleInterpolator());
        animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator,rotateAnimator,translateXAnimator,translateYAnimator);
        animatorSet.setDuration(4000);
        animatorSet.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(iv,"x",new SimpleEvaluator(),0,100);
        objectAnimator.setDuration(3000);
        objectAnimator.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        animatorSet.start();
        return super.onTouchEvent(event);
    }

    private void init() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        Date newDate = null;//addDate(date, 30);


        long time = date.getTime();
        long day = 30L * 24 * 60 * 60 * 1000;
        time += day;
        newDate = new Date(time);

        tv.setText(dateFormat.format(newDate));
    }

    public Date addDate(Date date, long day){
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
        time += day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

}
