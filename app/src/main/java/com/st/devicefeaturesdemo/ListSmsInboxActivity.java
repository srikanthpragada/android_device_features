package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
			cursor = getContentResolver().query(uriSms, null,null,null,null);


			for(int i = 0 ; i < cursor.getColumnCount() ; i++)
				Log.d ("Columns", cursor.getColumnName(i) );

			while(cursor.moveToNext())
			{

				for(int i = 0 ; i < cursor.getColumnCount() ; i++)
					try {
						Log.d("Data", i  + " :  " +  cursor.getString(i));
					}
					catch(Exception ex) {

					}

				break;
			}

			/*
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
				Log.d("demo", "No messages!"); */
			
			

		} catch (Exception ex) {
			Log.d("Exception", ex.getMessage());
		} finally {
			if ( cursor != null)
				 cursor.close();
		}
	}

}
