package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendEmailActivity extends Activity {

	private EditText editEmail;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendemail);
		editEmail = (EditText)  this.findViewById(R.id.editEmail);
    }
	
    public void sendEmail(View v) {
      	Intent email = new Intent(Intent.ACTION_SENDTO);
    	email.putExtra(Intent.EXTRA_EMAIL, new String[]{ editEmail.getText().toString()});		  
    	email.putExtra(Intent.EXTRA_SUBJECT, "subject");
    	email.putExtra(Intent.EXTRA_TEXT, "message");
    	email.setType("message/rfc822");
    	// startActivity(Intent.createChooser(email, "Choose an Email client :"));
		startActivity(email);
    } 

}
