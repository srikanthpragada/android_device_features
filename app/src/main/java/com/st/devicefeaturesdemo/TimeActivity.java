package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.Socket;
import java.util.Scanner;

public class TimeActivity extends Activity {
	private String mHost = "10.0.2.2";
	private int mPort = 2000;
	private TextView timeView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time);
		timeView = (TextView) findViewById(R.id.time_display);
	}

	class TimeThread extends Thread {
		public void run() {
			try {
				Log.d("Time", "About to connect...");
				Socket socket = new Socket(mHost, mPort);
				Scanner s = new Scanner(socket.getInputStream());
				final String timeResult = s.nextLine();
				timeView.post(new Runnable() {
					public void run() {
						timeView.setText(timeResult);
					}
				});

				socket.close();
			} catch (final Exception ex) {
				timeView.post(new Runnable() {
					public void run() {
						timeView.setText(ex.getMessage());
					}
				});
			}
		}
	}

	public void showTime(View clickedButton) {
	
		TimeThread t = new TimeThread();
		t.start();
	}
}