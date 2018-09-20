package com.example.administrator.demos.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.demos.R;
import com.example.administrator.demos.widget.MyTableWidget;

/**
 *  制作桌面小部件的步骤：
 *  1.定义小部件界面。
 *      res/layout/下新建一个布局文件。
 *  2.定义小部件配置信息。
 *      res/xml/新建文件
 * */
public class TableWidgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_widget);



    }

    public void openTableWidget(View view) {
        Intent intent = new Intent();
        intent.setAction(MyTableWidget.CLICK_ACTION);
        sendBroadcast(intent);
    }
}
