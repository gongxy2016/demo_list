package com.demo.gong.mydemoapplication.DemoAnimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class PropertyAnimationActivity extends BaseActivity {

    @BindViews({R.id.btn_start1_PropertyAnimationActivity,R.id.btn_start2_PropertyAnimationActivity,
            R.id.btn_start3_PropertyAnimationActivity})
    List<Button> btns;
    @BindView(R.id.iv_PropertyAnimationActivity)
    ImageView iv;

    @OnClick({R.id.btn_start1_PropertyAnimationActivity,R.id.btn_start2_PropertyAnimationActivity,
            R.id.btn_start3_PropertyAnimationActivity})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start1_PropertyAnimationActivity :
                ObjectAnimator.ofFloat(iv,"translationY",-iv.getHeight()).start();
                break;
            case R.id.btn_start2_PropertyAnimationActivity :
                ValueAnimator va = ObjectAnimator.ofInt(iv,"backgroundColor",0xFFFF8080,0xFF8080FF);
                va.setDuration(3000);
                va.start();
                break;
            case R.id.btn_start3_PropertyAnimationActivity :
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(iv,"rotationX",0,360),
                        ObjectAnimator.ofFloat(iv,"rotationY",0,180),
                        ObjectAnimator.ofFloat(iv,"rotation",0,-90),
                        ObjectAnimator.ofFloat(iv,"translationX",0,90),
                        ObjectAnimator.ofFloat(iv,"translationY",0,90),
                        ObjectAnimator.ofFloat(iv,"scaleX",1,1.5f),
                        ObjectAnimator.ofFloat(iv,"scaleY",1,0.5f),
                        ObjectAnimator.ofFloat(iv,"alpha",1,0.25f,1)
                );
                set.setDuration(5000).start();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);


    }
}
