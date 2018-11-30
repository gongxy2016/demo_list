package com.demo.gong.mydemoapplication.DemoCoordinatorLayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.R;

public class DemoCoordinatorLayoutActivity extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{

    private int count = 0;
    private Button btnMove;
    private TextView tvShow;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_coordinator_layout);

        btnMove = (Button)findViewById(R.id.btn_move);
        tvShow = (TextView)findViewById(R.id.tv_show);
        btnNext = (Button)findViewById(R.id.btn_next);

        btnMove.setOnTouchListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next) {
            startActivity(new Intent(this,DemoAppBarLayoutActivity.class));
        }
    }
}
