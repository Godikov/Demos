package com.example.administrator.demos.ui;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.example.administrator.demos.R;

public class AnimationTestActivity extends BaseActivity {

    private View view_animation;

    private Animation animation;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);

        view_animation = findViewById(R.id.view_animation);

        //animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha); //透明度
        //animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale); //缩放
        //animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate); //平移
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate); //旋转
        animation.setDuration(3000);

        //同时进行动画
        animationSet = new AnimationSet(true);
        Animation alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        Animation scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        Animation translateAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        animationSet.setDuration(3000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);

    }

    public void startAnimation(View view) {
        //view_animation.startAnimation(animation);
        view_animation.startAnimation(animationSet);
    }
}
