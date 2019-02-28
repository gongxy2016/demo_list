package com.demo.gong.mydemoapplication.DemoFloatingActionButton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

public class FloatingActionButtonActivity extends BaseActivity {

    MediaPlayer mediaPlayer;

    @BindView(R.id.btn_play_server_sound)
    Button btnPlaySound;

    @OnClick(R.id.btn_play_server_sound)
    public void onViewClick() {

        try {
            mediaPlayer.setDataSource("http://192.168.0.105/file/workflow/0/1/R120190226145230超级管理员.wav");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        mediaPlayer = new MediaPlayer();
    }
}
