package com.example.administrator.demos.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demos.R;
import com.example.administrator.demos.view.NestedExpandaleListView;

public class AddressBookActivity extends AppCompatActivity {

    private NestedExpandaleListView elv;
    private Context context;

    private String[] groups = {"综合部","财务部","后勤保障部","经营部","车船部","游客中心"};
    private String[][] childs = {
            {"张三","李四","王二","于谦"},
            {"张三","李四","王二","于谦"},
            {"张三","李四","王二","于谦"},
            {"张三","李四","王二","于谦"},
            {"张三","李四","王二","于谦"},
            {"张三","李四","王二","于谦"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book);

        context = this;

        elv = findViewById(R.id.elv);

        final MyAdapter adapter = new MyAdapter();

        elv.setAdapter(adapter);

        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), groups[groupPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), childs[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

/*        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = adapter.getGroupCount();
                for(int i = 0;i < count;i++){
                    if (i!=groupPosition){
                        elv.collapseGroup(i);
                    }
                }
            }
        });*/

    }

    class MyAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childs[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupViewHolder viewHolder;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.item_first_level_layout,parent,false);
                viewHolder = new GroupViewHolder();
                viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (GroupViewHolder) convertView.getTag();
            }
            viewHolder.tv_title.setText(groups[groupPosition]);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildViewHolder childViewHolder;
            if (convertView==null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child_level_layout,parent,false);
                childViewHolder = new ChildViewHolder();
                childViewHolder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
                convertView.setTag(childViewHolder);

            }else {
                childViewHolder = (ChildViewHolder) convertView.getTag();
            }
            childViewHolder.tv_name.setText(childs[groupPosition][childPosition]);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    class GroupViewHolder{
        TextView tv_title;
    }

    class ChildViewHolder{
        TextView tv_name;
    }

}
