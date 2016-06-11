package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GitUserPhotoActivity extends Activity {
	
	private EditText editUrl;
	private ImageView photo;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gituserphoto);
		photo = (ImageView) findViewById(R.id.photo);
		editUrl = (EditText) findViewById(R.id.editUrl);
		editUrl.setText("https://avatars.githubusercontent.com/u/11234226?v=3");
	}
	
	public void callRestService(View v) {

				DownloadThread dt = new DownloadThread(editUrl.getText().toString());
				dt.start();
	}




	class DownloadThread extends Thread {

		String url;

		public DownloadThread( String url) {

			this.url = url;
		}

		public void run() {
			try {
				URL sourceUrl = new  URL(this.url);
				InputStream is=null;
				try {
					is = sourceUrl.openStream();
					final Bitmap bitmap = BitmapFactory.decodeStream(is);
					photo.post(new Runnable() {

						@Override
						public void run() {
							photo.setImageBitmap(bitmap);
						}
					});

				}
				catch(Exception ex) {
				  Log.d("ST","Error processing stream -> " + ex.getMessage());
				}


			} catch (Exception ex) {
				Log.d("ST","Error while using URL -> " + ex.getMessage());
			}
		} // run
	}; // DownloadThread

}
