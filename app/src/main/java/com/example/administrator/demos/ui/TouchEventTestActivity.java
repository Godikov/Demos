package com.example.administrator.demos.ui;

import android.os.Bundle;

import com.example.administrator.demos.R;
import com.example.administrator.demos.view.TouchBallView;

/**
 *  TouchEvent探索
 * */
public class TouchEventTestActivity extends BaseActivity {

    private TouchBallView tbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_test);

        tbv = (TouchBallView) findViewById(R.id.tbv);

    }


}
