package com.demo.gong.mydemoapplication.DemoQRCode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;

public class QRCodeActivity extends BaseActivity {

    @BindView(R.id.iv_qrcode)
    ImageView ivQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("https://www.baidu.com", 480, 480);
        ivQRCode.setImageBitmap(mBitmap);
    }
}
