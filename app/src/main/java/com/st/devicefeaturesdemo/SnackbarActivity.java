package com.st.devicefeaturesdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SnackbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

    }

    public void showSnackbar(View v) {
        Snackbar snackbar = Snackbar.make(v ,
                 "Welcome to Snackbar",
                 Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    public void showSnackbarWithAction(View v) {
        Snackbar snackbar = Snackbar.make( v ,
                    "Snackbar With Action",
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("Delete",
                             new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   Toast.makeText( getApplicationContext(),
                                           "Snackbar is removed!", Toast.LENGTH_LONG).show();
                               }
                           });
        snackbar.show();
    }

}
