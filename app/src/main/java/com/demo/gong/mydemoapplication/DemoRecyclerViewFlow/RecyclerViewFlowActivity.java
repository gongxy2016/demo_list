package com.demo.gong.mydemoapplication.DemoRecyclerViewFlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.demo.gong.mydemoapplication.R;

import java.util.List;

import butterknife.BindView;

public class RecyclerViewFlowActivity extends AppCompatActivity {

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
        recvImageFlow.setLayoutManager(recyclerViewLayoutManager);
        recvImageFlow.setAdapter(new RecyclerViewFlowAdapter(this,showData));
    }

    private void initData() {
        showData.add(new ShowImageBean("图片0",R.mipmap.image0));
        showData.add(new ShowImageBean("图片1",R.mipmap.image1));
        showData.add(new ShowImageBean("图片2",R.mipmap.image2));
        showData.add(new ShowImageBean("图片3",R.mipmap.image3));
        showData.add(new ShowImageBean("图片4",R.mipmap.image4));
        showData.add(new ShowImageBean("图片5",R.mipmap.image5));
    }
}
