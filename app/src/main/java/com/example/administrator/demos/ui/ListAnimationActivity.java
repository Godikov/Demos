package com.example.administrator.demos.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.demos.R;

public class ListAnimationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_animation);

        ListView lv = (ListView) findViewById(R.id.lv);

        String[] datas = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.activity_list_item,android.R.id.text1,datas);
        lv.setAdapter(adapter);

        //代码设置列表动画
/*        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_list);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
        layoutAnimationController.setDelay(0.5f);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lv.setLayoutAnimation(layoutAnimationController);*/

    }
}
