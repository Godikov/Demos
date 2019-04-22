package com.example.administrator.demos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.demos.R;


public class MainActivity extends BaseActivity {

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

    //OnTouchEvent
    public void touchEventTest(View view) {
        Intent intent = new Intent(this,TouchEventTestActivity.class);
        startActivity(intent);
    }

    //自定义控件-圆
    public void circleView(View view) {
        Intent intent = new Intent(this,CircleViewActivity.class);
        startActivity(intent);
    }

    //自定义通知栏布局
    public void notificationTest(View view) {
        Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
    }

    //桌面小部件
    public void desktopWidgetTest(View view) {
        Intent intent = new Intent(this,TableWidgetActivity.class);
        startActivity(intent);
    }

    //各种动画效果
    public void animationTest(View view) {
        Intent intent = new Intent(this,AnimationTestActivity.class);
        startActivity(intent);
    }

    //列表动画
    public void listAnimationTest(View view) {
        Intent intent = new Intent(this,ListAnimationActivity.class);
        startActivity(intent);
    }

    //属性动画
    public void ValueAnimationTest(View view) {
        startActivity(new Intent(this,ValueAnimationActivity.class));
    }

    //实时获取摄像头图像
    public void photoTest(View view) {
        startActivity(new Intent(this,PhotoActivity.class));
    }

    public void photoTest2(View view) {
        startActivity(new Intent(this,Photo2Activity.class));
    }

    public void twentyWeeks(View view) {
        startActivity(new Intent(this,TwentyWeeksActivity.class));
    }

    public void recyclerViewTest(View view) {
        startActivity(new Intent(this,RecyclerViewTestActivity.class));
    }

    public void uploadImgTest(View view) {
        startActivity(new Intent(this,UploadImgActivity.class));
    }

    public void MVCTest(View view) {
        startActivity(new Intent(this,MVCTestActivity.class));
    }

    public void AddressBookTest(View view) {
        startActivity(new Intent(this,AddressBookActivity.class));
    }

    public void VelocityTrackerTest(View view) {
        startActivity(new Intent(this,VelocityTrackerActivity.class));
    }
}
