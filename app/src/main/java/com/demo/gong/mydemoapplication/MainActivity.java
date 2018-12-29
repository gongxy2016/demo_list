package com.demo.gong.mydemoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.DemoAnimation.DemoAnimationActivity;
import com.demo.gong.mydemoapplication.DemoCameraAndRecoder.TestPhotoActivity;
import com.demo.gong.mydemoapplication.DemoCoordinatorLayout.DemoCoordinatorLayoutActivity;
import com.demo.gong.mydemoapplication.DemoFragmentAndTabLayout.DemoFragmentActivity;
import com.demo.gong.mydemoapplication.DemoMyWidget.DemoPercentViewActivity;
import com.demo.gong.mydemoapplication.DemoNetActivity.TestNetWorkActivity;
import com.demo.gong.mydemoapplication.DemoRecyclerViewFlow.RecyclerViewFlowActivity;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.TestDatabaseActivity;
import java.util.List;
import butterknife.BindViews;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindViews({R.id.btn_camera,R.id.btn_my_widget,R.id.btn_net,R.id.btn_sqlite,R.id.btn_coordinatorLayout,
            R.id.btn_fragment_demo,R.id.btn_recy_image_flow_demo,R.id.btn_animation})
    List<Button> btnList;

    @OnClick({R.id.btn_camera,R.id.btn_my_widget,R.id.btn_net,R.id.btn_sqlite,R.id.btn_coordinatorLayout,
            R.id.btn_fragment_demo,R.id.btn_recy_image_flow_demo,R.id.btn_animation})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_camera :
                startActivity(new Intent(this, TestPhotoActivity.class));
                break;
            case R.id.btn_my_widget :
                startActivity(new Intent(this, DemoPercentViewActivity.class));
                break;
            case R.id.btn_net :
                startActivity(new Intent(this, TestNetWorkActivity.class));
                break;
            case R.id.btn_sqlite :
                startActivity(new Intent(this, TestDatabaseActivity.class));
                break;
            case R.id.btn_coordinatorLayout :
                startActivity(new Intent(this, DemoCoordinatorLayoutActivity.class));
                break;
            case R.id.btn_fragment_demo :
                startActivity(new Intent(this, DemoFragmentActivity.class));
                break;
            case R.id.btn_recy_image_flow_demo :
                startActivity(new Intent(MainActivity.this, RecyclerViewFlowActivity.class));
                break;
            case R.id.btn_animation :
                startActivity(new Intent(MainActivity.this, DemoAnimationActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
