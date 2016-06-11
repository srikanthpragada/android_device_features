package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;

public class PlayVideoWithIntentActivity extends Activity {
    String filename = "test[1].mp4";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_with_intent);
    }

    public void play(View v) {
        File movieFolder = Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_MOVIES);
        Uri video = Uri.parse("file://" + movieFolder + "/" + filename);
        Intent intent = new Intent( Intent.ACTION_VIEW);
        intent.setDataAndType(video, "video/*");
        startActivity(intent);
    }

}