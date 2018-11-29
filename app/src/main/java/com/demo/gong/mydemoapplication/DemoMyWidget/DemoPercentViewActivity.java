package com.demo.gong.mydemoapplication.DemoMyWidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.R;

public class DemoPercentViewActivity extends AppCompatActivity {

    private Button btnShowView;
    private MyPercentView myPercentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_percent_view);

        btnShowView = (Button)findViewById(R.id.btn_show_percentview);
        myPercentView = (MyPercentView)findViewById(R.id.my_percent_view);

        btnShowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myPercentView.getVisibility() == View.VISIBLE) {
                    myPercentView.setVisibility(View.GONE);
                    btnShowView.setText("显示图片");
                }else {
                    myPercentView.setVisibility(View.VISIBLE);
                    btnShowView.setText("隐藏图片");
                }
            }
        });
    }
}
