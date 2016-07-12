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

public class WeatherReportActivity extends Activity {

    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String APPID = "YOUR APP API";
    private EditText editCity, editCountry;
    private TextView textWeather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_report);
        textWeather = (TextView) findViewById(R.id.textWeather);
        editCity = (EditText) findViewById(R.id.editCity);
        editCountry = (EditText) findViewById(R.id.editCountry);

    }

    public void getWeather(View v) {
        final Handler contentHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if ( msg.obj.toString().contains("Error")) {
                    textWeather.setText(msg.obj.toString());
                    return;
                }

                try {
                    JSONObject obj = new JSONObject(msg.obj.toString());
                    JSONObject coord = obj.getJSONObject("coord");
                    String lon = coord.getString("lon");
                    String lat = coord.getString("lat");
                    JSONObject main = obj.getJSONObject("main");
                    String temp = main.getString("temp");
                    textWeather.setText("Temprature : " + temp);
                    textWeather.append("\nLongitude : " + lon);
                    textWeather.append("\nLatitude  : " + lat);
                }
                catch(Exception ex) {
                    Log.d("DeviceFeaturesDemo", ex.getMessage());
                }
            }
        };

        DownloadThread dt = new DownloadThread(contentHandler,
                editCity.getText().toString(), editCountry.getText().toString());
        dt.start();
    }

    class DownloadThread extends Thread {
        Handler handler;
        String  url;
        public DownloadThread(Handler handler, String city, String country) {
            this.handler = handler;
            url = URL + city + "," + country + "&mode=JSON&APPID=" + APPID;
        }

        public void run() {
            try {
                URL sourceUrl = new URL(url);
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
