package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GitHubClientActivity extends Activity {

    private static final String URL = "https://api.github.com/users/";
    private EditText editUrl;
    private TextView textContents;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callrest);
        textContents = (TextView) findViewById(R.id.textContents);
        editUrl = (EditText) findViewById(R.id.editUrl);
        editUrl.setText("srikanthpragada");
    }

    public void callRestService(View v) {
        final Handler contentHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                textContents.setText(msg.obj.toString());
            }
        };

        DownloadThread dt = new DownloadThread(contentHandler,
                editUrl.getText().toString());
        dt.start();
    }

    public void processResult(View v) {
        final Handler contentHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.obj.toString().equals("")) {
                    textContents.setText("Sorry! Name not found!");
                    return;
                }
                try {
                    Log.d("ST", msg.obj.toString());
                    JSONObject obj = new JSONObject(msg.obj.toString());
                    StringBuffer data = new StringBuffer();
                    data.append(obj.get("email").toString() + "\n");
                    data.append(obj.get("location").toString());
                    textContents.setText(data.toString());
                } catch (Exception ex) {
                    Log.d("ST", "Error -> " + ex.getMessage());
                }
            }

            ;
        };

        DownloadThread dt = new DownloadThread(contentHandler,
                editUrl.getText().toString());
        dt.start();
    }


    class DownloadThread extends Thread {
        Handler handler;
        String user;

        public DownloadThread(Handler handler, String user) {
            this.handler = handler;
            this.user = user;
        }

        public void run() {
            try {
                URL sourceUrl = new URL(URL + this.user);
                InputStream is = null;
                try {
                    is = sourceUrl.openStream();
                } catch (Exception ex) {
                    Message m = handler.obtainMessage();
                    m.obj = "";
                    handler.sendMessage(m); // update view
                    return;
                }
                // Get the response
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(is));
                String line = "";
                StringBuffer content = new StringBuffer("");
                while ((line = rd.readLine()) != null) {
                    content.append(line);
                }
                rd.close();
                Message m = handler.obtainMessage();
                m.obj = content;
                handler.sendMessage(m); // update view
            } catch (Exception ex) {
                Message m = handler.obtainMessage();
                m.obj = "Error : " + ex.getMessage();
                handler.sendMessage(m); // update view
            }
        } // run
    }

    ; // DownloadThread

}
