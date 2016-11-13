package com.rajatgoyal.hw2_intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLink;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLink = (Button)findViewById(R.id.btn_link);

        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        if(receivedAction.equals(Intent.ACTION_SEND)){
            url = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
            btnLink.setVisibility(View.VISIBLE);
        }

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    public void open(View v){
        String url="http://www.google.com";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void call(View v){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:9599586446"));
        startActivity(i);
    }
}
