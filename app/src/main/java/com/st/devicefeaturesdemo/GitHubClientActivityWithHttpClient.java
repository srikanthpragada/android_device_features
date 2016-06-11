package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GitHubClientActivityWithHttpClient extends Activity {
	
	private EditText editUrl;
	private TextView textContents;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callrest);
		textContents = (TextView) findViewById(R.id.textContents);
		editUrl = (EditText) findViewById(R.id.editUrl);
		editUrl.setText("https://api.github.com/users/srikanthpragada");
	}
	
	public void callRestService(View v) {
				final Handler contentHandler = new Handler() {
					@Override
					public void handleMessage(Message msg) {
						textContents.setText(msg.obj.toString());
					}
				};

				DownloadThread dt = new DownloadThread(contentHandler, editUrl.getText().toString());
				dt.start();
	}

	public void processResult(View v) {
		final Handler contentHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				try {
					JSONObject obj = new JSONObject(msg.obj.toString());
					textContents.setText(obj.get("email").toString());
				} catch (Exception ex) {
					Log.d("ST", "Error -> " + ex.getMessage());
				}
			}

			;
		};

		DownloadThread dt = new DownloadThread(contentHandler, editUrl.getText().toString());
		dt.start();
	}


	class DownloadThread extends Thread {
		Handler handler;
		String url;

		public DownloadThread(Handler handler, String url) {
			this.handler = handler;
			this.url = url;
		}

		public void run() {
			try {
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpUriRequest uri = new HttpGet(url);
				CloseableHttpResponse response1 = httpclient.execute(uri);
				try {
					HttpEntity entity1 = response1.getEntity();

					BufferedReader rd = new BufferedReader(
							new InputStreamReader(entity1.getContent()));
					String line = "";
					StringBuffer content = new StringBuffer("");
					while ((line = rd.readLine()) != null) {
						content.append(line);
					}

					Message m = handler.obtainMessage();
					m.obj = content.toString();
					handler.sendMessage(m); // update view
				}
				finally {
					response1.close();
				}
			} catch (Exception ex) {
				Message m = handler.obtainMessage();
				m.obj = "Error : " + ex.getMessage();
				handler.sendMessage(m); // update view
			}
			finally {

			}
		} // run
	}; // DownloadThread

}
