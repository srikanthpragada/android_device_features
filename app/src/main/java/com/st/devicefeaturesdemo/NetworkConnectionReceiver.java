package com.st.devicefeaturesdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnectionReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("Network", "action: " + intent.getAction());

		boolean haveConnectedWifi = false;
		boolean haveConnectedMobile = false;

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] netInfo = cm.getAllNetworkInfo();
		for (NetworkInfo ni : netInfo) {
			if (ni.getType() == ConnectivityManager.TYPE_WIFI)
				if (ni.isConnected()) {
					haveConnectedWifi = true;
					Log.d("Network", "WIFI");
				}
			if (ni.getType() == ConnectivityManager.TYPE_MOBILE)
				if (ni.isConnected()) {
					Log.d("Network", "MOBILE");
					haveConnectedMobile = true;
				}
		}
		if (! haveConnectedWifi && ! haveConnectedMobile)
			Log.d("Network", "No Network");
	}

}
