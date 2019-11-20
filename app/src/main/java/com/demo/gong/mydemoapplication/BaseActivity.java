package com.demo.gong.mydemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000; //Home键标志
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);

        ButterKnife.bind(this);
    }
}
