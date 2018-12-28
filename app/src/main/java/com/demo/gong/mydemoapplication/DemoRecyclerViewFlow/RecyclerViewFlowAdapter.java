package com.demo.gong.mydemoapplication.DemoRecyclerViewFlow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TS_02 on 2018/12/27.
 */

public class RecyclerViewFlowAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ShowImageBean> showData;
    private LayoutInflater layoutInflater;

    public RecyclerViewFlowAdapter(Context context, List<ShowImageBean> showData) {
        this.context = context;
        this.showData = showData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_image_flow_layout,parent,false);
        RecyclerViewFlowViewHolder viewHolder = new RecyclerViewFlowViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewFlowViewHolder mViewHolder = (RecyclerViewFlowViewHolder) holder;
        mViewHolder.iv.setImageResource((showData.get(position)).getImageId());
        mViewHolder.tv.setText(showData.get(position).getName().toString().trim());
    }

    @Override
    public int getItemCount() {
        return showData.size();
    }

    class RecyclerViewFlowViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image_flow_show)
        ImageView iv;
        @BindView(R.id.tv_image_flow_name)
        TextView tv;

        public RecyclerViewFlowViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
