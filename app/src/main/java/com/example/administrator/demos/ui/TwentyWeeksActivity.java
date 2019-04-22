package com.example.administrator.demos.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.demos.R;
import com.example.administrator.demos.adapter.baseadapter.BaseAdapter;
import com.example.administrator.demos.adapter.baseadapter.ViewHolder;
import com.example.administrator.demos.util.LogUtil;
import com.example.administrator.demos.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class TwentyWeeksActivity extends AppCompatActivity {

    private static final String TAG = "TwentyWeeksActivity";

    RecyclerView rv;
    private long earlyTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_weeks);

        rv = (RecyclerView) findViewById(R.id.rv);

        initViews();

        String eayly = TimeUtil.getDateByReduceDay(-140);
        earlyTimeMillis = TimeUtil.parseTimeToLong(eayly);
        LogUtil.e(TAG,TimeUtil.getDayOfWeek(System.currentTimeMillis())+"");
        loadData();

    }

    private void loadData() {
        TestAdapter adapter = new TestAdapter(this,new ArrayList<String>(),false);
        List<String> testList = new ArrayList<>();
        for(int i = 0;i<20;i++){
            testList.add(i+"");
        }
        adapter.setNewData(testList);
        rv.setAdapter(adapter);
    }

    private void initViews() {
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    class TestAdapter extends BaseAdapter<String>{

        public TestAdapter(Context context, List<String> datas, boolean isOpenLoadMore) {
            super(context, datas, isOpenLoadMore);
        }

        @Override
        protected void convert(ViewHolder holder, String data) {
            TextView tv = holder.getView(R.id.tv);
            int position = holder.getAdapterPosition();
            if(TimeUtil.getDayOfWeek(System.currentTimeMillis()) == 0){
                String leftTime = TimeUtil.getDateByReduceDay(earlyTimeMillis,(position)*7+1);
                String rightTime = TimeUtil.getDateByReduceDay(earlyTimeMillis,(position + 1)*7);
                tv.setText(leftTime+" 至 "+rightTime);
            }else{
                if(position < getAllDatas().size() - 1){
                    String leftTime = TimeUtil.getDateByReduceDay(earlyTimeMillis,(position)*7+1);
                    String rightTime = TimeUtil.getDateByReduceDay(earlyTimeMillis,(position + 1)*7);
                    tv.setText(leftTime+" 至 "+rightTime);
                }else{
                    String leftTime = TimeUtil.getDateByReduceDay(System.currentTimeMillis(),-TimeUtil.getDayOfWeek(System.currentTimeMillis()));
                    String rightTime = TimeUtil.getDateByReduceDay(System.currentTimeMillis(),0);
                    tv.setText(leftTime+" 至 "+rightTime);
                }
            }
        }

        @Override
        protected int getItemLayoutId() {
            return R.layout.item_twenty_weeks;
        }
    }

}
