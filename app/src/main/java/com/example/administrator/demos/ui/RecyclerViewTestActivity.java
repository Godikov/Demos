package com.example.administrator.demos.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.demos.R;
import com.example.administrator.demos.adapter.baseadapter.BaseAdapter;
import com.example.administrator.demos.adapter.baseadapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);

        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.nsv);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);

        List<String> stringList = new ArrayList<>();
        for(int i = 0;i<400;i++){
            stringList.add(i+"");
        }

        RevTestAdapter adapter = new RevTestAdapter(this,stringList,false);
        rv.setAdapter(adapter);

    }

    class RevTestAdapter extends BaseAdapter<String>{

        public RevTestAdapter(Context context, List<String> datas, boolean isOpenLoadMore) {
            super(context, datas, isOpenLoadMore);
        }

        @Override
        protected void convert(ViewHolder holder, String data) {
            TextView tv_content = holder.getView(R.id.tv_content);
            tv_content.setText(data);
        }

        @Override
        protected int getItemLayoutId() {
            return R.layout.item_rev_test;
        }
    }

}
