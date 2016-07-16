package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicViewActivity extends Activity implements View.OnClickListener {
    int count = 1;
    LinearLayout buttons;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);
        buttons = (LinearLayout) findViewById(R.id.buttons);
        textView =(TextView) findViewById(R.id.textView);
    }

    public void onClick(View v) {
        Button btn = (Button) v;
        textView.append( btn.getText() );
    }

    public void addButton(View v)
    {
        Button b = new Button(this);
        b.setOnClickListener(this);
        b.setText(String.valueOf(count));
        buttons.addView(b);
        count ++;
    }

    public void clearButtons(View v)
    {
        buttons.removeAllViews();
        count = 1;
    }


}
