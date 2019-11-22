package com.demo.gong.mydemoapplication.DemoAnimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FrameAnimationActivity extends BaseActivity {

    @BindView(R.id.iv_frame)
    ImageView ivFrame;
    @BindView(R.id.btn_start_DemoAnimationActivity)
    Button btnStart;
    @BindView(R.id.btn_stop_DemoAnimationActivity)
    Button btnStop;

    private AnimationDrawable ad;
    private ValueAnimator valueAnimator;

    @OnClick({R.id.btn_start_DemoAnimationActivity,R.id.btn_stop_DemoAnimationActivity})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_DemoAnimationActivity :
                if (!ad.isRunning()) {
                    ad.start();

                    valueAnimator = ObjectAnimator.ofInt(ivFrame,"backgroundColor",0xFFFF8080,0xFF8080FF);
                    valueAnimator.setDuration(3000);
                    valueAnimator.start();
                }
                break;
            case R.id.btn_stop_DemoAnimationActivity :
                if (ad.isRunning()) {
                    ad.stop();
                    valueAnimator.cancel();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ad = (AnimationDrawable) ivFrame.getDrawable();
    }
}
