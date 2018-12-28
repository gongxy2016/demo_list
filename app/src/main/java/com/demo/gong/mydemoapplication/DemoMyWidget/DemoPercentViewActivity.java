package com.demo.gong.mydemoapplication.DemoMyWidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class DemoPercentViewActivity extends BaseActivity {

    @BindView(R.id.btn_show_percentview)
    Button btnShowView;
    @BindView(R.id.my_percent_view)
    MyPercentView myPercentView;

    @OnClick(R.id.btn_show_percentview)
    public void onViewClick(View view) {
        if (myPercentView.getVisibility() == View.VISIBLE) {
            myPercentView.setVisibility(View.GONE);
            btnShowView.setText("显示图片");
        }else {
            myPercentView.setVisibility(View.VISIBLE);
            btnShowView.setText("隐藏图片");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_percent_view);

    }
}
