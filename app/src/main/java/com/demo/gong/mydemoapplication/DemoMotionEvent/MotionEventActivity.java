package com.demo.gong.mydemoapplication.DemoMotionEvent;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;

//事件分发机制
public class MotionEventActivity extends BaseActivity {

    @BindView(R.id.listView_MotionEventActivity)
    ListView mListView;

    private ArrayAdapter mListViewAdapter;
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);

        initListView();
    }

    private void initListView() {
        datas = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12"};
        mListViewAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datas);
        mListView.setAdapter(mListViewAdapter);
    }
}
