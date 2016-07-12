package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;

public class PlayAudioWithIntentActivity extends Activity {
    String filename = "wonderfullife.mp3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playaudio_with_intent);
    }

    public void playAudio(View v) {
        File musicFolder = Environment.getExternalStoragePublicDirectory
                        (Environment.DIRECTORY_MUSIC);
        Uri audio = Uri.parse("file://" + musicFolder + "/" + filename);
        Log.d("Demo", audio.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(audio, "audio/*");
        startActivity(intent);
    }

}