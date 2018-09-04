package com.example.administrator.demos.evaluator;

import android.animation.TypeEvaluator;

import com.example.administrator.demos.util.LogUtil;

/**
 * Created by Administrator on 2018/5/23.
 */

public class SimpleEvaluator implements TypeEvaluator<Integer> {

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int newInteger = (int) (startValue + (fraction * (endValue - startValue)));
        LogUtil.e("evaluate","fraction = "+fraction);
        LogUtil.e("evaluate","startValue = "+startValue);
        LogUtil.e("evaluate","endValue = "+endValue);
        LogUtil.e("evaluate","newInteger = "+newInteger);
        return newInteger;
    }

}
