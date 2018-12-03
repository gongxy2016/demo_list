package com.demo.gong.mydemoapplication.DemoCoordinatorLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.R;

import java.util.List;

/**
 * Created by TS_02 on 2018/12/3.
 */

public class DemoAppBarLayoutAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> showData;
    private LayoutInflater inflater;

    public DemoAppBarLayoutAdapter(Context context,List<String> showData) {
        this.context = context;
        this.showData = showData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.coordinator_item_layout,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mHolder = (MyViewHolder) holder;
        mHolder.tv.setText(showData.get(position));
    }

    @Override
    public int getItemCount() {
        return showData.size();
    }

    public void setData(List<String> showData) {
        this.showData = showData;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_cooitem);
        }
    }
}
