package com.demo.gong.mydemoapplication.DemoAnimation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class DemoAnimationActivity extends BaseActivity {

    @BindViews({R.id.btn_tween_animation,R.id.btn_frame_animation,R.id.btn_property_animation})
    List<Button> btnList;

    @OnClick({R.id.btn_tween_animation,R.id.btn_frame_animation,R.id.btn_property_animation})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween_animation :
                startActivity(new Intent(this,TweenAnimationActivity.class));
                break;
            case R.id.btn_frame_animation :
                startActivity(new Intent(this,FrameAnimationActivity.class));
                break;
            case R.id.btn_property_animation :
                startActivity(new Intent(this,PropertyAnimationActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_animation);
    }

}
