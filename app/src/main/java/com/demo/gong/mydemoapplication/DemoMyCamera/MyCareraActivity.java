package com.demo.gong.mydemoapplication.DemoMyCamera;

import android.os.Bundle;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MyCareraActivity extends BaseActivity {

    @BindView(R.id.btn_take_my_photo)
    Button btnTakeMyPhoto;

    @OnClick(R.id.btn_take_my_photo)
    public void onViewClick() {
        CameraSurfaceView cs = new CameraSurfaceView(this);
        cs.takePicture();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_carera);
    }
}
