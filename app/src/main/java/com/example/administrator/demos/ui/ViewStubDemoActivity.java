package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.example.administrator.demos.R;

public class ViewStubDemoActivity extends AppCompatActivity {

    private ViewStub vs;
    private boolean is_inflated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub_demo);

        vs = (ViewStub) findViewById(R.id.vs);
    }

    public void showImg(View view) {
        if(!is_inflated){
            View viewstub = vs.inflate();
            ImageView iv_viewstub = (ImageView) viewstub.findViewById(R.id.iv_viewstub);
            iv_viewstub.setImageResource(R.drawable.test_two);
            is_inflated = true;
        }
    }
}
