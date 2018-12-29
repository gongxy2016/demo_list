package com.demo.gong.mydemoapplication.DemoAnimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;

public class FrameAnimationActivity extends BaseActivity {

    @BindView(R.id.iv_frame)
    ImageView ivFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        AnimationDrawable ad = (AnimationDrawable) ivFrame.getDrawable();
        ad.start();
    }
}
