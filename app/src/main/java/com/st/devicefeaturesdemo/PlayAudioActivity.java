package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PlayAudioActivity extends Activity {
    MediaPlayer mp;
    boolean stopped = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playaudio);
        mp = MediaPlayer.create(this, R.raw.wonderfullife);
    }

    public void playAudio(View v) {
        mp.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                Toast.makeText(PlayAudioActivity.this, "Completed!", Toast.LENGTH_LONG).show();
            }
        });

        if (stopped) {
            try {
                mp.prepare();
            } catch (Exception ex) {
                Toast.makeText(PlayAudioActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

        mp.start();

    }

    public void stopAudio(View v) {
        mp.stop();
        stopped = true;

    }
}