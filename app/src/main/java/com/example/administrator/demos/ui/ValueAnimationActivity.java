package com.example.administrator.demos.ui;

import android.animation.ArgbEvaluator;
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
}
