package com.example.administrator.demos.interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by Administrator on 2018/5/23.
 */

public class SimpleInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return input * input;
    }

}
