package com.demo.gong.mydemoapplication.DemoCoordinatorLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DemoAppBarLayoutActivity extends AppCompatActivity {

    private RecyclerView recv_appbar;
    private List<String> showData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_app_bar_layout);

        recv_appbar = (RecyclerView)findViewById(R.id.recv_appbar);
        recv_appbar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        initShowData();
        MyRecvAdapter adapter = new MyRecvAdapter(showData);
        recv_appbar.setAdapter(adapter);
    }

    private void initShowData() {
        int i = 0;
        while(i < 50) {
            showData.add("1");
            i++;
        }
    }

    private class MyRecvAdapter extends  RecyclerView.Adapter {
        private List<String> showData;

        public MyRecvAdapter(List<String> showData) {
            this.showData = showData;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(DemoAppBarLayoutActivity.this).inflate(R.layout.coordinator_item_layout,parent,false);
            MyViewHolder mViewHolder = new MyViewHolder(view);
            return mViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder mHolder = (MyViewHolder) holder;
            mHolder.tv.setText(position+"");
        }

        @Override
        public int getItemCount() {
            return showData.size();
        }

        public void setData(List<String> showData) {
            this.showData = showData;
            notifyDataSetChanged();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv_cooitem);
            }
        }
    }
}
