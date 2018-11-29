package com.demo.gong.mydemoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.DemoCamera.TestPhotoActivity;
import com.demo.gong.mydemoapplication.DemoMyWidget.DemoPercentViewActivity;
import com.demo.gong.mydemoapplication.DemoNetActivity.TestNetWorkActivity;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.TestDatabaseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCamera;
    private Button btnWidget;
    private Button btnNet;
    private Button btnSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setOnClick();
    }

    private void setOnClick() {
        btnCamera.setOnClickListener(this);
        btnWidget.setOnClickListener(this);
        btnNet.setOnClickListener(this);
        btnSqlite.setOnClickListener(this);
    }

    private void initView() {
        btnCamera = (Button)findViewById(R.id.btn_camera);
        btnWidget = (Button)findViewById(R.id.btn_my_widget);
        btnNet = (Button)findViewById(R.id.btn_net);
        btnSqlite = (Button)findViewById(R.id.btn_sqlite);
    }

    @Override
    public void onClick(View view) {
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
        }
    }
}
