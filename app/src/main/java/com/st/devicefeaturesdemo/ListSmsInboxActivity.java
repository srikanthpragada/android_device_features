package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.Telephony;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class ListSmsInboxActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_sms_inbox);
		TextView tv = (TextView) findViewById(R.id.textMessages);
		tv.setText("");


		Cursor cursor = null;
		try {
			Uri uriSms = Uri.parse("content://sms/inbox");
			Cursor c = getContentResolver().query(uriSms, null,null,null,null);

			if (cursor != null) {
			  while (cursor.moveToNext()) {
					String address = cursor
							.getString(cursor
									.getColumnIndex(Telephony.Sms.ADDRESS));

					String body  = cursor
							.getString(cursor
									.getColumnIndex(Telephony.Sms.BODY));

     				tv.append(address + "\n");
					tv.append(body + "\n");

				}
			} else
				Log.d("demo", "No messages!");
			
			

		} catch (Exception ex) {
			Log.d("MissedCalls", ex.getMessage());
		} finally {
			if ( cursor != null)
				 cursor.close();
		}
	}

}
