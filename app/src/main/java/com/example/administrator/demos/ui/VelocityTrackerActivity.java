package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import com.example.administrator.demos.R;

public class VelocityTrackerActivity extends AppCompatActivity {

    private VelocityTracker velocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity_tracker);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(onTouchListener);
        velocityTracker = VelocityTracker.obtain();
    }

    public View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            velocityTracker.addMovement(motionEvent);
            velocityTracker.computeCurrentVelocity(1000);
            float xVelocity = velocityTracker.getXVelocity();
            float yVelocity = velocityTracker.getYVelocity();
            Log.d("VelocityTrackerTest",xVelocity+" "+yVelocity);
            return true;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(velocityTracker != null){
            velocityTracker.clear();
            velocityTracker.recycle();
        }
    }
}
