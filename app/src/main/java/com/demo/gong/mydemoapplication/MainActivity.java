package com.demo.gong.mydemoapplication;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.DemoAnimation.DemoAnimationActivity;
import com.demo.gong.mydemoapplication.DemoBaiduMap.BaiduMapActivity;
import com.demo.gong.mydemoapplication.DemoCameraAndRecoder.TestPhotoActivity;
import com.demo.gong.mydemoapplication.DemoCoordinatorLayout.DemoCoordinatorLayoutActivity;
import com.demo.gong.mydemoapplication.DemoEtTest.EtTestActivity;
import com.demo.gong.mydemoapplication.DemoFloatingActionButton.FloatingActionButtonActivity;
import com.demo.gong.mydemoapplication.DemoFragmentAndTabLayout.DemoFragmentActivity;
import com.demo.gong.mydemoapplication.DemoJsBridge.JsBridgeDemoActivity;
import com.demo.gong.mydemoapplication.DemoMotionEvent.MotionEventActivity;
import com.demo.gong.mydemoapplication.DemoMyCamera.MyCareraActivity;
import com.demo.gong.mydemoapplication.DemoMyWidget.DemoPercentViewActivity;
import com.demo.gong.mydemoapplication.DemoNetActivity.TestNetWorkActivity;
import com.demo.gong.mydemoapplication.DemoPlayMusic.PlayMusicActivity;
import com.demo.gong.mydemoapplication.DemoQRCode.QRCodeActivity;
import com.demo.gong.mydemoapplication.DemoRecyclerViewFlow.RecyclerViewFlowActivity;
import com.demo.gong.mydemoapplication.DemoRepeatChooseBtn.RepeatChooseBtnActivity;
import com.demo.gong.mydemoapplication.DemoRxjava.RxjavaPractiseActivity;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.TestDatabaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    @BindViews({R.id.btn_camera, R.id.btn_my_widget, R.id.btn_net, R.id.btn_sqlite, R.id.btn_coordinatorLayout,
            R.id.btn_fragment_demo, R.id.btn_recy_image_flow_demo, R.id.btn_animation, R.id.btn_my_camera,
            R.id.btn_qrcode, R.id.btn_baidumap, R.id.btn_floating_action_button, R.id.btn_repeat_choose_button,
            R.id.btn_jsbridge_button, R.id.btn_rxandroid_practise, R.id.btn_et_test, R.id.btn_mediaplayer,
            R.id.btn_motion_event})
    List<Button> btnList;

    @OnClick({R.id.btn_camera, R.id.btn_my_widget, R.id.btn_net, R.id.btn_sqlite, R.id.btn_coordinatorLayout,
            R.id.btn_fragment_demo, R.id.btn_recy_image_flow_demo, R.id.btn_animation, R.id.btn_my_camera,
            R.id.btn_qrcode, R.id.btn_baidumap, R.id.btn_floating_action_button, R.id.btn_repeat_choose_button,
            R.id.btn_jsbridge_button, R.id.btn_rxandroid_practise, R.id.btn_et_test, R.id.btn_mediaplayer,
            R.id.btn_motion_event})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                startActivity(new Intent(this, TestPhotoActivity.class));
                break;
            case R.id.btn_my_widget:
                startActivity(new Intent(this, DemoPercentViewActivity.class));
                break;
            case R.id.btn_net:
                startActivity(new Intent(this, TestNetWorkActivity.class));
                break;
            case R.id.btn_sqlite:
                startActivity(new Intent(this, TestDatabaseActivity.class));
                break;
            case R.id.btn_coordinatorLayout:
                startActivity(new Intent(this, DemoCoordinatorLayoutActivity.class));
                break;
            case R.id.btn_fragment_demo:
                startActivity(new Intent(this, DemoFragmentActivity.class));
                break;
            case R.id.btn_recy_image_flow_demo:
                startActivity(new Intent(MainActivity.this, RecyclerViewFlowActivity.class));
                break;
            case R.id.btn_animation:
                startActivity(new Intent(MainActivity.this, DemoAnimationActivity.class));
                break;
            case R.id.btn_my_camera:
                startActivity(new Intent(MainActivity.this, MyCareraActivity.class));
                break;
            case R.id.btn_qrcode:
                startActivity(new Intent(MainActivity.this, QRCodeActivity.class));
                break;
            case R.id.btn_baidumap:
                startActivity(new Intent(MainActivity.this, BaiduMapActivity.class));
                break;
            case R.id.btn_floating_action_button:
                startActivity(new Intent(MainActivity.this, FloatingActionButtonActivity.class));
                break;
            case R.id.btn_repeat_choose_button:
                startActivity(new Intent(MainActivity.this, RepeatChooseBtnActivity.class));
                break;
            case R.id.btn_jsbridge_button:
                startActivity(new Intent(MainActivity.this, JsBridgeDemoActivity.class));
                break;
            case R.id.btn_rxandroid_practise:
                startActivity(new Intent(MainActivity.this, RxjavaPractiseActivity.class));
                break;
            case R.id.btn_et_test:
                startActivity(new Intent(MainActivity.this, EtTestActivity.class));
                break;
            case R.id.btn_mediaplayer:
                startActivity(new Intent(MainActivity.this, PlayMusicActivity.class));
                break;
            case R.id.btn_motion_event:
                startActivity(new Intent(MainActivity.this,MotionEventActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置Toolbar的外观和功能和ActionBar一致
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("好嗨哟！感觉人生已经到达了巅峰");

        // 格式化后的数字   0 代表前面补充0,   4 代表长度为4,    d 代表参数为正数型
        Log.i("TEST", "格式化后的数字 : " + String.format("%022d", 1));


    }

    //初始化Toorbar右侧的图标
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test:
                Toast.makeText(this, "我是title_menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
