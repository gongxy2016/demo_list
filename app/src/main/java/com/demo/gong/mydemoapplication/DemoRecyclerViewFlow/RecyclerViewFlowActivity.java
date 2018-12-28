package com.demo.gong.mydemoapplication.DemoRecyclerViewFlow;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class RecyclerViewFlowActivity extends BaseActivity {

    @BindView(R.id.recv_image_flow)
    RecyclerView recvImageFlow;

    private List<ShowImageBean> showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_flow);

        initData();
        //使用瀑布流布局,第一个参数 spanCount 列数,第二个参数 orentation 排列方向
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recvImageFlow.setLayoutManager(recyclerViewLayoutManager);
        RecyclerViewFlowAdapter recyclerViewFlowAdapter = new RecyclerViewFlowAdapter(this, showData);
        recvImageFlow.setAdapter(recyclerViewFlowAdapter);
    }

    private void initData() {
        showData = new ArrayList<>();
        showData.add(new ShowImageBean("",R.mipmap.image0));
        showData.add(new ShowImageBean("",R.mipmap.image1));
        showData.add(new ShowImageBean("",R.mipmap.image2));
        showData.add(new ShowImageBean("",R.mipmap.image3));
        showData.add(new ShowImageBean("",R.mipmap.image4));
        showData.add(new ShowImageBean("",R.mipmap.image5));
        showData.add(new ShowImageBean("",R.mipmap.image6));
        showData.add(new ShowImageBean("",R.mipmap.image7));
        showData.add(new ShowImageBean("",R.mipmap.image8));
        showData.add(new ShowImageBean("",R.mipmap.image9));
        showData.add(new ShowImageBean("",R.mipmap.image10));
        showData.add(new ShowImageBean("",R.mipmap.image11));
        showData.add(new ShowImageBean("",R.mipmap.image12));
        showData.add(new ShowImageBean("",R.mipmap.image13));
        showData.add(new ShowImageBean("",R.mipmap.image14));
        Collections.shuffle(showData);
    }
}
