package com.demo.gong.mydemoapplication.DemoAnimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class TweenAnimationActivity extends BaseActivity {

    @BindViews({R.id.btn_alpha_TweenAnimationActivity,R.id.btn_rotate_TweenAnimationActivity,
            R.id.btn_scale_TweenAnimationActivity,R.id.btn_translate_TweenAnimationActivity,
            R.id.btn_set_TweenAnimationActivity})
    List<Button> btns;

    @BindView(R.id.iv_TweenAnimationActivity)
    ImageView iv;

    private Animation animation;//声明Animation类

    @OnClick({R.id.btn_alpha_TweenAnimationActivity,R.id.btn_rotate_TweenAnimationActivity,
            R.id.btn_scale_TweenAnimationActivity,R.id.btn_translate_TweenAnimationActivity,
            R.id.btn_set_TweenAnimationActivity})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha_TweenAnimationActivity :
                animation = AnimationUtils.loadAnimation(this,R.anim.alpha_test);
                iv.startAnimation(animation);
                break;
            case R.id.btn_rotate_TweenAnimationActivity :
                animation = AnimationUtils.loadAnimation(this,R.anim.rotate_test);
                iv.startAnimation(animation);
                break;
            case R.id.btn_scale_TweenAnimationActivity :
                animation = AnimationUtils.loadAnimation(this,R.anim.scale_test);
                iv.startAnimation(animation);
                break;
            case R.id.btn_translate_TweenAnimationActivity :
                animation = AnimationUtils.loadAnimation(this,R.anim.translate_test);
                iv.startAnimation(animation);
                break;
            case R.id.btn_set_TweenAnimationActivity :
                animation = AnimationUtils.loadAnimation(this,R.anim.set_test);
                iv.startAnimation(animation);
                break;
        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
    }
}
