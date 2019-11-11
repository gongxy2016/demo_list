package com.demo.gong.mydemoapplication.DemoPlayMusic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PlayMusicActivity extends BaseActivity {

    @BindView(R.id.play_music_PlayMusicActivity)
    Button btnPlay;
    @BindView(R.id.stop_PlayMusicActivity)
    Button btnStop;
    @BindView(R.id.sb_PlayMusicActivity)
    SeekBar seekBar;

    PlayerUtil player;

    @OnClick({R.id.play_music_PlayMusicActivity,R.id.stop_PlayMusicActivity})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.play_music_PlayMusicActivity :
                new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        player.playUrl("http://m7.music.126.net/20191107163427/29926b1a7848a61637ac591de8c93379/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3");
                    }
                }.start();
                break;
            case R.id.stop_PlayMusicActivity :
                player.stop();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        player = new PlayerUtil(seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    }

    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            this.progress = progress * player.mediaPlayer.getDuration() / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            player.mediaPlayer.seekTo(progress);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (player != null) {
            player.stop();
            player = null;
        }
    }
}


