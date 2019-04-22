package com.example.administrator.demos.ui;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.demos.R;

public class ValueAnimationActivity extends AppCompatActivity {

    private View testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);

        testView = findViewById(R.id.view);



    }

    public void objectAnimatorDemo(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(testView,"translationY",500);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    public void valueAnimatorDemo(View view) {
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(testView,"backgroundColor",0xFFFF8080,0xFF8080FF);
        valueAnimator.setDuration(500);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    public void AnimatorSetDemo(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator backgroundAnimator = ObjectAnimator.ofInt(testView,"backgroundColor",0xFFFF8080,0xFF8080FF);
        backgroundAnimator.setDuration(500);
        backgroundAnimator.setEvaluator(new ArgbEvaluator());
        backgroundAnimator.setRepeatCount(ValueAnimator.INFINITE);
        backgroundAnimator.setRepeatMode(ValueAnimator.REVERSE);
        ValueAnimator rotateAnimator = ObjectAnimator.ofFloat(testView,"rotation",0,45,90,45,90);
        rotateAnimator.setDuration(500);
        rotateAnimator.setEvaluator(new FloatEvaluator());
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setRepeatMode(ValueAnimator.REVERSE);
        animatorSet.playTogether(backgroundAnimator,rotateAnimator);
        animatorSet.start();
    }

    public void xmlAnimationDemo(View view) {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.test1);
        animatorSet.setTarget(testView);
        animatorSet.start();
    }

}
