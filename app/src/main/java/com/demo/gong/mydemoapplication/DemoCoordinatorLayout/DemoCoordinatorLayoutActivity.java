package com.demo.gong.mydemoapplication.DemoCoordinatorLayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTouch;

public class DemoCoordinatorLayoutActivity extends BaseActivity {

    @BindView(R.id.btn_move)
    Button btnMove;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.tv_show)
    TextView tvShow;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_coordinator_layout);

    }

    @OnClick({R.id.btn_next})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next :
                startActivity(new Intent(this,DemoAppBarLayoutActivity.class));
                break;
        }
    }

    @OnTouch(R.id.btn_move)
    public boolean onViewTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            v.setX(event.getRawX()-v.getWidth()/2);
            v.setY(event.getRawY()-v.getHeight()/2);
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (count < 6) {
                count++;
                switch (count) {
                    case 1:
                        tvShow.setText("彭");
                        break;
                    case 2:
                        tvShow.setText("刚");
                        break;
                    case 3:
                        tvShow.setText("爱");
                        break;
                    case 4:
                        tvShow.setText("吃");
                        break;
                    case 5:
                        tvShow.setText("鸡");
                        break;
                }
            }else {
                count = 1;
                tvShow.setText("彭");
            }
        }
        return false;
    }
}
