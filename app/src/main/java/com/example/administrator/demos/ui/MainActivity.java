package com.example.administrator.demos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.demos.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //动画
    public void animationDemo(View view) {
        Intent intent = new Intent(this,AnimationActivity.class);
        startActivity(intent);
    }

    //多线程
    public void threadDemo(View view) {
        Intent intent = new Intent(this,ThreadDemoActivity.class);
        startActivity(intent);
    }

    //ViewStub
    public void viewstubDemo(View view) {
        Intent intent = new Intent(this,ViewStubDemoActivity.class);
        startActivity(intent);
    }

    //评论
    public void commentDemo(View view) {
        Intent intent = new Intent(this,CommentActivity.class);
        startActivity(intent);
    }

    //自定义TextView
    public void MyTextViewTest(View view) {
        Intent intent = new Intent(this,MyTextViewActivity.class);
        startActivity(intent);
    }
}
