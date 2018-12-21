package com.demo.gong.mydemoapplication.DemoCameraAndRecoder;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

public class RecoderActivity extends BaseActivity {

    @BindView(R.id.btn_recoder_control)
    Button btnControl;
    @BindView(R.id.recv_recoder)
    RecyclerView recvRecorder;

//    private Button btnControl;
//    private RecyclerView recvRecorder;
    private boolean isStart = false;
    private MediaRecorder mr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoder);

    }

    @OnClick({R.id.btn_recoder_control})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recoder_control:
                if (isStart == false) {
                    isStart = true;
                    btnControl.setText("停止录音");
                    startRecord();
                } else {
                    isStart = false;
                    btnControl.setText("开始录音");
                    stopRecord();
                }

                break;
        }
    }

/*
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recoder_control:
                if (isStart == false) {
                    isStart = true;
                    btnControl.setText("停止录音");
                    startRecord();
                } else {
                    isStart = false;
                    btnControl.setText("开始录音");
                    stopRecord();
                }

                break;
        }
    }
*/

    private void startRecord() {
        if (mr == null) {
            File dir = new File(Environment.getExternalStorageDirectory(), "sounds");
            if (!dir.exists()) {
                dir.mkdirs();
                Log.i("RecoderActivity","recordfilepath:"+dir.getAbsolutePath());
            }

            File soundFile = new File(dir, System.currentTimeMillis() + ".amr");
            if (!soundFile.exists()) {
                try {
                    soundFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            mr = new MediaRecorder();
            mr.setAudioSource(MediaRecorder.AudioSource.MIC); //音频输入源
            mr.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB); //设置输出格式
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB); //设置编码格式
            mr.setOutputFile(soundFile.getAbsolutePath());
            try {
                mr.prepare();
                mr.start(); //开始录制
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //停止录制，资源释放
    private void stopRecord(){
        if(mr != null){
            mr.stop();
            mr.release();
            mr = null;
        }
    }
}
