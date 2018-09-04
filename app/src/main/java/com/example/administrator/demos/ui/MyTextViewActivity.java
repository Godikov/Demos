package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.demos.R;
import com.example.administrator.demos.view.FollowTextView;

public class MyTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_view);

        FollowTextView ftv = (FollowTextView) findViewById(R.id.ftv);
        ftv.setFollowed(false);

    }
}
