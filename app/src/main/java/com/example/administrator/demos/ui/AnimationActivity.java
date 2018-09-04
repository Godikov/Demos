package com.example.administrator.demos.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.administrator.demos.R;
import com.example.administrator.demos.evaluator.SimpleEvaluator;
import com.example.administrator.demos.interpolator.SimpleInterpolator;

/**
 *  动画demo
 * */
public class AnimationActivity extends AppCompatActivity {

    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ImageView iv = (ImageView) findViewById(R.id.iv);
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

}
